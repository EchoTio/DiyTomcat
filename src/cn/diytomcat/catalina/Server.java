package cn.diytomcat.catalina;

import cn.diytomcat.http.Request;
import cn.diytomcat.http.Response;
import cn.diytomcat.util.Constant;
import cn.diytomcat.util.ThreadPoolUtil;
import cn.diytomcat.util.WebXMLUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.LogFactory;
import cn.hutool.system.SystemUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Server {
    private Service service;
    public Server(){
        this.service = new Service(this);
    }

    public void start(){
        TimeInterval timeInterval = DateUtil.timer();
        logJVM();
        init();
        LogFactory.get().info("Server startup in {} ms",timeInterval.intervalMs());
    }

    private void init(){
        service.start();
    }


    private static void logJVM(){
        Map<String,String> infos = new LinkedHashMap<>();
        infos.put("Server version","DiyTomcat/1.0.1");
        infos.put("Server built","2020-12-15 10:44:47");
        infos.put("Server number","1.0.1");
        infos.put("OS Name\t", SystemUtil.get("os.name"));
        infos.put("OS Version",SystemUtil.get("os.version"));
        infos.put("Architecture",SystemUtil.get("os.arch"));
        infos.put("Java Home",SystemUtil.get("java.home"));
        infos.put("JVM Version",SystemUtil.get("java.runtime.version"));
        infos.put("JVM Vendor",SystemUtil.get("java.vm.specification.vendor"));

        Set<String> keys = infos.keySet();
        for (String key : keys) {
            LogFactory.get().info(key+":\t\t"+infos.get(key));
        }
    }
}
