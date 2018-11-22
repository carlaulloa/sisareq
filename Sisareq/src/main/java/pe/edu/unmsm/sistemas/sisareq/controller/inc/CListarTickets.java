package pe.edu.unmsm.sistemas.sisareq.controller.inc;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.service.inc.SVerTickets;

@Controller
public class CListarTickets {
    
    @Autowired
    private SVerTickets sIncVerTickets;
    
    @RequestMapping(value = "/operador")
    public ModelAndView listarTickets(){
        List<Ticket> lista = getListaTickets();
        
        ModelAndView model = new ModelAndView("INC/listaTickets");
        model.addObject("tickets", lista);
        
        return model;
    }
    
    private List<Ticket> getListaTickets(){
        List<Ticket> lista = null;
        lista = sIncVerTickets.obtenerListaTickets();
        return lista;
    }
}
