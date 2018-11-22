/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.impl.regtickets;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.unmsm.sistemas.sisareq.dao.DAtencion;
import pe.edu.unmsm.sistemas.sisareq.dao.DTicket;
import pe.edu.unmsm.sistemas.sisareq.service.bo.AtencionBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.EstadoBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.PrioridadBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.TicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SConsultaTicket;

/**
 *
 * @author ULLOA
 */
@Service
@Transactional(readOnly = true)
public class SConsultaTicketImpl implements SConsultaTicket{

    @Autowired
    private DTicket iTicketDAO;
    @Autowired
    private DAtencion iAtencionDAO;
    
    
    @Override
    public List<TicketBO> getByIdSolicitante(Integer idSolicitante) {
       List<Object[]> lsTickets = iTicketDAO.getByIdSolicitante(idSolicitante);
       List<TicketBO> lsTicketsBO = new ArrayList<>();
       for(Object[] row  : lsTickets){
           Integer idTicket = (Integer)row[0];
           String asunto = (String) row[1];
           String archivo = (String ) row[2];
           String descripcion = (String) row[3];
           Date fecha = (Date) row[4];
           Date hora = (Date) row[5];
           Boolean aprobacion = (Boolean) row[6];
           Integer idEstado = (Integer ) row[7];
           String nombreEstado = (String) row[8];
           Integer idPrioridad = (Integer) row[9];
           String nombrePrioridad = (String) row[10];
           Integer idServicio = (Integer) row[11];
           String nombreServicio = (String) row[12];
           Integer nivel = (Integer) row[13];
           
           EstadoBO estadBO = new EstadoBO();
           estadBO.setId(idEstado);
           estadBO.setEstado(nombreEstado);
           
           PrioridadBO prioridadBO = new PrioridadBO();
           prioridadBO.setId(idPrioridad);
           prioridadBO.setPrioridad(nombrePrioridad);
           
           ServicioBO servicioBO = new ServicioBO();
           servicioBO.setId(idServicio);
           servicioBO.setNombre(nombreServicio);
           servicioBO.setNivel(nivel);
           
           TicketBO ticketBO = new TicketBO();
           ticketBO.setId(idTicket);
           ticketBO.setAsunto(asunto);
           ticketBO.setArchivo(archivo);
           ticketBO.setDescripcion(descripcion);
           ticketBO.setFecha(fecha);
           ticketBO.setHora(hora);
           ticketBO.setAprobado(aprobacion);
           
           System.out.println("descripcion ");
           System.out.println(descripcion);
           
           ticketBO.setPrioridad(prioridadBO);
           ticketBO.setEstado(estadBO);
           ticketBO.setServicio(servicioBO);
           
            // falta obtener las rpta para los tickets que esten cerrados
           if (nombreEstado.equals("Cerrado")) {
               Object[] fila = iAtencionDAO.getByIdTicket(idTicket);
               System.out.println("atencion" + fila);
               if (fila!=null) {
                   AtencionBO atencionBO = new AtencionBO();
                   atencionBO.setId((Integer)fila[0]);
                   atencionBO.setDescripcion((String)fila[1]);
                   atencionBO.setFecha((Date)fila[2]);
                   atencionBO.setHora((Date)fila[3]);
                   atencionBO.setSiRespuesta((Boolean)fila[4]);
                   /*
                   SolucionBO solucionBO = new SolucionBO();
                   solucionBO.setId((Integer)fila[5]);
                   solucionBO.setDocumentacion((String)fila[6]);
                   solucionBO.setFechaEnvio((Date)fila[7]);
                   
                   atencionBO.setSolucion(solucionBO);*/
                   ticketBO.setAtencion(atencionBO);
               }
           }
           
           
           lsTicketsBO.add(ticketBO);
       }
       
      
       
       
       return lsTicketsBO;
    }

    @Override
    public List<TicketBO> getByIdSolicitante(Integer idSolicitante, Date fechaIni, Date fechaFin) {
      List<Object[]> lsTickets = iTicketDAO.getByIdSolicitante(idSolicitante,fechaIni,fechaFin);
       List<TicketBO> lsTicketsBO = new ArrayList<>();
       for(Object[] row  : lsTickets){
           Integer idTicket = (Integer)row[0];
           String asunto = (String) row[1];
           String archivo = (String ) row[2];
           String descripcion = (String) row[3];
           Date fecha = (Date) row[4];
           Date hora = (Date) row[5];
           Boolean aprobacion = (Boolean) row[6];
           Integer idEstado = (Integer ) row[7];
           String nombreEstado = (String) row[8];
           Integer idPrioridad = (Integer) row[9];
           String nombrePrioridad = (String) row[10];
           Integer idServicio = (Integer) row[11];
           String nombreServicio = (String) row[12];
           Integer nivel = (Integer) row[13];
           
           EstadoBO estadBO = new EstadoBO();
           estadBO.setId(idEstado);
           estadBO.setEstado(nombreEstado);
           
           PrioridadBO prioridadBO = new PrioridadBO();
           prioridadBO.setId(idPrioridad);
           prioridadBO.setPrioridad(nombrePrioridad);
           
           ServicioBO servicioBO = new ServicioBO();
           servicioBO.setId(idServicio);
           servicioBO.setNombre(nombreServicio);
           servicioBO.setNivel(nivel);
           
           TicketBO ticketBO = new TicketBO();
           ticketBO.setId(idTicket);
           ticketBO.setAsunto(asunto);
           ticketBO.setArchivo(archivo);
           ticketBO.setDescripcion(descripcion);
           ticketBO.setFecha(fecha);
           ticketBO.setHora(hora);
           ticketBO.setAprobado(aprobacion);
           
           System.out.println("descripcion ");
           System.out.println(descripcion);
           
           ticketBO.setPrioridad(prioridadBO);
           ticketBO.setEstado(estadBO);
           ticketBO.setServicio(servicioBO);
           
            // falta obtener las rpta para los tickets que esten cerrados
           if (nombreEstado.equals("Cerrado")) {
               Object[] fila = iAtencionDAO.getByIdTicket(idTicket);
               System.out.println("atencion" + fila);
               if (fila!=null) {
                   AtencionBO atencionBO = new AtencionBO();
                   atencionBO.setId((Integer)fila[0]);
                   atencionBO.setDescripcion((String)fila[1]);
                   atencionBO.setFecha((Date)fila[2]);
                   atencionBO.setHora((Date)fila[3]);
                   atencionBO.setSiRespuesta((Boolean)fila[4]);
                   /*
                   SolucionBO solucionBO = new SolucionBO();
                   solucionBO.setId((Integer)fila[5]);
                   solucionBO.setDocumentacion((String)fila[6]);
                   solucionBO.setFechaEnvio((Date)fila[7]);
                   
                   atencionBO.setSolucion(solucionBO);*/
                   ticketBO.setAtencion(atencionBO);
               }
           }
           
           
           lsTicketsBO.add(ticketBO);
       }
       
      
       
       
       return lsTicketsBO;
    }
    
}
