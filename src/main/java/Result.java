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
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;



class Result {

    /*
     * Complete the 'getDiscountedPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER barcode as parameter.
     * API URL: https://jsonmock.hackerrank.com/api/inventory?barcode=<barcode>
     */

    public static int getDiscountedPrice(int barcode) {

        int discountedPrice = -1;

        try {
            double price = 0;
            double discount = 0;


            //construct the URL to query the API
            String apiURL = "https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode;
            URL url = new URL (apiURL);

            //create a HTTP connetion
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //set the HTTP request method to GET
            connection.setRequestMethod("GET");

            //get the response code
            int responseCode = connection.getResponseCode();

            //check if response code is 200
            if (responseCode == HttpURLConnection.HTTP_OK) {

                //read and parse the API response

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder();


                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                //parse the JSON response
                JSONParser parser = new JSONParser();
                JSONObject jsonResponse = (JSONObject) parser .parse(response.toString());

                //extract the data array

                JSONArray dataArray = (JSONArray) jsonResponse.get("data");

                if(!dataArray.isEmpty()) {
                    //extract the item object which is the first item
                    JSONObject item = (JSONObject) dataArray.get(0);

                    //extract price
                    price = Double.parseDouble(item.get("price").toString());
                    discount = Double.parseDouble(item.get("discount").toString());

                    //calculate the discountedprice

                    discountedPrice = (int) Math.round(price * (1 - (discount / 100)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return discountedPrice;
    }

}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int barcode = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.getDiscountedPrice(barcode);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
