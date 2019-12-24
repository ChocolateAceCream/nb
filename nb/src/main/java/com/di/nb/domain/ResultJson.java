package com.di.nb.domain;

import lombok.Data;

@Data
public class ResultJson {
    private int status;
    private String msg;
    private Object result;

}
