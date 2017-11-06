package application;
import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class TesseractExample {

	public String getTextFromImage(String s) {
		// TODO Auto-generated method stub
		String result = null;
		File imageFile=new File(s);
		ITesseract instance=new Tesseract();
		try {
			result=instance.doOCR(imageFile);
			System.out.println(result);
			
		}
		catch(TesseractException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}
}