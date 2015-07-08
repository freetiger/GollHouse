package cn.goll.servlet.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

public class downloadServlet extends HttpServlet {
	String path;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setCharacterEncoding("utf-8");
			String filePath=request.getParameter("path");
			java.io.File file=new File(path+filePath);
			String fileName=file.getName();
			int filelength=(int)file.length();
			byte[] bt=new byte[filelength];
			FileInputStream in=new FileInputStream(file);
			in.read(bt);
			in.close();
			
			String userAgent=request.getHeader("User-Agent");
			if(userAgent.contains("MSIE"))//ie
				fileName=URLEncoder.encode(fileName, "UTF-8");
			else
				fileName="=?UTF-8?B?"+new String(Base64.encodeBase64(fileName.getBytes("UTF-8")), "UTF-8")+ "?=";
			
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
			response.setContentLength(bt.length);
			response.getOutputStream().write(bt);
			response.flushBuffer();
	}

	public void init(ServletConfig config) throws ServletException {
		this.path=config.getServletContext().getRealPath("/");
	}

}
