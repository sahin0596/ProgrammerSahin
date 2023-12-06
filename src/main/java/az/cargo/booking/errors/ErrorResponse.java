package az.cargo.booking.errors;

import org.springframework.http.HttpStatus;

public interface ErrorResponse {

    String getKey();
    HttpStatus getHttpStatus();

    String getMessage();
}
