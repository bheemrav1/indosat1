package com.ibm.cms.Controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.ibm.cms.Service.GenericService;
import com.ibm.indo.util.IndoUtil;

@Controller
public class DeviceController {
	
	@Autowired
	GenericService genService;

	private static Logger log = Logger.getLogger("ijoinLogger");
	
	@RequestMapping(value = "/device_page",method=RequestMethod.GET)
	public String add_device(HttpServletRequest req,@RequestParam Map<String,String> params, Model model) {
	  log.info("CRM LoginController.add_device(-)");
		 return "add_device";
	}
	
	@RequestMapping(value = "/home",method=RequestMethod.GET)
	public String home(HttpServletRequest req,@RequestParam Map<String,String> params, Model model) {
	  log.info("CMS LoginController.home(-)");
		 return "enquiry_device";
	}
	
	
	@RequestMapping(value = "/getdetails", produces = "application/json")
	public @ResponseBody Map<String, Object> getdetails(HttpServletRequest req, @RequestParam Map<String, String> params) {
		log.info("-----------------START------------------------" + params);
		Map<String, Object> data = new HashMap<String, Object>();
		try{	
			data = genService.getdetails();
			if(IndoUtil.isSuccess(data)){
				return data;
			}
		}catch(Exception ce){
			IndoUtil.populateErrorMap(data, "Indo-218","No Packs Found.",0);
			log.info("Indo-218- CmsController.fetchPack() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return data;
	}
	
	/*
	@RequestMapping(value = "/addDevice")
	public @ResponseBody Map<String, Object> addDevice(@RequestPart("pic1") MultipartFile pic1,@RequestPart("pic2") MultipartFile pic2,@RequestPart("pic3") MultipartFile pic3,
			@RequestPart("pic4") MultipartFile pic4, HttpServletRequest req, @RequestParam Map<String, String> params, Model model) {
		log.info("CmsController.addDevice() START");
		String root1="http://testmobileagent.indosatooredoo.com";
		String root3="/images/mobcrm/";
		String root2="/var/www";
		String img1=IndoUtil.getAlphaNumeric(8)+".png";
		String img2=IndoUtil.getAlphaNumeric(8)+".png";
		String img3=IndoUtil.getAlphaNumeric(8)+".png";
		String img4=IndoUtil.getAlphaNumeric(8)+".png";
		Map<String, Object> data = new HashMap<String,Object>();
		String path1=""+root2+""+root3+""+img1;
		String path2=""+root2+""+root3+""+img2;
		String path3=""+root2+""+root3+""+img3;
		String path4=""+root2+""+root3+""+img4;
		log.info("level-2-----------------"+path1);
		try{
			File file = new File(path1);
		    if(pic1!=null){	
				if(!file.exists()){
					file.createNewFile();
				}
				pic1.transferTo(file);
		    }
			
		    if(pic2!=null){
				file = new File(path2);
				if(!file.exists()){
					file.createNewFile();
				}
				pic2.transferTo(file);
		    }
		    if(pic3!=null){
				file = new File(path3);
				if(!file.exists()){
					file.createNewFile();
				}
				pic3.transferTo(file);
		    }
		    if(pic4!=null){
				file = new File(path4);
				if(!file.exists()){
					file.createNewFile();
				}
				pic4.transferTo(file);
		    }
			data = genService.addDevice(params.get("devicename")  ,params.get("brand")  ,params.get("price")  ,params.get("details")  ,params.get("color")  ,root1+""+root3+""+img1,root1+""+root3+""+img2,root1+""+root3+""+img3,root1+""+root3+""+img4);
			if(IndoUtil.isSuccess(data)){
				
			}else{
				new File(path1).delete();new File(path2).delete();new File(path3).delete();new File(path4).delete();
			}
		}catch(Exception ce){
			ce.printStackTrace();
			IndoUtil.populateErrorMap(data, "Indo-218","Unable To Register Device",0);
			
			log.info("Indo-218- CmsController.getdevice() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return data; 
	}
	

		
	@RequestMapping(value = "/editDevice")
	public @ResponseBody Map<String, Object> editDevice(@RequestParam(value="pic1", required=false) MultipartFile pic1,@RequestParam(value="pic2", required=false) MultipartFile pic2,@RequestParam(value="pic3", required=false) MultipartFile pic3,
			@RequestParam(value="pic4", required=false) MultipartFile pic4, HttpServletRequest req, @RequestParam Map<String, String> params, Model model) {
		System.out.println("CmsController.editDevice() START pic1 :"+params);
		Map<String, Object> data = new HashMap<String,Object>();
		try{	
			
		String img1=IndoUtil.getAlphaNumeric(8)+".png";
		String img2=IndoUtil.getAlphaNumeric(8)+".png";
		String img3=IndoUtil.getAlphaNumeric(8)+".png";
		String img4=IndoUtil.getAlphaNumeric(8)+".png";
		String path1="/var/www/images/mobcrm/"+img1;
		String path2="/var/www/images/mobcrm/"+img2;
		String path3="/var/www/images/mobcrm/"+img3;
		String path4="/var/www/images/mobcrm/"+img4;
		String dbUrl1="http://testmobileagent.indosatooredoo.com/images/mobcrm/"+img1;
		String dbUrl2="http://testmobileagent.indosatooredoo.com/images/mobcrm/"+img2;
		String dbUrl3="http://testmobileagent.indosatooredoo.com/images/mobcrm/"+img3;
		String dbUrl4="http://testmobileagent.indosatooredoo.com/images/mobcrm/"+img4;
		log.info("level-2-----------------"+path1);
	
			File file = new File(path1);
		    if(pic1!=null && pic1.getOriginalFilename()!=null && pic1.getOriginalFilename()!="" &&!pic1.isEmpty()){	
		    	if(!file.exists()){
					file.createNewFile();
				}
				pic1.transferTo(file);
		    }else{
		    	dbUrl1=null;
		    
		    }
		    if(pic2!=null &&  pic2.getOriginalFilename()!=null && pic2.getOriginalFilename()!="" && !pic2.isEmpty()){
				file = new File(path2);
				if(!file.exists()){
					file.createNewFile();
				}
				pic2.transferTo(file);
		    }else{
		    	dbUrl2=null;
		    }
		    if(pic3!=null && pic3.getOriginalFilename()!=null && pic3.getOriginalFilename()!="" && !pic3.isEmpty()  ){
		    	file = new File(path3);
				if(!file.exists()){
					file.createNewFile();
				}
				pic3.transferTo(file);
		    }else{
				
		    	dbUrl3=null;
		    }
		     
		    if(pic4!=null && pic4.getOriginalFilename()!=null && pic4.getOriginalFilename()!="" && !pic4.isEmpty()){
		    	file = new File(path4);
				if(!file.exists()){
					file.createNewFile();
				}
				pic4.transferTo(file);
		    }else{
		    	dbUrl4=null;
		    }
			data = genService.editDevice(params.get("devicename")  ,params.get("brand")  ,params.get("price")  ,params.get("details")  ,params.get("color")  ,dbUrl1,dbUrl2,dbUrl3,dbUrl4);
			if(IndoUtil.isSuccess(data)){
				  genService.removeIMG(params.get("deleteImg"));				
			}else{
				new File(path1).delete();new File(path2).delete();new File(path3).delete();new File(path4).delete();
			}
		}catch(Exception ce){
			ce.printStackTrace();
			IndoUtil.populateErrorMap(data, "Indo-218","Unable To Register Device",0);
			
			log.info("Indo-218- CmsController.editDevice() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return data; 
	}
*/	
	
	// please uncomment this code at the time of running application in location system and comment same other your is there
	@RequestMapping(value = "/addDevice")
	public @ResponseBody Map<String, Object> addDevice(@RequestPart("pic1") MultipartFile pic1,@RequestPart("pic2") MultipartFile pic2,@RequestPart("pic3") MultipartFile pic3,
			@RequestPart("pic4") MultipartFile pic4, HttpServletRequest req, @RequestParam Map<String, String> params, Model model) {
		log.info("CmsController.addDevice() START");
		Map<String, Object> data = new HashMap<String,Object>();
		String path1="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		String path2="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		String path3="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		String path4="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		try{
			log.info("level-2-----------------"+path1);
	
	
			File file = new File("c:/"+path1);
		    if(pic1!=null){	
				if(!file.exists()){
					file.createNewFile();
				}
				pic1.transferTo(file);
		    }else{
		    	path1=null;
		    }
			
		    if(pic2!=null){
				file = new File("c:/"+path2);
				if(!file.exists()){
					file.createNewFile();
				}
				pic2.transferTo(file);
		    }else{
		    	path2=null;
		    }
		    if(pic3!=null){
				file = new File("c:/"+path3);
				if(!file.exists()){
					file.createNewFile();
				}
				pic3.transferTo(file);
		    }else{
		    	path3=null;
		    }
		     
		    if(pic4!=null){
				file = new File("c:/"+path4);
				if(!file.exists()){
					file.createNewFile();
				}
				pic4.transferTo(file);
		    }else{
		    	path4=null;
		    }
			data = genService.addDevice(params.get("devicename")  ,params.get("brand")  ,params.get("price")  ,params.get("details")  ,params.get("color")  ,path1,path2,path3,path4);
	
			if(IndoUtil.isSuccess(data)){
				
			}else{
				new File(path1).delete();new File(path2).delete();new File(path3).delete();new File(path4).delete();
			}
		}catch(Exception ce){
			IndoUtil.populateErrorMap(data, "Indo-218","Unable To Register Device",0);
			
			log.info("Indo-218- IJoinController.getdevice() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return data; 
	}
	
	@RequestMapping(value = "/editDevice")
	public @ResponseBody Map<String, Object> editDevice(@RequestParam(value="pic1", required=false) MultipartFile pic1,@RequestParam(value="pic2", required=false) MultipartFile pic2,@RequestParam(value="pic3", required=false) MultipartFile pic3,
			@RequestParam(value="pic4", required=false) MultipartFile pic4, HttpServletRequest req, @RequestParam Map<String, String> params, Model model) {
		log.info("CmsController.editDevice() START pic1 :"+pic1);
		Map<String, Object> data = new HashMap<String,Object>();
		String path1="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		String path2="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		String path3="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		String path4="app/var/www/images/mobcrm/"+IndoUtil.getAlphaNumeric(8)+".png";
		try{
			log.info("level-2-----------------"+path1);
	
	
			File file = new File("c:/"+path1);
		    if(pic1!=null){	
				if(!file.exists()){
					file.createNewFile();
				}
				pic1.transferTo(file);
		    }else{
		    	path1=null;
		    }
			
		    if(pic2!=null){
				file = new File("c:/"+path2);
				if(!file.exists()){
					file.createNewFile();
				}
				pic2.transferTo(file);
		    }else{
		    	path2=null;
		    }
		    if(pic3!=null){
				file = new File("c:/"+path3);
				if(!file.exists()){
					file.createNewFile();
				}
				pic3.transferTo(file);
		    }else{
		    	path3=null;
		    }
		     
		    if(pic4!=null){
				file = new File("c:/"+path4);
				if(!file.exists()){
					file.createNewFile();
				}
				pic4.transferTo(file);
		    }else{
		    	path4=null;
		    }
			data = genService.editDevice(params.get("devicename")  ,params.get("brand")  ,params.get("price")  ,params.get("details")  ,params.get("color")  ,path1,path2,path3,path4);
	
			if(IndoUtil.isSuccess(data)){
				
			}else{
				new File(path1).delete();new File(path2).delete();new File(path3).delete();new File(path4).delete();
			}
		}catch(Exception ce){
			IndoUtil.populateErrorMap(data, "Indo-218","Unable To Register Device",0);
			
			log.info("Indo-218- IJoinController.getdevice() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return data; 
	}
	
	@RequestMapping(value = "/editDeviceDetails", produces = "application/json")
	public  String editDeviceDetails(HttpServletRequest req, @RequestParam Map<String, String> params,Model model) {
		log.info("-----------------START------------------------" + params);
	    System.out.println("params: "+params);
		Map<String, Object> data = new HashMap<String, Object>();
		List <Map<String, Object>> list=null;
		try{	
			data = genService.editDeviceDetails(params.get("name"));
			if (IndoUtil.isSuccess(data)) {
				list = (List<Map<String, Object>>) data.get("list");
			}
			String jsonList = new Gson().toJson(list);
			log.info("json list :"+jsonList);
			model.addAttribute("list", jsonList);
		}catch(Exception ce){
			IndoUtil.populateErrorMap(data, "Indo-218","No Packs Found.",0);
			log.info("Indo-218- CmsController.fetchPack() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return "edit_device";
	}

	@RequestMapping(value = "/deleteDeviceDetails", produces = "application/json")
	public @ResponseBody Map<String, Object> deleteDeviceDetails(HttpServletRequest req, @RequestParam Map<String, String> params) {
		log.info("-----------------START------------------------" + params);
		Map<String, Object> data = new HashMap<String, Object>();
		try{	
			data = genService.deleteDeviceDetails(params.get("name"));
			if(IndoUtil.isSuccess(data)){
				return data;
			}
		}catch(Exception ce){
			IndoUtil.populateErrorMap(data, "Indo-218","No Packs Found.",0);
			log.info("Indo-218- CmsController.deleteDeviceDetails() ce "+IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------"+data.get("Status"));
		return data;
	}
	
}
