package com.teamsoft.spring.controller;

import com.teamsoft.spring.constant.EventStatus;
import com.teamsoft.spring.constant.PlaceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @GetMapping("/places")
    //public String adminPlaces(@RequestParam PlaceType placeType) {  //@RequestParam적으면 required=true기본, 적지않으면 required=false
    public ModelAndView adminPlaces(PlaceType placeType,  //PlaceType.COMMON.name() -> Jackson이 이 이름을 토대로 직렬화 비직렬화 시도
                              String placeName,
                              String address) {

        System.out.println(PlaceType.COMMON.name());
        System.out.println(placeType + " " + placeName + " " + address);

        Map<String, Object> map = new HashMap<>();
        map.put("placeType", placeType);
        map.put("placeName", placeName);
        map.put("address", address);
        return new ModelAndView("admin/places", map);
    }

    @GetMapping("/places/{placeId}")
    public String adminPlaceDetail(@PathVariable Long placeId) {
        System.out.println(placeId);
        Map<String, Object> map = new HashMap<>();

        return "admin/place-detail";
    }

    @GetMapping("/events")
    public ModelAndView adminEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime) {
        Map<String, Object> map = new HashMap<>();
        map.put("placeName", "place-" + placeId);
        map.put("eventName", eventName);
        map.put("eventStatus", eventStatus);
        map.put("eventStartDatetime", eventStartDatetime);
        map.put("eventEndDatetime", eventEndDatetime);
        return new ModelAndView("admin/events", map);
    }

    @GetMapping("/events/{eventId}")
    public String adminEventDetail(@PathVariable Long eventId) {
        System.out.println(eventId);
        return "admin/event-detail";
    }
}
