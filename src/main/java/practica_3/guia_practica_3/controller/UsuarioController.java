package practica_3.guia_practica_3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import practica_3.guia_practica_3.model.Usuario;
import practica_3.guia_practica_3.service.UsuarioService;

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public boolean crearUsuario(@RequestBody Usuario nuevoUsuario){
        return usuarioService.crearUsuario(nuevoUsuario);
    }


    @GetMapping("/usuarios")
    public List<Usuario>getUuarios(){
        return usuarioService.getUuarios();
    }
}
