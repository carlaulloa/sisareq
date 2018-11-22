/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.regtickets;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import pe.edu.unmsm.sistemas.sisareq.service.bo.PrioridadBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SCatalogo;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SConsultaTicket;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SGeneraTicket;
import pe.edu.unmsm.sistemas.sisareq.util.Tiempo;

/**
 *
 * @author ULLOA
 */
@Controller
public class CSolicitante {

    @Autowired
    private SGeneraTicket iGeneraTicketService;

    @Autowired
    private SCatalogo iCatalogoService;

    @Autowired
    private SUsuario iUsuarioService;

    @Autowired
    private SConsultaTicket iConsultaTicketService;

    @RequestMapping(value = "/solicitante/catalogo")
    public String viewCatalogoServicio(Model model) {
        List<ServicioBO> lsServiciosBO = iCatalogoService.getCatalogo();
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        model.addAttribute("user", user);
        model.addAttribute("lsServicios", lsServiciosBO);
        return "Registro de tickets/solicitante/catalogo";
    }

    @RequestMapping(value = "/solicitante/generar_ticket")
    public String viewGenerarTicket(Model model, RedirectAttributes redirectAttributes) {
        List<PrioridadBO> lsPrioridadesBO = iGeneraTicketService.getPrioridades();
        List<ServicioBO> lsServiciosBO = iCatalogoService.getCatalogo();
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        Integer maxNivel = iCatalogoService.getMaxNivel();
        System.out.println("num serv en controoller" + lsServiciosBO.size());
        model.addAttribute("lsPrioridades", lsPrioridadesBO);
        model.addAttribute("lsServicios", lsServiciosBO);
        model.addAttribute("user", user);
        model.addAttribute("maxNivel", maxNivel);
        if (redirectAttributes.containsAttribute("msg")) {
            model.addAttribute("msg", redirectAttributes.getFlashAttributes().get("msg"));
        }
        return "Registro de tickets/solicitante/generarTicket";
    }

    @RequestMapping(value = "/solicitante/tickets_generados")
    public String viewTicketsGenerados(Model model, HttpServletRequest request) {
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            if (inputFlashMap.containsKey("lsTicketsFiltroRango")) {
                model.addAttribute("lsTickets", inputFlashMap.get("lsTicketsFiltroRango"));
                model.addAttribute("tituloTabla", inputFlashMap.get("tituloFiltro"));
            }
        } else {

            Date hoy = Tiempo.getFecha();
            Date semanaPasada = Tiempo.sumarRestarDiasFecha(hoy, -7);

            List<TicketBO> lsTickets = iConsultaTicketService.getByIdSolicitante(user.getId(), semanaPasada, hoy);

            model.addAttribute("lsTickets", lsTickets);
            model.addAttribute("tituloTabla", "Tickets desde " + Tiempo.transformDateToString(semanaPasada) + " hatsa " + Tiempo.transformDateToString(hoy));
        }
        model.addAttribute("user", user);
        return "Registro de tickets/solicitante/ticketsGenerados";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
