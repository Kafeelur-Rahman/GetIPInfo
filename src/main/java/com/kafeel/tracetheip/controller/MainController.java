package com.kafeel.tracetheip.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kafeel.tracetheip.service.EmailService;
import com.kafeel.tracetheip.service.TraceIP;

@Controller
public class MainController {

	@Autowired
	TraceIP traceIp;
	
	@Autowired
	EmailService mailService;
	
	private String ip;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		
		//Storing user's Ip Address
		ip=request.getRemoteAddr();
		
		//Sending IP information to the client.
		mailService.sendMail(traceIp.traceIp(ip).toString());
		
		return "seeMyPhoto";
	}
}
