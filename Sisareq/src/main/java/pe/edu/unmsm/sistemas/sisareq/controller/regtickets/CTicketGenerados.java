/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.regtickets;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SConsultaTicket;
import pe.edu.unmsm.sistemas.sisareq.util.Tiempo;

/**
 *
 * @author ULLOA
 */
@Controller
public class CTicketGenerados {

    @Autowired
    public SUsuario iUsuarioService;

    @Autowired
    public SConsultaTicket iConsultaTicketService;

    @RequestMapping(value = "/solicitante/form_filtrargen_by_rango", method = RequestMethod.POST)
    public String filtrarPorRangoFechas(RedirectAttributes redirectAttributes,
            @RequestParam("fechaIni") String fechaIni,
            @RequestParam("fechaFin") String fechaFin) {
        try {
            UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());

            String fecha1 = Tiempo.transformFechaToFormatSql(fechaIni);
            String fecha2 = Tiempo.transformFechaToFormatSql(fechaFin);

            Date df1 = Tiempo.formatearFecha(fecha1);
            Date df2 = Tiempo.formatearFecha(fecha2);

            List<TicketBO> lsTickets = iConsultaTicketService.getByIdSolicitante(user.getId(), df1, df2);

            redirectAttributes.addFlashAttribute("lsTicketsFiltroRango", lsTickets);
            redirectAttributes.addFlashAttribute("tituloFiltro", "Tickets desde " + fecha1 + " hasta " + fecha2);
        } catch (ParseException ex) {
            Logger.getLogger(CTicketGenerados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/solicitante/tickets_generados";
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
