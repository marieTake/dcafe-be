package com.dcafe.order.util;

import java.text.SimpleDateFormat;

import org.springframework.expression.ParseException;

public class DateFormatUtill {
	
	private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	 
	private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	private java.util.Date parseDate(String date) throws java.text.ParseException {
	    try {
	        return DATE_FORMAT.parse(date);
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}
	 
	private java.util.Date parseTimestamp(String timestamp) throws java.text.ParseException {
	    try {
	        return DATE_TIME_FORMAT.parse(timestamp);
	    } catch (ParseException e) {
	        throw new IllegalArgumentException(e);
	    }
	}

}
