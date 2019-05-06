package com.dp.test;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        CsvWriter.write(XmlReader.reader());
    }
}
