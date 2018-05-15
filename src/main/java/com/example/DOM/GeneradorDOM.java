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
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.xml.security.utils.Constants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorDOM {
	
	private Document document;
	
	public GeneradorDOM() throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.newDocument();
		
	}
	
	public void generarDocument() {
		
		 Element elemento = document.createElementNS("", "Invoice");
		 elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns", "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
		 elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:cac", "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2");
		 elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:cbc", "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2");
		 elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:ccts", "urn:un:unece:uncefact:documentation:2");
		 elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:ds", "http://www.w3.org/2000/09/xmldsig#");
         elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:ext", "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2");
         elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:qdt", "urn:oasis:names:specification:ubl:schema:xsd:QualifiedDatatypes-2");
         elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:sac", "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1");
         elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:udt", "urn:un:unece:uncefact:data:specification:UnqualifiedDataTypesSchemaModule:2");
         elemento.setAttributeNS(Constants.NamespaceSpecNS, "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
         elemento.appendChild(document.createTextNode("\n"));
         document.appendChild(elemento);
         
         Element UBLExtensions = document.createElementNS("", "ext:UBLExtensions");
         elemento.appendChild(UBLExtensions);
         Element UBLExtensions2 = document.createElementNS("", "ext:UBLExtension");
         UBLExtensions2.appendChild(document.createTextNode("\n"));
         Element ExtensionContent2 = document.createElementNS("", "ext:ExtensionContent");
         ExtensionContent2.appendChild(document.createTextNode("\n"));
         
         Element UBLExtension = document.createElementNS("", "ext:UBLExtennsion");
         elemento.appendChild(UBLExtension);
         Element ExtensionContent = document.createElementNS("", "ext:ExtensionContent");
         elemento.appendChild(ExtensionContent);
         
         
//		Element productos = document.createElement("productos");
//		document.appendChild(productos);
//
//		
//		Element producto = document.createElement("producto");
//		productos.appendChild(producto);
//		producto.setAttribute("codigo", "1");
//		producto.setAttribute("codigo2", "12");
//		
//		Element nombre = document.createElement("nombre");
//		Element nombre2= document.createElement("nombre");
//		nombre.appendChild(document.createTextNode("Teclado"));
//		nombre2.appendChild(document.createTextNode("Monitor"));		
//		producto.appendChild(nombre);
//		producto.appendChild(nombre2);
//		
//		Element producto2 = document.createElement("producto");
//		productos.appendChild(producto2);
//		producto2.setAttribute("codigo", "2");
//		producto2.setAttribute("codigo2", "22");
//		
//		Element nombre3 = document.createElement("nombre");
//		nombre3.appendChild(document.createTextNode("nombre"));
//		producto2.appendChild(nombre3);
		
		
	
		
	
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
