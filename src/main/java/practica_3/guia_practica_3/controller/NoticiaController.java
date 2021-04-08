package practica_3.guia_practica_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practica_3.guia_practica_3.model.Noticia;
import practica_3.guia_practica_3.service.NoticiaService;
import practica_3.guia_practica_3.util.Response;

/**@author Christian Eduardo Mendieta Tenesaca */

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class NoticiaController {
    
    @Autowired
    private NoticiaService noticiaService;


    @PostMapping("/noticias/{idUsuario}")
    public Response<Noticia> crearNoticia(@RequestBody Noticia nuevaNoticia, @PathVariable String idUsuario){
        return noticiaService.crearNoticia(nuevaNoticia, idUsuario);
    }

    @GetMapping("/noticias")
    public Response<Noticia> getNoticias(){
        return noticiaService.getNoticias();
    }

    /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**noticias por usuario: */ 

    @GetMapping("/noticias/{idUsuario}")
    public Response<Noticia> getNoticiasPorUsuario(@PathVariable String idUsuario){
        return noticiaService.getNoticiasPorUsuario(idUsuario);
    }

    /** Obtener 10 ultimas noticias publicadas */
    @GetMapping("/noticias/ultimas-noticias")
    public Response<Noticia> getUltimasNoticias(){
        return noticiaService.getUltimasNoticias();
    }

}
