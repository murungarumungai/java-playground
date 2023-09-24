package com.testharness;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HttpTest {


    private class Transaction {

        private Long id;

        private Long userId;

        private String userName;

        private Long timestamp;

        private String txnType;

        private String amount;

        private Location location;

        private String ip;

        public Transaction(Long id, Long userId, String userName, Long timestamp, String txnType, String amount, Location location, String ip) {
            this.id = id;
            this.userId = userId;
            this.userName = userName;
            this.timestamp = timestamp;
            this.txnType = txnType;
            this.amount = amount;
            this.location = location;
            this.ip = ip;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Long timestamp) {
            this.timestamp = timestamp;
        }

        public String getTxnType() {
            return txnType;
        }

        public void setTxnType(String txnType) {
            this.txnType = txnType;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

    }

    public class Location {

        private Integer id;

        private String address;

        private String city;

        private Integer zipCode;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Integer getZipCode() {
            return zipCode;
        }

        public void setZipCode(Integer zipCode) {
            this.zipCode = zipCode;
        }

    }

    public static class UserTransaction {

        private Long page;

        private Long perPage;

        private Long total;

        private Long totalPages;

        private JSONArray data = null;

        public UserTransaction(Long page, Long perPage, Long total, Long totalPages, JSONArray data) {
            this.page = page;
            this.perPage = perPage;
            this.total = total;
            this.totalPages = totalPages;
            this.data = data;
            /*this.data = new Transaction(
                    (Long) data.get("id"),
                    (Long) data.get("userId"),
                    (String) data.get("userName"),
                    (Long) data.get("timestamp"),
                    (String) data.get("txnType"),
                    (String) data.get("amount"),
                    (Location) data.get("location"),
                    (String) data.get("ip"));*/
        }

        public Long getPage() {
            return page;
        }

        public void setPage(Long page) {
            this.page = page;
        }

        public Long getPerPage() {
            return perPage;
        }

        public void setPerPage(Long perPage) {
            this.perPage = perPage;
        }

        public Long getTotal() {
            return total;
        }

        public void setTotal(Long total) {
            this.total = total;
        }

        public Long getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Long totalPages) {
            this.totalPages = totalPages;
        }

        public JSONArray getData() {
            return data;
        }

        public void setData(JSONArray data) {
            this.data = data;
        }

    }

    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
        List<Integer> retVal = new ArrayList<>();

        //initialzing null instance of URL class
        URL url = null;
        try {

            //instantiating URL wth default uri to fetch transactions
            url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId=" + uid);

            //connection to perform HTTP operations
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");


            try  {


                int responsecode = connection.getResponseCode();

                if (responsecode != 200) {
                    throw new RuntimeException("HttpResponseCode: " + responsecode);
                } else {

                    String inline = "";
                    Scanner scanner = new Scanner(url.openStream());

                    //Write all the JSON data into a string using a scanner
                    while (scanner.hasNext()) {
                        inline += scanner.nextLine();
                    }

                    //Close the scanner
                    scanner.close();

                    //Using the JSON simple library parse the string into a json object
                    JSONParser parse = new JSONParser();
                    JSONObject userTransactionObj = (JSONObject) parse.parse(inline);

                    Double averageSpeed = 0d;
                    NumberFormat format = NumberFormat.getCurrencyInstance();

                    UserTransaction userTransaction = new UserTransaction(
                            (Long) userTransactionObj.get("page"),
                            (Long) userTransactionObj.get("per_page"),
                            (Long) userTransactionObj.get("total"),
                            (Long) userTransactionObj.get("total_pages"),
                            (JSONArray) userTransactionObj.get("data"));


                    List<JSONObject> debitList = (List<JSONObject>) userTransaction.data.stream()
                            .filter(data -> ((JSONObject) data).get("txnType").equals(txnType))
                    .collect(Collectors.toList());

                    //Date date = new Date(ts.getTime());

                    debitList.stream()
                            .mapToDouble(data -> Double.valueOf( data.get("amount").toString().replace("$", "").replace(",", "")))
                            .average()
                            .ifPresent(average -> System.out.println(format.format(average)));


                    JSONArray arr = (JSONArray) userTransactionObj.get("Countries");

                    for (int i = 0; i < arr.size(); i++) {

                        JSONObject new_obj = (JSONObject) arr.get(i);

                        if (new_obj.get("Slug").equals("albania")) {
                            System.out.println("Total Recovered: " + new_obj.get("TotalRecovered"));
                            break;
                        }
                    }
                }


            } catch (ParseException e) {
                e.printStackTrace();
            }
            //opening inputstream to retrieve data fromn connnection
            InputStream responseStream = connection.getInputStream();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retVal;
    }

    public static void main(String[] args) {

        List<Integer> result = HttpTest.getUserTransaction(4, "debit","02-2019");
    }
}
