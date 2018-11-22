package pe.edu.unmsm.sistemas.sisareq.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"pe.edu.unmsm.sistemas.sisareq.configuration.security"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
    
    @Autowired
    AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    /**
     *
     * @param auth
     * @throws Exception
     */
    /*  @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
     auth.inMemoryAuthentication().withUser("solicitante").password("123").roles("SOLIC");
     auth.inMemoryAuthentication().withUser("jefe").password("132").roles("SOLIC_AV");
     // auth.userDetailsService(userDetailsService);
     }
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/info").permitAll() // corresponde al index y el about quiere decir que cualquier user puede acceder aqui
                .antMatchers("/solicitante/**").access("hasRole('ROLE_SOLICITANTE')") // expresion asociada el rol de solicitante
                .antMatchers("/solicitanteAv/**").access("hasRole('ROLE_SOLICITANTE_AV')")
                .antMatchers("/operador/**").access("hasRole('ROLE_OPERADOR')")
                .antMatchers("/admin_config/**").access("hasRole('ROLE_ADMINISTRADOR')")
                .antMatchers("/admin_ti/**").access("hasRole('ROLE_ADMIN_ACTIVOS_TI')")
                .antMatchers("/gestor_problemas/**").access("hasRole('ROLE_GESTOR_PROBLEMAS')")
                .antMatchers("/gestor_cambios/**").access("hasRole('ROLE_GESTOR_CAMBIOS')")
                .antMatchers("/usuario_cab/**").access("hasRole('ROLE_USUARIO_CAB')")
                .and().formLogin().loginPage("/login")// url de logueo
                .successHandler(customSuccessHandler) // sirve para redireccionar
                .usernameParameter("user") // nombre del input que corresponde al usuario
                .passwordParameter("pasw") // nombre del input de contraseña
                // .loginProcessingUrl("/iniciarSesion") // action del form del login
                .failureHandler(authenticationFailureHandler)
                
              //  .failureUrl("/login?auth=fail") // pagina de error 
                .and()
                .logout().logoutSuccessUrl("/")
                .and().csrf() // aun no se que es
              //  .and().exceptionHandling().accessDeniedPage("/error") //url de deslogueo ->eso se mostrara
                ;
        
         http.csrf().disable(); // ajax
    }
}
