/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.regtickets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SGeneraTicket;

/**
 *
 * @author ULLOA
 */
@Controller
public class CGeneraTicket {

    @Autowired
    private SGeneraTicket iGeneraTicketService;

    @RequestMapping(value = "/solicitante/form_generar_ticket", method = RequestMethod.POST)
    public String registrarForSolicitante(
            RedirectAttributes redirectAttributes,
            @RequestParam("asunto") String asunto,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("prioridades") String prioridad,
            @RequestParam("servicioSelected") String servicio,
            @RequestParam("archivo") MultipartFile archivo,
            @RequestParam("userName")String nombreUsuario) {

        if (!prioridad.equals("nada") && !asunto.equals("") && !descripcion.equals("")) {
            System.out.println("id : " + prioridad);
            System.out.println("asunto : " + asunto);
            System.out.println("descripcion : " + descripcion);
            System.out.println("servicio:  " + servicio);
            Integer idPrioridad = Integer.parseInt(prioridad);
            Integer idServicio = Integer.parseInt(servicio);
            byte[] adjunto = null;
            String strNomArchivo = null;
            String contentType = null;
            try {
                adjunto = archivo.getBytes();
                
                    strNomArchivo = archivo.getOriginalFilename();
                    contentType = archivo.getContentType();
                
            } catch (IOException ex) {
               
            }
            String salida = iGeneraTicketService.registrar(asunto, descripcion, idPrioridad, idServicio, nombreUsuario, strNomArchivo, 1,adjunto,contentType);
            System.out.println("salida " + salida);
            // para agregarlo y mostrarlo en la vista y no ocmo parametro con Model , redirect
            redirectAttributes.addFlashAttribute("msg", "El ticket fue registrado correctamente");
        } else {
            System.out.println("no puse nada");
        }

        return "redirect:/solicitante/generar_ticket";
    }

    @RequestMapping(value = "/solicitanteAv/form_generar_ticket", method = RequestMethod.POST)
    public String registrarForSolicitanteAv(
            RedirectAttributes redirectAttributes,
            @RequestParam("asunto") String asunto,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("prioridades") String prioridad,
            @RequestParam("servicioSelected") String servicio,
             @RequestParam("archivo") MultipartFile archivo, 
            @RequestParam("userName")String nombreUsuario) {

        if (!prioridad.equals("nada") && !asunto.equals("") && !descripcion.equals("")) {
            System.out.println("id : " + prioridad);
            System.out.println("asunto : " + asunto);
            System.out.println("descripcion : " + descripcion);
            System.out.println("servicio:  " + servicio);
            Integer idPrioridad = Integer.parseInt(prioridad);
            Integer idServicio = Integer.parseInt(servicio);
            
            byte[] adjunto = null;
            String strNomArchivo = null;
            String contentType = null;
            try {
                
                adjunto = archivo.getBytes();
                    strNomArchivo = archivo.getOriginalFilename();
                    contentType = archivo.getContentType();
                
                
            } catch (IOException ex) {
               
            }
            String salida = iGeneraTicketService.registrar(asunto, descripcion, idPrioridad, idServicio, nombreUsuario, strNomArchivo, 2,adjunto,contentType);
            System.out.println("salida " + salida);
            redirectAttributes.addFlashAttribute("msg", "El ticket fue registrado correctamente");
        } else {
            System.out.println("no puse nada");
        }

        return "redirect:/solicitanteAv/generar_ticket";
    }

}
