import java.io.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

/**
 * @author Nicolas Bataillard, Anthony Manikhouth LSI2
 */
public class parser {

	public PrintWriter out = null;

	//Rem changer Package par ModelElement
	public void parse(String _fichier)
		throws SAXException, ParserConfigurationException, IOException {

		// Charger le document
		FileInputStream _xml_input_file = new FileInputStream(_fichier);

		parse(_xml_input_file);
	}

	public void parse(InputStream _xml_input_file)
		throws SAXException, ParserConfigurationException, IOException {

		//création du fichier output
		out = new PrintWriter(new FileOutputStream("./ouput.html"));
		out.println("<html xmlns:fo=\"http://www.w3.org/1999/XSL/Format\"><head />");
		out.println("<?xml version=\"1.0\"?>");
		out.println("<e-mails>");

		//instancier le contructeur de parseurs
		DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();

		//ignorer les commentaires dans les fichiers XML parsés
		_factory.setIgnoringComments(true);
		
		// créer un parseur
		DocumentBuilder _builder = _factory.newDocumentBuilder();

		// Charger le document
		Document doc = _builder.parse(_xml_input_file);

		// Parser le document
		Element bib = doc.getDocumentElement();
		NodeList children = bib.getChildNodes();
		for(int i=0; i < children.getLength(); i++)
		{
			Node node = children.item(i);			
			if(node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element)node;  
				System.out.println(DomaineTemplate(element,""));
				Scanner sc = new Scanner(System.in);
				System.out.println("Balise à supprimer : To, From, Subject, Body");
				String name = sc.nextLine();
				out.println(DomaineTemplate(element, name));
				
			}
		}
		out.println("</e-mails>");
        out.close();
		out.flush();
	}
    public String DomaineTemplate(Element domaine, String name) {
		String s = "<e-mail>\n";
		if(!name.equals("To"))
			s += "<" + domaine.getElementsByTagName("To").item(0).getNodeName() + ">" + domaine.getElementsByTagName("To").item(0).getTextContent() + "</" + domaine.getElementsByTagName("To").item(0).getNodeName() + ">\n";
		if(!name.equals("From"))	
			s += "<" + domaine.getElementsByTagName("From").item(0).getNodeName() + ">" + domaine.getElementsByTagName("From").item(0).getTextContent() + "</" + domaine.getElementsByTagName("From").item(0).getNodeName() + ">\n";
		if(!name.equals("Subject"))		
			s += "<" + domaine.getElementsByTagName("Subject").item(0).getNodeName() + ">" + domaine.getElementsByTagName("Subject").item(0).getTextContent() + "</" + domaine.getElementsByTagName("Subject").item(0).getNodeName() + ">\n";
		if(!name.equals("Body"))		
			s += "<" + domaine.getElementsByTagName("Body").item(0).getNodeName() + ">" + domaine.getElementsByTagName("Body").item(0).getTextContent() + "</" + domaine.getElementsByTagName("Body").item(0).getNodeName() + ">\n";
		s += "</e-mail>\n";
		
		return s;
	}
}