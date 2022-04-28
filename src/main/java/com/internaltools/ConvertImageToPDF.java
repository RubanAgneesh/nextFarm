package com.internaltools;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import com.internaltools.util.CommonUtils;

public class ConvertImageToPDF {

    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        
    	//String zoneDate = CommonUtils.convertZoneIdToLocalDateString("Europe/Dublin");
    	
    	LocalDate zoneDate = CommonUtils.convertZoneIdToLocalDate("Europe/Dublin");
		Timestamp zoneTimestamp = Timestamp.valueOf(zoneDate.atTime(LocalTime.MIDNIGHT));
		System.out.println("Before transaction :: zoneTimestamp :: " + zoneTimestamp);
		
    }
    
    public static java.sql.Date convertStringtoDBDate(String startDate) {

    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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
