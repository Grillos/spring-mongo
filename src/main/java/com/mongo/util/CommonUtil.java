package com.mongo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CommonUtil {
	
	public static String getCurrentBrasilianDate() {
		LocalDate now = LocalDate.now(); 
		return sqlDateToBrazilian(now.toString());
	}
	
	static public String sqlDateToBrazilian(final String inputDate) {
		final String BRASIL_DATE_FORMAT = "dd/MM/yyyy";
        final String SQL_DATE_FORMAT = "yyyy-MM-dd";
        try {
            Date date = new SimpleDateFormat(SQL_DATE_FORMAT).parse(inputDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BRASIL_DATE_FORMAT);
            return simpleDateFormat.format(date);
        } catch (ParseException e) {
            return "";
        }
    }
	
	 static public Boolean isNullOrEmpty(final String string) {
	        Boolean result = true;
	        if (string != null)
	            if (!string.trim().isEmpty())
	                result = false;
	        return result;
	    }

}
