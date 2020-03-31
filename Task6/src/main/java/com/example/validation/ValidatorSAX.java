package com.example.validation;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import com.example.validation.errorhandler.CandiesErrorHandler;

import org.xml.sax.SAXException;

public class ValidatorSAX {

    public static void validateFile() {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/main/resources/data/Candies.xml";
        String schemaName = "src/main/resources/data/XSDSchemeForCandies.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
            System.out.println(fileName + " is valid.");
            CandiesErrorHandler sh = new CandiesErrorHandler("src/main/resources/logs/log.txt");
            validator.setErrorHandler(sh);
            validator.validate(source);
        } catch (SAXException e) {
            System.err.print("validation "+ fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            System.err.print(fileName + " is not valid because "
                    + e.getMessage());
        }
    }
}