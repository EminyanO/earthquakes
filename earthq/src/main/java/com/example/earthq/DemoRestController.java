package com.example.earthq;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoRestController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/earthquake")
    public ResponseEntity<List<EarthquakeDTO>> response(@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime, @RequestParam("country") CountryEnum countryEnum)
            throws JsonProcessingException {
        List<EarthquakeDTO> result = demoService.sizeOfResponse(startTime, endTime, countryEnum);
        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(result);
        }
    }
}