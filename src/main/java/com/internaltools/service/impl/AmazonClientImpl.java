package com.internaltools.service.impl;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.HttpMethod;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import com.internaltools.payload.response.ImageResponse;
import com.internaltools.util.ErrorConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.internaltools.service.AmazonClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.Date;

@Service
@Slf4j
public class AmazonClientImpl implements AmazonClient {

    private AmazonS3 s3client;

    @Value("${documends.aws.api.endpoint.url}")
    private String endpointUrl;
    
    @Value("${documends.aws.api.bucketName}")
    private String bucketName;
    
    @Value("${documends.aws.api.access.key}")
    private String accessKey;
    
    @Value("${documends.aws.api.secret.key}")
    private String secretKey;
    
    @Value("${documends.aws.api.region}")
    private String region;

    @PostConstruct
    private void initializeAmazon() {
        AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard();
        builder.withCredentials(new AWSStaticCredentialsProvider(credentials));
        builder.withRegion(region);
        AmazonS3 amazonS3 = builder.build();
        this.s3client = amazonS3;
    }

    @Override
    public ImageResponse uploadFile(MultipartFile multipartFile) {

    	log.debug("Entering into uploadFile");
    	ImageResponse imageResponse = new ImageResponse();
    	S3Object object = null;
        try {
        	File convFile = new File(multipartFile.getOriginalFilename());

        	long bytes = multipartFile.getBytes().length;
            long kilobytes = (bytes / 1024);
            long megabytes = (kilobytes / 1024);
            if(megabytes > 3) {
            	 imageResponse.setImageKey("");
                 imageResponse.setImagePath("");
                 imageResponse.setMessage("System is allowed to convert less than 3MB size.");
                 imageResponse.setStatus(false);
                 imageResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
                 return imageResponse;
            }

            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(multipartFile.getBytes());
            fos.close();

            String fileName = new Date().getTime() + "-" + multipartFile.getOriginalFilename().replace(" ", "_");

            log.debug("Before s3 upload :: putObject");
            s3client.putObject(new PutObjectRequest(bucketName, fileName, convFile).withCannedAcl(
            		CannedAccessControlList.Private));
            log.debug("After s3 upload :: putObject");

            log.debug("Before s3 upload :: getObject");
            object = s3client.getObject(bucketName,  fileName);
            log.debug("After s3 upload :: getObject");

            imageResponse.setImageKey(object.getKey());
            imageResponse.setImagePath(endpointUrl + fileName);
            imageResponse.setMessage("Image uploaded successfully");
            imageResponse.setStatus(true);
            return imageResponse;
        } catch (Exception e) {
        	log.error("Exception in uploadFile :: "+ e.getMessage());
        	e.printStackTrace();
		} finally {
			if (object != null) {
				try {
					object.close();
				} catch (IOException e) {
					log.error("Unable to close S3 object: {}", e.getMessage(), e);
				}
			}
		}

        imageResponse.setImageKey("");
        imageResponse.setImagePath("");
        imageResponse.setMessage("Problem in image upload");
        imageResponse.setStatus(false);
        log.debug("Before Image Response");
        return imageResponse;
    }

	@Override
	public byte[] downloadFile(@Valid String keyName) {

		byte[] content = null;
        log.debug("Downloading an object with key= " + keyName);
        final S3Object s3Object = s3client.getObject(bucketName, keyName);
        final S3ObjectInputStream stream = s3Object.getObjectContent();
        try {
            content = IOUtils.toByteArray(stream);
            log.debug("File downloaded successfully.");
            s3Object.close();
        } catch(final IOException ex) {
            log.debug("IO Error Message= " + ex.getMessage());
        }
        return content;
	}

	public ImageResponse deleteFile(@Valid String fileName) {

		ImageResponse apiResponse = new ImageResponse();
		try {
			S3Object object = s3client.getObject(bucketName,  fileName);
			s3client.deleteObject(bucketName, object.getKey());
			apiResponse.setStatus(true);
			apiResponse.setStatusCode("200");
			apiResponse.setMessage("Image has been deleted successfully");
		} catch (Exception e) {
			apiResponse.setStatus(false);
			apiResponse.setStatusCode("400");
			apiResponse.setMessage("Problem in deleting image");
			log.error("Exception in deleteFile :: " + e.getMessage());
		}
		return apiResponse;
	}

