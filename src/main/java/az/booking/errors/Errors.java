package az.booking.errors;

import org.springframework.http.HttpStatus;

public enum Errors implements ErrorResponse {

    jakarta_NOT_NULL("jakarta.validation.constraints.NotNull.message", HttpStatus.BAD_REQUEST,
            "The value can't be empty"),

    BOOKING_NOT_FOUND("BOOKING_NOT_FOUND", HttpStatus.NO_CONTENT, "Booking Not Found"),

    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NO_CONTENT, "User Not Found"),

    HOTEL_NOT_FOUND("HOTEL_NOT_FOUND", HttpStatus.NO_CONTENT, "Hotel Not Found"),

    PAYMENT_NOT_FOUND("PAYMENT_NOT_FOUND", HttpStatus.NO_CONTENT, "Payment Not Found"),

    FLIGHT_NOT_FOUND("FLIGHT_NOT_FOUND", HttpStatus.NO_CONTENT, "Flight Not Found"),

    CAR_NOT_FOUND("CAR_NOT_FOUND", HttpStatus.NO_CONTENT, "Car Not Found");


    final String key;

    final HttpStatus httpStatus;

    final String message;

    Errors(String key, HttpStatus httpStatus, String message) {
        this.message = message;
        this.key = key;
        this.httpStatus = httpStatus;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return null;
    }
    }


