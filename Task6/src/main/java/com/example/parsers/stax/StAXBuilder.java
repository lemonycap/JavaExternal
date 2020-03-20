package com.example.parsers.stax;

import candies.Candy;
import candies.Ingredients;
import candies.ObjectFactory;
import candies.Value;
import com.example.parsers.utils.CandyEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXBuilder {
    private HashSet<Candy> candies = new HashSet<Candy>();
    private XMLInputFactory inputFactory;

    public StAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void buildSetStudents(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
// StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CANDY) {
                        Candy cd = buildCandy(reader);
                        candies.add(cd);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Impossible close file " + fileName + " : " + e);
            }
        }
    }

    private Candy buildCandy(XMLStreamReader reader) throws XMLStreamException {
        Candy cd = new Candy();
        cd.setProductName(reader.getAttributeValue(null, CandyEnum.PRODUCT_NAME.getValue()));
        cd.setFilling(reader.getAttributeValue(null, CandyEnum.FILLING.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            cd.setName(getXMLText(reader));
                            break;
                        case ENERGY:
                            cd.setEnergy(getXMLText(reader));
                            break;
                        case TYPE:
                            cd.setType(getXMLText(reader));
                            break;
                        case INGREDIENTS:
                            cd.setIngredients(getXMLIngredients(reader));
                            break;
                        case VALUE:
                            cd.setValue(getXMLValues(reader));
                            break;
                        case PRODUCT_OWNER:
                            cd.setProductOwner(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.CANDY) {
                        return cd;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Candy");
    }
    private Ingredients getXMLIngredients(XMLStreamReader reader) throws XMLStreamException {
        Ingredients ingredients = new Ingredients();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case WATER:
                            ingredients.setWater(getXMLText(reader));
                            break;
                        case SUGAR:
                            ingredients.setSugar(getXMLText(reader));
                            break;
                        case FRUCTOSE:
                            ingredients.setFructose(getXMLText(reader));
                            break;
                        case VANILINE:
                            ingredients.setVaniline(getXMLText(reader));
                            break;
                        case CHOCOLATE_TYPE:
                            ingredients.setChocolateType(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.INGREDIENTS) {
                        return ingredients;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Ingredients");
    }
    private Value getXMLValues(XMLStreamReader reader) throws XMLStreamException {
        Value value = new Value();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (CandyEnum.valueOf(name.toUpperCase())) {
                        case PROTEINS:
                            value.setProtein(getXMLText(reader));
                            break;
                        case FATS:
                            value.setFat(getXMLText(reader));
                            break;
                        case CARBS:
                            value.setCarb(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (CandyEnum.valueOf(name.toUpperCase()) == CandyEnum.VALUE) {
                        return value;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Value");
    }
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}