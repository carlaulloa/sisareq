/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.configtipos;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ServicioBO;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SSLA;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SServicio;


@Controller
public class CServicio {

    @Autowired
    private SServicio iServicioService;
    
    @Autowired
    private SSLA iSlaService;

    @RequestMapping(value = "/admin_config/form_filtrar_nivel_1", method = RequestMethod.POST)
    public String filtrarByNivelServicio(final RedirectAttributes redirectAttributes,
            @RequestParam("filtroPrimerNivel") String idSeleccionado) {

        Integer idServicio = Integer.parseInt(idSeleccionado);

        ServicioBO servicioBO = iServicioService.getById(idServicio);
        List<ServicioBO> lsServicios = iServicioService.getByPadre(idServicio);

        redirectAttributes.addFlashAttribute("tipoOp", "filtrado");
        redirectAttributes.addFlashAttribute("filtro", servicioBO.getNombre());
        redirectAttributes.addFlashAttribute("lsServic", lsServicios);
        return "redirect:/admin_config/gestion_servicios";
    }

    @RequestMapping(value = "/admin_config/form_filtrar_nomservicio", method = RequestMethod.POST)
    public String filtrarByNombreServicio(final RedirectAttributes redirectAttributes,
            @RequestParam("nomServicio") String filtroNombre) {

        List<ServicioBO> lsServicios = iServicioService.filterByName(filtroNombre);

        redirectAttributes.addFlashAttribute("tipoOp", "filtrado");
        redirectAttributes.addFlashAttribute("filtroName", filtroNombre);
        redirectAttributes.addFlashAttribute("lsServic", lsServicios);

        return "redirect:/admin_config/gestion_servicios";
    }

    @RequestMapping(value = "/admin_config/form_registrar_servicio", method = RequestMethod.POST)
    public String formAniadirServicio(RedirectAttributes redirectAttributes,
            @RequestParam("nombreServicio") String nombre,
            @RequestParam("serviciosNivel2") String servicioPadre,
            @RequestParam("slas") String sla,
            @RequestParam("autorizacion1") String autorizacion) {

        
        Integer idServicioPadre = Integer.parseInt(servicioPadre);
        Integer idSla = Integer.parseInt(sla);

        ServicioBO servicioBO = new ServicioBO();
        servicioBO.setNombre(nombre);

        ServicioBO servicioBOPadre = new ServicioBO();
        servicioBOPadre.setId(idServicioPadre);

        SlaBO slaBO = iSlaService.getById(idSla);
        

        servicioBO.setServicioPadre(servicioBOPadre);
        servicioBO.setSlaBO(slaBO);
        servicioBO.setNivel(3);
        
        if (autorizacion.equals("si")) {
             servicioBO.setAutorizacion(Boolean.TRUE);
        }else{
            servicioBO.setAutorizacion(Boolean.FALSE);
        }
        

        String salida = iServicioService.registrar(servicioBO);

        redirectAttributes.addFlashAttribute("tipoOp", "CRUD");

        if (salida != null) {
            switch (salida) {
                case "error":
                    redirectAttributes.addFlashAttribute("tipoMsg", 2);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Error");
                    redirectAttributes.addFlashAttribute("msg", "Error al registrar el servicio.");
                    break;
                default:
                    redirectAttributes.addFlashAttribute("tipoMsg", 1);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Registro hecho!");
                    redirectAttributes.addFlashAttribute("msg", "Se registró el servicio '" + nombre + "' correctamente.");
                    break;
            }

        }

        return "redirect:/admin_config/gestion_servicios";
    }

    @RequestMapping(value = "/admin_config/form_delete_servicio", method = RequestMethod.POST)
    public String formElimianrServicio(RedirectAttributes redirectAttributes,
            @RequestParam("idServicioDelete") String servicio) {

        System.out.println("se recibe " + servicio);
        Integer idServicio = Integer.parseInt(servicio);

        ServicioBO servicioBO = iServicioService.getById(idServicio);

        String salida = iServicioService.eliminar(idServicio);

        redirectAttributes.addFlashAttribute("tipoOp", "CRUD");

        if (salida.equals("ok")) {
            redirectAttributes.addFlashAttribute("tipoMsg", 1);
            redirectAttributes.addFlashAttribute("tituloMsg", "Eliminación correcta");
            redirectAttributes.addFlashAttribute("msg", "Se eliminó el servicio '" + servicioBO.getNombre() + "' correctamente.");

        } else {
            redirectAttributes.addFlashAttribute("tipoMsg", 2);
            redirectAttributes.addFlashAttribute("tituloMsg", "Error");
            redirectAttributes.addFlashAttribute("msg", "Error al eliminar el servicio '" + servicioBO.getNombre() + "'");

        }

        return "redirect:/admin_config/gestion_servicios";
    }

    @RequestMapping(value = "/admin_config/form_update_servicio", method = RequestMethod.POST)
    public String formActualizarServicio(RedirectAttributes redirectAttributes,
            @RequestParam("idServicio") String idServicio,
            @RequestParam("nombreServicioUpdate") String nombreServicio,
            @RequestParam("slasUpdate") String sla,
            @RequestParam("autorizacion1")String autorizacion) {

        ServicioBO servicioBO = new ServicioBO();
        servicioBO.setId(Integer.parseInt(idServicio));
        servicioBO.setNombre(nombreServicio);
        servicioBO.setNivel(3);
        
        if (autorizacion.equals("si")) {
             servicioBO.setAutorizacion(Boolean.TRUE);
        }else{
            servicioBO.setAutorizacion(Boolean.FALSE);
        }

        SlaBO slaBO = new SlaBO();
        slaBO.setId(Integer.parseInt(sla));
        
        
        servicioBO.setSlaBO(slaBO);
        servicioBO.setEstado(Boolean.TRUE);
        
        String salida = iServicioService.actualizar(servicioBO);

        redirectAttributes.addFlashAttribute("tipoOp", "CRUD");

        if (salida != null) {
            switch (salida) {
                case "error":
                    redirectAttributes.addFlashAttribute("tipoMsg", 2);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Error");
                    redirectAttributes.addFlashAttribute("msg", "Error al actualizar el servicio.");
                    break;
                default:
                    redirectAttributes.addFlashAttribute("tipoMsg", 1);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Actualización correcta");
                    redirectAttributes.addFlashAttribute("msg", "Se actualizó el servicio '" + servicioBO.getNombre() + "' correctamente.");
                    break;
            }
        }

        return "redirect:/admin_config/gestion_servicios";
    }

    
    @RequestMapping(value = "/admin_config/update_selector_nivel2",method = RequestMethod.POST,
            produces="application/json")
    public @ResponseBody List<ServicioBO> updateSelectorNivel2AJAX(
        @RequestBody SelectorServicioForm selectorServicioForm){

        return iServicioService.getByPadre(selectorServicioForm.getId());        
    }

}
