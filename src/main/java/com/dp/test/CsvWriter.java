package com.dp.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import generated.Invoice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CsvWriter {

    public static void write(Invoice invoice) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema =   mapper
                .typedSchemaFor(Invoice.class)
                .withHeader();

        String csv = mapper.writer(schema).writeValueAsString(invoice);
        File file = new File("/Users/user/Desktop/invoice.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        try (PrintWriter out = new PrintWriter(file.getPath())) {
            out.write(csv);
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }

    }
}
