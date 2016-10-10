package com.ibm.cms.Controller;

import java.util.HashMap;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.cms.Service.GenericService;
import com.ibm.indo.util.IndoUtil;

/**
 * @author Alok Ranjan
 *
 */

@RestController
public class CmsController {
	@Autowired
	GenericService genService;

	private static Logger log = Logger.getLogger("ijoinLogger");
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> forgot(HttpServletRequest req, @RequestParam Map<String, String> params, Model model) {
		log.info("-----------------START------------------------");
		Map<String, Object> map = new HashMap<String, Object>();
		try{
		log.info("Params  : " +params);
		if(params.get("userId").toString()!=null || params.get("msisdn").toString()!=null){
				map = genService.forgot(params.get("userId"), params.get("msisdn"));
				if (IndoUtil.isSuccess(map)) {
					System.out.println("test5 :"+map);
					Properties props1 = new Properties();
					props1.put("mail.smtp.host", "smtpgw.indosatooredoo.com");
					props1.put("mail.smtp.port", "25");
				//	props1.put("mail.smtp.user", false);
				//	props1.put("mail.smtp.password", false);
					props1.put("mail.transport.protocol","smtp"); 
					Session session = Session.getDefaultInstance(props1);
					session.setDebug(true);
					MimeMessage msg = new MimeMessage(session);
					log.info("Msg is  || " + msg);
					InternetAddress addressFrom = new InternetAddress("noreply@indosatooredoo.com");
					log.debug("addressFrom is  || " + addressFrom);
					log.debug("Msg is *** || " + msg);
					addressFrom.setPersonal("INDOSAT");
			        msg.setFrom(addressFrom);
			        log.info("email to send mail: "+map.get("EMAIL").toString());
					msg.addRecipient(Message.RecipientType.TO, new InternetAddress(map.get("EMAIL").toString()));
					msg.setSubject("Your Password");
					msg.setText("Your New password is : "+map.get("USER_PASSWORD"));
					Transport.send(msg);
				}else{
					map.put("Status","FAILTURE");
				}
				
		}
		} catch (Exception ce) {
			ce.printStackTrace();
			model.addAttribute("msg","Failture_Forgot_Password");
			IndoUtil.populateErrorMap(map, "Indo-218","Failed to retrive password.",0);
			log.error(" CmsController.forgot() ce " + IndoUtil.getFullLog(ce));
		}
		log.info("-----------------END------------------------");
		return map;
	}
}
