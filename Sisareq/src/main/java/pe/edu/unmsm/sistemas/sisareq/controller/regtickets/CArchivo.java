/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.sistemas.sisareq.controller.regtickets;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.edu.unmsm.sistemas.sisareq.service.bo.ArchivoTicketBO;
import pe.edu.unmsm.sistemas.sisareq.service.regtickets.SArchivoTicket;

/**
 *
 * @author ULLOA
 */
@Controller
public class CArchivo {
    
    @Autowired
    private SArchivoTicket iArchivoTicketService;

    @RequestMapping(value = "/descargar-archivo/{idTicket}", method = RequestMethod.GET)
    public void descargarArchivo(@PathVariable Integer idTicket,
   
            HttpServletResponse response) throws IOException {
        ArchivoTicketBO archivoBO = iArchivoTicketService.getFileByIdTicket(idTicket);
        
        // ServletContext context = request.getSession().getServletContext();
        
      //   String mimeType = context.getMimeType(fullPath);
         
        response.setContentType(archivoBO.getTipo());
        response.setContentLength(archivoBO.getAdjunto().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + archivoBO.getNombre() +"\"");
 
        FileCopyUtils.copy(archivoBO.getAdjunto(), response.getOutputStream());
        
    }

}
