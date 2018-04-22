package com.yangst.cloud.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yangst.cloud.demo.entity.User;

@RestController
public class HelloController {
	
	private final Logger log = Logger.getLogger(HelloController.class.getName());
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String index() throws InterruptedException {
		//让处理线程等待几秒钟
		int sleep =  new Random().nextInt(3000);
		log.info("sleeptime:"+sleep);
		Thread.sleep(sleep);
		return "hello World";
	}
	
	
	@RequestMapping(value = "/hello",method = RequestMethod.POST)
	public List<String> toindex(List<String> ids) throws InterruptedException {
		List<String> list =new ArrayList<>();
		for(int i=0;i<ids.size();i++) {
			list.add("hello World"+i);
		}
		return list;
	}
	
	@RequestMapping(value = "/hello1",method = RequestMethod.GET)
	public String hello(@RequestParam String name) {
		return "Hello"+name;
	}
	
	@RequestMapping(value = "/hello2",method = RequestMethod.GET)
	public User hello(@RequestHeader String name,@RequestHeader Integer age) {
		return new User(name,age);
	}
	
	@RequestMapping(value = "/hello3",method = RequestMethod.POST)
	public String hello(@RequestBody User user) {
		return "Hello"+user.getName()+","+user.getAge();
	}

}
