package com.hexu.ebank.gate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            //super.configure(http);
            //配置不需要登陆验证
            http.csrf().disable();//允许跨域
            http.authorizeRequests().anyRequest().permitAll().and().logout().permitAll();
        }

//
//  @Autowired
//  private UserDetailsServiceImpl detailsService;
//
//  @Autowired
//  private CorsFilter corsFilter;
//
//  @Override
//  public void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(detailsService) /*.passwordEncoder(new BCryptPasswordEncoder())*/;
//  }
//
//  @Override
//  @Bean
//  public AuthenticationManager authenticationManagerBean() throws Exception {
//    return super.authenticationManagerBean();
//  }
//
//  /**
//   * 忽略静态文件
//   */
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    web.ignoring().antMatchers("/js/**", "/img/**", "/css/**", "/images/**","fav.ico");
//  }
//
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    //解决Refused to display 'http://......' in a frame because it set 'X-Frame-Options' to 'DENY'. "错误
//    http.headers().frameOptions().disable();
//
//    http.authorizeRequests().antMatchers("/","/ebank-user/v1/tUser/register").permitAll()
//            .antMatchers("/**/session/**").authenticated()//登录即可获取session信息
//            // 其他地址的访问均需验证权限（需要登录，且有指定的权限）
//            .anyRequest().access("@permissionService.hasPermission(request,authentication)").and()
//            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
//            .addFilterAt(codeUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class).exceptionHandling()
//            .authenticationEntryPoint((request, response, authException) -> {
//              String result = JSON.toJSONString(JsonUtil.getResultJson(ResultCodeEnum.NOLOGIN));
//              HttpHelper.setResponseJsonData(response,result);
//            }).and()
//            .addFilterBefore(corsFilter, LogoutFilter.class)
//            .formLogin().loginProcessingUrl("/login").permitAll().and()
//            .logout().logoutSuccessHandler(logoutSuccessHandler()).permitAll();
//    http.csrf().disable();
//  }
//
//
//  @Bean
//  public CodeUsernamePasswordAuthenticationFilter codeUsernamePasswordAuthenticationFilter() throws Exception {
//    CodeUsernamePasswordAuthenticationFilter codeUsernamePasswordAuthenticationFilter = new CodeUsernamePasswordAuthenticationFilter();
//    codeUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManagerBean());
//    codeUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
//    codeUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
//    return codeUsernamePasswordAuthenticationFilter;
//  }
//
//  @Bean
//  public AuthenticationSuccessHandler authenticationSuccessHandler() {
//    return new CustomAuthenticationSuccessHandler();
//  }
//
//  @Bean
//  public AuthenticationFailureHandler authenticationFailureHandler() {
//    return new CustomAuthenticationFailureHandler();
//  }
//
//  @Bean
//  public LogoutSuccessHandler logoutSuccessHandler() {
//    return new CustomLogoutSuccessHandler();
//  }

}
