package com.globaltech.trackify.services;

import com.globaltech.trackify.pojos.GeoFence;
import com.globaltech.trackify.repository.GeoFenceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class GeoFenceService {

//    One API to save GeoFence Data
//    One API to fetch all GeoFence Data list and compare current location with all GeoFences

    @Autowired
    GeoFenceRepository geoFenceRepository;

    public void saveGeoFenceData(String geoFenceName, String p1, String p2, String p3, String p4, Integer dcNum) {
        GeoFence geoFence = new GeoFence();
        geoFence.setGeoFenceName(geoFenceName);
        geoFence.setLocationP1(p1);
        geoFence.setLocationP2(p2);
        geoFence.setLocationP3(p3);
        geoFence.setLocationP4(p4);
        geoFence.setDcNum(dcNum);
        geoFence.setUpdatedTs(new Timestamp(new Date().getTime()));
        geoFenceRepository.save(geoFence);
    }

    public GeoFence verifyGeoFence(double lat, double lon, String deviceId) {
        List<GeoFence> geoFenceList = (List<GeoFence>) geoFenceRepository.findAll();

        for(GeoFence geoFence : geoFenceList) {
            if(isInsideGeoFence(geoFence, lat, lon))
                return geoFence;
        }

        return null;
    }

    public boolean isInsideGeoFence(GeoFence geoFence, double lat, double lon) {
        String[] points = {geoFence.getLocationP1(), geoFence.getLocationP2(),
                            geoFence.getLocationP3(), geoFence.getLocationP4()};

        String[] p1 = geoFence.getLocationP1().split("##");
        String[] p2 = geoFence.getLocationP2().split("##");
        String[] p3 = geoFence.getLocationP3().split("##");
        String[] p4 = geoFence.getLocationP4().split("##");


        return false;
    }
}
