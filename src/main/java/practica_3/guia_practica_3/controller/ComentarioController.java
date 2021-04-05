package practica_3.guia_practica_3.controller;

import java.util.List;

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

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;


    @PostMapping("/comentarios/{idUsuario}/{idNoticia}")
    public boolean crearComentario(
        @RequestBody Comentario nuevoComentario, 
        @PathVariable String idUsuario, 
        @PathVariable String idNoticia){
        return comentarioService.crearComentario(nuevoComentario, idUsuario, idNoticia);
    }


    @GetMapping("/comentarios")
    public List<Comentario>getComentarios(){
        return comentarioService.getComentarios();
    }
}
