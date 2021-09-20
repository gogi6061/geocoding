package com.amiriskhakov.geocoding;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "" +
                "{\n" +
                "    \"licence\": \"Data © OpenStreetMap contributors, ODbL 1.0. https://osm.org/copyright\",\n" +
                "    \"osm_id\": 6611864,\n" +
                "    \"address\": {\n" +
                "        \"region\": \"Приволжский федеральный округ\",\n" +
                "        \"city\": \"Кибячинское сельское поселение\",\n" +
                "        \"country\": \"Россия\",\n" +
                "        \"state\": \"Татарстан\",\n" +
                "        \"country_code\": \"ru\",\n" +
                "        \"county\": \"Пестречинский район\"\n" +
                "    },\n" +
                "    \"osm_type\": \"relation\",\n" +
                "    \"boundingbox\": [\n" +
                "        \"55.7184331\",\n" +
                "        \"55.8243716\",\n" +
                "        \"49.9011929\",\n" +
                "        \"50.0497509\"\n" +
                "    ],\n" +
                "    \"place_id\": 249113470,\n" +
                "    \"lat\": \"55.77189435\",\n" +
                "    \"lon\": \"49.9682151269626\",\n" +
                "    \"display_name\": \"Кибячинское сельское поселение, Пестречинский район, Татарстан, Приволжский федеральный округ, Россия\"\n" +
                "}";
        ObjectMapper mapper = new ObjectMapper();
        System.out.println( mapper.readTree(json).get("address").get("country"));

    }
}
