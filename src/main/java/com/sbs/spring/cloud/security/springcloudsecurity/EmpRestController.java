package com.sbs.spring.cloud.security.springcloudsecurity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbs.spring.cloud.vo.Employee;

@RestController
@EnableOAuth2Sso
public class EmpRestController {

	Map<String, Employee> empMap = new HashMap<String, Employee>();

	@RequestMapping(value="/emps",method = RequestMethod.GET)
	public Collection<Employee> getAllEmpoyee() {
		empMap.put("1", new Employee("1", "Bhargav"));
		empMap.put("2", new Employee("2", "Swamy"));
		empMap.put("3", new Employee("3", "Surimenu"));

		return empMap.values();
	}
	
	@Autowired
	OAuth2ClientContext oauth2Context;
	
	@GetMapping(value="/token")
	public String getToken()
	{
		
		String token = oauth2Context.getAccessToken().getValue();
		System.out.println("token --->"+token);
		return token;
	}
	
	
	
}
