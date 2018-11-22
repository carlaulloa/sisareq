/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.configuration.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

/**
 *
 * @author ULLOA
 */
@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    protected void handle(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {

            System.out.println("Can't redirect");
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        String url = "";

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<String>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
            System.out.println(a.getAuthority());
        }

        if (isSolicitante(roles)) {
            System.out.println("entra ");
            url = "/solicitante";
        } else if (isSolicitanteAv(roles)) {
            url = "/solicitanteAv";
        } else if (isOperador(roles)) {
            url = "/operador";
        } else if (isAdministrador(roles)) {
            url = "/admin_config";
        }else if (isAdminActivosTI(roles)) {
            url = "/admin_ti";
        }else if (isGestorProblemas(roles)) {
            url = "/gestor_problemas";
        }else if (isGestorCambios(roles)) {
            url = "/gestor_cambios";
        }else if (isUsuarioCAB(roles)) {
            url = "/usuario_cab";
        } else {            
            url = "/error";
        }

        return url;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    @Override
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    private boolean isSolicitante(List<String> roles) {
        if (roles.contains("ROLE_SOLICITANTE")) {
            return true;
        }
        return false;
    }

    private boolean isSolicitanteAv(List<String> roles) {
        if (roles.contains("ROLE_SOLICITANTE_AV")) {
            return true;
        }
        return false;
    }

    private boolean isOperador(List<String> roles) {
        if (roles.contains("ROLE_OPERADOR")) {
            return true;
        }
        return false;
    }
    
    private boolean isAdministrador(List<String> roles) {
        if (roles.contains("ROLE_ADMINISTRADOR")) {
            return true;
        }
        return false;
    }
    
    private boolean isAdminActivosTI(List<String> roles) {
        if (roles.contains("ROLE_ADMIN_ACTIVOS_TI")) {
            return true;
        }
        return false;
    }
    
    private boolean isGestorProblemas(List<String> roles) {
        if (roles.contains("ROLE_GESTOR_PROBLEMAS")) {
            return true;
        }
        return false;
    }
    
    private boolean isGestorCambios(List<String> roles) {
        if (roles.contains("ROLE_GESTOR_CAMBIOS")) {
            return true;
        }
        return false;
    }
    
    private boolean isUsuarioCAB(List<String> roles) {
        if (roles.contains("ROLE_USUARIO_CAB")) {
            return true;
        }
        return false;
    }

}
