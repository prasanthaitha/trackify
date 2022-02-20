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


    @PostMapping(path="/latest")
    public @ResponseBody String fetchLatestConfig (@RequestParam String deviceId) {
        return freqConfigService.fetchLatestConfig(deviceId);
    }

    @PostMapping(path = "/save")
    public @ResponseBody void saveConfig(@RequestParam String deviceId, @RequestParam String configData) {
        if (deviceId == null || deviceId.isEmpty())
            deviceId = CommonConstants.DEFAULT_USER_ID;
        freqConfigService.saveConfigData(deviceId, configData);
    }
}
