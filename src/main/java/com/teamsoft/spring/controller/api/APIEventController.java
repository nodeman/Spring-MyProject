package com.teamsoft.spring.controller.api;

import com.teamsoft.spring.constant.ErrorCode;
import com.teamsoft.spring.constant.EventStatus;
import com.teamsoft.spring.dto.APIDataResponse;
import com.teamsoft.spring.dto.APIErrorResponse;
import com.teamsoft.spring.dto.EventRequest;
import com.teamsoft.spring.dto.EventResponse;
import com.teamsoft.spring.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/api")
@RestController
public class APIEventController {

    @GetMapping("/events")
    public APIDataResponse<List<EventResponse>> getEvents() throws Exception{
        //throw new GeneralException("General Exception 메시지");
        //throw new HttpRequestMethodNotSupportedException("spring 에러 테스트");
        //return List.of("event1", "event2");
        EventResponse response = EventResponse.builder()
                .placeId(1L)
                .eventName("오후 운동")
                .eventStatus(EventStatus.OPENED)
                .eventStartDateTime(LocalDateTime.of(2021, 1, 1, 13, 0))
                .eventEndDateTime(LocalDateTime.of(2021, 1, 1, 16, 0, 0))
                .currentNumberOfPeople(0)
                .capacity(24)
                .memo("즐겁게 하세요")
                .build();

        return APIDataResponse.of(List.of(response));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/events")
    public APIDataResponse<Void> createEvent(@RequestBody EventRequest request) {
        //throw new RuntimeException("Runtime Exception 메시지");
        //return true;
        return APIDataResponse.empty();
    }

    @GetMapping("/events/{eventId}")
    public APIDataResponse<EventResponse> getEvent(@PathVariable Long eventId) {
        if (eventId.equals(2L)) {
           return APIDataResponse.empty();
        }
        EventResponse response = EventResponse.builder()
                .placeId(1L)
                .eventName("오후 운동")
                .eventStatus(EventStatus.OPENED)
                .eventStartDateTime(LocalDateTime.of(2021, 1, 1, 13, 0))
                .eventEndDateTime(LocalDateTime.of(2021, 1, 1, 16, 0, 0))
                .currentNumberOfPeople(0)
                .capacity(24)
                .memo("즐겁게 하세요")
                .build();
        return APIDataResponse.of(response);
    }

    @PutMapping("/events/{eventId}")
    public APIDataResponse<Void> modifyEvent(
            @PathVariable Long eventId,
            @RequestBody EventRequest request) {

        return APIDataResponse.empty();
    }

    @DeleteMapping("/events/{eventId}")
    public APIDataResponse<Void> removeEvent(@PathVariable Long eventId) {
        return APIDataResponse.empty();
    }

}
