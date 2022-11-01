package com.internaltools.service;

import com.internaltools.payload.response.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.InputStream;

public interface AmazonClient {

	/**
	 * @param file
	 * @return ImageResponse
	 */
	ImageResponse uploadFile(@Valid MultipartFile file);

	/**
	 * @param fileName
	 * @return byte[]
	 */
	byte[] downloadFile(@Valid String fileName);

	/**
	 * @param fileName
	 * @return ImageResponse
	 */
	ImageResponse deleteFile(String fileName);

	/**
	 * @param fileObject
	 * @return ImageResponse
	 */
	ImageResponse uploadMultiPartFile(File fileObject);

	/**
	 * @param fileName
	 * @return InputStream
	 */
	InputStream getFileInputStreamFromBucket(String fileName);

	/**
	 * @param imageKey
	 * @return ImageResponse
	 */
	ImageResponse getPresignedURL(String imageKey);

	/**
	 * @param file
	 * @return ImageResponse
	 */
	ImageResponse uploadProfileImage(@Valid MultipartFile file);
	
}
