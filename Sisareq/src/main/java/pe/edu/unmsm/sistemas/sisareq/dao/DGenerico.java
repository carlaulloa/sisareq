package pe.edu.unmsm.sistemas.sisareq.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

public interface DGenerico<Entidad, Id> {
    public Session getCurrentSession();
    public List<Entidad> listarTodos(Class<Entidad> clase);
    public void insertar(Entidad entidad);
    public Entidad buscarPorId(Class<Entidad> clase, Serializable id);
}
