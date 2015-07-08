package cn.goll.servlet.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.goll.common.PrintWaterTool;

import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class uploadServlet extends HttpServlet {
	
	private String path;//图片目录
	private ServletConfig config;
	String filePath;//相对
	String relativaPath;//绝对
	long millisecond;
	String typeFolder="default";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.path=config.getServletContext().getRealPath("/");
		this.config=config;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			SmartUpload su=new SmartUpload();
			try{
				su.initialize(config, request, response);
				su.setAllowedFilesList("jpg,jpeg,png,gif,JPG,JPEG,PNG,GIF,xls,xlsx");
				su.setDeniedFilesList("jsp,asp,php,aspx,html,htm,exe,bat");
				su.setTotalMaxFileSize(1024*1024*2);
				su.setMaxFileSize(1024*200);
				su.upload();
			
				Request uploadRequest=su.getRequest();
				String status=uploadRequest.getParameter("mark");
				String actName=uploadRequest.getParameter("fun");
				String fileType=uploadRequest.getParameter("fileType");
				if(fileType.contains("1"))
					fileType="systems/img";
				else if(fileType.contains("2"))
					fileType="house/img";
				else if(fileType.contains("3"))
					fileType="broker/img";
				com.jspsmart.upload.File uploadFile=su.getFiles().getFile(0);//上传第一个文件
				if(!uploadFile.isMissing()){
					Calendar c=Calendar.getInstance();
					int year=c.get(Calendar.YEAR);
					int month=c.get(Calendar.MONTH);
					int day=c.get(Calendar.DATE);
					millisecond=System.currentTimeMillis();
					
					filePath="upload/"+fileType+"/"+year+"/"+month+"/"+day+"/";
					java.io.File file=new java.io.File(path+filePath);
					if(!file.exists())
						file.mkdirs();
					relativaPath=path+filePath+millisecond+"."+uploadFile.getFileExt();
					//uploadFile.saveAs(relativaPath,SmartUpload.SAVE_VIRTUAL);
					uploadFile.saveAs(relativaPath);
					PrintWaterTool.printFontWater("Goll租房网", relativaPath, relativaPath);
				}
				PrintWriter out=response.getWriter();
				out.print("<script>parent."+actName+"('"+status+"','"+filePath+millisecond+"."+uploadFile.getFileExt()+"');history.go(-1);</script>");
			}catch (Exception e) {
				e.printStackTrace();
			}
	}


}
