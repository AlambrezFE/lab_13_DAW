package com.example.sprinjsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.sprinjsp.servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SeguridadConfiguracion {
    @Autowired
    private UsuarioServicio userDet;

    @Autowired
    private BCryptPasswordEncoder bycryp;

    @Bean
    public BCryptPasswordEncoder passEncoder(){
        BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
        return bcpe;
    }

    @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            (authz) -> authz
            .requestMatchers("/", "/listarEmpleados").permitAll()
            .requestMatchers("/", "/listarTareas").permitAll()
            
            .requestMatchers("/agregarEmpleado").hasRole("ADMIN")
            .requestMatchers("/mostrarEmpleado").hasRole("ADMIN")
            .requestMatchers("/guardarEmpleado").hasRole("ADMIN")
            .requestMatchers("/editarEmpleado").hasRole("ADMIN")

            .requestMatchers("/agregarTarea").hasRole("ADMIN")
            .requestMatchers("/mostrarTarea").hasRole("ADMIN")
            .requestMatchers("/guardarTarea").hasRole("ADMIN")
            .requestMatchers("/editarTarea").hasRole("ADMIN")
            .requestMatchers("/eliminarTarea/*").hasRole("ADMIN")
            .anyRequest().authenticated())
            
            .formLogin((form) -> 
                form.loginPage("/login") 
                    .permitAll())
            .logout((logout) -> logout.permitAll()
            );
            
        return http.build();
    }

    protected void  configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDet).passwordEncoder(bycryp);
    }
}
