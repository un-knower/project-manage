package org.tsxuehu.pm.domain.scm;

import com.alibaba.fastjson.JSON;
import org.gitlab.api.GitlabAPI;
import org.gitlab.api.Pagination;
import org.gitlab.api.models.GitlabCommit;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by tsxuehu on 16/8/18.
 */
public class GitlabSCMTest {
    @Test
    public void gitlab() throws Exception {
        GitlabAPI gitlabAPI = GitlabAPI.connect("http://gitlab.qima-inc.com/", "2iAZn7fTUjKV9xsiS4KR");
        Pagination pagination =new Pagination();
        pagination.setPage(1);
        pagination.setPerPage(5);
    //    List<GitlabCommit> result = gitlabAPI.getAllCommits("bower/ZenUI",pagination,"master");
        List<GitlabCommit> result =  gitlabAPI.getLastCommits("bower/ZenUI","master");
        System.out.println(JSON.toJSON(result));

    }
}