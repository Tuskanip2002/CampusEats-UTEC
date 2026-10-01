package security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    jakarta.servlet.Filter jwtFilter;
    return http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(
                    manager -> manager.sessionCreationPolicy(STATELESS)
            )
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
            )
            .authenticationProvider(authenticationProvider())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
}

private AuthenticationProvider authenticationProvider() {
}