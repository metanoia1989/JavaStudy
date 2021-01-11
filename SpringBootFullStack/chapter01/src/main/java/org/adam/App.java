package org.adam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        // SpringApplication.run(App.class, args);
        
        // 关闭打印Banner
        SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        builder.bannerMode(Mode.OFF).run(args);
    }
}
