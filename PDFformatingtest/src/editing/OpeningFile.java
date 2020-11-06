package editing;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class OpeningFile {
	
	public static void main(String args[]) {
		String dest="F:/sample3.pdf";
		
		DoShit s=new DoShit();
		
		try {
			Document d=s.createDoc(dest);
			
			PdfWriter.getInstance(d, new FileOutputStream(dest));
			d.open();
//			s.addSpaces(d);
//			s.addLine(d);
//			s.addTab(d);
			s.addCredentials(d);
			d.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class DoShit{
	
	public Document createDoc(String dest) throws Exception{
		Document d=new Document();
		return d;
	}
	public void addTab(Document d) throws DocumentException {
		// TODO Auto-generated method stub
		float[] columnWidth= {1,5,5};
		PdfPTable t=new PdfPTable(columnWidth);
		t.setWidthPercentage(100);
//		t.getDefaultCell().setUseAscender(true);
//		t.getDefaultCell().setUseDescender(true);
		for(int i=0;i<15;i++) {
			PdfPCell p=new PdfPCell(new Phrase("Blah"));
			p.setBorder(Rectangle.NO_BORDER);
			t.addCell(p);
		}
		d.add(t);
		
	}
	
	public void addCredentials(Document d) throws DocumentException {
		//creating table
		float[] columnWidth= {2,1};
		PdfPTable cred=new PdfPTable(columnWidth);
//		cred.setWidthPercentage(100);
		Phrase id=new Phrase("Ref No:100");
		Phrase Date=new Phrase("Date: 31.10.2020");
		Phrase name=new Phrase("Patient Name: 100");
		Phrase age=new Phrase("Age/Sex:100");
		Phrase doc=new Phrase("Rfd By:100");
		PdfPCell a=new PdfPCell(id);
		a.setBorder(Rectangle.NO_BORDER);
		PdfPCell b=new PdfPCell(Date);
		b.setBorder(Rectangle.NO_BORDER);
		PdfPCell c=new PdfPCell(name);
		c.setBorder(Rectangle.NO_BORDER);
		PdfPCell e=new PdfPCell(age);
		e.setBorder(Rectangle.NO_BORDER);
		PdfPCell f=new PdfPCell(doc);
		f.setBorder(Rectangle.NO_BORDER);
		cred.addCell(a);
		cred.addCell(b);
		cred.addCell(c);
		cred.addCell(e);
		cred.addCell(f);
		cred.addCell(new PdfPCell());
		d.add(cred);
	}
}

















