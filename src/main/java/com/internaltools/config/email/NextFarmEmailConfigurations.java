package com.internaltools.config.email;

import java.io.StringWriter;
import java.util.function.Function;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.internaltools.persistence.entity.User;


@Component
public class NextFarmEmailConfigurations {

	@Value("${spring.mail.username}")
	private String senderEmailId;

//	@Value("${internaltools.internaltools-web.url}")
//	private String internaltoolsWebUrl;
//
//	@Value("${internaltools.internaltools-web.registerUrl}")
//	private String registrationUrl;

	public Function<User, EmailObject> signUpOtpEmail = (user) -> {
		EmailObject object = new EmailObject();
		object.setSubject("Registration - Internaltool");
		object.setReciveremailId(user.getUserEmailId());
		object.setSenderemailId(senderEmailId);

		BodyPart body = new MimeBodyPart();
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = ve.getTemplate("emailtemplates/signupotpemail.vm");

		VelocityContext context = new VelocityContext();
		context.put("user", user);
		StringWriter out = new StringWriter();
		t.merge(context, out);

		Multipart multipart = new MimeMultipart();
		try {
			body.setContent(out.toString(), "text/html");
			multipart.addBodyPart(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		object.setMultipart(multipart);
		return object;
	};

	private String senderUserEmailId;

	public Function<User, EmailObject> welcomeEmail = (user) -> {

		EmailObject object = new EmailObject();
		object.setSubject("Welcome to Internaltool");
		object.setReciveremailId(user.getUserEmailId());
		object.setSenderemailId(senderEmailId);
		String firstName = user.getFirstName()+" "+user.getLastName();
		BodyPart body = new MimeBodyPart();
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = ve.getTemplate("emailtemplates/welcome.vm");

		VelocityContext context = new VelocityContext();
		context.put("userName", firstName);
		context.put("user", user);
		StringWriter out = new StringWriter();
		t.merge(context, out);

		Multipart multipart = new MimeMultipart();
		try {
			body.setContent(out.toString(), "text/html");
			multipart.addBodyPart(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		object.setMultipart(multipart);
		return object;
	};

	public Function<User, EmailObject> resetPasswordEmail = (user) -> {

		EmailObject object = new EmailObject();
		object.setSubject("Reset Password - InternalTools");
		object.setReciveremailId(user.getUserEmailId());
		object.setSenderemailId(senderEmailId);
		String userName = user.getFirstName()+" "+user.getLastName();
		BodyPart body = new MimeBodyPart();
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = ve.getTemplate("emailtemplates/resetpasswordemail.vm");

		VelocityContext context = new VelocityContext();
		context.put("userName", userName);
		context.put("user", user);
		StringWriter out = new StringWriter();
		t.merge(context, out);

		Multipart multipart = new MimeMultipart();
		try {
			body.setContent(out.toString(), "text/html");
			multipart.addBodyPart(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		object.setMultipart(multipart);
		return object;
	};

	public Function<User, EmailObject> passwordResetSuccess = (user) -> {

		EmailObject object = new EmailObject();
		object.setSubject("internaltool - Password Reset Successfully");
		object.setReciveremailId(user.getUserEmailId());
		object.setSenderemailId(senderEmailId);
		String firstName = user.getFirstName()+" "+user.getLastName();
		BodyPart body = new MimeBodyPart();
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = ve.getTemplate("emailtemplates/resetpasswordsuccess.vm");

		VelocityContext context = new VelocityContext();
		context.put("userName", firstName);
		context.put("user", user);
		StringWriter out = new StringWriter();
		t.merge(context, out);

		Multipart multipart = new MimeMultipart();
		try {
			body.setContent(out.toString(), "text/html");
			multipart.addBodyPart(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		object.setMultipart(multipart);
		return object;
	};

	//	public BiFunction<LinkedEmailsOtp, User, EmailObject> linkedEmail = (linkedEmailsOtp, user) -> {
//		EmailObject object = new EmailObject();
//		object.setSubject("Linked Email - Internaltool");
//		object.setReciveremailId(linkedEmailsOtp.getUserEmailId());
//		object.setSenderemailId(senderEmailId);
//        String firstName = user.getFirstName()+" "+user.getLastName();
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/linkedEmailOtp.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("userName", firstName);
//		context.put("linkedEmailsOtp", linkedEmailsOtp);
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//	};
//
//	public BiFunction<User,LinkedEmails, EmailObject> removeLinkedEmail = (owner, linkedEmail) -> {
//		EmailObject object = new EmailObject();
//		object.setSubject("Withdraw Linked Email - DocKKet");
//		object.setReciveremailId(owner.getUserEmailId());
//		object.setSenderemailId(senderEmailId);
//        String userName = owner.getFirstName()+" "+owner.getLastName();
//        String email = linkedEmail.getEmailId();
//        String company = linkedEmail.getCompany().getCompanyName();
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/removeLinkedEmail.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("userName", userName);
//		context.put("email", email);
//		context.put("company", company);
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//	};
//
//	public Function<CompanyUserRole, EmailObject> addStaffEmail = (storeUserRole) -> {
//		EmailObject object = new EmailObject();
//		object.setSubject("DocKKet - Assigned Company");
//		object.setReciveremailId(storeUserRole.getUser().getEmail());
//		object.setSenderemailId(senderEmailId);
//
//
//		String companyName = storeUserRole.getCompany().getCompanyName();
//		String userName = storeUserRole.getUser().getFirstName() + " " + storeUserRole.getUser().getLastName();
//		String resetToken = storeUserRole.getToken();
//
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/addStaffEmail.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("companyName", companyName);
//		context.put("userName", userName);
//		context.put("url", documendsWebUrl +"activateToken.do?token=" + resetToken);
//
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//	};
//
//	public Function<Website, EmailObject> contactUs = (websiteEntity) -> {
//
//		String mobile = websiteEntity.getMobileNumber();
//		String email = websiteEntity.getEmail();
//		String userName = websiteEntity.getFirstName() + " " + websiteEntity.getLastName();
//		String message = websiteEntity.getMessage();
//
//		EmailObject object = new EmailObject();
//		object.setSubject("Customer Contact - "+ userName);
//		object.setReciveremailId("admin@dockket.com");
//		object.setSenderemailId(senderEmailId);
//
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/contactUs.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("mobile", mobile);
//		context.put("email", email);
//		context.put("userName", userName);
//		context.put("message", message);
//
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//	};
//	public BiFunction<CompanyUserRole, User, EmailObject> addNewUser = (storeUserRole, tempUser1) -> {
//		EmailObject object = new EmailObject();
//		object.setSubject("DocKKet - Assigned Company");
//		object.setReciveremailId(storeUserRole.getUser().getEmail());
//		object.setSenderemailId(senderEmailId);
//
//		String companyName = storeUserRole.getCompany().getCompanyName();
//		String userName = tempUser1.getFirstName() +" "+ tempUser1.getLastName();
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/addNewUser.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("userName", userName);
//		context.put("companyName", companyName);
//		context.put("url", registrationUrl);
//
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//
//	};
//
//
//	public Function<CompanyUserRole, EmailObject> addAccountantEmail = (cmpUser) -> {
//		EmailObject object = new EmailObject();
//		object.setSubject("DocKKet - Assigned Company");
//		object.setReciveremailId(cmpUser.getUser().getEmail());
//		object.setSenderemailId(senderEmailId);
//
//		String roleName = cmpUser.getRoleMaster().getRoleName();
//		String companyName = cmpUser.getCompany().getCompanyName();
//		String userName = cmpUser.getUser().getFirstName() + " " + cmpUser.getUser().getLastName();
//		String resetToken = cmpUser.getToken();
//
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/addAccountantEmail.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("roleName", roleName);
//		context.put("companyName", companyName);
//		context.put("userName", userName);
//		context.put("url", documendsWebUrl +"/activateAccountantToken.do?token=" + resetToken);
//
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//	};
//
//
//	public BiFunction<CompanyUserRole, User, EmailObject> addNewAccountantUser = (cmpUser, tempUser1) -> {
//		EmailObject object = new EmailObject();
//		object.setSubject("DocKKet - Assigned Company");
//		object.setReciveremailId(cmpUser.getUser().getEmail());
//		object.setSenderemailId(senderEmailId);
//
//		String roleName = cmpUser.getRoleMaster().getRoleName();
//		String companyName = cmpUser.getCompany().getCompanyName();
//		String name = tempUser1.getFirstName()+ " "+ tempUser1.getLastName();
//
//		BodyPart body = new MimeBodyPart();
//		VelocityEngine ve = new VelocityEngine();
//		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//		ve.init();
//
//		Template t = ve.getTemplate("emailtemplates/addNewAccountantUser.vm");
//
//		VelocityContext context = new VelocityContext();
//		context.put("roleName", roleName);
//		context.put("companyName", companyName);
//		context.put("name", name);
//		context.put("url", registrationUrl);
//
//		StringWriter out = new StringWriter();
//		t.merge(context, out);
//
//		Multipart multipart = new MimeMultipart();
//		try {
//			body.setContent(out.toString(), "text/html");
//			multipart.addBodyPart(body);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		object.setMultipart(multipart);
//		return object;
//
//	};
	public Function<User, Object> remainderEmail = (user) -> {

		EmailObject object = new EmailObject();
		object.setSubject("Welcome to Internaltool");
		object.setReciveremailId(user.getUserEmailId());
		object.setSenderemailId(senderEmailId);
		String firstName = user.getFirstName()+" "+user.getLastName();
		BodyPart body = new MimeBodyPart();
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		Template t = ve.getTemplate("emailtemplates/remainderEmail.vm");

		VelocityContext context = new VelocityContext();
		context.put("userName", firstName);
		context.put("user", user);
		StringWriter out = new StringWriter();
		t.merge(context, out);

		Multipart multipart = new MimeMultipart();
		try {
			body.setContent(out.toString(), "text/html");
			multipart.addBodyPart(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		object.setMultipart(multipart);
		return object;
	};

}

