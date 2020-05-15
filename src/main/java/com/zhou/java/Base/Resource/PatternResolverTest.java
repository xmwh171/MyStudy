package com.zhou.java.Base.Resource;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

/**
 * @Description
 * @Author xiaohu
 * @Date 2019/8/8 16:00
 */
public class PatternResolverTest {

    @Test
    public void getResource() throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:aop/**/*.xml");
        assertNotNull(resources);
        for(Resource resource : resources){
            System.out.println(resource.getDescription());
        }
    }
}
