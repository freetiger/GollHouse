package cn.goll.common;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * 静态生成的工具类
 * @author LJ
 *
 */
public class HtmlFactory {
	/**
	 * 根据地址获取源代码
	 * @param url
	 * @return
	 */
	public static String getHTML(String address){
		StringBuffer sb=new StringBuffer();
		String result=null;
		try {
			URL url=new URL(address);
			//打开URL引用的资源通信链接
			URLConnection connection=url.openConnection();
			//模拟web请求，哄骗服务器，设置头信息
			connection.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET4.0C; .NET4.0E; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
			//从链接中获取输入流，并创建一个带有缓冲区域的输入流
			BufferedInputStream in=new BufferedInputStream(connection.getInputStream());
			
			String inputline;
			byte[] bytes=new byte[4096];
			int read=0;
			while(read>=0){
				read=in.read(bytes);
				if(read>0){
					inputline=new String(bytes,0,read,"utf-8");
					if(inputline!=null&&!inputline.equals(""))sb.append(inputline);
					inputline=null;
				}
			}
			bytes=null;
			in.close();
			connection=null;
			url=null;
			
			result=new String(sb.toString().trim().getBytes("utf-8"),"utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} 
	/**
	 * 将指定内容写入到指定文件中
	 * @param filePath
	 * @param info
	 * synchronized:用他修饰一个方法或者一个代码块的时候，能够保证同一时刻最多只有一个线程执行该段代码
	 */
	public static synchronized void writeHTML(String filePath,String info){
		PrintWriter pw=null;
		try {
			File file=new File(filePath);
			if(!file.exists()){
				file.createNewFile();		
			}
			
			

			pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath,false), "UTF-8"));   

			pw.println(info);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(pw!=null){
				pw.close();
				pw=null;
			}
		}
		
	}
}
