/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.inicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;

/**
 *
 * @author ULLOA
 */
@Controller
public class CLogin {

    @Autowired
    private SUsuario iUsuarioService;

    @RequestMapping(value = "/solicitante")
    public String viewSolicitante(Model model) {
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        model.addAttribute("user", user);
        return "Registro de tickets/viewSolicitante";
    }

    @RequestMapping(value = "/solicitanteAv")
    public String viewSolicitanteAv(Model model) {
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        model.addAttribute("user", user);
        return "Registro de tickets/viewSolicitanteAvanzado";
    }
    
    @RequestMapping(value = "/admin_config")
    public String viewAdministradorConfiguracion(Model model) {
        model.addAttribute("user", getPrincipal());
        return "Configuracion/viewAdministrador";
    }
    
/*
    @RequestMapping(value = "/operador", method = RequestMethod.GET)
    public String viewOperador(Model model) {
        model.addAttribute("user", getPrincipal());
        return "Atencion de req/viewOperador";
    }
*/
    @RequestMapping("/error")
    public String viewError() {
        return "error";
    }
    
    
    /*    
     @RequestMapping(value = "/solicitante**", method = RequestMethod.GET)
     public String verSolicitante(){
     return "solicitante";
     }
     */
    
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
