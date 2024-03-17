package com.ssg.productmanagement.config.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
    /*
    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptionNumber(NumberFormatException numberFormatException) {
        log.info("=================================");
        log.error(numberFormatException.getMessage());
        return "NUMBER FORMAT EXCEPTION";
    }
    */

    // 배포할 때는 responseBody 로 출력하는게 부담되기 때문에 error page 를 따로 걷어낸다.
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptionCommon(Exception exception) {
        log.info("=================================");
        log.error(exception.getMessage());
        StringBuffer stringBuffer = new StringBuffer("<ul>");
        stringBuffer.append("<li>" + exception.getMessage() + "</li>");
        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
           stringBuffer.append("<li>" + stackTraceElement + "</li>");
        });
        stringBuffer.append("</ul>");

        return stringBuffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
}
