package com.internaltools.util;

import java.text.SimpleDateFormat;
import java.util.Date;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.internaltools.config.email.EmailObject;
import com.internaltools.event.OnEmailSignUpEvent;
import com.internaltools.persistence.entity.ResetUserPassword;
import com.internaltools.persistence.entity.User;
import com.internaltools.persistence.entity.UserRegistration;
import com.internaltools.persistence.repository.ResetUserPasswordRepository;
import com.internaltools.persistence.repository.UserRegistrationRepository;

import lombok.extern.slf4j.Slf4j;

///**
// * This is a utility file for all common operations
// * 
// */
//@Component
//@Slf4j
public class CommonUtils {

//
//	@Value("#{new Integer('${documends.expiration.time}')}")
//	private Integer EXPIRATION;
//	
//	@Autowired
//	private UserRegistrationRepository userRegistrationRepository;
//	
//	@Autowired
//	private ResetUserPasswordRepository resetUserPasswordRepository;
//
//	@Autowired
//	private ApplicationEventPublisher eventPublisher;
//	
//	public Consumer<User> createVerificationOtp = (userEntity) -> {
//		Random random = new Random();
//		Integer otp = 1000 + random.nextInt(9000);
//		userEntity.setOtp(otp);
//		
//		UserRegistration userRegistration = new UserRegistration();
//		userRegistration.setOtp(otp);
//		userRegistration.setOtpCreationTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//		userRegistration.setOtpValid(true);
//		userRegistration.setUser(userEntity);
//		userRegistrationRepository.save(userRegistration);
//	};
//
//	public Consumer<EmailObject> sendEmail = emailObject -> {
//		eventPublisher.publishEvent(new OnEmailSignUpEvent(emailObject, Locale.US));
//	};
//
//	public static Optional<String> getJwtFromRequest(HttpServletRequest request) {
//		String bearerToken = request.getHeader("Authorization");
//		if (org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//			return Optional.of(bearerToken.substring(7, bearerToken.length()));
//		}
//		return Optional.empty();
//	}
//
//	/**
//	 * @param strDate
//	 * @return Date
//	 */
//	public static Date convertStringToDbDate(String strDate) {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		Date date = null;
//		try {
//			date = simpleDateFormat.parse(strDate);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return date;
//	}
//	
//	/**
//	 * @param zoneDate
//	 * @param zoneId
//	 * @return String
//	 */
//	public static LocalDate convertZoneIdToLocalDate(String zoneId) {
//		log.debug("zoneId :: " + zoneId);
//		if(StringUtils.isNotBlank(zoneId)) {
//			LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//			ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//			LocalDate localDate = jpTime.toLocalDate();
//			log.debug("zoneDate :: " + localDate);
//			return localDate;
//		}
//		return null;
//	}
//	
//	public static boolean isCloserToNextDate(java.sql.Date originalDate, java.sql.Date previousDate,java.sql.Date nextDate) {
//	    if(previousDate.after(nextDate))
//	        throw new IllegalArgumentException("previousDate > nextDate");
//	    return ((nextDate.getTime() - previousDate.getTime()) / 2 + previousDate.getTime() <= originalDate.getTime());
//	}
//	public Consumer<User> createResetPasswordOtp = (userEntity) -> {
//		Random random = new Random();
//		Integer otp = 1000 + random.nextInt(9000);
//		userEntity.setOtp(otp);
//		
//		List<Optional<ResetUserPassword>> resetPwdList = resetUserPasswordRepository.findByUserId(userEntity.getId());
//		if(!resetPwdList.isEmpty()) {
//			for(Optional<ResetUserPassword> resetPwdOpt : resetPwdList) {
//				ResetUserPassword resetPwd = resetPwdOpt.get();
//				resetPwd.setOtpValid(false);
//				resetUserPasswordRepository.save(resetPwd);
//			}
//		}
//		
//		ResetUserPassword userPassword = new ResetUserPassword();
//		userPassword.setOtp(otp);
//		userPassword.setOtpCreationTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//		userPassword.setOtpValid(true);
//		userPassword.setUser(userEntity);
//		resetUserPasswordRepository.save(userPassword);
//	};
//	
//	/**
//	 * @param instant
//	 * @param zoneId
//	 * @return String
//	 */
//	public static String convertDbInstantToStringWithZone(Instant instant, String zoneId) {
//		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
//        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(zoneId));
//		Timestamp timestamp = Timestamp.valueOf(zonedDateTime.toLocalDateTime());
//		return dateTimeFormater.format(timestamp);
//	}
//	
//	/**
//	 * @param dbDate
//	 * @return String
//	 */
//	public static String convertTimestampToString(Timestamp dbDate) {
//		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
//		return dateTimeFormater.format(dbDate);
//	}
//	
//	/**
//	 * @param dbDate
//	 * @return String
//	 */
//	public static String convertDbTimestampToString(java.sql.Date dbDate) {
//		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
//		return dateTimeFormater.format(dbDate);
//	}
//	
//	public static String convertDbTimestampToStringWithoutTime(java.sql.Date dbDate) {
//		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy");
//		return dateTimeFormater.format(dbDate);
//	}
//	
//	
//	public static Timestamp thisWeekFromDate(String zoneId) {
//		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//		LocalDate monday = jpTime.toLocalDate();
//	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
//	      monday = monday.minusDays(1);
//	    }
//	    return Timestamp.valueOf(monday.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp thisWeektoDate(String zoneId) {
//		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//	    return Timestamp.valueOf(jpTime.toLocalDateTime());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp lastWeekFromDate(String zoneId) {
//		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//		LocalDate monday = jpTime.toLocalDate();
//	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
//	      monday = monday.minusDays(1);
//	    }
//	    monday = monday.minusDays(7);
//	    return Timestamp.valueOf(monday.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp lastWeektoDate(String zoneId) {
//		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//		LocalDate sunday = jpTime.toLocalDate();
//	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
//	      sunday = sunday.plusDays(1);
//	    }
//	    sunday = sunday.minusDays(7);
//	    return Timestamp.valueOf(sunday.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp previousMonthFromDate(String zoneId) {
//		YearMonth yearMonthNow = YearMonth.now(ZoneId.of(zoneId));
//		YearMonth yearMonthPrevious = yearMonthNow.minusMonths( 1 );
//		LocalDate firstOfMonth = yearMonthPrevious.atDay( 1 );
//	    return Timestamp.valueOf(firstOfMonth.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp previousMonthToDate(String zoneId) {
//		YearMonth yearMonthNow = YearMonth.now(ZoneId.of(zoneId));
//		YearMonth yearMonthPrevious = yearMonthNow.minusMonths( 1 );
//		LocalDate lastOfMonth = yearMonthPrevious.atEndOfMonth();
//	    return Timestamp.valueOf(lastOfMonth.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp currentMonthFromDate(String zoneId) {
//		YearMonth yearMonthNow = YearMonth.now(ZoneId.of(zoneId));
//		LocalDate firstOfMonth = yearMonthNow.atDay( 1 );
//	    return Timestamp.valueOf(firstOfMonth.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp currentMonthToDate(String zoneId) {
//		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//	    return Timestamp.valueOf(jpTime.toLocalDateTime());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp previousYearFromDate(String zoneId) {
//		Year yearNow = Year.now(ZoneId.of(zoneId));
//		Year yearPrevious = yearNow.minusYears( 1 );
//		LocalDate firstOfYear = yearPrevious.atDay( 1 );
//	    return Timestamp.valueOf(firstOfYear.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp previousYearToDate(String zoneId) {
//		Year yearNow = Year.now(ZoneId.of(zoneId));
//		Year yearPrevious = yearNow.minusYears( 1 );
//		YearMonth yearMonthNow = yearPrevious.atMonth(12);
//		LocalDate lastOfMonth = yearMonthNow.atEndOfMonth();
//	    return Timestamp.valueOf(lastOfMonth.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp currentYearFromDate(String zoneId) {
//		Year yearNow = Year.now(ZoneId.of(zoneId));
//		LocalDate firstOfYear = yearNow.atDay( 1 );
//	    return Timestamp.valueOf(firstOfYear.atStartOfDay());
//	}
//	
//	/**
//	 * @return Timestamp
//	 */
//	public static Timestamp currentYearToDate(String zoneId) {
//		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//	    return Timestamp.valueOf(jpTime.toLocalDateTime());
//	}
//	
//	public static String convertTimeZonetoDate(String sourceTimeZone, DateTimeFormatter formatter) {
//
//		ZoneId fromTimeZone = ZoneId.of(sourceTimeZone);
//		LocalDateTime today = LocalDateTime.now();
//		ZonedDateTime currentISTime = today.atZone(fromTimeZone);
//		return formatter.format(currentISTime);
//	}
//	
//	
//	/**
//	 * @param startDate
//	 * @param endDate
//	 * @return String
//	 */
//	public static String findDifference(String startDateStr, String endDateStr) {
//		
//		String returnValue = "";
//		SimpleDateFormat startDateSDF = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
//		SimpleDateFormat endDateSDF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//		try {
//			Date startDate = startDateSDF.parse(startDateStr);
//            Date endDate = endDateSDF.parse(endDateStr);
//			long difference_In_Time = endDate.getTime() - startDate.getTime();
//			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
//			long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
//			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
//			long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
//			long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;
//
//			if (difference_In_Years > 0) {
//				returnValue = returnValue + difference_In_Years + "y ";
//			} 
//			if (difference_In_Days > 0) {
//				returnValue = returnValue + difference_In_Days + "d ";
//			} 
//			if (difference_In_Hours > 0) {
//				returnValue = returnValue + difference_In_Hours + "h ";
//			} 
//			if (difference_In_Minutes > 0) {
//				returnValue = returnValue + difference_In_Minutes + "m ";
//			} 
//			if (difference_In_Seconds > 0) {
//				returnValue = returnValue + difference_In_Seconds + "s ";
//			} 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return returnValue;
//	}
//	
//	
//	/**
//	 * @param zoneId
//	 * @return String
//	 */
//	public static String convertZoneIdToLocalDateString(String zoneId) {
//		log.debug("zoneId :: " + zoneId);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		if(StringUtils.isNotBlank(zoneId)) {
//			LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//			ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of(zoneId));
//			return zonedDateTime.format(formatter);
//		}
//		return null;
//	}
//	
//	public static Timestamp convertStringToTimestamp(String dateStr) {
//		
//		try {
//		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		    Date parsedDate = dateFormat.parse(dateStr);
//		    return new java.sql.Timestamp(parsedDate.getTime());
//		} catch(Exception e) { 
//			log.error("Exception in convertStringToTimestamp :: " + e.getMessage()); 
//		}
//		return null;
//	}
//	
//	public static Predicate<Date> testExpriryDateIsValid = expiryDate -> {
//		Calendar cal = Calendar.getInstance();
//		return expiryDate.getTime() - cal.getTime().getTime() <= 0;
//	};
//	
//	 /**
//     * @param expiryTimeInMinutes
//     * @return Date
//     */
//    public static Date calculateExpiryDate(int expiryTimeInMinutes) {
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Timestamp(cal.getTime().getTime()));
//        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
//        return new Date(cal.getTime().getTime());
//    }
//    
//    /**
//     * @param zoneId
//     * @return String
//     */
//    public static String convertZoneIdToLocalDateStringWithoutTime(String zoneId) {
//		log.debug("zoneId :: " + zoneId);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		if(StringUtils.isNotBlank(zoneId)) {
//			LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//			ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of(zoneId));
//			return zonedDateTime.format(formatter);
//		}
//		return null;
//	}
//    
//    /**
//     * @param startDate
//     * @return java.sql.Date
//     */
//    public static java.sql.Date convertStringtoDBDate(String startDate) {
//
//    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		Date date = null;
//		try {
//			date = simpleDateFormat.parse(startDate);
//			return new java.sql.Date(date.getTime());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}


	@Value("#{new Integer('${documends.expiration.time}')}")
	private Integer EXPIRATION;
	
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
	@Autowired
	private ResetUserPasswordRepository resetUserPasswordRepository;

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
//	public Consumer<User> createVerificationOtp = (userEntity) -> {
//		Random random = new Random();
//		Integer otp = 1000 + random.nextInt(9000);
//		userEntity.setId(otp);
//		
//		UserRegistration userRegistration = new UserRegistration();
//		userRegistration.setOtp(otp);
//		userRegistration.setOtpCreationTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//		userRegistration.setOtpValid(true);
//		userRegistration.setUser(userEntity);
//		userRegistrationRepository.save(userRegistration);
//	};

	public Consumer<EmailObject> sendEmail = emailObject -> {
		eventPublisher.publishEvent(new OnEmailSignUpEvent(emailObject, Locale.US));
	};

	public static Optional<String> getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (org.springframework.util.StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return Optional.of(bearerToken.substring(7, bearerToken.length()));
		}
		return Optional.empty();
	}

	/**
	 * @param strDate
	 * @return Date
	 */
	public static Date convertStringToDbDate(String strDate) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = simpleDateFormat.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * @param zoneDate
	 * @param zoneId
	 * @return String
	 */
