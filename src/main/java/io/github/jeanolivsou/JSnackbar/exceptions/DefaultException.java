package io.github.jeanolivsou.JSnackbar.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefaultException {
    private Integer status;
    private String message;
    private LocalDateTime dateTime;
}
