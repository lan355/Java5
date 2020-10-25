package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Joke joke = new Joke();
        joke = joke.jokeURL("https://sv443.net/jokeapi/v2/joke/Any?amount=4");
        System.out.println(joke);
        System.out.println("\n");
        joke.SortId();
        System.out.println(joke);
    }
}
