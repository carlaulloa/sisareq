package pe.edu.unmsm.sistemas.sisareq.controller.inc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.service.inc.SVerDetalleTicket;

@Controller
public class CVerDetalleTicket {
    @Autowired
    private SVerDetalleTicket sIncVerDetalleTicket;
    
    @RequestMapping("/verDetalleTicket")
    public String irDetalle(Integer idTicket, Model modelo){
        System.out.println("Id buscado: "+idTicket);
        Ticket ticket = sIncVerDetalleTicket.obtenerTicket(idTicket);
        modelo.addAttribute("ticket", ticket);
//        if (ticket.getEstadoId().getIdEstado() == 4) {
//            modelo.addAttribute("solucion", ticket.getSolucionList().get(0));
//        }
        
        return "INC/VerDetalleTicket";
    }
    
//    @RequestMapping(value = "/registrarProblema")
//    public ModelAndView registrarProblema(Integer idTicket){
//        System.out.println("Id "+idTicket+" registrado como problema: ");
//        sIncVerDetalleTicket.registrarTicketComoProblema(idTicket);
//        ModelAndView model = new ModelAndView("INC/RegistroOk");
//        
//        return model;
//    }
}