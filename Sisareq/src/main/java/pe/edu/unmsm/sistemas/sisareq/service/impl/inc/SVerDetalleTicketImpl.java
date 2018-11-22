package pe.edu.unmsm.sistemas.sisareq.service.impl.inc;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
//import pe.edu.unmsm.sistemas.sisareq.domain.Solucion;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import pe.edu.unmsm.sistemas.sisareq.service.inc.SVerDetalleTicket;

@Service("sVerDetalleTicketImpl")
@Transactional(readOnly = true)
public class SVerDetalleTicketImpl implements Serializable, SVerDetalleTicket{
    @Autowired
    private DTicket dTicket;
    
    @Override
    public Ticket obtenerTicket(int id) {
        Ticket ticket = dTicket.buscar(id);
//        List<Solucion> sols = ticket.getSolucionList(); //Se trae la lista
//        if (sols == null) { //Solo sirve para que se guarde la lista soluciones en el objeto
//            System.out.println("Nulo");
//        }
        return ticket;
    }
//
//    @Override
//    @Transactional(readOnly = false)
//    public void registrarTicketComoProblema(int idTicket) {
//        dTicket.actualizarTicketAProblema(idTicket);
//    }
    
}