	@Override
	public ImageResponse uploadMultiPartFile(File fileObject) {

    	log.debug("Entering into uploadMimeFile");
    	ImageResponse imageResponse = new ImageResponse();
    	S3Object object = null;
        try {

			String fileName = new Date().getTime() + "-" + fileObject.getName().replace(" ", "_");
            log.debug("Before fileName :: " + fileName);
            long bytes = fileName.length();
            long kilobytes = (bytes / 1024);
            long megabytes = (kilobytes / 1024);
            if(megabytes > 3) {
            	 imageResponse.setImageKey("");
                 imageResponse.setImagePath("");
                 imageResponse.setMessage("System is allowed to convert less than 3MB size.");
                 imageResponse.setStatus(false);
                 return imageResponse;
            }

            log.debug("Before s3 upload :: putObject");
            s3client.putObject(new PutObjectRequest(bucketName, fileName, fileObject).withCannedAcl(
            		CannedAccessControlList.Private));
            log.debug("After s3 upload :: putObject");

            log.debug("Before s3 upload :: getObject");
            object = s3client.getObject(bucketName,  fileName);
            log.debug("After s3 upload :: getObject");

            imageResponse.setImageKey(object.getKey());
        	imageResponse.setImagePath(endpointUrl + fileName);
            imageResponse.setMessage("Image uploaded successfully");
            imageResponse.setStatus(true);
            return imageResponse;
        } catch (Exception e) {
        	log.debug("Exception in uploadFile :: "+ e.getMessage());
        	e.printStackTrace();
		} finally {
			if (object != null) {
				try {
					object.close();
				} catch (IOException e) {
					log.error("Unable to close S3 object: {}", e.getMessage(), e);
				}
			}
		}

        imageResponse.setImageKey("");
        imageResponse.setImagePath("");
        imageResponse.setMessage("Problem in image upload");
        imageResponse.setStatus(false);
        return imageResponse;
    }

    @Override
    public InputStream getFileInputStreamFromBucket(String fileName) {

        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, fileName);
        S3Object s3Object = s3client.getObject(getObjectRequest);
        InputStream fileInputStream = s3Object.getObjectContent();
        log.debug("File Input Stream fetched from s3 bucket for File {} ", fileName);
        return fileInputStream;
    }

	@Override
	public ImageResponse getPresignedURL(String imageKey) {

    	log.debug("****** Entering into getPresignedURL *******");
    	ImageResponse imageResponse = new ImageResponse();
    	S3Object object = null;
    	try {
            java.util.Date expiration = new java.util.Date();
            long expTimeMillis = Instant.now().toEpochMilli();
            expTimeMillis += 1000 * 60 * 60;
            expiration.setTime(expTimeMillis);

            log.debug("Generating pre-signed URL.");
            object = s3client.getObject(bucketName,  imageKey);
            GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(bucketName, imageKey)
                            .withMethod(HttpMethod.GET)
                            .withExpiration(expiration);
            URL url = s3client.generatePresignedUrl(generatePresignedUrlRequest);
            log.debug("Pre-Signed URL :: " + url.toString());
            imageResponse.setImageKey(imageKey);
            imageResponse.setImagePath(url.toString());
            imageResponse.setMessage("Success");
            imageResponse.setStatus(true);
            return imageResponse;
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } finally {
			if (object != null) {
				try {
					object.close();
				} catch (IOException e) {
					log.error("Unable to close S3 object: {}", e.getMessage(), e);
				}
			}
		}
        imageResponse.setImageKey("");
        imageResponse.setImagePath("");
        imageResponse.setMessage("Problem in Get Presigned URL");
        imageResponse.setStatus(false);
        return imageResponse;
    }

	@Override
	public ImageResponse uploadProfileImage(@Valid MultipartFile multipartFile) {

    	log.debug("Entering into uploadFile");
    	ImageResponse imageResponse = new ImageResponse();
    	S3Object object = null;
        try {
        	File convFile = new File(multipartFile.getOriginalFilename());

        	long bytes = multipartFile.getBytes().length;
            long kilobytes = (bytes / 1024);
            long megabytes = (kilobytes / 1024);
            if(megabytes > 3) {
            	 imageResponse.setImageKey("");
                 imageResponse.setImagePath("");
                 imageResponse.setMessage("System is allowed to convert less than 3MB size.");
                 imageResponse.setStatus(false);
                 imageResponse.setStatusCode(ErrorConstants.ERROR_CODE_401);
                 return imageResponse;
            }

            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(multipartFile.getBytes());
            fos.close();

            String fileName = new Date().getTime() + "-" + multipartFile.getOriginalFilename().replace(" ", "_");

            log.debug("Before s3 upload :: putObject");
            s3client.putObject(new PutObjectRequest(bucketName, fileName, convFile).withCannedAcl(
            		CannedAccessControlList.Private));
            log.debug("After s3 upload :: putObject");

            log.debug("Before s3 upload :: getObject");
            object = s3client.getObject(bucketName,  fileName);
            log.debug("After s3 upload :: getObject");
            imageResponse = getPresignedURL(object.getKey());
            imageResponse.setImageKey(object.getKey());
            imageResponse.setMessage("Image uploaded successfully");
            imageResponse.setStatusCode(ErrorConstants.ERROR_CODE_200);
            imageResponse.setStatus(true);
            return imageResponse;
        } catch (Exception e) {
        	log.error("Exception in uploadFile :: "+ e.getMessage());
        	e.printStackTrace();
		} finally {
			if (object != null) {
				try {
					object.close();
				} catch (IOException e) {
					log.error("Unable to close S3 object: {}", e.getMessage(), e);
				}
			}
		}

        imageResponse.setImageKey("");
        imageResponse.setImagePath("");
        imageResponse.setMessage("Problem in image upload");
        imageResponse.setStatus(false);
        log.debug("Before Image Response");
        return imageResponse;
    }

}
