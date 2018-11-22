package pe.edu.unmsm.sistemas.sisareq.service.impl.inc;

import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import java.io.Serializable;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DAtencion;
import pe.edu.unmsm.sistemas.sisareq.dao.DOperador;
import pe.edu.unmsm.sistemas.sisareq.dao.DProblema;
import pe.edu.unmsm.sistemas.sisareq.dao.DSolucion;
import pe.edu.unmsm.sistemas.sisareq.domain.Atencion;
import pe.edu.unmsm.sistemas.sisareq.domain.Operador;
import pe.edu.unmsm.sistemas.sisareq.domain.Problema;
//import pe.edu.unmsm.sistemas.sisareq.domain.Solucion;
import pe.edu.unmsm.sistemas.sisareq.service.inc.SRegistrarSolucion;

@Service("sRegistrarSolucionImpl")
@Transactional(readOnly = true)
public class SRegistrarSolucionImpl implements Serializable, SRegistrarSolucion{
    @Autowired
    private DTicket dTicket;
    
    @Autowired
    private DAtencion dAtencion;
    
    @Autowired
    private DOperador dOperador;
    
    @Autowired
    private DProblema dProblema;
//    
//    @Autowired
//    private DSolucion dSolucion;
    
//    @Transactional(readOnly = false)
//    @Override
//    public void guardarSolucion(Solucion solucion, int idTicket) {
//        Ticket ticket = new Ticket(idTicket);
//        
//        solucion.setTicket(ticket);
//        
//        dSolucion.insertarSolucion(solucion);
//        
//        //Cambiando ticket a estado Cerrado
//        dTicket.actualizarEstadoTicket(idTicket, 4);
//    }

    @Override
    public Ticket obtenerTicket(int id) {
        return dTicket.buscar(id);
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarAtencion(Atencion atencion, int idTicket, String userName) {
        Ticket ticket = new Ticket(idTicket);
        atencion.setTicketId(ticket);
        
        Operador operador = dOperador.obtenerOperadorPorUsuario(userName);   //Buscar operador por id usuario
        atencion.setOperadorId(operador);
        
        dAtencion.insertarAtencion(atencion);
        
        dTicket.actualizarEstadoTicket(idTicket, 4);
    }

    @Transactional(readOnly = false)
    @Override
    public void guardarProblema(Problema problema, Atencion atencion, int idTicket, String userName) {
        Ticket ticket = new Ticket(idTicket);
        atencion.setTicketId(ticket);
        
        Operador operador = dOperador.obtenerOperadorPorUsuario(userName);   //Buscar operador por id usuario
        atencion.setOperadorId(operador);
        
        atencion.setDescripcion("");
        
        Atencion atencionRegistrada = dAtencion.insertarAtencion(atencion);
        
        problema.setFechaDeRegistro(new Date());
        problema.setAtencionId(atencionRegistrada);
        problema.setOperadorId(operador);
        
        dProblema.insertarProblema(problema);
    }
    
    
}