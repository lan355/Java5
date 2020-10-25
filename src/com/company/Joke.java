
package com.company;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Joke implements Serializable
{

    private boolean error;
    private List<Joke> jokes = new ArrayList<>();
    private int amount;
    private String category;
    private String type;
    private String setup;
    private String delivery;
    private Flags flags;
    private int id;
    private String lang;
    private final static long serialVersionUID = -5168268896830113654L;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<Joke> getJokes() {
        return jokes;
    }

    public void setJokes(List<Joke> jokes) {
        this.jokes = jokes;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void SortId()
    {
        this.getJokes().sort(Joke.bySortId);
    }

    public Joke jokeURL(String url) throws IOException
    {
        StringBuilder builderIn = new StringBuilder();
        InputStream input = null;
        input = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));

            int cp;
            while ((cp = rd.read()) != -1)
            {
                builderIn.append((char) cp);
            }
        }
        finally
        {
            input.close();
        }

        return new ObjectMapper().readValue(builderIn.toString().strip(), Joke.class);

    }

    @Override
    public String toString() {
        return "Joke{" +"\n"+
                "error=" + error + "\n"+
                "jokes=" + jokes + "\n"+
                "category='" + category + '\'' + "\n"+
                "type='" + type + '\'' + "\n"+
                "setup='" + setup + '\'' + "\n"+
                "delivery='" + delivery + '\'' + "\n"+
                "flags=" + flags + "\n"+
                "id=" + id + "\n"+
                "lang='" + lang + '\'' + "\n"+
                "amount=" + amount + "\n"+
                '}';
    }

    public static Comparator<Joke> bySortId = Comparator.comparing(o -> o.id);

}
