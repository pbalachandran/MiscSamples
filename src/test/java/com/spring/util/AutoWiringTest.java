package com.spring.util;

import com.spring.AppConfig;
import com.spring.AutoWiring;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class AutoWiringTest {

    private AutoWiring subject;

    @Before
    public void setUp() throws Exception {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        subject = ctx.getBean(AutoWiring.class);
    }

    @Test
    public void retrieveUserDetail() {
        assertTrue(subject != null);
        assertTrue(subject.retrieveUserDetail().getFirstname().equals("Pradeep"));
    }
}