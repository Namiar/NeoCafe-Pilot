package Neocafe.model;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class Generate_pdf {

	public static void main(String[] args) {
		
		
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("D:/receipt.pdf"));
			document.open();
			document.add(new Paragraph("Example"));
			document.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("itext PDF program executed");
	}

}
