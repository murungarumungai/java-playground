package com.testharness;
import java.lang.*;

public class Inverter {

    public static String invert(String s) {

        //create and initialize instance of StringBuilder
        StringBuilder sb = new StringBuilder();

        if(s == null)  {
            return "";
        }

        //append string to invert to sb
        sb.append(s);

        //reverse and return the string to invert
        return sb.reverse().toString();

    }
}
