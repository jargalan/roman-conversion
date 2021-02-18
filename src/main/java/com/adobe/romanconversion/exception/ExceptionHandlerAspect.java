package com.adobe.romanconversion.exception;

import com.adobe.romanconversion.model.AdobeErrorResponse;
import com.adobe.romanconversion.model.AdobeResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotNull;

import static com.adobe.romanconversion.constant.ErrorCodes.BAD_REQUEST_ILLEGAL_ARGUMENT;
import static com.adobe.romanconversion.constant.ErrorCodes.INTERNAL_SERVER_ERROR;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class ExceptionHandlerAspect {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<AdobeResponse> handleException(final HttpServletRequest request, final Exception exception) {
        log.error("HttpServletRequest: {}, exception: {}", request, getStackTrace(exception));
        return processIllegalArgument(exception);
    }

    @SuppressWarnings("unchecked")
    private ResponseEntity<AdobeResponse> processIllegalArgument(@NotNull final Throwable throwable) {
        if (throwable instanceof ConstraintViolationException) {
            return new ResponseEntity<>(
                    AdobeResponse
                            .builder()
                            .error(AdobeErrorResponse
                                    .builder()
                                    .code(BAD_REQUEST_ILLEGAL_ARGUMENT.value())
                                    .message(throwable.getMessage())
                                    .build())
                            .build(),
                    HttpStatus.BAD_REQUEST
            );
        } else {
            return processInternalServer(throwable);
        }
    }

    private ResponseEntity<AdobeResponse> processInternalServer(@NotNull final Throwable throwable) {
        return new ResponseEntity<>(
                AdobeResponse
                        .builder()
                        .error(AdobeErrorResponse
                                .builder()
                                .code(INTERNAL_SERVER_ERROR.value())
                                .message(throwable.getMessage())
                                .build())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
