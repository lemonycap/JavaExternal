package com.example.parsers.dom;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import candies.Candy;
import candies.Ingredients;
import candies.ObjectFactory;
import candies.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMBuilder {
    private Set<Candy> candies;
    private DocumentBuilder docBuilder;
    public DOMBuilder() {
        this.candies = new HashSet<Candy>();
// создание DOM-анализатора
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Ошибка конфигурации парсера: " + e);
        }
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    public void buildSetCandies(String fileName) {
        Document doc = null;
        try {
// parsing XML-документа и создание древовидной структуры
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
// получение списка дочерних элементов <candy>
            NodeList candiesList = root.getElementsByTagName("candy");
            for (int i = 0; i < candiesList.getLength(); i++) {
                Element candyElement = (Element) candiesList.item(i);
                Candy candy = buildCandy(candyElement);
                candies.add(candy);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }
    private Candy buildCandy(Element candyElement) {
        Candy candy = new Candy();

        candy.setProductName(candyElement.getAttribute("productName"));
        candy.setFilling(candyElement.getAttribute("filling"));
        candy.setName(getElementTextContent(candyElement, "name"));
        candy.setEnergy(getElementTextContent(candyElement, "energy"));
        candy.setType(getElementTextContent(candyElement, "type"));
        candy.setIngredients(ObjectFactory.createIngredients());

        Ingredients ingredients = candy.getIngredients();
        Element ingrecElement = (Element) candyElement.getElementsByTagName(
                "ingredients").item(0);
        ingredients.setWater(getElementTextContent(ingrecElement, "water"));
        ingredients.setSugar(getElementTextContent(ingrecElement, "sugar"));
        ingredients.setFructose(getElementTextContent(ingrecElement, "fructose"));
        ingredients.setVaniline(getElementTextContent(ingrecElement, "vaniline"));
        ingredients.setChocolateType(getElementTextContent(ingrecElement, "chocolate_type"));

        candy.setValue(ObjectFactory.createValue());
        Value value = candy.getValue();
        Element valueElement = (Element) candyElement.getElementsByTagName(
                "value").item(0);
        value.setProtein(getElementTextContent(valueElement, "proteins"));
        value.setFat(getElementTextContent(valueElement, "fats"));
        value.setCarb(getElementTextContent(valueElement, "carbs"));

        candy.setProductOwner(getElementTextContent(candyElement, "product_owner"));
        return candy;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
