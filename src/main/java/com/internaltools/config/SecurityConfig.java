package com.internaltools.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.internaltools.security.JwtAuthenticationEntryPoint;
import com.internaltools.security.JwtAuthenticationFilter;
import com.internaltools.service.impl.CustomUserDetailsServiceImpl;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    
    @Autowired
    CustomUserDetailsServiceImpl customUserDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests().antMatchers("/api/client/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/company/**").permitAll()
.and().authorizeRequests().antMatchers("/api/companies/***").permitAll()
.and().authorizeRequests().antMatchers("/api/clients/***").permitAll()
                .and().authorizeRequests().antMatchers("/api/bank/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/address/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/billaddress/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/invoice/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/company/getByCompanyId/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/company/**").permitAll()

                .and().authorizeRequests().antMatchers("/api/country/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/tax/**").permitAll()
                .and().authorizeRequests().antMatchers("/api/tax/getByTaxId/**").permitAll()

                .and().authorizeRequests().antMatchers("/api/company/**").permitAll()

//			.antMatchers(
//					"/api/s3service/uploadFile"
//					,"/api/s3service/uploadProfileImage"
//					,"/api/website/contactUs"
//					,"/api/user/getCountry"
//					,"/api/user/getCountryInfo/**"
//                    ,"/api/user/activateUser"
//                    ,"/api/user/activateAccountant"
//                    ,"/api/account/getAccountMaster"
//                    ,"/api/account/getAccountTransactionByGroupType/**"
//                    ,"/api/user/getCurrency"
//			 ).permitAll()
			.antMatchers(HttpMethod.GET, "/api/s3service/**").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "https://dockket.com/").permitAll()
			.antMatchers(HttpMethod.OPTIONS, "https://test.dockket.com/").permitAll()
			.anyRequest().authenticated();
				
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                                   "/configuration/ui",
                                   "/swagger-resources/**",
                                   "/configuration/security",
                                   "/swagger-ui.html",
                                   "/webjars/**");
    }
    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
    	CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("http://127.0.0.1:5500","https://prodapi.dockket.com","https://testapi.dockket.com", 
//        		"https://dockket.com","*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", 
        		"Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
   
}