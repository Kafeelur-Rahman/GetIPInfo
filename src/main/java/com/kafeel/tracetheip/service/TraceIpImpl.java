package com.kafeel.tracetheip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.kafeel.tracetheip.model.IPApiResponse;

@Component
public class TraceIpImpl implements TraceIP {

	@Autowired
	RestTemplate restTemplate;
	
	private static final String URL="http://ip-api.com/json/";
	
	@Override
	public IPApiResponse traceIp(String ip) {
		
		IPApiResponse response = restTemplate.exchange(URL+ip,HttpMethod.POST, null, IPApiResponse.class)
				.getBody() ;
		
		System.out.println("Response : "+response);
		return response;
	}

}
