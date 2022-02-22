package com.globaltech.trackify.services;

import com.globaltech.trackify.constants.CommonConstants;
import com.globaltech.trackify.pojos.FreqConfig;
import com.globaltech.trackify.repository.FreqConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.stream.Collectors;

@Component
public class FreqConfigService {

    @Autowired
    private FreqConfigRepository freqConfigRepository;

    public String fetchLatestConfig(String deviceId) {
//        OptionalInt latestVersion = freqConfigRepository.findByDeviceId(deviceId)
//                .stream().map(FreqConfig::getVersion).collect(Collectors.toList())
//                .stream().mapToInt(v -> v).max();
        Integer latestVersion = freqConfigRepository.fetchLatestVersionForDevice(deviceId);
        if(latestVersion == null) {
            return freqConfigRepository.fetchLatestFreqConfig(CommonConstants.DEFAULT_USER_ID, latestVersion);
//                    .get(0).getConfigData();
        }
        return freqConfigRepository.fetchLatestFreqConfig(deviceId, latestVersion);
//                .get(0).getConfigData();
    }

    public void saveConfigData(String deviceId, String configData) {
//        int maxVersion = freqConfigRepository.findByDeviceId(deviceId)
//                .stream().map(FreqConfig::getVersion).collect(Collectors.toList())
//                .stream().mapToInt(v -> v).max().getAsInt();
        Integer maxVersion = freqConfigRepository.fetchLatestVersionForDevice(deviceId);
        if(maxVersion == null) maxVersion = 0;
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
