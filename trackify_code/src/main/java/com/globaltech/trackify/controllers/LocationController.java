package com.globaltech.trackify.controllers;


import com.globaltech.trackify.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping(path="/update")
    public @ResponseBody void updateLocation (@RequestParam String deviceId,
                                              @RequestParam double lat, @RequestParam double lon,
                                              @RequestParam float speed) {
        locationService.updateLocation(deviceId, lat, lon, speed);
    }

    @PostMapping(path="/fetch")
    public @ResponseBody void fetchLocation (@RequestParam String deviceId) {
        locationService.getLocation(deviceId);
    }
}
