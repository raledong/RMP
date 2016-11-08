package com.cell.convertor;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/** 
* @author 作者 rale 
* @version 创建时间：Mar 7, 2016 11:24:50 AM 
* date和string之间的转换
*/
@Converter
public class DateToStringConverter implements AttributeConverter<String, Date>{

	DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Date convertToDatabaseColumn(String value) {
		if(value == null || value.equals(""))
			return null;
		Date date = null;
		try {
			date = format.parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	@Override
	public String convertToEntityAttribute(Date value) {
		if(value == null)
			return null;
		return format.format(value);
	}

}
