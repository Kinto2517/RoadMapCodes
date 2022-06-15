package com.company;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */

    public static String decryptMessage(String encryptedMessage) {
        StringBuffer strb = new StringBuffer();

        String[] strArray = encryptedMessage.split(" ");
        for (int i = 0; i < strArray.length; i++) {
            int count = 0;
            for (int j = 0; j < strArray[i].toString().length(); j++) {

                char c = strArray[i].toString().charAt(j);
                if (Character.isDigit(c)) {
                    count = count * 10 + c - '0';
                } else {
                    while (count >0){
                        strb.append(c);
                        count--;
                    }
                }
                strArray[i]=strb.toString();
            }


        }


        for(int i = strArray.length-1; i>=0; i--) {
            strb.append(strArray[i]);
            strb.append(" ");
        }
        String a = strb.toString();
        return a;
    }

}




public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
