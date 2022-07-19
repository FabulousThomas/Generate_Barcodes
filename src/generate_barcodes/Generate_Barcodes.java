/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generate_barcodes;

/**
 *
 * @author Thomas
 */

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

public class Generate_Barcodes {
	
	
	public static void main(String[] args) {
		Generate_Barcodes.createImage("YOUR_BARCODE_NAME.png", "BARCODE_INFO(CONTENT)");
		System.out.println("finished");
	}

	public static void createImage(String image_name,String myString)  {    
		try {
		
		Code128Bean code128 = new Code128Bean();
		code128.setHeight(15f);
		code128.setModuleWidth(0.3);
		code128.setQuietZone(10);
		code128.doQuietZone(true);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
		code128.generateBarcode(canvas, myString);
		canvas.finish();

		//write to png file
		FileOutputStream fos = new FileOutputStream("PATH_TO_SAVE_YOUR_BARCODE"+image_name);
		fos.write(baos.toByteArray());
		fos.flush();
		fos.close();
		} catch (Exception e) {
			// TODO: handle exception
                    e.printStackTrace();
		}
	}


}

