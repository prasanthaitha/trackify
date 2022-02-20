package com.globaltech.trackify.services;

import com.globaltech.trackify.constants.CommonConstants;
import com.globaltech.trackify.pojos.FreqConfig;
import com.globaltech.trackify.repository.FreqConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FreqConfigService {

    @Autowired
    private FreqConfigRepository freqConfigRepository;

    public String fetchLatestConfig(String deviceId) {
        Integer latestVersion = freqConfigRepository.fetchLatestVersionForDevice(deviceId);
        if(latestVersion == null) {
            return freqConfigRepository.fetchLatestFreqConfig(CommonConstants.DEFAULT_USER_ID, latestVersion);
        }
        return freqConfigRepository.fetchLatestFreqConfig(deviceId, latestVersion);
    }

    public void saveConfigData(String deviceId, String configData) {
        int maxVersion = freqConfigRepository.fetchLatestVersionForDevice(deviceId);
        FreqConfig freqConfig = new FreqConfig();
        freqConfig.setDeviceId(deviceId);
        freqConfig.setConfigData(configData);
        freqConfig.setVersion(maxVersion+1);
        freqConfig.setUpdatedTs(new Timestamp(new Date().getTime()));
        freqConfigRepository.save(freqConfig);
    }

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(formatter.format(ts));
}
