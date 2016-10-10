package com.ibm.cms.ServiceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ibm.cms.Service.GenericService;
import com.ibm.indo.util.DBUtil;
import com.ibm.indo.util.IndoUtil;

/*
 * 
 * Author Alok Ranjan
 * 
 */
@Service
public class GenericServiceImpl implements GenericService{
	@Autowired
	DBUtil dbUtil;
	


	private static Logger log = Logger.getLogger("ijoinLogger");
	
	@Override
	public Map<String, Object> validateUser(String uid, String pwd) {
		log.info("GenericServiceImpl.validateUser(-).............start.");
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			data = dbUtil.getRow("select * from mobilecms_users where userid=? and password=?", new Object[] {uid,pwd});
			String LoginID= data.get("USERID").toString();
			if (data.get("PASSWORD").toString().equals(pwd)) {
				data.put("LoginID",LoginID);
				data.put("Status", "SUCCESS");
				return data;
			}
		} catch (EmptyResultDataAccessException ce) {
			IndoUtil.populateErrorMap(data, "Indo-1025", "Subscriber number not found. Please register.", 0);
		} catch (Exception ce) {
			log.info("Indo-1025- GenericServiceImpl.validateUser() e - " + ce);
			IndoUtil.populateErrorMap(data, "Indo-1025", "Subscriber number not found. Please register.", 0);
		}
		log.info("GenericServiceImpl.validateUser(-).............end. map :" + data);
		return data;
	}

	@Override
	public Map<String, Object> getdetails() {
		System.out.println("GenericServiceImpl.validateUser(-).............start.");
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList <Map<String, Object>>();
		try {
			list = dbUtil.getData("select * from ( select ROWNUM NO,m.BRAND,m.COLOR,m.DETAILS,m.NAME,m.PRICE from MOBILECMS_DEVICE m)", new Object[] {});
			if(list.size()>0){	
				data.put("data",list);
				data.put("Status", "SUCCESS");
			}
		} catch (Exception ce) {
			IndoUtil.populateErrorMap(data, "Order-524","Unable to Update",0);
			System.out.println("Indo-218- OrderController.updateOrder() ce " + ce);
		}
		return data;
	}

	@Override
	public Map<String, Object> forgotPassword(String userid) {
		log.info("packageServiceImpl.forgot(-)  start");
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			list = dbUtil.getData("select * from MOBILECMS_USERS where email =?",new Object[] {userid});
			if (list != null &&list.size() > 0) {
				data.put("Password",list.get(0).get("password"));
				data.put("Status","SUCCESS");
			}else{
				IndoUtil.populateErrorMap(data, "Indo-100", "Failed to change password", 0);
			}
		} catch (EmptyResultDataAccessException ce) {
			IndoUtil.populateErrorMap(data, "Indo-101", "Unable to Validate User now. Please try again later.", 0);
		} catch (Exception ce) {
			log.info("Indo-100- packageServiceImpl.forgot() e - " + IndoUtil.getFullLog(ce));
			IndoUtil.populateErrorMap(data, "Indo-100", ce.getClass().getSimpleName(), 0);
		}
		return data;
	}

	@Override
	public Map<String, Object> editDevice(String name, String brand, String price, String details, String color,String pic1,String pic2,String pic3,String pic4) {
		log.info("GenericServiceImpl.editDevice() - START" +name);
		Map<String, Object> map=new HashMap<String, Object>();
		   int count=0;
		try {
			String sql="update MOBILECMS_device_image set ";
			String condition="";
			//"select DISTINCT "+col+" from ijoin_location where "+where+"=?
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			if(pic1!=null){
				sql=sql+" pic1=? ";
				condition=condition+pic1;
				count=count+1;
			}
			
			if(pic2!=null){
				if(count>0){
				  sql=sql+",";	
				  condition=condition+",";	
				}
				sql=sql+"pic2=? ";
				condition=condition+pic2;
				count=count+1;
			}
			
			if(pic3!=null){
				 if(count>0){
					sql=sql+","; 
					condition=condition+",";
				 }
				sql=sql+" pic3=? ";
				condition=condition+pic3;
				count=count+1;
			}
			
			if(pic4!=null){
				if(count>0){
					sql=sql+","; 
					condition=condition+",";
				 }
				sql=sql+" pic4=? ";
				condition=condition+pic4;
				count=count+1;
			}
			
			 sql=sql+" where name=? ";
			condition=condition+",";

			condition=condition+name;	
			String[] str1=condition.split(",");	
			log.info("qry : "+sql);
			log.info("str1 : "+Arrays.toString(str1));
			int ct1,ct2=0;
				if(!StringUtils.isEmpty(name)){
						list=dbUtil.getData("select * from MOBILECMS_device where name=?", new Object[]{name});
					if(list.size()>0){
							ct1 = dbUtil.saveData("update MOBILECMS_device set brand=?,price=?,details=?,color=? where name=?", new Object[]{brand,price,details,color,name});
						if(pic1!=null || pic2!=null || pic3!=null || pic4!=null)
							ct2= dbUtil.saveData(sql, str1);
						if(pic1!=null || pic2!=null || pic3!=null || pic4!=null && ( ct1>0 && ct2>0)){
							map.put("Status","SUCCESS");
						}else if(ct1>0){
							map.put("Status","SUCCESS");
						}
					}else{
						map.put("Status", "FAILTURE");
						IndoUtil.populateErrorMap(map, "MOBILECMS_device-1002", "Product Details already Stored.",0);
						return map;
					}
				}
			}catch (Exception ce) {
				ce.printStackTrace();
				log.info("MobileCRM-100- CmsController.editDevice() e - " + IndoUtil.getFullLog(ce));
			}
				log.info("CmsController.editDevice. End");
			return map;
	}

	@Override
	public Map<String, Object> addDevice(String name, String brand, String price, String details, String color,String pic1,String pic2,String pic3,String pic4) {
		log.info("GenericServiceImpl.addDevice() - START " +pic1);
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			int ct=0;
				if(!StringUtils.isEmpty(name)){
						list=dbUtil.getData("select * from MOBILECMS_device where name=?", new Object[]{name});
					if(list.size()>0){
						map.put("Status", "FAILTURE");
						IndoUtil.populateErrorMap(map, "MOBILECMS_device-1002", "Product Details already Stored.",0);
						return map;
					}else{
						ct = dbUtil.saveData("insert into MOBILECMS_device(name,brand,price,details,color) VALUES(?,?,?,?,?)", new Object[]{name,brand,price,details,color});
						if(ct>0){
							dbUtil.saveData("insert into MOBILECMS_device_image (name,pic1,pic2,pic3,pic4) values(?,?,?,?,?)", new Object[]{name,pic1,pic2,pic3,pic4});
						}
						map.put("Status","SUCCESS");
					}
				}
			}catch (Exception ce) {
				ce.printStackTrace();
				log.info("MobileCRM-100- genericServiceImpl.addDevice() e - " + IndoUtil.getFullLog(ce));
			}
				log.info("genericServiceImpl.addDevice(). Start");
			return map;
	}

	
	@Override
	public Map<String, Object> editDeviceDetails(String name) {
		log.info("GenericServiceImpl.editDeviceDetails() - START");
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			if(!StringUtils.isEmpty(name)){
					list=dbUtil.getData("select * from (select a.name,a.brand,a.price,a.details,a.color,b.pic1,b.pic2,b.pic3,b.pic4 from MOBILECMS_device a,MOBILECMS_device_image b where a.name=b.name and a.name=?)", new Object[]{name});
				if(list.size()<0){
					map.put("Status", "FAILTURE");
					IndoUtil.populateErrorMap(map, "MOBILECMS_device-1002", "Unable to retrieve the data please check the Name.",0);
					return map;
				}else{
					map.put("list",list);
					map.put("Status","SUCCESS");
				}
			}
		}catch (Exception ce) {
			IndoUtil.populateErrorMap(map, "MobileCRM-100", "Device details not found.", 0);
			log.info("MobileCRM-100- genericServiceImpl.editDeviceDetails() e - " + IndoUtil.getFullLog(ce));
		}
			log.info("genericServiceImpl.editDeviceDetails(). Start");
		return map;
	}
	
	@Override
	public Map<String, Object> deleteDeviceDetails(String name) {
			// list of name coming for delete device infor like "test1,test2,test3"	
		log.info("GenericServiceImpl.deleteDeviceDetails() - START");
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			int ct1=0,ct2=0;
			 String nameArray[]=name.split(",");
			 for(String name1:nameArray){
				 ct1=dbUtil.saveData("delete from MOBILECMS_device where name=?", new Object[]{name1});
				 ct2=dbUtil.saveData("delete from MOBILECMS_device_image where  name=?", new Object[]{name1});
			 }
			  if(ct1>0 && ct2>0){
					map.put("Status","SUCCESS");
				}else{
					map.put("Status", "FAILTURE");
				}
		}catch (Exception ce) {
			ce.printStackTrace();
			IndoUtil.populateErrorMap(map, "MobileCRM-100", "Device details not found.", 0);
			log.info("MobileCRM-100- genericServiceImpl.deleteDeviceDetails() e - " + IndoUtil.getFullLog(ce));
		}
			log.info("genericServiceImpl.deleteDeviceDetails(). Start");
		return map;
	}
	
	@Override
	public Map<String, Object> forgot(String email , String msisdn) {
		log.info("genericServiceImpl.forgot(-)  start");
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> vList = new ArrayList<Map<String, Object>>();
		try {
			vList = dbUtil.getData("select * from mobilecms_users where email=? or msisdn=? ",new Object[] {email,msisdn});
			if (vList != null && vList.size() > 0) {
				System.out.println("test3");
				String newPassword=IndoUtil.getAlphaNumeric(8);
				int	ct1 = dbUtil.saveData("update mobilecms_users set password=? where email=? or msisdn=?", new Object[]{newPassword,email,msisdn});
					if(ct1>0){	
						data.put("USER_PASSWORD",newPassword);
						data.put("EMAIL",vList.get(0).get("EMAIL"));
						data.put("Status","SUCCESS");
					}else{
						data.put("Status","FAILTURE");
					}
				}else{
				IndoUtil.populateErrorMap(data, "Indo-100", "Record Not Found!", 0);
			}
						 
		} catch (EmptyResultDataAccessException ce) {
			IndoUtil.populateErrorMap(data, "MobileCRM-100", "Unable to Validate User now. Please try again later.", 0);
		} catch (Exception ce) {
			log.info("MobileCRM-100- genericServiceImpl.forgot() e - " + IndoUtil.getFullLog(ce));
			IndoUtil.populateErrorMap(data, "MobileCRM-100", ce.getClass().getSimpleName(), 0);
		}
		log.info("genericServiceImpl.forgot(-)  end");
		return data;
	}
	
	@Override
	public Map<String, Object> removeIMG(String img) {
		log.info("genericServiceImpl.removeIMG(-)  start :"+img);
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> vList = new ArrayList<Map<String, Object>>();
		try {
			  String str[]= img.split(",");
				 for(String str1:str){
				    File file= new File("/var/www/images/mobcrm/"+str1);
				      if(file.exists()){
				    	  	file.delete(); 
					    	 log.info("genericServiceImpl image remove : "+str1);
				      }
	 
				  }		 
		} catch (EmptyResultDataAccessException ce) {
			IndoUtil.populateErrorMap(data, "MobileCRM-100", "Unable to Remove image from server.", 0);
		} catch (Exception ce) {
			log.info("MobileCRM-100- genericServiceImpl.removeIMG() e - " + IndoUtil.getFullLog(ce));
			IndoUtil.populateErrorMap(data, "MobileCRM-100", ce.getClass().getSimpleName(), 0);
		}
		return data;
	}
	
}
