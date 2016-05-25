package com.leneq.gateway.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class WechatMsg {

	private String toUserName;
	
	private String fromUserName;
	
	private String createTime;
	
	private String msgType;
	
	private String content;
	
	private String msgId;

	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUsername) {
		this.toUserName = toUsername;
	}

	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	@XmlElement(name = "CreateTime")
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	@XmlElement(name = "Content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlElement(name = "MsgId")
	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	@Override
	public String toString() {
		return "WechatMsg [toUsername=" + toUserName + ", fromUserName="
				+ fromUserName + ", createTime=" + createTime + ", msgType="
				+ msgType + ", content=" + content + ", msgId=" + msgId + "]";
	}
	
}

