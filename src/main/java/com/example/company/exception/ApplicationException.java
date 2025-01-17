package com.example.company.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApplicationException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final Optional<String> errorMessageOptional;
    private final Optional<Exception> internalExceptionOptional;

    ApplicationException() {
        this.httpStatus = HttpStatus.BAD_REQUEST;
        this.errorMessageOptional = Optional.empty();
        this.internalExceptionOptional = Optional.empty();
    }

    ApplicationException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.errorMessageOptional = Optional.empty();
        this.internalExceptionOptional = Optional.empty();
    }

    public ApplicationException(HttpStatus httpStatus, String errorMessage) {
        this.httpStatus = httpStatus;
        this.errorMessageOptional = Optional.of(errorMessage);
        this.internalExceptionOptional = Optional.empty();
    }

    ApplicationException(HttpStatus httpStatus, String errorMessage, Exception runtimeException) {
        this.httpStatus = httpStatus;
        this.errorMessageOptional = Optional.of(errorMessage);
        this.internalExceptionOptional = Optional.of(runtimeException);
    }
}
