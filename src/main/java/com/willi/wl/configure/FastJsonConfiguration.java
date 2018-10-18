package com.willi.wl.configure;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: William
 * @Description:
 * @Date: 2018/8/17 14:43
 **/
@Configuration
public class FastJsonConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter fastJsonhttpConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //处理中文乱码问题
        List<MediaType> fastJsonMediaTypes = new ArrayList<>();
        fastJsonMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonhttpConverter.setSupportedMediaTypes(fastJsonMediaTypes);
        fastJsonhttpConverter.setFastJsonConfig(fastJsonConfig);
        converters.add(fastJsonhttpConverter);
    }
}
