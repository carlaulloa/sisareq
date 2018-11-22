package pe.edu.unmsm.sistemas.sisareq.controller.inc;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import pe.edu.unmsm.sistemas.sisareq.domain.Atencion;
import pe.edu.unmsm.sistemas.sisareq.domain.Problema;
//import pe.edu.unmsm.sistemas.sisareq.domain.Solucion;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.service.inc.SRegistrarSolucion;

@Controller
public class CRegistrarSolucion {
    
    @Autowired
    private SRegistrarSolucion sIncRegistrarSolucion;
    
    @RequestMapping(value = "/registroSolucion")
    public String formularioRegistro(Integer idTicket, Model modelo){
        System.out.println("Id buscado: "+idTicket);
        modelo.addAttribute("ticket", sIncRegistrarSolucion.obtenerTicket(idTicket));
        
        return "INC/RegistroSolucion";
    }
    
    @RequestMapping(value = "/registrarSolucion")
    public ModelAndView guardar(Atencion atencion, int idTicketRelacionado, String userName){
        atencion.setFecha(new Date());
        atencion.setHora(new Date());
        atencion.setSiRespuesta(true);
        System.out.println("Id ticket: "+idTicketRelacionado);
        System.out.println("con descripcion: "+ atencion.getDescripcion());
        
        System.out.println("User: "+userName);
        sIncRegistrarSolucion.guardarAtencion(atencion, idTicketRelacionado, userName);
        ModelAndView model = new ModelAndView("INC/RegistroOk");
        
        return model;
    }
    
    @RequestMapping(value = "/registrarProblema")
    public ModelAndView guardarComoProblema(Atencion atencion, int idTicketRelacionado, String userName, String asuntoTicket, String descTicket, String tratamiento){
        atencion.setFecha(new Date());
        atencion.setHora(new Date());
        atencion.setSiRespuesta(true);
        System.out.println("Id ticket: "+idTicketRelacionado);
        System.out.println("con descripcion: "+ atencion.getDescripcion());
        
        System.out.println("User: "+userName);
        //sIncRegistrarSolucion.guardarAtencion(atencion, idTicketRelacionado, userName);
        Problema problema = new Problema();
        problema.setAsunto(asuntoTicket);
        problema.setDescripcion(descTicket);
        problema.setTratamientoPrevio(tratamiento);
        
        sIncRegistrarSolucion.guardarProblema(problema, atencion, idTicketRelacionado, userName);
        ModelAndView model = new ModelAndView("INC/RegistroOk");
        
        return model;
    }
}