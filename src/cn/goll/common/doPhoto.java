package cn.goll.common;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;
import junit.framework.TestCase;

public class doPhoto extends TestCase {
	/**
	 * 改变图片大小的方法(不影响图片的清晰度，格式转换成为jpg)
	 * @param imgPath 需要改变的图片的路径
	 * @param width  理想图片的宽
	 * @param height  理想图片的高
	 * @param goalPath 目标图片的存储路径
	 * @throws Exception
	 */
	public void testphoto(String imgPath,int width,int height,String goalPath) throws Exception {

		BufferedImage originalImage = ImageIO.read(new File(imgPath));
		//根据图片路径来进行生成新的图片，设置图片大小
		BufferedImage thumbnail = Thumbnails.of(originalImage).size(width, height).keepAspectRatio(false).asBufferedImage();

		ImageIO.write(thumbnail, "jpg", new File(goalPath));

	}
}
