package com.teamsoft.spring.error;

import com.teamsoft.spring.constant.ErrorCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class BaseErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView error(HttpServletResponse response) throws Exception {
       HttpStatus status = HttpStatus.valueOf(response.getStatus());
       ErrorCode errorCode = status.is4xxClientError() ? ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;

        Map<String, Object> map = new HashMap<>();
        map.put("statusCode", status.value());
        map.put("errorCode", errorCode);
        map.put("message", errorCode.getMessage(status.getReasonPhrase()));
        return new ModelAndView("error", map, status);
    }
}
