package com.sample;

import java.util.List;
import java.util.ArrayList;


public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private int messageCount = 0;

    public void send(final String message) {
	for(Subscriber sub : subscribers) {
	    sub.receive(message);
	}
	messageCount++;
    }
    
}
