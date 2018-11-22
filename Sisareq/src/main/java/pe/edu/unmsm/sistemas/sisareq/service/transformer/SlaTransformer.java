/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.service.transformer;


import java.util.ArrayList;
import java.util.List;
import pe.edu.unmsm.sistemas.sisareq.domain.Sla;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;

/**
 *
 * @author ULLOA
 */
public class SlaTransformer {

   public static SlaBO entityToBO(Sla sla) {
        SlaBO slaBO = null;
        if (sla != null) {
            slaBO = new SlaBO();
            slaBO.setId(sla.getIdSla());
            slaBO.setNombre(sla.getNombreSla());
            slaBO.setEstado(sla.getEstado());
            slaBO.setResolucionDias(sla.getTresolucionDd());
            slaBO.setResolucionHoras(sla.getTresolucionHh());
            slaBO.setResolucionMinutos(sla.getTresolucionMm());
            slaBO.setRespuestaDias(sla.getTrespuestaDd());
            slaBO.setRespuestaHoras(sla.getTrespuestaHh());
            slaBO.setRespuestaMinutos(sla.getTrespuestaMm());
        }
        return slaBO;
    }
   
    
   public static Sla boToEntity(SlaBO slaBO){
       Sla sla = null;
        if (slaBO != null) {
            sla = new Sla();
            sla.setIdSla(slaBO.getId());
            sla.setNombreSla(slaBO.getNombre());
            sla.setEstado(slaBO.getEstado());
            sla.setTresolucionDd(slaBO.getResolucionDias());
            sla.setTresolucionHh(slaBO.getResolucionHoras());
            sla.setTresolucionMm(slaBO.getResolucionMinutos());
            sla.setTrespuestaDd(slaBO.getRespuestaDias());
            sla.setTrespuestaHh(slaBO.getRespuestaHoras());
            sla.setTrespuestaMm(slaBO.getRespuestaMinutos());
        }
        return sla;
   }
   
   public static List<SlaBO> listEntityToListBO(List<Sla> lsSlas){
       List<SlaBO> lsSlasBO = new ArrayList<>();
       for(Sla sla : lsSlas){
           SlaBO slabo = SlaTransformer.entityToBO(sla);
           lsSlasBO.add(slabo);
           
       }
       return lsSlasBO;
   }
   
}
