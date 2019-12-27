package com.di.nb;

import com.di.nb.configuration.FileStorageProperties;
import com.di.nb.security.JWTAuthFilter;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@SpringBootApplication
@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
@MapperScan(
        basePackages = {"com.di.nb"},
        annotationClass = Mapper.class
)
@ComponentScan("com.di")


public class NbApplication {

    public static void main(String[] args) {
        SpringApplication.run(NbApplication.class, args);
    }


    @EnableWebSecurity
    @Configuration
    class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthFilter(), UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/user/login").permitAll()
                    //.antMatchers(HttpMethod.POST, "/rest/config/uploadFile").permitAll()
                    //.antMatchers(HttpMethod.DELETE, "/rest/config/delete").permitAll()
                    .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
                    .anyRequest().authenticated();
        }
    }
}
