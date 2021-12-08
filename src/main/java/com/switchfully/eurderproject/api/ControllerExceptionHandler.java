package com.switchfully.eurderproject.api;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    protected void exception(Exception ex, HttpServletResponse response) throws IOException {
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }
}
