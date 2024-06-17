package com.farhad.example.codekata.event_proccessing_design_kata;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

public class Spike {

    public static void main(String[] args) throws Exception {
        String filename = "com/farhad/example/codekata/event_proccessing_design_kata/sample_store.xml";
        ClassLoader classLoader = Spike.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(inputStream);

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        String storeType = xPath.compile("/store/@type").evaluate(document);
        String storeProfile = xPath.compile("/store/profile/text()").evaluate(document);
        String nextEventId = xPath.compile("/store/next_event/text()").evaluate(document);
        String nextEventName = xPath.compile("/store/product[@id='" + nextEventId + "']/text()[3]").evaluate(document);

        System.out.println("Store class: " + storeType);
        System.out.println("Store ptofile: " + storeProfile);
        System.out.println("Store next event: " + nextEventName);
    }
}
