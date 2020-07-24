@Configuration
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/")
            .antMatchers("/login")
                .antMatchers("/error").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
