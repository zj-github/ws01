package cn.iktz.jedis.test;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageUtils {

	/**
	 * 强制压缩/放大图片到固定的大小
	 * 
	 * @param w
	 *            int 新宽度
	 * @param h
	 *            int 新高度
	 * @throws IOException
	 */
	public void resize(Image srcImage, int w, int h, int imageWidth, int imageHeight, OutputStream os)
			throws IOException {
		// Image srcImage = javax.imageio.ImageIO.read(new File(""));
		// int imageWidth = srcImage.getWidth(null);
		// int imageHeight = srcImage.getHeight(null);

		System.out.println("width: " + imageWidth);
		System.out.println("height: " + imageHeight);

		// 得到合适的压缩大小，按比例。
		if (imageWidth >= imageHeight) {
			h = (int) Math.round((imageHeight * w * 1.0 / imageWidth));
		} else {
			w = (int) Math.round((imageWidth * h * 1.0 / imageHeight));
		}

		// 构建图片对象
		BufferedImage _image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		// 绘制缩小后的图
		_image.getGraphics().drawImage(srcImage, 0, 0, w, h, null);
		// 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(_image);

	}
	public void resize2(Image srcImage, int w, int h, int imageWidth, int imageHeight, OutputStream os)
			throws IOException {
		// Image srcImage = javax.imageio.ImageIO.read(new File(""));
		// int imageWidth = srcImage.getWidth(null);
		// int imageHeight = srcImage.getHeight(null);
		
		System.out.println("width: " + imageWidth);
		System.out.println("height: " + imageHeight);
		
		// 得到合适的压缩大小，按比例。
		if (imageWidth >= imageHeight) {
			h = (int) Math.round((imageHeight * w * 1.0 / imageWidth));
		} else {
			w = (int) Math.round((imageWidth * h * 1.0 / imageHeight));
		}
		
		// 构建图片对象
		BufferedImage _image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		// 绘制缩小后的图
		_image.getGraphics().drawImage(srcImage, 0, 0, w, h, null);
		// 输出到文件流
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
		encoder.encode(_image);
		
	}
}