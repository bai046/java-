package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.security.JwtFilter;
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
  private JwtFilter jwtFilter;
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
		.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // token过滤器
		.cors() // 跨域
		.and()
	   // 禁用csrf
		.csrf().disable()
		 // 关闭session
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and() 
		// 权限
		.authorizeRequests()
    .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
    .antMatchers("/admin/**").hasRole("ADMIN")
    .and() 
    // 登录
    .formLogin()
    .loginPage("/forbidden")
    .loginProcessingUrl("/login")
    .successHandler(loginSuccessHandler)
    .failureHandler(loginFailureHandler)
    .and() 
    // 退出
    .logout()
    .logoutUrl("/logout")
    .logoutSuccessHandler(logoutHandler)
    .and()
    // 禁用缓存
    .headers().cacheControl();
	}
	
}
