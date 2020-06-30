package ru.itmatveev.task2.service;

import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import ru.itmatveev.task2.domain.Domain;
import ru.itmatveev.task2.repository.Repo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class ParseService{

    private Repo repo;

    public ParseService(Repo repo) {
        this.repo = repo;
    }

    public List<Domain> getDomainList() {
        return repo.getDomainList();
    }

    public void clearList(){
        repo.clearList();
    }

    public void parsing(String date) throws Exception {
        clearList();
        URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp?date_req=" + date);

        XMLReader myReader = XMLReaderFactory.createXMLReader();
        XMLHandler handler = new XMLHandler(repo);
        myReader.setContentHandler(handler);
        InputStream inputStream = url.openStream();

        myReader.parse(new InputSource(inputStream));
    }
}
