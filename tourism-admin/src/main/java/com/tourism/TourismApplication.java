package com.tourism;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author tourism
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class TourismApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TourismApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
