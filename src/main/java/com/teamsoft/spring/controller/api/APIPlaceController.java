package com.teamsoft.spring.controller.api;

import com.teamsoft.spring.constant.PlaceType;
import com.teamsoft.spring.dto.APIDataResponse;
import com.teamsoft.spring.dto.PlaceRequest;
import com.teamsoft.spring.dto.PlaceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class APIPlaceController {


    @GetMapping("/places")
    public APIDataResponse<List<PlaceResponse>> getPlaces() {
        PlaceResponse response = PlaceResponse.builder()
                .placeType(PlaceType.COMMON)
                .placeName("강남 베드민턴장")
                .address("서울시 강남구 강남대로 123")
                .phoneNumber("010-1234-1234")
                .capacity(30)
                .memo("신장개업")
                .build();

        return APIDataResponse.of(List.of(response));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/places")
    public APIDataResponse<Void> createPlace(@RequestBody PlaceRequest request) {
        return APIDataResponse.empty();
    }

    @GetMapping("/places/{placeId}")
    public APIDataResponse<PlaceResponse> getPlace(@PathVariable Long placeId) {
        if (placeId.equals(2l)) {
            return APIDataResponse.empty();
        }

        PlaceResponse response = PlaceResponse.builder()
                .placeType(PlaceType.COMMON)
                .placeName("강남 베드민턴장")
                .address("서울시 강남구 강남대로 123")
                .phoneNumber("010-1234-1234")
                .capacity(30)
                .memo("신장개업")
                .build();

        return APIDataResponse.of(response);
    }

    @PutMapping("/places/{placeId}")
    public APIDataResponse<Void> modifyPlace(@PathVariable Long placeId, @RequestBody PlaceRequest request) {
        System.out.println(request);
        return APIDataResponse.empty();
    }

    @DeleteMapping("/places/{placeId}")
    public APIDataResponse<Void> removePlace(@PathVariable Long placeId) {
        return APIDataResponse.empty();
    }

}
