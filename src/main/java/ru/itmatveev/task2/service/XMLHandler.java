package ru.itmatveev.task2.service;

import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ru.itmatveev.task2.domain.Domain;
import ru.itmatveev.task2.repository.Repo;

import java.util.List;

@Service
public class XMLHandler extends DefaultHandler {
    private String id;
    private String charCode;
    private String name;
    private String value;
    private String lastElementName;
    private Repo repo;

    public XMLHandler(Repo repo) {
        this.repo = repo;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);

        if (!information.isEmpty()) {
            if (lastElementName.equals("CharCode")) {
                charCode = information;
            }
            if (lastElementName.equals("Name")) {
                name = information;
            }
            if (lastElementName.equals("Value")) {
                value = information;
                addDomain("0", charCode, name, value);
                System.out.println("Валюта: " + name + " Цена: " + value);
            }
        }
    }

    public void addDomain(String id, String charCode, String name, String value) {
        repo.addDomain(id, charCode, name, value);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

    }
}


