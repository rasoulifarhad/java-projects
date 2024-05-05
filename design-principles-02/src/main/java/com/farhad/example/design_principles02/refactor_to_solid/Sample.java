package com.farhad.example.design_principles02.refactor_to_solid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import lombok.Getter;
import lombok.Setter;

public class Sample {

    @Getter
    @Setter
    private String fileName;
    // /com/farhad/example/design_principles02/refactor_to_solid/xmlDocument.xml

    private List<List<String>> items = new ArrayList<>();

    public void load() throws Exception {
        items.clear();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(
            this.getClass().getResourceAsStream(fileName));
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if(nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                if(startElement.getName().getLocalPart().equals("product")) {
                    String id = startElement.getAttributeByName(new QName("id")).getValue();
                    String name = startElement.getAttributeByName(new QName("name")).getValue();
                    String unitPrice = startElement.getAttributeByName(new QName("unitPrice")).getValue();
                    String discontinued = startElement.getAttributeByName(new QName("discontinued")).getValue();
                    // String[] item = new String[] {id, name, unitPrice, discontinued};
                    items.add(Arrays.asList(id, name, unitPrice, discontinued));
                }
            }
        }
    }

    public void log() {
        System.out.println(items);
    }

    public static void main(String[] args) throws Exception {
        
        Sample sample = new Sample();
        sample.setFileName("/com/farhad/example/design_principles02/refactor_to_solid/xmlDocument.xml");
        sample.load();
        sample.log();
    }
}
