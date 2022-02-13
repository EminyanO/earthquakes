package com.example.earthq;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EarthquakeDTO {

    private CountryEnum countryEnum;
    private String place;
    private Double magnitude;
    private LocalDateTime dateTime;

}