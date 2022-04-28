package com.internaltools.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.internaltools.service.AmazonClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class InternalToolsScheduler {
	
	@Autowired
	AmazonClient amazonClient;
	
	
	
	@Value("${documends.jobs.enabled}")
	private boolean isEnabled;
	
//	@Scheduled(fixedDelay=5000, zone = DocumendsConstant.DEFAULT_ZONE)
//	private synchronized boolean validateLinkedEmails() {
//		
//		if(isEnabled) {
//			String host = "outlook.office365.com";
//			String port = "993";
//			String userName = "rloganathan84@outlook.com";
//			String password = "Pirai@2021";
//			try {
//				
//				List<Optional<ConfigProperties>> emailUserName = configPropertiesRepository.findByConfigNameAndIsActiveTrue(
//						DocumendsConstant.EMAIL_USERNAME);
//				List<Optional<ConfigProperties>> emailPassword = configPropertiesRepository.findByConfigNameAndIsActiveTrue(
//						DocumendsConstant.EMAIL_PASSWORD);
//				
//				if(null != emailUserName && !emailUserName.isEmpty()) {
//					userName = emailUserName.get(0).get().getConfigValue();
//					log.debug("userName :: " + userName);
//				}
//				
//				if(null != emailPassword && !emailPassword.isEmpty()) {
//					password = emailPassword.get(0).get().getConfigValue();
//				}
//				
//				Properties properties = new Properties();
//
//				properties.put("mail.imaps.host", host);
//				properties.put("mail.imaps.port", port);
//
//				properties.setProperty("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//				properties.setProperty("mail.imaps.socketFactory.fallback", "false");
//				properties.setProperty("mail.imaps.socketFactory.port", String.valueOf(port));
//
//				Session session = Session.getDefaultInstance(properties);
//				Store store = session.getStore("imaps");
//				store.connect(userName, password);
//				log.debug("Before entering into linkedEmailList");
//				List<Optional<Company>> companyEmailList = companyRepository.findByIsActiveTrue();
//				log.debug("After entering into linkedEmailList :: ");
//				if (!companyEmailList.isEmpty()) {
//					Folder inbox = store.getFolder("INBOX");
//					inbox.open(Folder.READ_WRITE);
//					FlagTerm flagTerm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
//					for (Optional<Company> companyOpt : companyEmailList) {
//						
//						Company company = companyOpt.get();
//						if(null != company.getDockketEmail() && !company.getDockketEmail().isBlank()) {
//							javax.mail.Message.RecipientType recipientType = RecipientType.TO;
//							SearchTerm receiver =  new RecipientTerm(recipientType, new InternetAddress(company.getDockketEmail()));
//							//SearchTerm sender =  new FromTerm(new InternetAddress(company.getDockketEmail().toLowerCase()));
//							SearchTerm searchTerm = new AndTerm(flagTerm, receiver);
//							Message[] inboxMessageArray = inbox.search(searchTerm);
//							
//							Map<String, String> imgUrlMap = new HashMap<>();
//							for (Message message : inboxMessageArray) {
//								
//								/**
//								 *  Update the message as READ
//								 */
//								message.setFlag(Flags.Flag.SEEN, true);
//								
//								Date sentDate = message.getSentDate();
//								String subject = message.getSubject();
//								Multipart multiPart = (Multipart) message.getContent();
//								
//								for (int fileCount = 0; fileCount < multiPart.getCount(); fileCount++) {
//									
//									MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(fileCount);
//						           
//						            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
//						                part.saveFile(part.getFileName());
//						                File fileObject = new File(part.getFileName());
//						                ImageResponse imgResponse = amazonClient.uploadMultiPartFile(fileObject);
//										if(null != imgResponse) {
//											if(null != fileObject.getName()) {
//												imgUrlMap.put(imgResponse.getImagePath(), imgResponse.getImageKey());	
//											}
//										}
//						            }
//								}
//								
//								log.debug("linkedEmails.getId() :: " + company.getId());
//								List<Optional<com.internaltools.persistence.entity.Store>> storeList = storeRepository.findByCompanyId(
//										company.getId());
//								
//									if(!imgUrlMap.isEmpty()) {
//										for (Map.Entry<String,String> entry : imgUrlMap.entrySet()) {
//											Document document = new Document();
//											
//											if(null != sentDate) {
//												Timestamp docTS = new Timestamp(sentDate.getTime());
//												java.sql.Date sqlDocDate = new java.sql.Date(docTS.getTime());
//												document.setDocumentDate(sqlDocDate);
//											}
//											
//											document.setSource("Email");
//											document.setCompany(company);
//											Optional<CompanyUserRole> companyUserRole = companyUserRoleRepository.findByCompanyIdAndRoleMasterId(company.getId(), 2L);
//											if(companyUserRole.isPresent()) {
//												document.setUser(companyUserRole.get().getUser());
//											}
//											
//											if(null != storeList && !storeList.isEmpty()) {
//												String docNumber = storeList.get(0).get().getStoreCode() + "-" + getDocumentSequenceCode();
//												document.setDocumentNumber(docNumber);
//												
//												if(storeList.size() == 1) {
//													document.setStore(storeList.get(0).get());
//												}
//											} else {
//												String companyName = company.getCompanyName().replaceAll("\\s", "");
//												String docNumber = companyName.substring(0, 3).toUpperCase() + company.getId() + "-" + getDocumentSequenceCode();
//												document.setDocumentNumber(docNumber);
//											}
//											
//											document.setImageType(FilenameUtils.getExtension(entry.getValue()));
//											document.setCreatedAt(sentDate.toInstant());
//											document.setCreatedBy(0L);
//											document.setConvertedPdf(false);
//											if("pdf".equalsIgnoreCase(FilenameUtils.getExtension(entry.getValue()))) {
//												document.setConvertedPdf(true);
//											}
//											document.setParentImgUrl(entry.getKey());
//											document.setParentImgKey(entry.getValue());
//											document = documentRepository.save(document);
//											
//											DocumentImages documentImages = new DocumentImages();
//											documentImages.setImageUrl(entry.getKey());
//											documentImages.setImageKey(entry.getValue());
//											documentImages.setDocument(document);
//											documentImagesRepository.save(documentImages);
//										}
//									}
//									message.setFlag(Flags.Flag.DELETED, true);
//								}
//						}
//					}
//					inbox.close(true);
//					store.close();
//				}
//			} catch (NoSuchProviderException ex) {
//				log.error("No provider for imap." + ex.getMessage());
//				ex.printStackTrace();
//			} catch (MessagingException ex) {
//				log.error("Could not connect to the message store" + ex.getMessage());
//				ex.printStackTrace();
//			} catch (IOException ex) {
//				log.error("IOException " + ex.getMessage());
//				ex.printStackTrace();
//			} catch (Exception ex) {
//				log.error("IOException " + ex.getMessage());
//			}
//		}
//		return false;
//	}
//	
//	private String getDocumentSequenceCode() {
//		
//		try {
//			List<DocumentSequence> docSequenceList = docSeqRepository.findAll();
//			if(!docSequenceList.isEmpty()) {
//				DocumentSequence storeSequence = docSequenceList.get(0);
//				Long tmpSeqNo = storeSequence.getSeqNo() + 1;
//				storeSequence.setSeqNo(tmpSeqNo);
//				storeSequence = docSeqRepository.save(storeSequence);
//				String seqNo = "DC-"+storeSequence.getSeqNo();
//				return seqNo;
//			} else {
//				DocumentSequence docSequence = new DocumentSequence();
//				docSequence.setSeqNo(101L);
//				docSequence = docSeqRepository.save(docSequence);
//				return "DC-"+docSequence.getSeqNo();
//			}
//		} catch (Exception e) {
//			log.error("Exception in getDocumentSequenceCode :: " + e.getMessage());
//			return "Invalid Code";
//		}
//	}
//
////	@Scheduled(cron = "59 59 23 * * *", zone = DocumendsConstant.DEFAULT_ZONE)
////	private synchronized boolean moveDocumentToRecycleBin() {
////		LocalDate dateTime = LocalDate.now(ZoneId.of("Europe/Dublin"));
////		LocalDate ago_30 = dateTime.minusDays(30) ;
////		java.sql.Date from = java.sql.Date.valueOf(ago_30);
////		List<Document> docList = documentRepository.findByDocumentDateLessThanAndDocumentTypeIdNullAndRecycledFalse(from);
////		if(!docList.isEmpty()) {
////			for(Document document : docList) {
////				document.setRecycled(true);
////				documentRepository.save(document);
////			}
////		}
////		return true;
////	}
//	
//	@Scheduled(cron = "59 59 23 * * *", zone = DocumendsConstant.DEFAULT_ZONE)
//	private synchronized boolean deleteDocumentFromRecycleBin() {
//		LocalDate dateTime = LocalDate.now(ZoneId.of("Europe/Dublin"));
//		LocalDate ago_30 = dateTime.minusDays(1) ;
//		java.sql.Date from = java.sql.Date.valueOf(ago_30);
//		List<Document> docList = documentRepository.findByDocumentDateLessThanAndDocumentTypeIdNullAndRecycledTrue(from);
//		if(!docList.isEmpty()) {
//			for(Document document : docList) {
//				documentRepository.delete(document);
//			}
//		}
//		return true;
//	}
}
