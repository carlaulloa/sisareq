/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.configtipos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.unmsm.sistemas.sisareq.service.bo.SlaBO;
import pe.edu.unmsm.sistemas.sisareq.service.configuracion.SSLA;

@Controller
public class CSLA {

    @Autowired
    private SSLA iSLAService;

    @RequestMapping(value = "/admin_config/form_registrar_sla", method = RequestMethod.POST)
    public String formRegistrar(RedirectAttributes redirectAttributes,
            @RequestParam("nombre_sla") String nombre,
            @RequestParam("diasResol") Integer diasResol,
            @RequestParam("horasResol") Integer horasResol,
            @RequestParam("minutosResol") Integer minutosResol,
            @RequestParam("diasRpta") Integer diasRpta,
            @RequestParam("horasRpta") Integer horasRpta,
            @RequestParam("minutosRpta") Integer minutosRpta
    ) {

        SlaBO slaBO = new SlaBO();
        slaBO.setNombre(nombre);
        slaBO.setResolucionDias(diasResol);
        slaBO.setResolucionHoras(horasResol);
        slaBO.setResolucionMinutos(minutosResol);
        slaBO.setRespuestaDias(diasRpta);
        slaBO.setRespuestaHoras(horasRpta);
        slaBO.setRespuestaMinutos(minutosRpta);
        slaBO.setEstado(Boolean.TRUE);

        String salida = iSLAService.registrar(slaBO);

        if (salida != null) {
            switch (salida) {
                case "duplicado":
                    redirectAttributes.addFlashAttribute("tipoMsg", 3);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Duplicado");
                    redirectAttributes.addFlashAttribute("msg", "El nombre '" + nombre + "' ya existe. Registre de nuevo.");
                    break;
                case "error":
                    redirectAttributes.addFlashAttribute("tipoMsg", 2);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Error");
                    redirectAttributes.addFlashAttribute("msg", "Error al registrar el SLA.");
                    break;
                default:
                    redirectAttributes.addFlashAttribute("tipoMsg", 1);
                    redirectAttributes.addFlashAttribute("tituloMsg", "Registro hecho!");
                    redirectAttributes.addFlashAttribute("msg", "Se registró el SLA '" + nombre + "' correctamente.");
                    break;
            }

        }

        return "redirect:/admin_config/gestion_slas";
    }

    @RequestMapping(value = "/admin_config/form_update_sla", method = RequestMethod.POST)
    public String formActualizar(RedirectAttributes redirectAttributes,
            @RequestParam("id_sla") Integer idSla,
            @RequestParam("nombre_sla") String nombre,
            @RequestParam("diasResol") Integer diasResol,
            @RequestParam("horasResol") Integer horasResol,
            @RequestParam("minutosResol") Integer minutosResol,
            @RequestParam("diasRpta") Integer diasRpta,
            @RequestParam("horasRpta") Integer horasRpta,
            @RequestParam("minutosRpta") Integer minutosRpta
    ) {

        SlaBO slaBO = new SlaBO();
        slaBO.setId(idSla);
        slaBO.setNombre(nombre);
        slaBO.setResolucionDias(diasResol);
        slaBO.setResolucionHoras(horasResol);
        slaBO.setResolucionMinutos(minutosResol);
        slaBO.setRespuestaDias(diasRpta);
        slaBO.setRespuestaHoras(horasRpta);
        slaBO.setRespuestaMinutos(minutosRpta);
        slaBO.setEstado(Boolean.TRUE);

        String salida = iSLAService.actualizar(slaBO);

        if (salida.equals("ok")) {
            redirectAttributes.addFlashAttribute("tipoMsg", 1);
            redirectAttributes.addFlashAttribute("tituloMsg", "Actualización correcta");
            redirectAttributes.addFlashAttribute("msg", "Se actualizó el SLA '" + slaBO.getNombre() + "' correctamente.");

        } else {
            redirectAttributes.addFlashAttribute("tipoMsg", 2);
            redirectAttributes.addFlashAttribute("tituloMsg", "Error");
            redirectAttributes.addFlashAttribute("msg", "Error al actualizar el SLA '" + slaBO.getNombre() + "'");

        }

        return "redirect:/admin_config/gestion_slas";
    }

    @RequestMapping(value = "/admin_config/form_delete_sla", method = RequestMethod.POST)
    public String formEliminar(RedirectAttributes redirectAttributes,
            @RequestParam("idSlaDelete") Integer idSla,
            @RequestParam("nomSlaDelete") String nombreSla) {

        String salida = iSLAService.eliminar(idSla);

        if (salida == null) {
            redirectAttributes.addFlashAttribute("tipoMsg", 2);
            redirectAttributes.addFlashAttribute("tituloMsg", "Error");
            redirectAttributes.addFlashAttribute("msg", "Error al eliminar el SLA '" + nombreSla + "'");

        } else {
            if (salida.equals("ok")) {
                redirectAttributes.addFlashAttribute("tipoMsg", 1);
                redirectAttributes.addFlashAttribute("tituloMsg", "Eliminación correcta");
                redirectAttributes.addFlashAttribute("msg", "Se eliminó el SLA '" + nombreSla + "' correctamente.");

            } else {
                redirectAttributes.addFlashAttribute("tipoMsg", 2);
                redirectAttributes.addFlashAttribute("tituloMsg", "Error");
                redirectAttributes.addFlashAttribute("msg", "Error al eliminar el SLA '" + nombreSla + "'");

            }
        }
        return "redirect:/admin_config/gestion_slas";
    }

    @RequestMapping(value = "/admin_config/filtrar_nombre_sla", method = RequestMethod.POST)
    public String formFiltrarByNombre(@RequestParam("nombreSla") String nombre, RedirectAttributes redirectAttributes) {

        List<SlaBO> lsSlas = iSLAService.filtrarByNombre(nombre);
        redirectAttributes.addFlashAttribute("lsSlas", lsSlas);
        return "redirect:/admin_config/gestion_slas";
    }
}
