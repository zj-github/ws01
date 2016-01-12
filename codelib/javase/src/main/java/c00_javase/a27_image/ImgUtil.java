package c00_javase.a27_image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImgUtil {
	public static byte[] streamToByte(InputStream in) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int b = 0;
		byte[] buf = new byte[1024];
		while ((b = in.read(buf)) != -1) {
			// System.out.println(" size "+b);
			out.write(buf, 0, b);
		}

		byte[] byteArray = out.toByteArray();
		// for (byte bd : byteArray) {
		// System.out.println( " **------------------- "+bd);
		// }
		return byteArray;
	}

	public static String down(String imgURL, String fmt) throws Exception {
		// byte[] streamToByte = streamToByte(new URL(imgURL).openStream());
		byte[] streamToByte = streamToByte(new URL(imgURL).openStream(), fmt);
		// for (byte b : streamToByte) {
		// System.out.println( " ** "+b);
		// }
		return Base64Util.encode(streamToByte);
	}

	public static String down(String imgURL) throws Exception {
		byte[] streamToByte = streamToByte(new URL(imgURL).openStream());
		return Base64Util.encode(streamToByte);
	}

	/**
	 * ��stringת�� byte[] ,��ת���ֽ�������ת��ͼƬ��Ȼ��д
	 * 
	 * @param args
	 */

	public void test() {
		// String u="";
		//
		// byte[] bytes = u.getBytes();
		// ByteArrayOutputStream out = new ByteArrayOutputStream();
		//
		// for (byte b : bytes) {
		// out.write(b);
		// }
		//
		// ImageIO.w
	}

	public static byte[] streamToByte(InputStream openStream, String fmt) throws IOException {

		BufferedImage image = ImageIO.read(openStream);
		int height = image.getHeight();
		int width = image.getWidth();
		
		System.out.println(height + " >>> " + width);
		image = newImgSize(image,"w",670);
		
		height = image.getHeight();
		width = image.getWidth();
		System.out.println(height + " >>> " + width);
		ByteArrayOutputStream bos = new ByteArrayOutputStream(); // �ֽ������
		ImageIO.write(image, fmt, bos); // ������ͼƬ��Ϣд�뵽�ֽ��������
		byte[] b = bos.toByteArray();// generate byte[] //��������ֽ���Ϣ�����byte����b��
		return b;
	}
	
	/**
	 * 
	 * @Description: �ȱ�ѹ��ͼƬ 
	 * @author zhangjie
	 * @date 2016��1��12�� ����1:59:39 
	 * @param srcImage
	 * @param type
	 * @param num
	 * @return
	 *
	 */
	public static BufferedImage newImgSize(BufferedImage srcImage,String type,int num){
		
		int imageWidth = srcImage.getWidth();
		int imageHeight = srcImage.getHeight();

		int w=0,h=0;
		
		BufferedImage resImage = null;
		boolean f = false;
		if(type.equals("w")){
			if(num<imageWidth){
				f=true;
				h=(int)Math.round(imageHeight*num*1.0/imageWidth);
				w=num;
			}
		}else if(type.equals("h")){
			if(num<imageHeight){
				f=true;
				h=(int)Math.round(imageWidth*num*1.0/imageHeight);
				h=num;
			}
		}
		if(f){
			resImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
			resImage.getGraphics().drawImage(srcImage, 0, 0, w, h, null);
		}else{
			resImage=srcImage;
		}
		return resImage;
	}
	
}
