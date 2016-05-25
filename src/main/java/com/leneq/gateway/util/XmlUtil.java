package com.leneq.gateway.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlUtil {

	public static <T> String toXml(Class<T> z, Object o){
		try {
			JAXBContext jc = JAXBContext.newInstance(z);  
			Marshaller ms = jc.createMarshaller();  
			ms.marshal(o, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return "";
	}
}
