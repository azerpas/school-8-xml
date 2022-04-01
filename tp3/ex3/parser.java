import java.io.*;
import java.security.AllPermission;
import java.util.Scanner;

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
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE list [");
		out.println("<!ELEMENT list (man | woman)*>");
		out.println("<!ELEMENT man (sons, daughters)>");
		out.println("<!ATTLIST man name CDATA #REQUIRED>");
		out.println("<!ELEMENT woman (sons, daughters)>");
		out.println("<!ATTLIST woman name CDATA #REQUIRED>");
		out.println("<!ELEMENT sons (man)*>");
		out.println("<!ELEMENT daughters (woman)*>");
		out.println("]>");
		out.println("<list>");

		//instancier le contructeur de parseurs
		DocumentBuilderFactory _factory = DocumentBuilderFactory.newInstance();

		//ignorer les commentaires dans les fichiers XML parsees
		_factory.setIgnoringComments(true);
		
		// créer un parseur
		DocumentBuilder _builder = _factory.newDocumentBuilder();

		// Charger le document
		
		Document doc = _builder.parse(_xml_input_file);

		// Parser le document
		Element bib = doc.getDocumentElement();
		NodeList children = bib.getChildNodes();
		
		for (int i=0; i < children.getLength(); i++){
			Node node = children.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element)node;
				
				out.print(DomaineTemplate(element, 1));
			}
		}
		out.print("</list>");
		out.close();
		out.flush();
	}
	
	public String DomaineTemplate(Element domaine, int cpt) {
		String s = "";
		NodeListnodeDomain = domaine.getChildNodes();
		
		if(domaine.getAttributeNode("gender").getValue().equals("M"))
		{
			s += tabulation(cpt);
			s += "<man name=\"" + domaine.getElementsByTagName("name").item(0).getTextContent() + "\">\n";
			s += tabulation(cpt*2);
			s += "<sons>\n";
			
			for(int i = 0; i <nodeDomain.getLength() ; i++) 
			{
				Node node =nodeDomain.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					if(element.getNodeName().equals("children"))
					{
						NodeList subNodeDomain = element.getChildNodes();
						
						for(int j = 0; j < subNodeDomain.getLength(); j++)
						{
							Node childNode = subNodeDomain.item(j);
							if(childNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element nodeElement = (Element) childNode;
								if (nodeElement.getAttributeNode("gender").getValue().equals("M"))
								{
									s += DomaineTemplate(nodeElement, cpt + 1);
								}
							}
						}
					}
				}
			}
			s += tabulation(cpt*2);
			s += "</sons>\n";
			s += tabulation(cpt*2);
			s += "<daughters>\n";
			
			for(int i = 0; i <nodeDomain.getLength() ; i++) 
			{
				Node node =nodeDomain.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					if(element.getNodeName().equals("children"))
					{
						NodeList subNodeDomain = element.getChildNodes();
						
						for(int j = 0; j < subNodeDomain.getLength(); j++)
						{
							Node childNode = subNodeDomain.item(j);
							if(childNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element nodeElement = (Element) childNode;
								if (nodeElement.getAttributeNode("gender").getValue().equals("F"))
								{
									s += DomaineTemplate(nodeElement, cpt + 1);
								}
							}
						}
					}
				}
			}
			
			s += tabulation(cpt*2);
			s += "</daughters>\n";
			s += tabulation(cpt);
			s += "</man>";
		}
		else
		{
			s += tabulation(cpt);
			s += "<woman name=\"" + domaine.getElementsByTagName("name").item(0).getTextContent() + "\">\n";
			s += tabulation(cpt*2);
			s += "<sons>\n";
			
			for(int i = 0; i <nodeDomain.getLength() ; i++) 
			{
				Node node =nodeDomain.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					if(element.getNodeName().equals("children"))
					{
						NodeList subNodeDomain = element.getChildNodes();
						
						for(int j = 0; j < subNodeDomain.getLength(); j++)
						{
							Node childNode = subNodeDomain.item(j);
							if(childNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element nodeElement = (Element) childNode;
								if (nodeElement.getAttributeNode("gender").getValue().equals("M"))
								{
									s += DomaineTemplate(nodeElement, cpt + 1);
								}
							}
						}
					}
				}
			}
			
			s += tabulation(cpt*2);
			s += "</sons>\n";
			s += tabulation(cpt*2);
			s += "<daughters>\n";
			
			for(int i = 0; i <nodeDomain.getLength() ; i++) 
			{
				Node node =nodeDomain.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					if(element.getNodeName().equals("children"))
					{
						NodeList subNodeDomain = element.getChildNodes();
						
						for(int j = 0; j < subNodeDomain.getLength(); j++)
						{
							Node childNode = subNodeDomain.item(j);
							if(childNode.getNodeType() == Node.ELEMENT_NODE)
							{
								Element nodeElement = (Element) childNode;
								if (nodeElement.getAttributeNode("gender").getValue().equals("F"))
								{
									s += DomaineTemplate(nodeElement, cpt + 1);
								}
							}
						}
					}
				}
			}
			
			s += tabulation(cpt*2);
			s += "</daughters>\n";
			s += tabulation(cpt);
			s += "</woman>";
		}
		
		s += "\n";
		
		return s;
	}
	
	public String tabulation(int cpt)
	{
		String s = "";
		
		for(int i = 0; i < cpt; i++)
		{
			s += "\t";
		}
		
		return s;
	}
}