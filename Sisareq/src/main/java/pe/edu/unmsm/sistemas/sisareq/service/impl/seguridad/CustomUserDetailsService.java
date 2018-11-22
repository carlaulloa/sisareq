package pe.edu.unmsm.sistemas.sisareq.service.impl.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.configuration.security.SecurityUser;
import pe.edu.unmsm.sistemas.sisareq.dao.DUsuario;
import pe.edu.unmsm.sistemas.sisareq.domain.Usuario;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DUsuario iUsuarioDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Usuario usuario = iUsuarioDao.buscarPorNombre(login);

        if (usuario == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        } else {
            String rol = usuario.getRolId().getNombreRol();
            System.out.println(rol);
            switch (rol) {
                case "SOLICITANTE":
                case "SOLICITANTE_AV":
                case "OPERADOR":
                case "ADMINISTRADOR":
                case "ADMIN_ACTIVOS_TI":
                case "GESTOR_PROBLEMAS":
                case "GESTOR_CAMBIOS":
                case "USUARIO_CAB":
                    // el primer true es de si esta activo o no deberia ser un atributo
                    return new SecurityUser(usuario.getNombreUsuario(), usuario.getContrasenia(), true,
                            true, true, true, getGrantedAuthorities(usuario), usuario);
                default:
                    return null;
            }
        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(Usuario user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRolId().getNombreRol()));
        return authorities;
    }

}
