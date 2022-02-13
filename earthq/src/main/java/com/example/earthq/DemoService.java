package com.example.earthq;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {

    private static final String URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";

    public List<EarthquakeDTO> sizeOfResponse(String startTime, String endTime, CountryEnum countryEnum) {
        String url = URL + "&starttime=" + startTime + "&endtime=" + endTime + "&minlatitude="
                + countryEnum.minLatitude + "&maxlatitude=" + countryEnum.maxLatitude + "&minlongitude="
                + countryEnum.minLongitude + "&maxlongitude=" + countryEnum.maxLongitude;

        RestTemplate restTemplate = new RestTemplate();
        JSONObject jsonObject = new JSONObject(restTemplate.getForObject(url, String.class));
        JSONArray features1 = jsonObject.getJSONArray("features");
        List<EarthquakeDTO> resultList = new ArrayList<>();
        for (int i = 0; i < features1.length(); i++) {
            EarthquakeDTO earthquakeDTO = new EarthquakeDTO();
            JSONObject jsonObject1 = features1.getJSONObject(i);
            JSONObject properties1 = jsonObject1.getJSONObject("properties");
            earthquakeDTO.setMagnitude(properties1.getDouble("mag"));
            earthquakeDTO.setCountryEnum(countryEnum);
            earthquakeDTO.setPlace(properties1.getString("place"));
            earthquakeDTO.setDateTime(
                    Instant.ofEpochMilli(properties1.getLong("time")).atZone(ZoneId.systemDefault()).toLocalDateTime());
            resultList.add(earthquakeDTO);


        }
        return resultList;
    }
}