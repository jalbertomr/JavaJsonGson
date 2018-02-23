package com.example.bext;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class JsonTest {

    @Test
    public void testCountRevisions() {
        JsonParser parser = new JsonParser();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("sample.json");
        Reader reader = new InputStreamReader(resourceAsStream);
        JsonElement root = parser.parse(reader);
        Assert.assertNotNull(root);
    }
}
