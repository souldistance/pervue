package com.songyinglong.pervue.config;/**
 * @author SongYinglong
 * @date 2020/2/26- 2020/2/26
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Souldistance
 * 2020/2/26
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 静态资源访问配置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:D:\\pic\\");
    }

    /**
     *  配置跨域访问  代替 controller中 CrossOrigin 注解
     *  allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如："http://www.baidu.com"，只有百度可以访问我们的跨域资源。
     * addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。
     * allowedMethods：允许输入参数的请求方法访问该跨域资源服务器，如：POST、GET、PUT、OPTIONS、DELETE等。
     * allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
     * allowCredentials： 响应头表示是否可以将对请求的响应暴露给页面。返回true则可以，其他值均不可以。
     * Maxage 预响应的高速缓存持续时间的最大时间（以秒为单位）。 值在标题Access-Control-Max-Age中设置。
     * – 如果未定义, 最大时间设置为1800秒（30分钟）
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*")
                .maxAge(3600);
    }
    /*private CorsConfiguration addcorsConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        List<String> list = new ArrayList<>();
        list.add("*");
        corsConfiguration.setAllowedOrigins(list);
    *//*
    // 请求常用的三种配置，*代表允许所有，当时你也可以自定义属性（比如header只能带什么，只能是post方式等等）
    *//*
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", addcorsConfig());
        return new CorsFilter(source);
    }*/
}
