package com.leneq.gateway.util;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

public class HttpUtil {

	public static void writeXmlToClient(HttpServletResponse response, String xml) {
        Writer writer = null;
        try {
            response.setContentType("text/plain; charset=utf-8");
            writer = response.getWriter();
            writer.write(xml);
        } catch (Exception ex) {

        } finally {
            if (writer != null) {
                try {
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
        }
    }
}
