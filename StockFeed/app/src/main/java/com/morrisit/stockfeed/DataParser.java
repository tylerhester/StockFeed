package com.morrisit.stockfeed;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.ArrayList;
public class DataParser {
    static TreeMap<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
    public DataParser () throws Exception {
        populateCompanies();
    }
    public void populateCompanies() throws Exception {
        URL xml = new URL("http://stock-feed.cloudapp.net/examples/field_output.txt");
        BufferedReader stream = new BufferedReader(new InputStreamReader(xml.openStream()));
        String line;
        do {
            line = stream.readLine();
            if(line == null) break;
            String[] data = line.split(":");
            String companyName = data[0];
            String lowPrice = data[1];
            String highPrice = data[2];
            ArrayList<String> companyList = new ArrayList<String>();
            companyList.add(companyName);
            companyList.add(lowPrice);
            companyList.add(highPrice);
            map.put(companyName, companyList);
        }
        while (line != null);
    }
    public ArrayList<String> retrieveData(String data) throws Exception {
        return map.get(data);
    }
    public String retrieveLow(String data) throws Exception {
        ArrayList<String> arrayList = map.get(data);
        return arrayList.get(1);
    }
    public String retrieveHigh(String data) throws Exception {
        ArrayList<String> arrayList = map.get(data);
        return arrayList.get(2);
    }
}