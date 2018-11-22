/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.configuracion;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DUsuario;
import pe.edu.unmsm.sistemas.sisareq.service.bo.RolBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.UsuarioBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SUsuario;
import pe.edu.unmsm.sistemas.sisareq.service.transformer.UsuarioTransformer;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SUsuarioImpl implements SUsuario {

    @Autowired
    private DUsuario iUsuarioDao;

    @Override
    public UsuarioBO getByNombreUsuario(String nombreUsuario) {
        return UsuarioTransformer.entityToBO(iUsuarioDao.buscarPorNombre(nombreUsuario));
    }

    @Override
     @Transactional(readOnly=false)
    public String registrar(UsuarioBO usuarioBO) {
        return iUsuarioDao.insert(UsuarioTransformer.boToEntity(usuarioBO));
    }

    @Override
    public List<UsuarioBO> getAllActivos() {
        List<Object[]> lsUsuarios = iUsuarioDao.getAllActivos();
        List<UsuarioBO> lsUsuariosBO = new ArrayList<>();
        for (Object[] fila : lsUsuarios) {
            Integer idUsuario = (Integer) fila[0];
            String nombreUsuario = (String) fila[1];
            String contrasenia = (String) fila[2];
            String nombre = (String) fila[3];
            String apellidoPat = (String) fila[4];
            String apellidoMat = (String) fila[5];
            Boolean estado = (Boolean) fila[6];

            Integer idRol = (Integer) fila[7];
            String nombreRol = (String) fila[8];
            String descripcion = (String) fila[9];

            Integer idSupervisor = (Integer) fila[10];

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.setId(idUsuario);
            usuarioBO.setNomUsuario(nombreUsuario);
            usuarioBO.setClave(contrasenia);
            usuarioBO.setNombre(nombre);
            usuarioBO.setApellidoPaterno(apellidoPat);
            usuarioBO.setApellidoMaterno(apellidoMat);
            usuarioBO.setEstado(estado);

            RolBO rolBO = new RolBO();
            rolBO.setId(idRol);
            rolBO.setNombre(nombreRol);
            rolBO.setDescripcion(descripcion);

            if (idSupervisor != null) {
                UsuarioBO supervisor = getById(idSupervisor);
                usuarioBO.setSupervisor(supervisor);
            }

            usuarioBO.setRol(rolBO);
            lsUsuariosBO.add(usuarioBO);
        }
        return lsUsuariosBO;
    }

    @Override
    public UsuarioBO getById(Integer idUsuario) {
        Object[] usuario = iUsuarioDao.getById(idUsuario);
        UsuarioBO usuarioBO = new UsuarioBO();

        Integer idUser = (Integer) usuario[0];
        String nombreUsuario = (String) usuario[1];
        String contrasenia = (String) usuario[2];
        String nombre = (String) usuario[3];
        String apellidoPat = (String) usuario[4];
        String apellidoMat = (String) usuario[5];
        Boolean estado = (Boolean) usuario[6];

        Integer idRol = (Integer) usuario[7];
        String nombreRol = (String) usuario[8];
        String descripcion = (String) usuario[9];

        usuarioBO.setId(idUser);
        usuarioBO.setNomUsuario(nombreUsuario);
        usuarioBO.setClave(contrasenia);
        usuarioBO.setNombre(nombre);
        usuarioBO.setApellidoPaterno(apellidoPat);
        usuarioBO.setApellidoMaterno(apellidoMat);
        usuarioBO.setEstado(estado);

        RolBO rolBO = new RolBO();
        rolBO.setId(idRol);
        rolBO.setNombre(nombreRol);
        rolBO.setDescripcion(descripcion);
        usuarioBO.setRol(rolBO);

        return usuarioBO;
    }

    @Override
    public List<UsuarioBO> getByRol(Integer idRol) {
        List<Object[]> lsUsuarios = iUsuarioDao.getByRol(idRol);
        List<UsuarioBO> lsUsuariosBO = new ArrayList<>();
        for (Object[] fila : lsUsuarios) {
            Integer idUsuario = (Integer) fila[0];
            String nombreUsuario = (String) fila[1];
            String contrasenia = (String) fila[2];
            String nombre = (String) fila[3];
            String apellidoPat = (String) fila[4];
            String apellidoMat = (String) fila[5];
            Boolean estado = (Boolean) fila[6];

            Integer idRole = (Integer) fila[7];
            String nombreRol = (String) fila[8];
            String descripcion = (String) fila[9];

            Integer idSupervisor = (Integer) fila[10];

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.setId(idUsuario);
            usuarioBO.setNomUsuario(nombreUsuario);
            usuarioBO.setClave(contrasenia);
            usuarioBO.setNombre(nombre);
            usuarioBO.setApellidoPaterno(apellidoPat);
            usuarioBO.setApellidoMaterno(apellidoMat);
            usuarioBO.setEstado(estado);

            RolBO rolBO = new RolBO();
            rolBO.setId(idRole);
            rolBO.setNombre(nombreRol);
            rolBO.setDescripcion(descripcion);

            if (idSupervisor != null) {
                UsuarioBO supervisor = getById(idSupervisor);
                usuarioBO.setSupervisor(supervisor);
            }

            usuarioBO.setRol(rolBO);
            lsUsuariosBO.add(usuarioBO);
        }
        return lsUsuariosBO;
    }

    @Override
    public List<UsuarioBO> getSupervisores() {
        List<Object[]> lsUsuarios = iUsuarioDao.getSupervisores();
        List<UsuarioBO> lsUsuariosBO = new ArrayList<>();
        for (Object[] fila : lsUsuarios) {
            Integer idUsuario = (Integer) fila[0];
            String nombreUsuario = (String) fila[1];
            String contrasenia = (String) fila[2];
            String nombre = (String) fila[3];
            String apellidoPat = (String) fila[4];
            String apellidoMat = (String) fila[5];
            Boolean estado = (Boolean) fila[6];

            Integer idRole = (Integer) fila[7];
            String nombreRol = (String) fila[8];
            String descripcion = (String) fila[9];

            UsuarioBO usuarioBO = new UsuarioBO();
            usuarioBO.setId(idUsuario);
            usuarioBO.setNomUsuario(nombreUsuario);
            usuarioBO.setClave(contrasenia);
            usuarioBO.setNombre(nombre);
            usuarioBO.setApellidoPaterno(apellidoPat);
            usuarioBO.setApellidoMaterno(apellidoMat);
            usuarioBO.setEstado(estado);

            RolBO rolBO = new RolBO();
            rolBO.setId(idRole);
            rolBO.setNombre(nombreRol);
            rolBO.setDescripcion(descripcion);

            usuarioBO.setRol(rolBO);
            lsUsuariosBO.add(usuarioBO);
        }
        return lsUsuariosBO;
    }

    @Override
    public UsuarioBO getAllDataByNombreUsuario(String nombreUsuario) {
         UsuarioBO usuarioBO = null;
        Object[] fila = iUsuarioDao.getByNombreUsuario(nombreUsuario);
        if (fila!=null) {
            
            Integer idUsuario = (Integer) fila[0];
            String nomUsuario = (String) fila[1];
            String contrasenia = (String) fila[2];
            String nombre = (String) fila[3];
            String apellidoPat = (String) fila[4];
            String apellidoMat = (String) fila[5];
            Boolean estado = (Boolean) fila[6];

            Integer idRole = (Integer) fila[7];
            String nombreRol = (String) fila[8];
            String descripcion = (String) fila[9];

            Integer idSupervisor = (Integer) fila[10];

            usuarioBO = new UsuarioBO();
            usuarioBO.setId(idUsuario);
            usuarioBO.setNomUsuario(nomUsuario);
            usuarioBO.setClave(contrasenia);
            usuarioBO.setNombre(nombre);
            usuarioBO.setApellidoPaterno(apellidoPat);
            usuarioBO.setApellidoMaterno(apellidoMat);
            usuarioBO.setEstado(estado);

            RolBO rolBO = new RolBO();
            rolBO.setId(idRole);
            rolBO.setNombre(nombreRol);
            rolBO.setDescripcion(descripcion);

            if (idSupervisor != null) {
                UsuarioBO supervisor = getById(idSupervisor);
                usuarioBO.setSupervisor(supervisor);
            }

            usuarioBO.setRol(rolBO);
            
        }
        return usuarioBO;
    }

    @Override
     @Transactional(readOnly=false)
    public String deleteUsuario(Integer idUser) {
        UsuarioBO usuarioBO = getById(idUser);
        usuarioBO.setEstado(Boolean.FALSE);
        return iUsuarioDao.update(UsuarioTransformer.boToEntity(usuarioBO));
    }

    @Override
     @Transactional(readOnly=false)
    public String updateUsuario(UsuarioBO usuarioBO) {
        return iUsuarioDao.update(UsuarioTransformer.boToEntity(usuarioBO));
    }

    @Override
    public UsuarioBO getAllDataByNombrePersona(String nombre) {
       UsuarioBO usuarioBO = null;
        Object[] fila = iUsuarioDao.getByNombrePersona(nombre);
        if (fila!=null) {
            
            Integer idUsuario = (Integer) fila[0];
            String nomUsuario = (String) fila[1];
            String contrasenia = (String) fila[2];
            String nombreP = (String) fila[3];
            String apellidoPat = (String) fila[4];
            String apellidoMat = (String) fila[5];
            Boolean estado = (Boolean) fila[6];

            Integer idRole = (Integer) fila[7];
            String nombreRol = (String) fila[8];
            String descripcion = (String) fila[9];

            Integer idSupervisor = (Integer) fila[10];

            usuarioBO = new UsuarioBO();
            usuarioBO.setId(idUsuario);
            usuarioBO.setNomUsuario(nomUsuario);
            usuarioBO.setClave(contrasenia);
            usuarioBO.setNombre(nombreP);
            usuarioBO.setApellidoPaterno(apellidoPat);
            usuarioBO.setApellidoMaterno(apellidoMat);
            usuarioBO.setEstado(estado);

            RolBO rolBO = new RolBO();
            rolBO.setId(idRole);
            rolBO.setNombre(nombreRol);
            rolBO.setDescripcion(descripcion);

            if (idSupervisor != null) {
                UsuarioBO supervisor = getById(idSupervisor);
                usuarioBO.setSupervisor(supervisor);
            }

            usuarioBO.setRol(rolBO);
            
        }
        return usuarioBO;    
    }

}
