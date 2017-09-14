package com.example.priya.parentassistapp.pojo;

/**
 * Created by priya on 13/9/17.
 */

public class DataModel {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    String description;

    public DataModel(String title, String description) {
        this.title = title;
        this.description = description;
    }


}
