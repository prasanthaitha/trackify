package com.globaltech.trackify.services;

import com.globaltech.trackify.dto.LocationDto;
import com.globaltech.trackify.pojos.Location;
import com.globaltech.trackify.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public void updateLocation (String deviceId, double lat, double lon, float speed) {
        Location location = new Location();
        location.setDeviceId(deviceId);
        location.setLocation(lat+"##"+lon);
        location.setUpdatedTs(new Date().getTime());
        location.setSpeed(speed);
        locationRepository.save(location);
    }

    public LocationDto getLocation (String deviceId) {
        Location latestLocation = locationRepository.fetchLatestLocation(deviceId);
        String[] coords = latestLocation.getLocation().split("##");
        LocationDto locationDto = new LocationDto();
        locationDto.setLatitude(Double.parseDouble(coords[0]));
        locationDto.setLongitude((Double.parseDouble(coords[1])));
        locationDto.setSpeed(latestLocation.getSpeed());
        locationDto.setUpdatedTs(latestLocation.getUpdatedTs());
        return locationDto;
    }
}