//	public static LocalDate convertZoneIdToLocalDate(String zoneId) {
//		log.debug("zoneId :: " + zoneId);
//		if(StringUtils.isNotBlank(zoneId)) {
//			LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//			ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
//			LocalDate localDate = jpTime.toLocalDate();
//			log.debug("zoneDate :: " + localDate);
//			return localDate;
//		}
//		return null;
//	}
//	
	public static boolean isCloserToNextDate(java.sql.Date originalDate, java.sql.Date previousDate,java.sql.Date nextDate) {
	    if(previousDate.after(nextDate))
	        throw new IllegalArgumentException("previousDate > nextDate");
	    return ((nextDate.getTime() - previousDate.getTime()) / 2 + previousDate.getTime() <= originalDate.getTime());
	}
//	public Consumer<User> createResetPasswordOtp = (userEntity) -> {
//		Random random = new Random();
//		Integer otp = 1000 + random.nextInt(9000);
//		userEntity.setId(otp);
//		
//		List<Optional<ResetUserPassword>> resetPwdList = resetUserPasswordRepository.findByUserId(userEntity.getId());
//		if(!resetPwdList.isEmpty()) {
//			for(Optional<ResetUserPassword> resetPwdOpt : resetPwdList) {
//				ResetUserPassword resetPwd = resetPwdOpt.get();
//				resetPwd.setOtpValid(false);
//				resetUserPasswordRepository.save(resetPwd);
//			}
//		}
//		
//		ResetUserPassword userPassword = new ResetUserPassword();
//		userPassword.setOtp(otp);
//		userPassword.setOtpCreationTimestamp(Timestamp.valueOf(LocalDateTime.now()));
//		userPassword.setOtpValid(true);
//		userPassword.setUser(userEntity);
//		resetUserPasswordRepository.save(userPassword);
//	};
	
	/**
	 * @param instant
	 * @param zoneId
	 * @return String
	 */
	public static String convertDbInstantToStringWithZone(Instant instant, String zoneId) {
		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of(zoneId));
		Timestamp timestamp = Timestamp.valueOf(zonedDateTime.toLocalDateTime());
		return dateTimeFormater.format(timestamp);
	}
	
	/**
	 * @param dbDate
	 * @return String
	 */
	public static String convertTimestampToString(Timestamp dbDate) {
		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
		return dateTimeFormater.format(dbDate);
	}
	
	/**
     * @param dbDate
     * @return String
     */
	public static String convertDbTimestampToString(java.sql.Date dbDate) {
		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy HH:mm aa");
		return dateTimeFormater.format(dbDate);
	}
	
	public static String convertDbTimestampToStringWithoutTime(java.sql.Date dbDate) {
		SimpleDateFormat dateTimeFormater = new SimpleDateFormat("dd-MM-yyyy");
		return dateTimeFormater.format(dbDate);
	}
	
	
	public static Timestamp thisWeekFromDate(String zoneId) {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
		LocalDate monday = jpTime.toLocalDate();
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }
	    return Timestamp.valueOf(monday.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp thisWeektoDate(String zoneId) {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
	    return Timestamp.valueOf(jpTime.toLocalDateTime());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp lastWeekFromDate(String zoneId) {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
		LocalDate monday = jpTime.toLocalDate();
	    while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
	      monday = monday.minusDays(1);
	    }
	    monday = monday.minusDays(7);
	    return Timestamp.valueOf(monday.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp lastWeektoDate(String zoneId) {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
		LocalDate sunday = jpTime.toLocalDate();
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }
	    sunday = sunday.minusDays(7);
	    return Timestamp.valueOf(sunday.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp previousMonthFromDate(String zoneId) {
		YearMonth yearMonthNow = YearMonth.now(ZoneId.of(zoneId));
		YearMonth yearMonthPrevious = yearMonthNow.minusMonths( 1 );
		LocalDate firstOfMonth = yearMonthPrevious.atDay( 1 );
	    return Timestamp.valueOf(firstOfMonth.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp previousMonthToDate(String zoneId) {
		YearMonth yearMonthNow = YearMonth.now(ZoneId.of(zoneId));
		YearMonth yearMonthPrevious = yearMonthNow.minusMonths( 1 );
		LocalDate lastOfMonth = yearMonthPrevious.atEndOfMonth();
	    return Timestamp.valueOf(lastOfMonth.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp currentMonthFromDate(String zoneId) {
		YearMonth yearMonthNow = YearMonth.now(ZoneId.of(zoneId));
		LocalDate firstOfMonth = yearMonthNow.atDay( 1 );
	    return Timestamp.valueOf(firstOfMonth.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp currentMonthToDate(String zoneId) {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
	    return Timestamp.valueOf(jpTime.toLocalDateTime());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp previousYearFromDate(String zoneId) {
		Year yearNow = Year.now(ZoneId.of(zoneId));
		Year yearPrevious = yearNow.minusYears( 1 );
		LocalDate firstOfYear = yearPrevious.atDay( 1 );
	    return Timestamp.valueOf(firstOfYear.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp previousYearToDate(String zoneId) {
		Year yearNow = Year.now(ZoneId.of(zoneId));
		Year yearPrevious = yearNow.minusYears( 1 );
		YearMonth yearMonthNow = yearPrevious.atMonth(12);
		LocalDate lastOfMonth = yearMonthNow.atEndOfMonth();
	    return Timestamp.valueOf(lastOfMonth.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp currentYearFromDate(String zoneId) {
		Year yearNow = Year.now(ZoneId.of(zoneId));
		LocalDate firstOfYear = yearNow.atDay( 1 );
	    return Timestamp.valueOf(firstOfYear.atStartOfDay());
	}
	
	/**
	 * @return Timestamp
	 */
	public static Timestamp currentYearToDate(String zoneId) {
		LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
		ZonedDateTime jpTime = dateTime.atZone(ZoneId.of(zoneId));
	    return Timestamp.valueOf(jpTime.toLocalDateTime());
	}
	
	public static String convertTimeZonetoDate(String sourceTimeZone, DateTimeFormatter formatter) {

		ZoneId fromTimeZone = ZoneId.of(sourceTimeZone);
		LocalDateTime today = LocalDateTime.now();
		ZonedDateTime currentISTime = today.atZone(fromTimeZone);
		return formatter.format(currentISTime);
	}
	
	
	/**
	 * @param startDate
	 * @param endDate
	 * @return String
	 */
	public static String findDifference(String startDateStr, String endDateStr) {
		
		String returnValue = "";
		SimpleDateFormat startDateSDF = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
		SimpleDateFormat endDateSDF = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			Date startDate = startDateSDF.parse(startDateStr);
            Date endDate = endDateSDF.parse(endDateStr);
			long difference_In_Time = endDate.getTime() - startDate.getTime();
			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;
			long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;
			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;
			long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
			long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;

			if (difference_In_Years > 0) {
				returnValue = returnValue + difference_In_Years + "y ";
			} 
			if (difference_In_Days > 0) {
				returnValue = returnValue + difference_In_Days + "d ";
			} 
			if (difference_In_Hours > 0) {
				returnValue = returnValue + difference_In_Hours + "h ";
			} 
			if (difference_In_Minutes > 0) {
				returnValue = returnValue + difference_In_Minutes + "m ";
			} 
			if (difference_In_Seconds > 0) {
				returnValue = returnValue + difference_In_Seconds + "s ";
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnValue;
	}
	
	
	/**
	 * @param zoneId
	 * @return String
	 */
//	public static String convertZoneIdToLocalDateString(String zoneId) {
//		log.debug("zoneId :: " + zoneId);
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
//		if(StringUtils.isNotBlank(zoneId)) {
//			LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
//			ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of(zoneId));
//			return zonedDateTime.format(formatter);
//		}
//		return null;
//	}
	
//	public static Timestamp convertStringToTimestamp(String dateStr) {
//		
//		try {
//		    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//		    Date parsedDate = dateFormat.parse(dateStr);
//		    return new java.sql.Timestamp(parsedDate.getTime());
//		} catch(Exception e) { 
//			log.error("Exception in convertStringToTimestamp :: " + e.getMessage()); 
//		}
//		return null;
//	}
	
	public static Predicate<Date> testExpriryDateIsValid = expiryDate -> {
		Calendar cal = Calendar.getInstance();
		return expiryDate.getTime() - cal.getTime().getTime() <= 0;
	};
	
	 /**
     * @param expiryTimeInMinutes
     * @return Date
     */
    public static Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
    
    /**
     * @param zoneId
     * @return String
     */
    public static String convertZoneIdToLocalDateStringWithoutTime(String zoneId) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if(StringUtils.isNotBlank(zoneId)) {
			LocalDateTime dateTime = LocalDateTime.now(ZoneId.of(zoneId));
			ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.of(zoneId));
			return zonedDateTime.format(formatter);
		}
		return null;
	}
    
    /**
     * @param startDate
     * @return java.sql.Date
     */
    public static java.sql.Date convertStringtoDBDate(String startDate) {

    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = simpleDateFormat.parse(startDate);
			return new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
