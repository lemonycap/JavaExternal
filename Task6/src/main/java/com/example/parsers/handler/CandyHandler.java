package com.example.parsers.handler;

import candies.Candy;
import candies.ObjectFactory;
import com.example.parsers.utils.CandyEnum;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class CandyHandler extends DefaultHandler {
    private Set<Candy> candies;
    private Candy current = null;
    private CandyEnum currentEnum = null;
    private EnumSet<CandyEnum> withText;
    public CandyHandler() {
        candies = new HashSet<Candy>();
        withText = EnumSet.range(CandyEnum.NAME, CandyEnum.PRODUCT_OWNER);
    }
    public Set<Candy> getCandies() {
        return candies;
    }

    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException
    {
        if ("candy".equals(localName)) {
            current = new Candy();
            current.setProductName(attributes.getValue(0));
            current.setFilling(attributes.getValue(1));
        } else {
            CandyEnum temp = CandyEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if ("candy".equals(localName)) {
            candies.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;
                case ENERGY:
                    current.setEnergy(s);
                    break;
                case TYPE:
                    current.setType(s);
                    break;
                case INGREDIENTS:
                    current.setIngredients(ObjectFactory.createIngredients());
                    break;
                case VALUE:
                    current.setValue(ObjectFactory.createValue());
                    break;
                case WATER:
                    current.getIngredients().setWater(s);
                    break;
                case SUGAR:
                    current.getIngredients().setSugar(s);
                    break;
                case FRUCTOSE:
                    current.getIngredients().setFructose(s);
                    break;
                case VANILINE:
                    current.getIngredients().setVaniline(s);
                    break;
                case CHOCOLATE_TYPE:
                    current.getIngredients().setChocolateType(s);
                    break;
                case PROTEINS:
                    current.getValue().setProtein(s);
                    break;
                case FATS:
                    current.getValue().setFat(s);
                    break;
                case CARBS:
                    current.getValue().setCarb(s);
                    break;
                case PRODUCT_OWNER:
                    current.setProductOwner(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}
