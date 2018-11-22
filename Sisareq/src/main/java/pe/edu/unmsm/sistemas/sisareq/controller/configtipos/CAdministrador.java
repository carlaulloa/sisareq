/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.configtipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import pe.edu.unmsm.sistemas.sisareq.service.bo.RolBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SRol;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SSLA;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SServicio;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;

@Controller
public class CAdministrador {

    @Autowired
    private SUsuario iUsuarioService;
    @Autowired
    private SRol iRolService;
    @Autowired
    private SServicio iServicioService;
    @Autowired
    private SSLA ISLAService;

    @RequestMapping(value = "/admin_config/gestion_usuarios")
    public String viewRegistrarUsuario(Model model, RedirectAttributes redirectAttributes) {

        List<RolBO> lsRoles = iRolService.getAll();
        List<UsuarioBO> lsSupervisores = iUsuarioService.getSupervisores();
        model.addAttribute("lsRoles", lsRoles);
        model.addAttribute("lsSupervisores", lsSupervisores);

        if (redirectAttributes.containsAttribute("tipoFiltro")) {
            Integer filtro = (Integer) redirectAttributes.getFlashAttributes().get("tipoFiltro");
            switch (filtro) {
                case 1:
                    model.addAttribute("lsUsuarios", redirectAttributes.getFlashAttributes().get("lsUsuarios"));
                    break;
                case 2:
                    model.addAttribute("lsUsuarios", redirectAttributes.getFlashAttributes().get("lsUsuarios"));
                    break;
            }

        } else {
            List<UsuarioBO> lsUsuarios = iUsuarioService.getAllActivos();
            model.addAttribute("lsUsuarios", lsUsuarios);
        }

        if (redirectAttributes.containsAttribute("msg")) {
            model.addAttribute("tipoMsg", redirectAttributes.getFlashAttributes().get("tipoMsg"));
            model.addAttribute("msg", redirectAttributes.getFlashAttributes().get("msg"));
        }

        return "Configuracion/gestionUsuarios";
    }

    @RequestMapping(value = "/admin_config/gestion_servicios")
    public String viewGestionServicios(HttpServletRequest request,
            Model model) {
        List<SlaBO> lsSlasBO = ISLAService.getAll();
        List<ServicioBO> lsServiciosFiltroBO = iServicioService.getByNivelUno();
        List<ServicioBO> lsServiciosNivel2De1 = iServicioService.getByPadre(lsServiciosFiltroBO.get(0).getId());

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap == null) {
            List<ServicioBO> lsServiciosTablaBO = iServicioService.getByPadre(lsServiciosFiltroBO.get(0).getId());
            model.addAttribute("tituloTabla", "Subservicios de " + lsServiciosFiltroBO.get(0).getNombre());
            model.addAttribute("lsServiciosTabla", lsServiciosTablaBO);
        } else {
            List<ServicioBO> lsFiltrado = (List<ServicioBO>) inputFlashMap.get("lsServic");
            if (inputFlashMap.containsKey("filtro")) {
                String filtro = (String) inputFlashMap.get("filtro");
                if (lsFiltrado != null) {
                    if (lsFiltrado.isEmpty()) {
                        model.addAttribute("tituloTabla", filtro + " no tiene subservicios");
                    } else {
                        model.addAttribute("tituloTabla", "Subservicios de " + filtro);
                    }
                    model.addAttribute("lsServiciosTabla", lsFiltrado);
                } else {
                    List<ServicioBO> lsServiciosTablaBO = iServicioService.getByPadre(lsServiciosFiltroBO.get(0).getId());
                    model.addAttribute("tituloTabla", "Subservicios de " + lsServiciosFiltroBO.get(0).getNombre());
                    model.addAttribute("lsServiciosTabla", lsServiciosTablaBO);
                }
            } else {
                if (inputFlashMap.containsKey("filtroName")) {
                    String filtro = (String) inputFlashMap.get("filtroName");
                    if (lsFiltrado != null) {
                        if (lsFiltrado.isEmpty()) {
                            model.addAttribute("tituloTabla", "No se encontraron coincidencias para '" + filtro + "'");
                        } else {
                            model.addAttribute("tituloTabla", "Coincidencias para '" + filtro + "'");
                        }
                        model.addAttribute("lsServiciosTabla", lsFiltrado);
                    } else {
                        List<ServicioBO> lsServiciosTablaBO = iServicioService.getByPadre(lsServiciosFiltroBO.get(0).getId());
                        model.addAttribute("tituloTabla", "Subservicios de " + lsServiciosFiltroBO.get(0).getNombre());
                        model.addAttribute("lsServiciosTabla", lsServiciosTablaBO);
                    }
                } else {
                    if (inputFlashMap.containsKey("tipoOp")) {
                        //mensajes
                        model.addAttribute("tipoMsg", inputFlashMap.get("tipoMsg"));
                        model.addAttribute("tituloMsg", inputFlashMap.get("tituloMsg"));
                        model.addAttribute("msg", inputFlashMap.get("msg"));
                        //reinicio
                        List<ServicioBO> lsServiciosTablaBO = iServicioService.getByPadre(lsServiciosFiltroBO.get(0).getId());
                        model.addAttribute("tituloTabla", "Subservicios de " + lsServiciosFiltroBO.get(0).getNombre());
                        model.addAttribute("lsServiciosTabla", lsServiciosTablaBO);
                    }
                }
            }

        }

        model.addAttribute("lsSlas", lsSlasBO);
        model.addAttribute("lsServiciosFiltro", lsServiciosFiltroBO);
        model.addAttribute("lsServiciosNivel2", lsServiciosNivel2De1);

        return "Configuracion/gestionServicios";
    }

    @RequestMapping(value = "/admin_config/gestion_slas")
    public String viewGestionSlas(Model model, HttpServletRequest request) {
        int maxDias = 7, maxHoras = 24, maxMinutos = 60;

        List<Integer> lsDias = new ArrayList<>();
        List<Integer> lsHoras = new ArrayList<>();
        List<Integer> lsMinutos = new ArrayList<>();

        for (int i = 0; i < maxDias; i++) {
            lsDias.add(i);
        }
        for (int i = 0; i < maxHoras; i++) {
            lsHoras.add(i);
        }
        for (int i = 0; i < maxMinutos; i++) {
            lsMinutos.add(i);
        }

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            if (inputFlashMap.containsKey("lsSlas")) {
                model.addAttribute("lsSlas", inputFlashMap.get("lsSlas"));
            }
            if (inputFlashMap.containsKey("tipoMsg")) {
                model.addAttribute("tipoMsg", inputFlashMap.get("tipoMsg"));
                model.addAttribute("tituloMsg", inputFlashMap.get("tituloMsg"));
                model.addAttribute("msg", inputFlashMap.get("msg"));
                List<SlaBO> lsSlas = ISLAService.getAll();
                model.addAttribute("lsSlas", lsSlas);
            }
        } else {
            List<SlaBO> lsSlas = ISLAService.getAll();
            model.addAttribute("lsSlas", lsSlas);
        }

        model.addAttribute("lsDias", lsDias);
        model.addAttribute("lsHoras", lsHoras);
        model.addAttribute("lsMinutos", lsMinutos);

        return "Configuracion/gestionSlas";
    }

}
