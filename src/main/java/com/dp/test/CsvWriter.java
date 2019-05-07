package com.dp.test;

import generated.Invoice;

import java.io.*;

public class CsvWriter {


// Metoda 1 de lucru : -------------------------- Descriere citire CSV prin CSV Mapper----------------------------------

//    public static void write(Invoice invoice) throws IOException {
//        CsvMapper mapper = new CsvMapper();
//        CsvSchema schema =   mapper
//                .typedSchemaFor(Invoice.class)
//                .withHeader();
//
//        String csv = mapper.writer(schema).writeValueAsString(invoice);
//        File file = new File("/Users/user/Desktop/invoice.csv");
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        try (PrintWriter out = new PrintWriter(file.getPath())) {
//            out.write(csv);
//        } catch (FileNotFoundException e) {
//           e.printStackTrace();
//        }
//
//    }

    // o noua functie ce foloseste StringBuilder in loc de csv Mapper


// Metoda 2 de lucru : -------------------------- Descriere citire CSV prin StringBuilder ----------------------------------



    private static final String CSV_SEPARATOR = ",";
    public static void write(Invoice product)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/Users/user/Documents/projects/products.csv"), "UTF-8"));


                StringBuffer oneLine = new StringBuffer();
                oneLine.append("issue,nr,total");
                oneLine.append("\n");
                oneLine.append(product.getNr() <=0 ? "" : product.getNr());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getIssue()<=0? "" : product.getIssue());
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(product.getTotal() < 0 ? "" : product.getTotal());
//                oneLine.append(product.isVatApplicable() ? "Yes" : "No");
                bw.write(oneLine.toString());
                bw.newLine();

            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }





}
