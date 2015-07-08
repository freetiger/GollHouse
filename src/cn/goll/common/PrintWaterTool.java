package cn.goll.common;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class PrintWaterTool {
	/**
	 *  
	 * @param waterPath 水印图片路径   ↓嵌入在原图中
	 * @param imagePath 原图片路径
	 * @param targetPath 输出图片路径
	 */
	public static void printImageWater(String waterPath,String imagePath,String targetPath) {
		OutputStream os=null;
		try{
			//图像对象
			Image image=ImageIO.read(new File(imagePath));
			//带有缓冲的图行
			BufferedImage bufferImg=new BufferedImage(image.getHeight(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
			//得到画笔对象，专门用于图像绘制的类
			Graphics2D grd=bufferImg.createGraphics();
			//设置抗锯齿功能(处理毛边)
			grd.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			//绘制，getScaledInstance按原有比例获取图形实例，0,0代表绘制的坐标
			grd.drawImage(image.getScaledInstance(image.getWidth(null), image.getHeight(null), Image.SCALE_SMOOTH),0,0,null);
			//获取水印Icon
			ImageIcon imgIcon=new ImageIcon(waterPath);
			Image ico=imgIcon.getImage();
			//半透明
			float alpha=0.5f;
			grd.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));
			//水印的位置
			grd.drawImage(ico,10,10,null);
			//释放资源
			grd.dispose();
			os=new FileOutputStream(targetPath);
			ImageIO.write(bufferImg, "JPG", os);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void printFontWater(String fontStr,String imagePath,String targetPath) {
		System.out.println(imagePath);
		OutputStream os=null;
		try{
			//图形对象
			Image image=ImageIO.read(new File(imagePath));
			//带有缓冲的图形
			BufferedImage bufferImg=new BufferedImage(image.getWidth(null),image.getHeight(null),BufferedImage.TYPE_INT_RGB);
			//得到画笔对象,专门用于图形绘制的类
			Graphics2D grd=bufferImg.createGraphics();
			//设置抗锯齿功能(处理毛边)
			grd.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			//绘制,getScaledInstance按原有比例获取图形实例，0,0位置开始绘制
			grd.drawImage(image.getScaledInstance(image.getWidth(null), image.getHeight(null), image.SCALE_SMOOTH),  0, 0,null);
			//字体颜色
			grd.setColor(Color.orange);
			//字体、样式(1粗体,2斜体)、大小
			grd.setFont(new Font("楷体",2,20));
			//绘制字样
			grd.drawString(fontStr,20,33);
			//释放资源
			grd.dispose();
			os=new FileOutputStream(targetPath);
			ImageIO.write(bufferImg, "JPG", os);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(os!=null){
				 try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//PrintWater.printImageWater("f:/1.png", "f:/1.jpg", "f:/2.jpg");
		//PrintWater.printImageWater("f:/1.jpg", "f:/1.png", "f:/2.png");
		//PrintWaterTool.printFontWater("郭大侠，不要走，决战到天亮", "e:/1.jpg", "e:/11.jpg");
		//PrintWaterTool.printFontWater("剑哥，不要走，决战到天亮", "e:/h1.jpg", "e:/h1-1.jpg");
		PrintWaterTool.printFontWater("Goll房产", "f:/3.png", "f:/3.png");
	}
}
