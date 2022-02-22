package com.globaltech.trackify.controllers;


import com.globaltech.trackify.dto.LocationDto;
import com.globaltech.trackify.dto.LocationList;
import com.globaltech.trackify.dto.LocationSaveRequest;
import com.globaltech.trackify.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = "/location")
public class LocationController {

    public static final String APPLICATION_JSON_VALUE = "application/json";

    @Autowired
    private LocationService locationService;

//    TODO:: I need to make the request params ad DTO instead of individual params
//    @PostMapping(value="/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public @ResponseBody void updateLocation ( @RequestBody LocationList locationList) {
//        locationService.updateLocation(locationList.getLocationRequests().get(0));
//    }

    @PostMapping(value = "/update", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public @ResponseBody void updateLocation ( @RequestBody LocationSaveRequest locationSaveRequest) {
        locationService.updateLocation(locationSaveRequest);
    }

    @GetMapping(value="/save")
    public @ResponseBody void updateLocationWithGet (@RequestParam String deviceId, @RequestParam double latitude, @RequestParam double longitude, @RequestParam float speed) {
        locationService.updateLocationWithValues(deviceId, latitude, longitude, speed);
    }

    @GetMapping(value="/fetch")
    public @ResponseBody String fetchLocation (@RequestParam String deviceId) {
        LocationDto locationDto = locationService.getLocation(deviceId);
        return  "Latitude:: "+locationDto.getLatitude()
                +"\nLongitude:: "+locationDto.getLongitude()
                +"\nLastUpdatedTs:: "+locationDto.getUpdatedTs();
    }
}
