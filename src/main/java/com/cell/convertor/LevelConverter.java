package com.cell.convertor;

import javax.persistence.AttributeConverter;

import com.cell.enumType.Level;


public class LevelConverter implements AttributeConverter<Level, Integer>{

	@Override
	public Integer convertToDatabaseColumn(Level attribute) {
		
		if(attribute == null)
			return null;
		
		return attribute.getCode();
	}

	@Override
	public Level convertToEntityAttribute(Integer dbData) {
		if(dbData == null)
			return null;
		
		return Level.fromCode(dbData);
	}

}
