package com.order.demo.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

@Component
public class OrderXmlValidator {

    private static final String XSD_PATH = "/path/to/order.xsd"; // Update with the actual path

    public boolean validateXml(String xmlContent) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(getClass().getResourceAsStream(XSD_PATH)));

            Validator validator = schema.newValidator();
            validator.setErrorHandler(new DefaultHandler());
            validator.validate(new StreamSource(new StringReader(xmlContent)));

            return true;
        } catch (IOException | SAXException e) {
            // Handle validation exception
            return false;
        }
    }
}
