package com.teamsoft.spring.controller.api;

import com.teamsoft.spring.dto.APIDataResponse;
import com.teamsoft.spring.dto.AdminRequest;
import com.teamsoft.spring.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class APIAuthController {

    private final RestTemplate restTemplate;

    @PostMapping("/sign-up")
    public APIDataResponse<String> signUp(@RequestBody AdminRequest request) throws Exception{
        StopWatch stopWatch = new StopWatch();
        log.info("start!!!");
        stopWatch.start();

        String response = this.restTemplate.getForObject("http://www.daum.net", String.class);
        System.out.println(response);

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        log.info(stopWatch.shortSummary());
        log.info(String.valueOf(stopWatch.getTotalTimeSeconds()) + " Second");
        log.info(String.valueOf(stopWatch.getLastTaskTimeMillis()));

        return APIDataResponse.empty();
    }

    @GetMapping("/login")
    public APIDataResponse<String> login(@RequestBody LoginRequest request) {
        return APIDataResponse.empty();
    }
}
