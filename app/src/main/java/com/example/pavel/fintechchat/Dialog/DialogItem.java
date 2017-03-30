package com.example.pavel.fintechchat.Dialog;

/**
 * Created by pavel on 3/23/17.
 */

public class DialogItem {

    private String title;
    private String desc;

    public DialogItem(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}