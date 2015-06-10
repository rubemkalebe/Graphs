package main.arc.persistence;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import main.arc.domain.Graph;
import main.arc.domain.GraphAsList;
import main.arc.domain.Vertex;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ReaderXML extends DefaultHandler{

	private String currentTag; // Tag corrente
	private String atr; // Atributo da tag
	private Graph g;
	
	
	public ReaderXML() {
		// TODO Auto-generated constructor stub
		super();
//		this.g = obj;		
	}
	
	public void init(String path){
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser;
		
		try {
			parser= factory.newSAXParser();
			parser.parse(path, this);
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO: handle exception
			StringBuffer msg = new StringBuffer();
			msg.append("Erro:\n").append(e.getMessage()+"\n").append(e.toString());
			System.out.println(msg);
		}
		
		
		
	}
	
	
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\n Iniciando processamento... \n");
	}
	
	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("\n Fim do processamento... \n");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		this.currentTag = qName;
		
//		Verifica se é 'vertex'
		if(qName.compareTo("vertex") == 0){
			try {
				this.g.addVertex(new Vertex(Integer.parseInt(attributes.getValue(0))) {
				});
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(qName.compareTo("edge") == 0){
			int v1 = Integer.parseInt(attributes.getValue(1));
			int v2 = Integer.parseInt(attributes.getValue(2));
			try {
				this.g.connectVertices(this.g.getVertex(v1), this.g.getVertex(v2));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		this.currentTag = " ";
	}
	
	public Graph getGraph(){
		return this.g;
	}
	
	
	
}
