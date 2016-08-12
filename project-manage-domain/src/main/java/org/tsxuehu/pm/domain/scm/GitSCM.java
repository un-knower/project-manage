package org.tsxuehu.pm.domain.scm;

import org.gitlab.api.GitlabAPI;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by tsxuehu on 16/7/23.
 */
public class GitSCM implements SCM {

    public GitSCM(Long id,String name,String privateToken, String host){
        this.privateToken = privateToken;
        this.host = host;
        this.id = id;
        this.name = name;
    }

    long id;
    String name;
    String privateToken;
    String host;

    @Override
    public String createNewBranch(String projectId, String newBranchName, String fromBranch) throws IOException {
        long now = System.currentTimeMillis();
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy_MM_dd_HHmmss_SSS");
        Date date = new Date();
        String actualBranchName = newBranchName + "_" + dateFormater.format(date);
        GitlabAPI gitlabAPI = GitlabAPI.connect(host, privateToken);
        gitlabAPI.createBranch(projectId, actualBranchName, fromBranch);
        return actualBranchName;
    }
}
