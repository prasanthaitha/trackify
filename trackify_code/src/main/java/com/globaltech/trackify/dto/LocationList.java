package com.globaltech.trackify.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationList {

    private List<LocationSaveRequest> locationRequests;

}
