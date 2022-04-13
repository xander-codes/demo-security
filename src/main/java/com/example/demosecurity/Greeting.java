package com.example.demosecurity;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Greeting {
    int id;
    String content;

    public Greeting(String content) {
        this.id = new Random().nextInt();
        this.content = content;
    }

    public Greeting() {
    }
}
