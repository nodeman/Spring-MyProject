package com.teamsoft.spring.dto;

import com.teamsoft.spring.constant.PlaceType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PlaceResponse {
    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;
}