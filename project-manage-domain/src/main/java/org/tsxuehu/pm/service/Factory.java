package org.tsxuehu.pm.service;

import com.alibaba.fastjson.JSONObject;
import org.tsxuehu.pm.domain.scm.SCM;

/**
 * Created by tsxuehu on 16/8/14.
 */
public interface Factory {
    <T> T create(JSONObject jsonObject);
}
