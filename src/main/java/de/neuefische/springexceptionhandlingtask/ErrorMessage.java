package de.neuefische.springexceptionhandlingtask;

import org.springframework.http.HttpStatus;

public record ErrorMessage(
        String errorMsg,
        HttpStatus errorCode
) {
}
