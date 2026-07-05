package ua.javarush.task.task40.task4011;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import  javax.mail.*;
import  javax.mail.internet.*;

/* 
Властивості URL
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        decodeURLString("https://www.amrood.com/index.htm?language=en#j2se");
    }

    public static void decodeURLString(String s) throws MalformedURLException {
        try {
            URL url = new URL(s);

            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Authority: " + url.getAuthority());
            System.out.println("File: " + url.getFile());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Default port: " + url.getDefaultPort());
            System.out.println("Query: " + url.getQuery());
            System.out.println("Ref: " + url.getRef());
        } catch (MalformedURLException e) {
            System.out.printf("Parameter %s is not a valid URL.", s);
        }
    }
}

