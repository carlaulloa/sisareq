package pe.edu.unmsm.sistemas.sisareq.configuration.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextFacade {
 	
    public static SecurityUser getAuthenticatedUser() {
         
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
         
        if (user instanceof SecurityUser) {
            return ((SecurityUser)user);
        
        } else {
            return null;
        }
    }  
     
    public static boolean hasAuthenticatedUserRole(AllowedAuthorities role) {
         
        for (GrantedAuthority authority : getAuthenticatedUser().getAuthorities()) {
            if (authority.getAuthority().equals(role.toString())) {
                return true;
            }
        }
        return false;
    }
}



