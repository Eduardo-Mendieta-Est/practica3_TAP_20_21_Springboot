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

import practica_3.guia_practica_3.model.Noticia;
import practica_3.guia_practica_3.service.NoticiaService;

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class NoticiaController {
    
    @Autowired
    private NoticiaService noticiaService;


    @PostMapping("/noticias/{idUsuario}")
    public boolean crearNoticia(@RequestBody Noticia nuevaNoticia, @PathVariable String idUsuario){
        return noticiaService.crearNoticia(nuevaNoticia, idUsuario);
    }

    @GetMapping("/noticias")
    public List<Noticia> getNoticias(){
        return noticiaService.getNoticias();
    }
}
