/**
 * 
 */
package com.ibm.cms.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.ibm.cms.Service.GenericService;
import com.ibm.indo.util.IndoUtil;

/**
 * @author Alok Ranjan
 *
 */
@Controller
public class LoginController {
	@Autowired
	GenericService genService;

	private static Logger log = Logger.getLogger("ijoinLogger");
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String loginPage(HttpServletRequest req,@RequestParam Map<String,String> params, Model model) {
	  log.info("CMS LoginController.loginPage(-) login page display ");
		 return "index";
		
	}
	
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public String loginService(HttpServletRequest req,@RequestParam Map<String,String> params, Model model ,HttpServletResponse response) {
		log.info("LoginController.loginService(-).............start. :"+params);
		System.out.println("params: "+params);
		Map<String, Object> data = new HashMap<String,Object>();
		if(null==params.get("userid") || StringUtils.isEmpty(params.get("userid"))){
			log.info("LoginController.loginService(-).............user id :."+params.get("userid")+" "+params.get("password"));
			return "index";
		}
		data =  genService.validateUser(params.get("userid"), params.get("password"));
		log.info("LoginController.loginService(-).............start."+data);
		if(IndoUtil.isSuccess(data)){
				if(params.get("systemCookies").equalsIgnoreCase("yes")){
					Cookie myCookie1 =new Cookie("userid",params.get("userid"));
					response.addCookie(myCookie1);
				}
			return "enquiry_device";
		}else{
			model.addAttribute("msg","Login_Fail");
			return "index";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logoutService(HttpSession session) {
		System.out.println("-----------------START Logout------------------------");
		try{
			//model.addAttribute("msg",IndoUtil.eMsg("Su. Please login."));
			session.invalidate();
			return "index";
		}catch(Exception ce){
			
		}
		log.info("-----------------END------------------------");
		return "index";
	}
	
	@RequestMapping(value = "/sessionInvalid")
	public String sessionInvalid(HttpServletRequest req, Model model) {
		log.info("-----------------START------------------------");
		try{
			model.addAttribute("msg",IndoUtil.eMsg("Session Expired. Please login."));
			return "index";
		}catch(Exception ce){
			
		}
		log.info("-----------------END------------------------");
		return null;
	}
	

}
