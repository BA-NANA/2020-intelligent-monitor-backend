package com.tjut.monitor;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//打包war后增加的war包启动类
public class WarStarterMonitorApplication extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        //指向Application的SpringBoot启动类
        return builder.sources(MonitorApplication.class);
    }
}
