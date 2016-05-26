package com.leneq.gateway.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leneq.gateway.domain.ParamForm;
import com.leneq.gateway.util.HttpUtil;

@Controller
@RequestMapping(value ="/wechat")
public class WeChat {
	
	private static Logger logger = LoggerFactory.getLogger(WeChat.class);

	private static final String REP_XML="<xml>"
										+	"<ToUserName><![CDATA[toUser]]></ToUserName>"
										+	"	<FromUserName><![CDATA[fromUser]]></FromUserName>"
										+	"	<CreateTime>12345678</CreateTime>"
										+	"	<MsgType><![CDATA[text]]></MsgType>"
										+	"	<Content><![CDATA[你好]]></Content>"
										+	"</xml>";
	
	@RequestMapping(value = "router")
	public void router(ParamForm params, HttpServletRequest request, HttpServletResponse response ){
		logger.info(params.toString());
		if("GET".equals(request.getMethod())){			
			HttpUtil.writeXmlToClient(response, params.getEchostr());
		}else{
			logger.info(request.getMethod());
			logger.info(REP_XML);
			HttpUtil.writeXmlToClient(response, REP_XML);
		}
	}
}
