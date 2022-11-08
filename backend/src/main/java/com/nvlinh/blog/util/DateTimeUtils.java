package com.nvlinh.blog.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtils {
	public Date convertToGMT7Time(Date date) throws ParseException {
		DateFormat df = new SimpleDateFormat();
		df.setTimeZone(TimeZone.getTimeZone("GMT+7"));
		return df.parse(date.toString());
	}
}
