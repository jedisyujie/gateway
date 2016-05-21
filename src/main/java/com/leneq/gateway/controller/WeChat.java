package com.leneq.gateway.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leneq.gateway.domain.ParamForm;
import com.leneq.gateway.util.HttpUtil;

@Controller
@RequestMapping(value ="/wechat")
public class WeChat {

	@RequestMapping(value = "router")
	public void router(ParamForm params, HttpServletRequest request, HttpServletResponse response ){
		HttpUtil.writeXmlToClient(response, params.getEchostr());
	}
}
