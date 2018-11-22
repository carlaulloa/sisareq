/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.configtipos;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.unmsm.sistemas.sisareq.service.bo.RolBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SRol;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;

@Controller
public class CUsuario {

    @Autowired
    private SUsuario iUsuarioService;
    @Autowired
    private SRol iRolService;

    @RequestMapping(value = "/admin_config/form_registrar_usuario", method = RequestMethod.POST)
    public String registrarUsuario(RedirectAttributes redirectAttributes,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellidoPat") String apellidoPat,
            @RequestParam("apellidoMat") String apellidoMat,
            @RequestParam("nomUsuario") String nomUsuario,
            @RequestParam("contrasenia") String contrasenia,
            @RequestParam("roles") String rol,
            @RequestParam("supervisores") String supervisor
    ) {

        System.out.println("id rol " + rol);
        Integer idRol = Integer.parseInt(rol);

        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setNomUsuario(nomUsuario);
        usuarioBO.setNombre(nombre);
        usuarioBO.setApellidoPaterno(apellidoPat);
        usuarioBO.setApellidoMaterno(apellidoMat);
        usuarioBO.setEstado(Boolean.TRUE);
        usuarioBO.setClave(contrasenia);

        RolBO rolBO = new RolBO();
        rolBO.setId(idRol);
        usuarioBO.setRol(rolBO);

        if (idRol == 1) {
            UsuarioBO supervisorBO = new UsuarioBO();
            supervisorBO.setId(Integer.parseInt(supervisor));
            usuarioBO.setSupervisor(supervisorBO);
        }

        String salida = iUsuarioService.registrar(usuarioBO);
        System.out.println("id user " + salida);
        if (salida != null) {
            switch (salida) {
                case "duplicado":
                    redirectAttributes.addFlashAttribute("tipoMsg", 2);
                    redirectAttributes.addFlashAttribute("msg", "El usuario " + nomUsuario + " ya existe.");
                    break;
                case "error":
                    redirectAttributes.addFlashAttribute("tipoMsg", 3);
                    redirectAttributes.addFlashAttribute("msg", "Error al registrar usuario. ");
                    break;
                default:
                    redirectAttributes.addFlashAttribute("tipoMsg", 1);
                    redirectAttributes.addFlashAttribute("msg", "El usuario " + nomUsuario + " se registró un nuevo usuario correctamente.");
                    break;
            }
        }

        return "redirect:/admin_config/gestion_usuarios";
    }

    @RequestMapping(value = "/admin_config/form_filtrar_nomuser", method = RequestMethod.POST)
    public String formBuscarByNomUsuario(
            RedirectAttributes redirectAttributes,
            Model model,
            @RequestParam("nomUser") String nombreUser) {
        System.out.println("nom " + nombreUser);
        UsuarioBO usuarioBO = iUsuarioService.getAllDataByNombrePersona(nombreUser);
        if (usuarioBO != null) {
            List<UsuarioBO> lsUsuariosBO = new ArrayList<>();
            lsUsuariosBO.add(usuarioBO);
            System.out.println(lsUsuariosBO.size());

            List<RolBO> lsRoles = iRolService.getAll();
            List<UsuarioBO> lsSupervisores = iUsuarioService.getSupervisores();
            model.addAttribute("lsRoles", lsRoles);
            model.addAttribute("lsSupervisores", lsSupervisores);
            model.addAttribute("lsUsuarios", lsUsuariosBO);

            return "Configuracion/gestionUsuarios";
        }
        redirectAttributes.addFlashAttribute("tipoMsg", 8);
        redirectAttributes.addFlashAttribute("msg", "El usuario " + nombreUser + " no existe.");
        return "redirect:/admin_config/gestion_usuarios";
    }

