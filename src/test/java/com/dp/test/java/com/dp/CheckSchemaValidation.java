package com.dp.test.java.com.dp;

import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;

public class CheckSchemaValidation {

    static boolean validateAgainstXSD(InputStream xml, InputStream xsd) throws SAXException, IOException {

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;


    }

    @Test
    public void validate() throws IOException, SAXException {

       InputStream inv =  getClass()
                .getClassLoader().getResourceAsStream("invoice.xml");

        InputStream xsd =  getClass()
                .getClassLoader().getResourceAsStream("invoice.xsd");
        validateAgainstXSD(inv, xsd);

    }
// validare xsd-ul
    @Test(expected = SAXParseException.class)
    public void validate2() throws IOException, SAXException {

        InputStream inv =  getClass()
                .getClassLoader().getResourceAsStream("order.xml");

        InputStream xsd =  getClass()
                .getClassLoader().getResourceAsStream("invoice.xsd");
        validateAgainstXSD(inv, xsd);

    }

}
