package com.example.DOM;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorDOM {
	
	private Document document;
	
	public GeneradorDOM() throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.newDocument();
		
	}
	
	public void generarDocument() {
		
		Element productos = document.createElement("productos");
		document.appendChild(productos);

		
		Element producto = document.createElement("producto");
		productos.appendChild(producto);
		producto.setAttribute("codigo", "1");
		
		Element nombre = document.createElement("nombre");
		Element nombre2= document.createElement("nombre");
		nombre.appendChild(document.createTextNode("Teclado"));
		nombre2.appendChild(document.createTextNode("Monitor"));		
		producto.appendChild(nombre);
		producto.appendChild(nombre2);
		
		Element producto2 = document.createElement("producto");
		productos.appendChild(producto2);
		producto2.setAttribute("codigo", "2");
		
		Element nombre3 = document.createElement("nombre");
		nombre3.appendChild(document.createTextNode("nombre"));
		producto2.appendChild(nombre3);
		
		
	
		
	
	}
	
	public void generarXml() throws IOException, TransformerException {
		
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		
		Source source = new DOMSource(document);
		File file = new File("productos.xml");
		FileWriter fileWriter = new FileWriter(file);
		PrintWriter printWriter= new PrintWriter(fileWriter);
		Result result = new StreamResult(printWriter);
		
		transformer.transform(source, result);
		
		
	}
	
	
	
	

}
