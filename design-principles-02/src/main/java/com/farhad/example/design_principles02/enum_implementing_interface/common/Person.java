package com.farhad.example.design_principles02.enum_implementing_interface.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String name;
	private int age;
	private int height;
	private int weight;
	private String eyeColor;
	private Gender gender;

	public void printAudit(StringBuffer buffer) {
		buffer.append("Name=");
		buffer.append(getName());
		buffer.append(",");
		buffer.append("Age=");
		buffer.append(getAge());
		buffer.append(",");
		buffer.append("Height=");
		buffer.append(getHeight());
		buffer.append(",");
		buffer.append("Weight=");
		buffer.append(getWeight());
		buffer.append(",");
		buffer.append("EyeColor=");
		buffer.append(getEyeColor());
		buffer.append(",");
		buffer.append("Gender=");
		buffer.append(getGender());		
	}

	public void printAudit() {
		StringBuffer sb = new StringBuffer();
		printAudit(sb);
		log.info(sb.toString());
	}

}
