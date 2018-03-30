package com.yangst.cloud.demo.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yangst.demo.api.entity.User;

@RequestMapping("/refactor")
public interface HelloRefactorService {
	@RequestMapping(value = "/hello4",method = RequestMethod.GET)
	public String hello(@RequestParam("name") String name);
	
	@RequestMapping(value = "/hello5",method = RequestMethod.GET)
	public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age);
	
	@RequestMapping(value = "/hello6",method = RequestMethod.POST)
	public String hello(@RequestBody User user);

}
