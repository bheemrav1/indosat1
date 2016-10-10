package com.ibm.cms.Service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface GenericService {
	Map<String, Object> validateUser(String uid, String pwd);
	Map<String, Object> forgotPassword(String userId);
	Map<String, Object> addDevice(String string, String string2, String string3, String string4, String string5,
			String pic1,String pic2,String pic3,String pic4);
	Map<String, Object> getdetails();
	Map<String, Object> editDeviceDetails(String name);
	Map<String, Object> editDevice(String name, String brand, String price, String details, String color, String pic1,
			String pic2, String pic3, String pic4);
	Map<String, Object> deleteDeviceDetails(String name);
	Map<String, Object> forgot(String msisdn, String emailID);
	Map<String, Object> removeIMG(String String);
}
