package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.security.LoginFailureHandler;
import com.example.security.LoginSuccessHandler;
import com.example.security.LogoutHandler;
import com.example.util.PasswordUtils;

/**
 * 安全配置
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Value("${myapp.user.password.secret}")
	private String secret;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
  private LoginSuccessHandler loginSuccessHandler;
  @Autowired
  private LoginFailureHandler loginFailureHandler;
  @Autowired
  private LogoutHandler logoutHandler;
  
	/**
	 * 用户认证
	 * @param auth
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(PasswordUtils.getPasswordEncoder(this.secret));
	}
	
	/**
	 * 资源授权
	 * @param http
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors()
		.and()
		//.csrf().disable()
		.authorizeRequests()
    .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
    .antMatchers("/admin/**").hasRole("ADMIN")
    .and() // 登录
    .formLogin()
    .loginPage("/forbidden")
    .loginProcessingUrl("/login")
    .successHandler(loginSuccessHandler)
    .failureHandler(loginFailureHandler)
    .and() // 开启记住我
    .rememberMe()
    .tokenValiditySeconds(86400).key("remember-me-cookie")
    .and() // 退出
    .logout()
    .logoutUrl("/logout")
    .logoutSuccessHandler(logoutHandler)
    .deleteCookies("JSESSIONID", "remember-me");
	}
	
}
