package com.ibm.indo.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;

public class Base64Converter {
	
	private static Logger log = Logger.getLogger("ijoinLogger");

	public  static String  encodeImage(byte[] imageByteArray) {
		 log.info("BannerEn  : 2");
		byte[] valueEncoded= Base64.encodeBase64(imageByteArray );
		log.info("BannerEn : "+valueEncoded);
		
		    return new String(valueEncoded);
        
    }
 
	public static Map<String,String> decodeImage(String imageDataString,String file) {
		log.info("Base64Converter.decodeImage - Start");
        BufferedImage bufImg = null;   	
        String path="/var/www/images/ijoin/";
    	BASE64Decoder decoder = new BASE64Decoder();
        byte[] imgBytes = null;
        ByteArrayInputStream stream =null;
        boolean flag = false;
        String format="jpeg";
        Map<String,String> map = new HashMap<String,String>();
        String temp[]=imageDataString.split(",");
        if(imageDataString.split(",").length>1){
        	imageDataString = temp[1];
        }
		try {
			imgBytes = decoder.decodeBuffer(imageDataString);
			log.info("Base64Converter.decodeImage() imgBytes.length "+imgBytes.length);
			stream = new ByteArrayInputStream(imgBytes);
			format=URLConnection.guessContentTypeFromStream(stream);
			if(null==format){format="jpeg";}
			log.info("Base64Converter.decodeImage() format "+format);
			temp =  format.split("/");
			if(temp.length>1){
				format = temp[1];
			}else{
				format = temp[0];
			}
			log.info("Base64Converter.decodeImage() format1 "+format);
			File imgOutFile = new File(path+file+"."+format);
			if(imgOutFile.exists())
			{
				imgOutFile = new File(path+IndoUtil.getAlphaNumeric(30)+"."+format);
			}else{
				imgOutFile.createNewFile();
			}
	    	bufImg = ImageIO.read(stream);
	    	log.info("Base64Converter.decodeImage() saving file at "+imgOutFile);
			flag = ImageIO.write(bufImg, format, imgOutFile);
			bufImg.flush();
			if(flag){
				map.put("Status", "SUCCESS");
				map.put("file", imgOutFile.getName());
			}
		} catch (IOException e) {
			log.error("Ijoin-1005- GenericServiceImpl.uploadImage() ce "+IndoUtil.getFullLog(e));
		}catch (Exception e) {
			log.error("Ijoin-1005- GenericServiceImpl.uploadImage() ce "+IndoUtil.getFullLog(e));
		}finally{
			if(null!=stream){
				try {
					stream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("Base64Converter.decodeImage - End");
			}
			log.info("Base64Converter.decodeImage() flag "+flag);
		}
		return map;
	}
}
