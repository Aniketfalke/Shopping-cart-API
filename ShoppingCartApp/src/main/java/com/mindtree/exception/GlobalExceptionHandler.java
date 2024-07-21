package com.mindtree.exception;


import com.mindtree.dto.ErrorReponse;
import com.mindtree.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({CartItemDoesNotExistException.class})
    public ResponseEntity<ErrorReponse> cartItemDoesNotExistException(CartItemDoesNotExistException e, HttpServletRequest request) {

        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setTimstamp(System.currentTimeMillis());
        errorReponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorReponse.setPath(request.getContextPath());
        errorReponse.setMesssage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorReponse);
    }

    @ExceptionHandler({ProductDoesNotExistException.class})
    public ResponseEntity<ErrorReponse> productDoesNotExistException(ProductDoesNotExistException e, HttpServletRequest request) {

        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setTimstamp(System.currentTimeMillis());
        errorReponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorReponse.setPath(request.getContextPath());
        errorReponse.setMesssage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorReponse);
    }

    @ExceptionHandler({CartNotAssociatedException.class})
    public ResponseEntity<ErrorReponse> cartNotAssociatedException(CartNotAssociatedException e, HttpServletRequest request) {

        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setTimstamp(System.currentTimeMillis());
        errorReponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorReponse.setPath(request.getContextPath());
        errorReponse.setMesssage(e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorReponse);
    }
    @ExceptionHandler({InvalidRequestException.class})
    public ResponseEntity<ErrorReponse> invalidRequestExcpetion(InvalidRequestException e, HttpServletRequest request) {

        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setTimstamp(System.currentTimeMillis());
        errorReponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorReponse.setPath(request.getContextPath());
        errorReponse.setMesssage(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errorReponse);
    }
    @ExceptionHandler({UserNotCreatedException.class})
    public ResponseEntity<ErrorReponse> userNotCreated(UserNotCreatedException e, HttpServletRequest request) {

        ErrorReponse errorReponse = new ErrorReponse();
        errorReponse.setTimstamp(System.currentTimeMillis());
        errorReponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorReponse.setPath(request.getContextPath());
        errorReponse.setMesssage(e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorReponse);
    }
}
