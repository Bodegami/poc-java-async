package br.com.bode.springasync.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import java.lang.reflect.Method;

@Configuration
public class ConfigurationAsync extends AsyncConfigurerSupport {


    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new AsyncUncaughtExceptionHandler() {

            @Override
            public void handleUncaughtException(Throwable ex, Method method, Object... params) {
                System.out.println("Error: " + ex.getMessage());
                System.out.println("Method: " + method.getName());

            }
        };

    }
}
