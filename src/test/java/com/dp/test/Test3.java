package com.dp.test;


import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test3 {
// aici e rezolvarea cea mai simpla de unitTest
    @Test
    public void test() throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("/Users/user/Desktop/invoice.csv"));
        String string = new String(encoded, "UTF-8");
        assert string.startsWith("issue,nr,total");
    }
}
