package com.example.pavel.fintechchat.Message;

/**
 * Created by pavel on 3/23/17.
 */

public class MessageItem {
    private String message;
    private boolean incoming;

    public MessageItem(String message, Boolean incoming) {
        this.message = message;
        this.incoming = incoming;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getIncoming() {
        return incoming;
    }

}
