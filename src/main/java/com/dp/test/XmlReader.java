package com.dp.test;

import generated.Invoice;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlReader {

    // trasform din html in obiect java-Invoice, apoi retrunez
    public static Invoice reader() throws RuntimeException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Invoice.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("/Users/user/Documents/projects/task.xml");
        return  (Invoice) unmarshaller.unmarshal(xml);
    }

}
