package com.internaltools.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.extern.slf4j.Slf4j;

@Api(tags = { "File Upload Controller" })
@SwaggerDefinition(tags = { @Tag(name = "Upload process", description = "Upload process") })
@RestController
@RequestMapping("/api/s3service")
@Slf4j
public class AWSS3Controller {

//	@Autowired
//	JwtTokenProvider tokenProvider;
//
//	@Autowired
//	AmazonClient amazonClient;
//
//	@ApiOperation(value = "Upload File", response = ApiResponse.class)
//	@PostMapping("/uploadFile")
//	public ImageResponse uploadFile(@Valid @RequestBody MultipartFile file) throws AppException {
//		
//		log.debug("******Entering into uploadFile ******");
//		ImageResponse imageReponse = amazonClient.uploadFile(file);
//		return imageReponse;
//	}
//	
//	@ApiOperation(value = "Download File", response = ApiResponse.class)
//	@GetMapping("/download")
//	public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value= "fileName") final String keyName) throws AppException {
//
//		log.debug("******Entering into downloadFile ******");
//		final byte[] data = amazonClient.downloadFile(keyName);
//        final ByteArrayResource resource = new ByteArrayResource(data);
//        return ResponseEntity
//                .ok()
//                .contentLength(data.length)
//                .header("Content-type", "application/octet-stream")
//                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
//                .body(resource);
//	}
//	
//	@ApiOperation(value = "Delete File", response = ApiResponse.class)
//	@PostMapping("/deleteFile")
//	public ApiResponse deleteFile(@RequestParam(value= "fileName") final String fileName) throws AppException {
//		
//		log.debug("******Entering into uploadFile ******");
//		ImageResponse imageReponse = amazonClient.deleteFile(fileName);
//		return imageReponse;
//	}
//	
//	@ApiOperation(value = "Get Presigned URL", response = ApiResponse.class)
//	@GetMapping("/getPresignedURL")
//	public ImageResponse getPresignedURL(@RequestParam(value= "imageKey") final String imageKey) throws AppException {
//		
//		log.debug("******Entering into getPresignedURL ******");
//		ImageResponse imageReponse = amazonClient.getPresignedURL(imageKey);
//		return imageReponse;
//	}
//	
//	@ApiOperation(value = "Upload File", response = ApiResponse.class)
//	@PostMapping("/uploadProfileImage")
//	public ImageResponse uploadProfileImage(@Valid @RequestBody MultipartFile file) throws AppException {
//		
//		log.debug("******Entering into uploadProfileImage ******");
//		ImageResponse imageReponse = amazonClient.uploadProfileImage(file);
//		return imageReponse;
//	}
	
}