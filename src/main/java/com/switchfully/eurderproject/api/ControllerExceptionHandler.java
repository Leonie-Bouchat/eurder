package com.switchfully.eurderproject.api;

import com.switchfully.eurderproject.exceptions.AlreadyExistsException;
import com.switchfully.eurderproject.exceptions.ListOfUsersIsEmptyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class ControllerExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler({IllegalArgumentException.class, AlreadyExistsException.class})
    protected void badRequestException(Exception ex, HttpServletResponse response) throws IOException {
        logger.error(ex.getMessage(), ex);
        response.sendError(BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(ListOfUsersIsEmptyException.class)
    protected void notFoundException(Exception ex, HttpServletResponse response) throws IOException {
        logger.error(ex.getMessage(), ex);
        response.sendError(NOT_FOUND.value(), ex.getMessage());
    }
}