    @RequestMapping(value = "/admin_config/form_filtrar_rol", method = RequestMethod.POST)
    public String formFiltrarByRol(Model model,
            @RequestParam("rolesFiltro") String rol) {

        if (!rol.equals("todos")) {
            Integer idRol = Integer.parseInt(rol);
            System.out.println(" rol filtro " + idRol);

            List<UsuarioBO> lsUsuariosBO = iUsuarioService.getByRol(idRol);
            List<RolBO> lsRoles = iRolService.getAll();
            List<UsuarioBO> lsSupervisores = iUsuarioService.getSupervisores();
            model.addAttribute("lsRoles", lsRoles);
            model.addAttribute("lsSupervisores", lsSupervisores);
            model.addAttribute("lsUsuarios", lsUsuariosBO);

            return "Configuracion/gestionUsuarios";
        }

        return "redirect:/admin_config/gestion_usuarios";
    }

    @RequestMapping(value = "/admin_config/form_update_usuario", method = RequestMethod.POST)
    public String formUpdateUsuario(RedirectAttributes redirectAttributes,
            @RequestParam("idUsuario") String idUsuario,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellidoPat") String apellidoPat,
            @RequestParam("apellidoMat") String apellidoMat,
            @RequestParam("nomUsuario") String nomUsuario,
            @RequestParam("contrasenia") String contrasenia,
            @RequestParam("selectorRolUpdate") String rol,
            @RequestParam("supervisoresUpdate") String supervisor
    ) {

        System.out.println(idUsuario);
        System.out.println(nombre);
        System.out.println(apellidoMat);
        System.out.println(apellidoPat);
        System.out.println(contrasenia);
        System.out.println(nomUsuario);
        System.out.println(rol);
        System.out.println(supervisor);

        System.out.println("id rol " + rol);
        Integer idRol = Integer.parseInt(rol);
        Integer idUser = Integer.parseInt(idUsuario);

        UsuarioBO usuarioBO = new UsuarioBO();
        usuarioBO.setId(idUser);
        usuarioBO.setNomUsuario(nomUsuario);
        usuarioBO.setNombre(nombre);
        usuarioBO.setApellidoPaterno(apellidoPat);
        usuarioBO.setApellidoMaterno(apellidoMat);
        usuarioBO.setEstado(Boolean.TRUE);
        usuarioBO.setClave(contrasenia);

        RolBO rolBO = new RolBO();
        rolBO.setId(idRol);
        usuarioBO.setRol(rolBO);

        if (idRol == 1) {
            UsuarioBO supervisorBO = new UsuarioBO();
            supervisorBO.setId(Integer.parseInt(supervisor));
            usuarioBO.setSupervisor(supervisorBO);
        }

        String salida = iUsuarioService.updateUsuario(usuarioBO);
        System.out.println("salida " + salida);
        if (salida.equals("ok")) {
            redirectAttributes.addFlashAttribute("tipoMsg", 6);
            redirectAttributes.addFlashAttribute("msg", "El usuario " + nomUsuario + " se actualizó correctamente.");

        } else {
            redirectAttributes.addFlashAttribute("tipoMsg", 7);
            redirectAttributes.addFlashAttribute("msg", "No se pudo actualizar al usuario " + nomUsuario);
        }

        return "redirect:/admin_config/gestion_usuarios";
    }

    @RequestMapping(value = "/admin_config/form_delete_usuario", method = RequestMethod.POST)
    public String formDeleteUsuario(RedirectAttributes redirectAttributes,
            @RequestParam("idUserDelete") String idUser,
            @RequestParam("nomUserDelete") String nomUsuario
    ) {

        String salida = iUsuarioService.deleteUsuario(Integer.parseInt(idUser));
        System.out.println(salida);
        if (salida.equals("ok")) {
            redirectAttributes.addFlashAttribute("tipoMsg", 4);
            redirectAttributes.addFlashAttribute("msg", "El usuario " + nomUsuario + " se eliminó correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("tipoMsg", 5);
            redirectAttributes.addFlashAttribute("msg", "No se pudo elimianr al usuario " + nomUsuario);
        }
        return "redirect:/admin_config/gestion_usuarios";
    }

}
