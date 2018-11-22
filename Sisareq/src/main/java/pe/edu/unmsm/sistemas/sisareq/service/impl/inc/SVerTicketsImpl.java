package pe.edu.unmsm.sistemas.sisareq.service.impl.inc;

import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.domain.Ticket;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.service.inc.SVerTickets;

@Service("sVerTicketsImpl")
@Transactional(readOnly = true)
public class SVerTicketsImpl implements Serializable, SVerTickets{
    @Autowired
    private DTicket dTicket;

    @Override
    public List<Ticket> obtenerListaTickets() {
        List<Ticket> lista = dTicket.listarTickets();
        return lista;
    }
}
