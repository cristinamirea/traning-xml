package com.dp.test.java.com.dp;

import com.opencsv.CSVReader;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class Tests {

    @Test
    public void test() throws FileNotFoundException {
        List<String> list  = Arrays.asList("issue","nr","total");

        //deschizi si citesti din fisier(fisierul csv)
        //assert fisier.continut startswith (issue,nr,total);



            try {
                // class with CSV file as a parameter.
                FileReader filereader = new FileReader("/Users/user/Desktop/invoice.csv");

                // create csvReader object passing
                // file reader as a parameter
                CSVReader csvReader = new CSVReader(filereader);
                String[] nextRecord;
                int  line = 0 ;
                // we are going to read data line by line
                while ((nextRecord = csvReader.readNext()) != null) {
                    for (String cell : nextRecord) {
                        System.out.print(cell + "\t");
                    }
                    System.out.println();
                    if(line == 0){
                        assert  Arrays.asList(nextRecord).containsAll(list);
                    }
                    line ++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



}
