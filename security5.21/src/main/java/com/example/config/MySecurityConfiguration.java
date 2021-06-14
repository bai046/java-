package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Value("${myapp.user.password.secret}")
	private String secret;
	@Autowired
	private UserDetailsService UserDetailsService;

	/**
	 * 用户认证
	 * @param auth
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder encoder = new Pbkdf2PasswordEncoder(this.secret);
		auth.userDetailsService(UserDetailsService).passwordEncoder(encoder);
	}
	
	/**
	 * 资源授权
	 * @param http
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
   http
    .authorizeRequests() // 访问请求指定权限
//    .antMatchers("/user/**").hasRole("USER")
    .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
    .antMatchers("/admin/**").hasRole("ADMIN")
    .and() // 设置登录页和默认的跳转路径
    .formLogin()
    .loginPage("/login").defaultSuccessUrl("/user/welcome").failureUrl("/failure")
    .and() // 开启记住我的功能
    .rememberMe()
    .tokenValiditySeconds(86400).key("remember-me-cookie")
    .and() // 登出页面和默认跳转路径
    .logout()
    .logoutUrl("/logout").logoutSuccessUrl("/login");
	}
	
}
