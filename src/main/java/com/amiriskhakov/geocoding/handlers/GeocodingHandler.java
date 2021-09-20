package com.amiriskhakov.geocoding.handlers;

import com.amiriskhakov.geocoding.exceptions.WrongAddressException;
import com.amiriskhakov.geocoding.exceptions.WrongCoordinatesException;
import com.amiriskhakov.geocoding.payload.response.ErrorMessageResponse;
import org.hibernate.criterion.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeocodingHandler {

    @ExceptionHandler(WrongCoordinatesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageResponse coordinatesException(){
        return new ErrorMessageResponse("wrong coordinates(must be two coordinates)");
    }

    @ExceptionHandler(WrongAddressException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageResponse addressException(){
        return new ErrorMessageResponse("wrong address(must be city or street)");
    }
}
