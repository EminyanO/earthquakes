package com.example.earthq;


public enum CountryEnum {

    TURKEY(36, 42, 26, 45),
    USA(24,71,66,172),
    GERMANY(47,55,6,15);

    public final double minLatitude;
    public final double maxLatitude;
    public final double minLongitude;
    public final double maxLongitude;

    CountryEnum(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude) {
        this.minLatitude = minLatitude;
        this.maxLatitude = maxLatitude;
        this.minLongitude = minLongitude;
        this.maxLongitude = maxLongitude;
    }
}