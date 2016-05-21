package com.leneq.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ="/")
public class Hello {

	@RequestMapping(value = "hello")
	public String sayHello(){
		return "index";
	}
}
