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
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SAutorizarTicket;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SCatalogo;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SConsultaTicket;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SGeneraTicket;
import pe.edu.unmsm.sistemas.sisareq.util.Tiempo;

/**
 *
 * @author ULLOA
 */
@Controller
public class CSolicitanteAv {

    @Autowired
    private SGeneraTicket iGeneraTicketService;

    @Autowired
    private SCatalogo iCatalogoService;

    @Autowired
    private SUsuario iUsuarioService;

    @Autowired
    private SConsultaTicket iConsultaTicketService;

    @Autowired
    private SAutorizarTicket iAutorizarTicketService;

    @RequestMapping(value = "/solicitanteAv/catalogo")
    public String viewCatalogoServicio(Model model) {
        List<ServicioBO> lsServiciosBO = iCatalogoService.getCatalogo();
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        model.addAttribute("user", user);
        model.addAttribute("lsServicios", lsServiciosBO);
        return "Registro de tickets/solicitante avanzado/catalogo";
    }

    @RequestMapping(value = "/solicitanteAv/generar_ticket")
    public String viewGenerarTicket(Model model, RedirectAttributes redirectAttributes) {
        List<PrioridadBO> lsPrioridadesBO = iGeneraTicketService.getPrioridades();
        List<ServicioBO> lsServiciosBO = iCatalogoService.getCatalogo();
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        Integer maxNivel = iCatalogoService.getMaxNivel();
        model.addAttribute("lsPrioridades", lsPrioridadesBO);
        model.addAttribute("lsServicios", lsServiciosBO);
        model.addAttribute("user", user);
        model.addAttribute("maxNivel", maxNivel);
        if (redirectAttributes.containsAttribute("msg")) {
            model.addAttribute("msg", redirectAttributes.getFlashAttributes().get("msg"));
        }
        return "Registro de tickets/solicitante avanzado/generarTicket";
    }

    @RequestMapping(value = "/solicitanteAv/tickets_generados")
    public String viewTicketsGenerados(Model model) {
        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        Date hoy = Tiempo.getFecha();
        Date semanaPasada = Tiempo.sumarRestarDiasFecha(hoy, -7);
        List<TicketBO> lsTickets = iConsultaTicketService.getByIdSolicitante(user.getId(), semanaPasada, hoy);
        model.addAttribute("lsTickets", lsTickets);
        model.addAttribute("tituloTabla", "Tickets desde " + Tiempo.transformDateToString(semanaPasada) + " hatsa " + Tiempo.transformDateToString(hoy));

        return "Registro de tickets/solicitante avanzado/ticketsGenerados";
    }

    @RequestMapping(value = "/solicitanteAv/visar_tickets")
    public String viewVisarTickets(Model model, HttpServletRequest request) {

        UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());
        model.addAttribute("user", user);

        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);

        if (inputFlashMap != null) {
            if (inputFlashMap.containsKey("tipoMsg")) {
                model.addAttribute("tipoMsg", inputFlashMap.get("tipoMsg"));
                model.addAttribute("tituloMsg", inputFlashMap.get("tituloMsg"));
                model.addAttribute("msg", inputFlashMap.get("msg"));
            }
            if (inputFlashMap.containsKey("lsTicketsFiltroRango")) {
                model.addAttribute("lsTickets", inputFlashMap.get("lsTicketsFiltroRango"));
                model.addAttribute("tituloTabla", inputFlashMap.get("tituloFiltro"));
            }
        } else {
            Date hoy = Tiempo.getFecha();
            Date semanaPasada = Tiempo.sumarRestarDiasFecha(hoy, -7);

            List<TicketBO> lsTicketBOs = iAutorizarTicketService.getByPorAutorizarRangoFechas(user.getId(), semanaPasada, hoy);
            model.addAttribute("lsTickets", lsTicketBOs);
            model.addAttribute("tituloTabla", "Tickets desde " + Tiempo.transformDateToString(semanaPasada) + " hatsa " + Tiempo.transformDateToString(hoy));
        }

        return "Registro de tickets/solicitante avanzado/visarTickets";
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
