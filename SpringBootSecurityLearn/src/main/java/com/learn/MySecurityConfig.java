package com.learn;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http

				// .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
				.csrf().disable()

				.authorizeRequests().antMatchers("/signin").permitAll().antMatchers("/public/**").hasRole("NORMAL")
				.antMatchers("/users/**").hasRole("ADMIN").anyRequest().authenticated().and().httpBasic().and()
				.formLogin().loginPage("/signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/users/");

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		String pwd = passwordEncoder().encode("usha");
		auth.inMemoryAuthentication().withUser("Ashok").password(pwd).roles("NORMAL");
		auth.inMemoryAuthentication().withUser("Roshini").password(this.passwordEncoder().encode("rani"))
				.roles("ADMIN");
		System.out.println(pwd);
	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//return NoOpPasswordEncoder.getInstance();
//
//}

}
