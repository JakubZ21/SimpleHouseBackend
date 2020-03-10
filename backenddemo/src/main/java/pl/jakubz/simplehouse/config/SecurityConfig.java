

package pl.jakubz.simplehouse.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("securityDataSource")
    private DataSource securityDataSource;

    public SecurityConfig() {
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(this.securityDataSource);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                        .antMatchers(new String[]{"/meals/delete**"})
                .hasRole("ADMIN").antMatchers(new String[]{"/seeMessages"})
                .hasAnyRole(new String[]{"ADMIN", "MANAGER"})
                .antMatchers(new String[]{"/meals/*"}).hasRole("MANAGER")
                .antMatchers(new String[]{"/*"})
                .permitAll().and()
                .formLogin().loginPage("/loginForm")
                .loginProcessingUrl("/processLogin")
                .permitAll().and().logout().permitAll()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/").and()
                .exceptionHandling()
                .accessDeniedPage("/denied");
    }
}
