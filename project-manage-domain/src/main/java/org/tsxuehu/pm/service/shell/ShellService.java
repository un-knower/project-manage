package org.tsxuehu.pm.service.shell;

import org.tsxuehu.pm.domain.build.Shell;

/**
 * Created by tsxuehu on 16/8/12.
 */
public interface ShellService {
    /**
     * 选择一台编译机器执行shell脚本
     * 如果shell的content内容为空,执行
     * @param shell
     * @param param
     */
    void excuteShell(Shell shell,String param);
}
