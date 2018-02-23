import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeMaker {
	
	public static void main(String[] args) {
		try {
			ArrayList<URLEnum> oQRData = new ArrayList<URLEnum>();
			oQRData.add(URLEnum.URL01);
			oQRData.add(URLEnum.URL02);
			oQRData.add(URLEnum.URL03);
			for (URLEnum oData: oQRData) {
				// リンクされるURL
				String sUrl = oData.getsUrl();
				// イメージの高さ
				int iWidth = oData.getiWidth();
				// イメージの幅
				int iHeight = oData.getiHeight();
				// 保存されるファイル名
				String sFileName = oData.getsFileName();
				
				String sCodeUrl = new String(sUrl.getBytes("UTF-8"), "ISO-8859-1");
            	
            	int qrcodeColor =   0xFF2e4e96;
            	int backgroundColor = 0xFFFFFFFF;
            	
            	QRCodeWriter qrCodeWriter = new QRCodeWriter();
            	BitMatrix bitMatrix = qrCodeWriter.encode(sCodeUrl, BarcodeFormat.QR_CODE,iWidth, iHeight);
            	//
            	MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor,backgroundColor);
            	BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix,matrixToImageConfig);

            	ImageIO.write(bufferedImage, "png", new File(System.getProperty("user.dir") + "\\QRcode\\" + sFileName));
            	
			}
			System.out.println("QRコード生成先：" + System.getProperty("user.dir") + "\\QRcode\\" );
		} catch (Exception e) {
      		e.printStackTrace();
    	}  
	}
}
