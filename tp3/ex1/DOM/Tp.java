import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Tp {

	public static void main(String[] args) {
		parser parser  = new parser();
		
		String bib = "./bib.xml";
		
		try {
			parser.parse(bib);
		} catch (SAXException | ParserConfigurationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}