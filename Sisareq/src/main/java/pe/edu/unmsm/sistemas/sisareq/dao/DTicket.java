package pe.edu.unmsm.sistemas.sisareq.dao;

import java.util.Date;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import java.util.List;

public interface DTicket {
    public List<Ticket> listarTickets();
    public Ticket buscar(int id);
    
    public void actualizarEstadoTicket(int idTicket, int nuevoEstado);
    /* public void actualizarTicketAProblema(int idTicket);
     */

    // MODULO REGISTRO DE TICKETS 
    public String insert(Ticket ticket);
    public Ticket getById(Integer id);
    public String update(Ticket ticket);
    public List<Object[]> getByIdSolicitante(Integer idSolicitante);
    public List<Object[]> getByIdSolicitante(Integer idSolicitante, Date fechaIni,Date fechaFin);
    public List<Object[]> getByPorAutorizar(Integer idSolicitanteAv);
    public List<Object[]> getByPorAutorizar(Integer idSolicitanteAv, Date fechaIni, Date fechaFin);
    public Object[] getFileByIdTicket(Integer idTicket);
}
