package com.example.bext;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

public class JsonTest {

    @Test
    public void testCountRevisions() {
        JsonParser parser = new JsonParser();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(resourceAsStream);
        JsonElement rootElement = parser.parse(reader);
        JsonObject rootObject = rootElement.getAsJsonObject();
        JsonObject pages = rootObject.getAsJsonObject("query").getAsJsonObject("pages");
        JsonArray arrayRevisions = null;
        for (Map.Entry<String,JsonElement> entry : pages.entrySet()) {   //En este caso hay dos pages
            JsonObject entryObject = entry.getValue().getAsJsonObject();
            arrayRevisions = entryObject.getAsJsonArray("revisions");
        }
        Assert.assertEquals(4, arrayRevisions.size());
    }
}
