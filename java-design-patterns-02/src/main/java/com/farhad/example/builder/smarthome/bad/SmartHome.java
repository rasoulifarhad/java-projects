package com.farhad.example.builder.smarthome.bad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmartHome {
	private String name;
    private int serialNumber;
    private String addressName;
    private String addressNumber;
    private String city;
    private String country;
    private String postalCode;
    private int light1PortNum;
    private int light2PortNum;
    private int door1PortNum;
    private int door2PortNum;
    private int microwavePortNum;
    private int tvPortNum;
    private int waterHeaterPortNum;
	public SmartHome(String name, int serialNumber, String addressName, String addressNumber, String city,
			String country, String postalCode, int light1PortNum, int light2PortNum, int door1PortNum, int door2PortNum,
			int microwavePortNum, int tvPortNum, int waterHeaterPortNum) {
		this.name = name;
		this.serialNumber = serialNumber;
		this.addressName = addressName;
		this.addressNumber = addressNumber;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.light1PortNum = light1PortNum;
		this.light2PortNum = light2PortNum;
		this.door1PortNum = door1PortNum;
		this.door2PortNum = door2PortNum;
		this.microwavePortNum = microwavePortNum;
		this.tvPortNum = tvPortNum;
		this.waterHeaterPortNum = waterHeaterPortNum;
	}

	
}
