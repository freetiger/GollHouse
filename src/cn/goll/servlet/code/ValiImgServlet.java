package cn.goll.servlet.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 产生验证码图片的类
 * @author Administrator
 *
 */
public class ValiImgServlet extends HttpServlet{
	
	//准备在验证码图片中可能出现的字符集（可根据需求修改）
	private char chars[]={
			'A','B','C','D','E','F',
			'G','H','N','J','K','M',
			'1','2','3','4','5','6'
			};
	//验证码尺寸
	int width=60;
	int height=20;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 生成彩色验证码图片
		 */
		//构造一个带有缓冲区的图形对象
		BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//获取图形上下文对象
		Graphics g=image.getGraphics();
		//设定背景颜色
		g.setColor(new Color(0x00FFFF));
		g.fillRect(0, 0, width, height);//填充背景色
		//绘制边框
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);
		//随机产生验证码
		String rdmStr="";
		//此处产生4位长度验证码，如果需要更长，则修改循环次数
		for (int i = 0; i < 4; i++) {
			rdmStr+=chars[(int)(Math.random()*chars.length)];
		}
		//将随机验证码显示到图形对象中
		g.setColor(Color.blue);//设置验证码字符颜色
		g.setFont(new Font("Atlantic Inline",Font.PLAIN,18));//设置验证码字符设置样式，大小
		String str=rdmStr.substring(0,1);//截取出验证码字符串的第一位
		g.drawString(str, 8,17);//在不同的位置绘制字符
		
		str=rdmStr.substring(1,2);
		g.drawString(str,20,15);
		
		str=rdmStr.substring(2,3);
		g.drawString(str,35,18);
		
		str=rdmStr.substring(3,4);
		g.drawString(str,45,15);
		
		//随机产生15个干扰点
		Random random=new Random();
		for (int i = 0; i < 15; i++) {
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			g.drawOval(x, y, 1,3);
		}
		//释放图形上下文对象
		g.dispose();
		//将验证码存入session
		request.getSession(true).setAttribute("Code", rdmStr);
		//输出图形到页面
		ServletOutputStream sos=response.getOutputStream();
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(sos);
		encoder.encode(image);
	}

}
