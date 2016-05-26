package com.leneq.gateway.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

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
	
	public static String getStrFromInputStream(InputStream is) throws Exception {
    	ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
	    byte[] data = new byte[1024];  
	    int count = -1;  
	    while((count = is.read(data,0,1024)) != -1)  
	       outStream.write(data, 0, count);  
	      
	    return new String(outStream.toByteArray(),"utf-8");
	}
	
	@SuppressWarnings("unchecked")
    public static <T> T convertToObject(String xml, Class<T> type) {
        StringReader sr = new StringReader(xml);
        try {
            JAXBContext jAXBContext = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = jAXBContext.createUnmarshaller();
            return (T) unmarshaller.unmarshal(sr);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
	
	public static String convertToXmlString(Object source) {
        try {
            StringWriter sw = new StringWriter();
            JAXBContext jAXBContext = JAXBContext.newInstance(source.getClass());
            Marshaller marshaller = jAXBContext.createMarshaller();
            marshaller.marshal(source, sw);
            return sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
