package pe.edu.unmsm.sistemas.sisareq.service.inc;

//import pe.edu.unmsm.sistemas.sisareq.domain.Solucion;
import pe.edu.unmsm.sistemas.sisareq.domain.Atencion;
import pe.edu.unmsm.sistemas.sisareq.domain.Problema;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;

public interface SRegistrarSolucion {
    //public void guardarTicket(Ticket ticket);
//    public void guardarSolucion(Solucion solucion, int idTicket);
    public Ticket obtenerTicket(int id);
    public void guardarAtencion(Atencion atencion, int idTicket,String userName);
    public void guardarProblema(Problema problema, Atencion atencion, int idTicket,String userName);
}
