package com.cell.convertor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.cell.enumType.Gender;



@Converter
public class GenderConverter implements AttributeConverter<Gender, Integer>{

	@Override
	public Integer convertToDatabaseColumn(Gender value) {
		if(value == null)
			return null;
		
		return value.getCode();
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		if(value == null)
			return null;
		
		return Gender.fromCode(value);
	}

}
