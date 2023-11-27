package az.cargo.booking.errors;

import org.springframework.http.HttpStatus;

public enum Errors implements ErrorResponse {

    jakarta_NOT_NULL("jakart.validation.constrains.NotNull.message",
            HttpStatus.BAD_REQUEST,"Dəyər boş ola bilməz"),
    BOOKING_NOT_FOUND("BOOKING_NOT_FOUND" , HttpStatus.NO_CONTENT,"Olmayan bookingi axtarirsan,bele booking movcud deyil"),
    USER_NOT_FOUND("USER_NOT_FOUND", HttpStatus.NO_CONTENT, "User Not Found"),

    HOTEL_NOT_FOUND("HOTEL_NOT_FOUND", HttpStatus.NO_CONTENT, "Hotel Not Found"),

    PAYMENT_NOT_FOUND("PAYMENT_NOT_FOUND", HttpStatus.NO_CONTENT, "Payment Not Found"),

    FLIGHT_NOT_FOUND("FLIGHT_NOT_FOUND", HttpStatus.NO_CONTENT, "Flight Not Found"),

    CAR_NOT_FOUND("CAR_NOT_FOUND", HttpStatus.NO_CONTENT, "Car Not Found");

    HttpStatus httpStatus;
    String key;

    String message;

    Errors(String key,HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.key= key;
        this.message = message;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
