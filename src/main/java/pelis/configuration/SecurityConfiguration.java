package pelis.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("miUserDetailsService")
	private UserDetailsService miUserDetailsService;

	@Autowired
	private CustomSuccessHandler customSuccessHandler;

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(miUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    //configuramos el acceso a la parte pública
		http.authorizeRequests().antMatchers("/", "/home").permitAll().
		         // todas las URI a partir de /admin/ solo estan autorizadas
				// al rol ADMIN
		         antMatchers("/admin/**").access("hasRole('ADMIN')")
				//Formulario de login y asignación de la clase que controlara la atenticación
				// debemos indicar también que que parametros son el login y la contraseña
				.and().formLogin().loginPage("/login").
				successHandler(customSuccessHandler).usernameParameter("ssoId")
				.passwordParameter("password").
				// activación del control CSRF
				and().csrf()
				.and().exceptionHandling()
				.accessDeniedPage("/Access_Denied");
				

	}
}
