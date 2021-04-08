package practica_3.guia_practica_3.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practica_3.guia_practica_3.model.Comentario;
import practica_3.guia_practica_3.service.ComentarioService;
import practica_3.guia_practica_3.util.Response;

/**@author Christian Eduardo Mendieta Tenesaca */

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;


    @PostMapping("/comentarios/{idUsuario}/{idNoticia}")
    public Response<Comentario> crearComentario(
        @RequestBody Comentario nuevoComentario, 
        @PathVariable String idUsuario, 
        @PathVariable String idNoticia){
        return comentarioService.crearComentario(nuevoComentario, idUsuario, idNoticia);
    }


    @GetMapping("/comentarios")
    public Response<Comentario> getComentarios(){
        return comentarioService.getComentarios();
    }

    @GetMapping("/comentarios/noticia/{idNoticia}")
    public Response<Comentario> getComentariosPorNoticia(@PathVariable String idNoticia){
        return comentarioService.getComentariosPorNoticia(idNoticia);
    }

    @GetMapping("/comentarios/usuario/{idUsuario}")
    public Response<Comentario> getComentariosPorUsuario(@PathVariable String idUsuario){
        return comentarioService.getComentariosPorUsuario(idUsuario);
    }

    @GetMapping("/comentarios/fecha-publicacion/{fechaPublicacion}")
    public Response<Comentario> getComentariosPorFecha(@PathVariable String fechaPublicacion){
        try {
            LocalDate fecha = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return comentarioService.getComentariosPorFecha(fecha);
        } catch (Exception e) {
            return new Response<>(400, "Error, formato de fecha no valido", null);
        }
    }

    /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**numero de noticias por usuario, noticia y dia: */ 
    @GetMapping("/comentarios/usuario/count/{idUsuario}")
    public Response<Long> getNumComentariosPorUsuario(@PathVariable String idUsuario){
        return comentarioService.getNumComentariosPorUsuario(idUsuario);
    }


    @GetMapping("/comentarios/noticia/count/{idNoticia}")
    public Response<Long> getNumComentariosPorNoticia(@PathVariable String idNoticia){
        return comentarioService.getNumComentariosPorNoticia(idNoticia);
    }

    @GetMapping("/comentarios/fecha-publicacion/count/{fechaPublicacion}")
    public Response<Long> getNumComentariosPorDia(@PathVariable String fechaPublicacion){
        try {
            LocalDate fecha = LocalDate.parse(fechaPublicacion, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return comentarioService.getNumComentariosPorDia(fecha);
        } catch (Exception e) {
            return new Response<>(400, "Error, formato de fecha no valido", null);
        }
    }
}
