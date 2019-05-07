package com.dp.test;

import org.junit.Test;

import java.io.*;


public class Test2 {

    @Test
    public void test() throws IOException {

        String[] expected = {"issue", "nr", "total"};
        String words = "";
        String separator = "\t";//Here you can use , or space according to your csv file
        File f = new File("/Users/user/Desktop/altFisier.txt");
// de vazut de ce nu da ce trebuie
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/user/Desktop/invoice.csv"));

             BufferedWriter br2 = new BufferedWriter(new FileWriter(("/Users/user/Desktop/altFisier.txt")))) {

            while ((words = br.readLine()) != null) {
                br2.write(words);
                br2.write("\n");

            }
            // scrie pe disk
            br2.flush();
            // inchide
            br2.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
