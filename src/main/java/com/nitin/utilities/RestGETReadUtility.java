package com.nitin.utilities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nitin.utilities.entity.Card;
import com.nitin.utilities.entity.CovidIndia;
import com.nitin.utilities.entity.Vehicle;
import com.nitin.utilities.entity.crossRef.CrossRef;
import com.nitin.utilities.entity.currencyExchange.CurrencyExchange;
import com.nitin.utilities.entity.git.GitUser;
import com.nitin.utilities.entity.gutendex.Gutendex;
import com.nitin.utilities.entity.openLibrary.Isbn;
import com.nitin.utilities.entity.openLibrary.OpenLibDto;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class RestGETReadUtility {

    ObjectMapper mapper = new ObjectMapper();

    public static void cardReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<Card> listCard = null;
        String url = "https://random-data-api.com/api/business_credit_card/random_card?size=100";

        try {
             listCard = mapper.readValue(new URL(url), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(listCard.size());
    }


    public static List<CovidIndia> covidReader() {
        ObjectMapper mapper = new ObjectMapper();
        List<CovidIndia> covidIndiaList = null;

        String url = "https://api.covid19api.com/total/country/india";
        //Getting the response code
       // int responsecode = getConnectionResponse(url);

        try {
            covidIndiaList = mapper.readValue(new URL(url), new TypeReference<List<CovidIndia>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return covidIndiaList;

    }

    public static List<Vehicle> getRandomVehicles(){
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> randomVehicleList = null;
        String url = "https://random-data-api.com/api/vehicle/random_vehicle?size=100";

        try {
            randomVehicleList = mapper.readValue(new URL(url), new TypeReference<List<Vehicle>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomVehicleList;

    }
    private static int getConnectionResponse(String urlLink) throws IOException {
        URL url = new URL(urlLink);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responsecode = conn.getResponseCode();
        if (responsecode != 200) {
            throw new RuntimeException("HttpResponseCode: " + responsecode);
        }

        return responsecode;
    }

    public static GitUser getRandomGitUsers(){
        ObjectMapper mapper = new ObjectMapper();
        GitUser randomGitUser = null;
        String url = "https://random-data-api.com/api/omniauth/github_get?size=100";//Returns a singl;e git user


        try {
            randomGitUser = mapper.readValue(new URL(url), GitUser.class );//TODO : NOT WORKING, find a way to map to an array of GitUSers
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomGitUser;
    }

    public static Gutendex getGutenbergResults(String searchString){
        ObjectMapper mapper = new ObjectMapper();
        Gutendex results = null;
        String url = "https://gutendex.com/books/?search="+searchString;//Returns a singl;e git user

        try {
            results = mapper.readValue(new URL(url), Gutendex.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static CrossRef getCrossRef(String searchString){
        ObjectMapper mapper = new ObjectMapper();
        CrossRef results = null;
        String url = "https://api.crossref.org/works?query.author="+searchString;//Returns a singl;e git user

        try {
            results = mapper.readValue(new URL(url), CrossRef.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static List<OpenLibDto> getBookDetailsOpenLibrary(String searchString)  {
        //Form the Search string like : ISBN:9780980200447,ISBN:0385472579,LCCN:62019420
        //Given Comma separated search strings
        String[] isbnStr = searchString.split(",");
        StringBuilder searchStringBuilder = new StringBuilder();
        for (int i = 0; i < isbnStr.length; i++) {
            searchStringBuilder.append("ISBN:");
            searchStringBuilder.append(isbnStr[i]);
            searchStringBuilder.append(",");//Will result in Off-By-One error, but doesn't affec t results
        }

        URL url = null;
        try {
            url = new URL("https://openlibrary.org/api/books?bibkeys="+ searchStringBuilder.toString()+ "&format=json&jscmd=data");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        Map<String, Isbn> resultsMap = new HashMap<>();
        try {
            jsonNode = mapper.readTree(url);
            resultsMap = mapper.treeToValue(jsonNode, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<OpenLibDto> openLibDtos = new ArrayList<>();
        Iterator<String> itr = resultsMap.keySet().iterator();//Reponse from the service is in the dynamic form ISBN:9780980200447: {
        while (itr.hasNext()){
            String key = itr.next();//ISBN:9780980200447 is the key
            openLibDtos.add(mapper.convertValue(resultsMap.get(key), OpenLibDto.class));
        }
        return openLibDtos;
    }

    public static void getOpenLibIsbnSearchResultsWithGson() throws IOException {
        URL url = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:9780980200447,ISBN:0385472579,LCCN:62019420&jscmd=data&format=json");
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        // Google GSON library used
        JsonObject jsonobj = JsonParser.parseReader(new InputStreamReader((InputStream) httpConn.getContent())).getAsJsonObject();
        Gson gson = new Gson();
        for (Map.Entry<String, JsonElement> entry : jsonobj.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            JsonObject jsonObject = value.getAsJsonObject();
            Isbn result = gson.fromJson(jsonObject, Isbn.class);
            System.out.println(result.getNumberOfPages());
        }
    }

    public static CurrencyExchange convertCurrency(){
        String url_string = "https://api.exchangerate.host/convert?from=USD&to=INR&base=USD&historical=true&format=json";
        ObjectMapper mapper = new ObjectMapper();

        CurrencyExchange results = new CurrencyExchange();

        try {
            results = mapper.readValue(new URL(url_string), CurrencyExchange.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    public static void main(String[] args) throws IOException {
        //cardReader();
//        List<CovidIndia> list = covidReader();
//                list.forEach(x -> System.out.println(x.toString()));
        //System.out.println(getRandomGitUsers().credentials.token);
        // System.out.println(getRandomVehicles().size());
        /*getGutenbergResults("Pride+and+Prejudice")
                .results.forEach(result -> result.getAuthors().forEach(author -> System.out.println(author.name)));

        //Item -> Author and Indexed
        getCrossRef("jane+austin").getMessage().getItems().forEach(item -> System.out.println(item.getIsbn()));

        //System.out.println(getBookDetailsOpenLibrary("9781108074568").getIsbn().getNumberOfPages());

        getBookDetailsOpenLibrary("9780980200447,0385472579").forEach(isbn -> System.out.println(isbn.getNumberOfPages()));
        getOpenLibIsbnSearchResultsWithGson();
*/
        System.out.println(convertCurrency().getResult());
    }

}