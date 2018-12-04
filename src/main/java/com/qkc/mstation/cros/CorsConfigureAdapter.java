package com.qkc.mstation.cros;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by gzx on 2017/10/28.
 */
@Configuration
@EnableWebMvc
public class CorsConfigureAdapter extends WebMvcConfigurerAdapter {

    /**
     * 跨域支持
     * @param registry
     */
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**");
    }

}
