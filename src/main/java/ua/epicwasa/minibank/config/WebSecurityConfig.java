package ua.epicwasa.minibank.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import ua.epicwasa.minibank.data.entity.User;
import ua.epicwasa.minibank.data.repo.UserRepo;

@EnableWebSecurity
@EnableOAuth2Sso
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/","/login**", "/error**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and().logout() .logoutSuccessUrl("/").permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepo userRepo){
        return map -> {
            String id = (String)map.get("sub");
            User user = userRepo.findById(id);
            if(user==null){
                 user = new User();

                user.setId(id);
                user.setName((String) map.get("name"));
                user.setEmail((String) map.get("email"));
            }

            return userRepo.save(user);
        };
    }
}
