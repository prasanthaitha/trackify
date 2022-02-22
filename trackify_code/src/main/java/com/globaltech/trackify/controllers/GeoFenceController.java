package com.globaltech.trackify.controllers;


import com.globaltech.trackify.constants.CommonConstants;
import com.globaltech.trackify.pojos.Location;
import com.globaltech.trackify.repository.GeoFenceRepository;
import com.globaltech.trackify.repository.LocationRepository;
import com.globaltech.trackify.services.GeoFenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/geofence")
public class GeoFenceController {

    @Autowired
    private GeoFenceService geoFenceService;

//    One API to save GeoFence Data
//    One API to fetch all GeoFence Data list and compare current location with all GeoFences

    @PostMapping(path = "/save")
    public @ResponseBody void saveConfig(@RequestParam String geoFenceName,
                                         @RequestParam double p1Lat,@RequestParam double p1Lon,
                                         @RequestParam double p2Lat,@RequestParam double p2Lon,
                                         @RequestParam double p3Lat,@RequestParam double p3Lon,
                                         @RequestParam double p4Lat,@RequestParam double p4Lon,
                                         @RequestParam Integer dcNum) {
        String p1 = p1Lat+"##"+p1Lon;
        String p2 = p2Lat+"##"+p2Lon;
        String p3 = p3Lat+"##"+p3Lon;
        String p4 = p4Lat+"##"+p4Lon;
        geoFenceService.saveGeoFenceData(geoFenceName, p1, p2, p3, p4, dcNum);
    }


//    isInside=doc["isInside"];
//    P1.x=doc["P1_x"];
//    P1.y=doc["P1_y"];
//    P2.x=doc["P2_x"];
//    P2.y=doc["P2_y"];
//    P3.x=doc["P3_x"];
//    P3.y=doc["P3_y"];
//    P4.x=doc["P4_x"];
//    P4.y=doc["P4_y"];

    @GetMapping("/fetch")
    public @ResponseBody String verifyGeoFence(@RequestParam double lat, @RequestParam double lon) {
        return "";
    }
}
