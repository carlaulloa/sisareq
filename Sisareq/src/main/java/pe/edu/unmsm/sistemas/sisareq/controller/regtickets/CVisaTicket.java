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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SAutorizarTicket;
import pe.edu.unmsm.sistemas.sisareq.util.Tiempo;

/**
 *
 * @author ULLOA
 */
@Controller
public class CVisaTicket {

    @Autowired
    public SUsuario iUsuarioService;

    @Autowired
    public SAutorizarTicket iAutorizarTicketService;
/*
    
    @RequestMapping(value = "/solicitanteAv/form_filtrar_by_rango", method = RequestMethod.POST,
            produces = "application/json")
    public @ResponseBody
    List<TicketBO> filtrarPorRangoFechas(@RequestBody FiltroRangoFechaForm filtro) {
        try {
            UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());

            String fecha1 = Tiempo.transformFechaToFormatSql(filtro.getFechaIni());
            String fecha2 = Tiempo.transformFechaToFormatSql(filtro.getFechaFin());

            Date df1 = Tiempo.formatearFecha(fecha1);
            Date df2 = Tiempo.formatearFecha(fecha2);

            return iAutorizarTicketService.getByPorAutorizarRangoFechas(user.getId(), df1, df2);
        } catch (ParseException ex) {
            Logger.getLogger(CVisaTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/

    @RequestMapping(value = "/solicitanteAv/form_filtrar_by_rango", method = RequestMethod.POST)
    public String filtrarPorRangoFechas(RedirectAttributes redirectAttributes,
            @RequestParam("fechaIni") String fechaIni,
            @RequestParam("fechaFin") String fechaFin) {
        try {
            UsuarioBO user = iUsuarioService.getByNombreUsuario(getPrincipal());

            String fecha1 = Tiempo.transformFechaToFormatSql(fechaIni);
            String fecha2 = Tiempo.transformFechaToFormatSql(fechaFin);

            Date df1 = Tiempo.formatearFecha(fecha1);
            Date df2 = Tiempo.formatearFecha(fecha2);

            List<TicketBO> lsTickets = iAutorizarTicketService.getByPorAutorizarRangoFechas(user.getId(), df1, df2);
            
            
            redirectAttributes.addFlashAttribute("lsTicketsFiltroRango",lsTickets);
            redirectAttributes.addFlashAttribute("tituloFiltro", "Tickets desde "+ fecha1 + " hasta " + fecha2);
        } catch (ParseException ex) {
            Logger.getLogger(CVisaTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/solicitanteAv/visar_tickets";
    }

    
    
    @RequestMapping(value = "/solicitanteAv/form_autorizar_ticket")
    public String formAutorizarTicket(RedirectAttributes redirectAttributes , 
            @RequestParam("idTicket") Integer idTicket){
        
        String salida = iAutorizarTicketService.setAutorizacion(idTicket);
        
       if (salida.equals("ok")) {
            redirectAttributes.addFlashAttribute("tipoMsg", 1);
            redirectAttributes.addFlashAttribute("tituloMsg", "Autorización correcta");
            redirectAttributes.addFlashAttribute("msg", "Se autorizó el ticket '" + idTicket + "' correctamente.");

        } else {
            redirectAttributes.addFlashAttribute("tipoMsg", 2);
            redirectAttributes.addFlashAttribute("tituloMsg", "Error");
            redirectAttributes.addFlashAttribute("msg", "Error al autorizar el ticket '" + idTicket + "'");

        }       
        
        return "redirect:/solicitanteAv/visar_tickets";
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
