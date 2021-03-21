
package com.project.nbpAPIcurrency.parser;

import com.project.nbpAPIcurrency.model.Currency;
import com.project.nbpAPIcurrency.model.CurrencyList;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class Reader {

    private final CurrencyList currencyList;
    private final Currency currency;

    public Reader(CurrencyList currencyList, Currency currency) {
        this.currencyList = currencyList;
        this.currency = currency;
    }

    public void readFromUrl() {
        final String url = "https://www.nbp.pl/kursy/xml/LastA.xml";
        List <Currency> currencyList1 = new ArrayList<>();
        Currency currency = new Currency();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new URL(url).openStream());
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("pozycja");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String curName =getValue("nazwa_waluty", element);
                    String curCode = getValue("kod_waluty", element);
                    String curExchange = getValue("kurs_sredni", element);
                    currency = new Currency(curName,curCode,curExchange);

                }
                currencyList1.add(currency);
            }
        } catch (ParserConfigurationException parserConfigurationException) {
            parserConfigurationException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (SAXException saxException) {
            saxException.printStackTrace();
        }
        currencyList.setCurrencyList(currencyList1);
    }

    public static String getValue(String symbol, Element element) {
            NodeList nodes = element.getElementsByTagName(symbol).item(0).getChildNodes();
            Node node = nodes.item(0);
            return node.getNodeValue();
        }
}

