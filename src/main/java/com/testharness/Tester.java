package com.testharness;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Tester {

    class AirPlane {

        public AirPlane() throws IOException {
            System.out.print("AirPlane");
            throw new IOException();
        }

    }

    class AirJet extends AirPlane {
        public AirJet() throws IOException {

            System.out.println("Airjet");

            /*try {

                super();

            } catch (IOException e) {
                System.out.print("IOException is thrown in Air Jet");

            }*/
        }

    }

    public static void main(String args[]) throws IOException {

        URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId=");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        /*try{

            new AirJet();

        } catch (IOException e)

        {

            System.out.print("IOException is thrown in Tester");
        }*/


        try {
            Float f1 = new Float("3.0");
            int x = f1.intValue();

            byte b = f1.byteValue();

            double d = f1.doubleValue();
            System.out.println(x + b + d);
        } catch (NumberFormatException e) {
            System.out.println("bad number");
        }


    }
}
