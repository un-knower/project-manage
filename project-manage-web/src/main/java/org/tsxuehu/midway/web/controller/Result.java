package org.tsxuehu.midway.web.controller;

import lombok.Data;

/**
 * Created by tsxuehu on 16/8/14.
 */
@Data
public class Result {
    boolean success=false;
    String msg;
    Object data;
}
