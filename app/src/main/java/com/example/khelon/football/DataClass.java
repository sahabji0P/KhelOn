package com.example.khelon.football;

public class DataClass {
    private String heading;
    private String content;
    private String dataImage;
    private String postPlace;

    public String getHeading() {
        return heading;
    }

    public String getContent() {
        return content;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getPostPlace() {
        return postPlace;
    }

    public DataClass(String heading, String content, String dataImage) {
        this.heading = heading;
        this.content = content;
        this.dataImage = dataImage;

    }

    public DataClass(){

    }
}
