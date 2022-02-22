package com.globaltech.trackify.services;

import com.globaltech.trackify.dto.LocationDto;
import com.globaltech.trackify.dto.LocationSaveRequest;
import com.globaltech.trackify.pojos.Location;
import com.globaltech.trackify.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public void updateLocation (LocationSaveRequest locationSaveRequest) {
        Location location = new Location();
        location.setDeviceId(locationSaveRequest.getDeviceId());
        location.setLocation(locationSaveRequest.getLatitude()+"##"+locationSaveRequest.getLongitude());
        location.setUpdatedTs(new Timestamp(new Date().getTime()));
        location.setSpeed(locationSaveRequest.getSpeed());
        locationRepository.save(location);
    }

    public void updateLocationWithValues (String deviceId, double lat, double lon, float speed) {
        Location location = new Location();
        location.setDeviceId(deviceId);
        location.setLocation(lat+"##"+lon);
        location.setUpdatedTs(new Timestamp(new Date().getTime()));
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
