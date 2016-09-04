package org.tsxuehu.midway.web.html;

import lombok.Data;
import org.tsxuehu.midway.web.api.Idable;
import org.tsxuehu.midway.web.service.Configure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tsxuehu on 16/8/28.
 */
@Data
public class Html implements Idable {
    String path;
    String title;
    List<Asserts> assertsList;
    List<InjectData> injectDatas;
    List<String> cssFiles;
    List<String> jsFiles;

    public void calculateStaticResouceLocation(Configure configure) {
        cssFiles = new ArrayList<>();
        jsFiles = new ArrayList<>();
        for (Asserts asserts : assertsList) {
            for (String css : asserts.getCssFiles()) {
                cssFiles.add(generateLocation(configure, asserts.getProject(), asserts.getVerion(),
                        css));
            }
            for (String js : asserts.getJsFiles()) {
                jsFiles.add(generateLocation(configure, asserts.getProject(), asserts.getVerion(),
                        js));
            }
        }

    }

    private String generateLocation(Configure configure,
                                    String project, String version, String file) {
        if ("github".equals(configure.getRepositoryType())) {
            if ("online".equals(configure.getEnv())) {
                return configure.getOnlineRepositoryHost() + project + "/public/" + version + "/dist/" + file;
            } else {
                return configure.getDevRepositoryHost() + project + "/daily/" + version + "/dist/" + file;
            }
        } else if ("gitlab".equals(configure.getRepositoryType())) {
            if ("online".equals(configure.getEnv())) {
                return configure.getOnlineRepositoryHost() + project + "/public/" + version + "/dist/" + file;
            } else {
                return configure.getDevRepositoryHost() + project + "/daily/" + version + "/dist/" + file;
            }
        }
        return null;//todo 异常处理
    }

    @Override
    public String getId() {
        return path;
    }
}
