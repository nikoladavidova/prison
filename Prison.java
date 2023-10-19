package com.example.demo.prisons;

public class Prison {

    private int id;
    private String name;
    private String page;
    private int capacity;
    private double latitude;
    private double longitude;

    public Prison(int id, String name, String page, int capacity, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.page = page;
        this.capacity = capacity;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPage() {
        return page;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
