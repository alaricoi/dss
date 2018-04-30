/**
 * Práctica de Desarrollo de software Seguro
 */
package pelis.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
/**
 * Clase para redireccionar la entrada a usuarios logados
 * @author Isma
 *
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	/**
	 * propiedad para gestionar el log de la aplicación
	 */
	private static final Log LOGGER = LogFactory.getLog(CustomSuccessHandler.class);

	/**
	 * propiedad para gestionar la estrategia de redirección
	 */
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	/**
	 * Metodo heredado que se encarga de la gestión de la redirección
	 */
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication);

		if (response.isCommitted()) {
			LOGGER.error("Can't redirect");
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
/**
 *  
 * @param authentication objeto que nos proporciona el objeto con los datos
 * de la autenticación
 * @return dirección a la que correspodera ir dependiendo del rol de usuario
 */
	protected String determineTargetUrl(Authentication authentication) {
		String url = "";

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

		List<String> roles = new ArrayList<String>();

		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}

		if (isAdmin(roles)) {
			url = "/admin";
		} else if (isUser(roles)) {
			url = "/";
		} else {
			url = "/accessDenied";
		}

		return url;
	}

	@Override
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	@Override
	/**
	 * 
	 */
	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
/**
 * 
 * @param roles
 * @return
 */
	private boolean isUser(List<String> roles) {
		return (roles.contains("ROLE_USER"));

	}
/**
 * 
 * @param roles
 * @return
 */
	private boolean isAdmin(List<String> roles) {
		return (roles.contains("ROLE_ADMIN"));
	}

}
