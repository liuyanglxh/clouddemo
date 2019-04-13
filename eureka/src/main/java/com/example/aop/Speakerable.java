package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class Speakerable implements Speaker {
    @Override
    public void speak() {
        System.out.println("speak");
    }
}
