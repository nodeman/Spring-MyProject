package com.teamsoft.spring.error;

import com.teamsoft.spring.constant.ErrorCode;
import com.teamsoft.spring.dto.APIErrorResponse;
import com.teamsoft.spring.exception.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice //전체 컨트롤러 뷰에 대한 동작 감시
public class BaseExceptionHandler {

    @ExceptionHandler
    public ModelAndView general(GeneralException e) {   //GeneralException 처리
        System.out.println("GeneralException !!!");
        ErrorCode errorCode = e.getErrorCode();
        HttpStatus status = errorCode.isClientSideError() ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR;

        Map<String, Object> map = new HashMap<>();
        map.put("statusCode", status.value());
        map.put("errorCode", errorCode);
        map.put("message", errorCode.getMessage(e));
        return new ModelAndView("error", map, status);
    }

    @ExceptionHandler
    public ModelAndView general(Exception e) {          //GeneralException 외에 Exception 처리
        System.out.println("BaseExceptionHandler !!!");
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR; //예상치못한 일반적인 에러이니
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        Map<String, Object> map = new HashMap<>();
        map.put("statusCode", status.value());
        map.put("errorCode", errorCode);
        map.put("message", errorCode.getMessage(e));
        return new ModelAndView("error", map, status);
    }
}
