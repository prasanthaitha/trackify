package com.globaltech.trackify.controllers;


import com.globaltech.trackify.constants.CommonConstants;
import com.globaltech.trackify.pojos.Location;
import com.globaltech.trackify.repository.FreqConfigRepository;
import com.globaltech.trackify.repository.LocationRepository;
import com.globaltech.trackify.services.FreqConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/config")
public class FreqConfigController {

    @Autowired
    private FreqConfigService freqConfigService;

    /**
     *     int tempVersion=doc["version"];
     *     if (tempVersion>version){
     *       version=tempVersion;
     *       configFrequency=doc["configFrequency"];  //in minutes
     *       locationFrequency=doc["locationFrequency"];  //in minutes
     *       geofenceDataFrequency=doc["geofenceDataFrequency"];
     * @param deviceId
     * @return
     */
    @GetMapping(path="/latest")
    public @ResponseBody String fetchLatestConfig (@RequestParam String deviceId) {
        return freqConfigService.fetchLatestConfig(deviceId);
    }

    @PostMapping(path = "/save")
    public @ResponseBody void saveConfig(String deviceId, String configData) {
        if (deviceId == null || deviceId.isEmpty())
            deviceId = CommonConstants.DEFAULT_USER_ID;
        freqConfigService.saveConfigData(deviceId, configData);
    }
}
