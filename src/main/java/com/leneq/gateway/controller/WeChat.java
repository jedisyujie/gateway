package com.leneq.gateway.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leneq.gateway.domain.InMessage;
import com.leneq.gateway.domain.OutMessage;
import com.leneq.gateway.domain.ParamForm;
import com.leneq.gateway.util.HttpUtil;
import com.leneq.gateway.util.XmlUtil;

@Controller
@RequestMapping(value ="/wechat")
public class WeChat {
	
	private static Logger logger = LoggerFactory.getLogger(WeChat.class);
	
	private static final String REP_XML="<xml>"

									+	"<ToUserName><![CDATA[%s]]></ToUserName>"
							
									+	"<FromUserName><![CDATA[%s]]></FromUserName>"
							
									+	"<CreateTime>%s</CreateTime>"
							
									+	"<MsgType><![CDATA[%s]]></MsgType>"
							
									+	"<Content><![CDATA[%s]]></Content>"
							
									+	"</xml>";

	@RequestMapping(value = "router")
	public void router(ParamForm params, HttpServletRequest request, HttpServletResponse response ){
		try {
			logger.info(params.toString());
			if("GET".equals(request.getMethod())){			
				HttpUtil.writeXmlToClient(response, params.getEchostr());
			}else{
				InMessage inMessage = fetchInmessage(request);
				OutMessage outMessage = new OutMessage();
				outMessage.setFromUserName(inMessage.getToUserName());
				outMessage.setToUserName(inMessage.getFromUserName());
				outMessage.setCreateTime(new Date().getTime()+"");
				outMessage.setMsgType(inMessage.getMsgType());
				outMessage.setContent(inMessage.getContent());
				//String outStr = XmlUtil.convertToXmlString(outMessage);
				String outStr = null;
				switch (inMessage.getMsgType()) {
				case "text": 
//					outStr = genMessage( outMessage);
					break;
				case "voice":
					outMessage.setMsgType("text");
					outMessage.setContent(inMessage.getRecognition());
//					outStr = genMessage( outMessage);
					break;
				default:
					break;
				}
				outStr = XmlUtil.convertToXmlString(outMessage);
				logger.info("message to wechat:{}",outStr);
				HttpUtil.writeXmlToClient(response, outStr);
			}
		} catch (IOException e) {
			logger.error("xml convert error :{}", e);
		} catch (Exception e) {
			logger.error("system error :{}", e);
		}
	}

	private String genMessage(OutMessage outMessage) {
		String outStr;
		outStr = String.format(REP_XML, outMessage.getToUserName(),outMessage.getFromUserName(),outMessage.getCreateTime(),
				outMessage.getMsgType(),outMessage.getContent());
		return outStr;
	}

	private InMessage fetchInmessage(HttpServletRequest request)
			throws Exception, IOException {
		String xmlStr = XmlUtil.getStrFromInputStream(request.getInputStream());
		logger.info("message from wechat:{}",xmlStr);
		InMessage inMessage = XmlUtil.convertToObject(xmlStr, InMessage.class);
		return inMessage;
	}
}
