package org.tsxuehu.pm.domain.application;

import org.gitlab.api.GitlabAPI;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by tsxuehu on 16/7/24.
 */
public class ApplicationTest {
    @Test
    public void createNewBranch() throws Exception {
        SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
        Date date=new Date();
        System.out.print(dateFormater.format(date));
    }

    @Test
    public void createBranch() throws IOException {

    }

}