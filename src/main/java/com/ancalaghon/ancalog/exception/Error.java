package com.ancalaghon.ancalog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Error {

    private Integer status;
    private LocalDateTime timeStamp;
    private String title;
    private List<Fields> field;

    @AllArgsConstructor
    @Getter
    public static class Fields {
        private String name;
        private String message;
    }


}
