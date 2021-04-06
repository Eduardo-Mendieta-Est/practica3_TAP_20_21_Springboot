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

import practica_3.guia_practica_3.model.Usuario;
import practica_3.guia_practica_3.service.UsuarioService;
import practica_3.guia_practica_3.util.HttpResponse;

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public HttpResponse<Usuario> crearUsuario(@RequestBody Usuario nuevoUsuario){
        return usuarioService.crearUsuario(nuevoUsuario);
    }


    @GetMapping("/usuarios")
    public List<Usuario>getUuarios(){
        return usuarioService.getUsuarios();
    }

     /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**Consulta por Nombre Usuario, Facebook, Instagram y Twitter: */

    @GetMapping("/usuarios/nombre-usuario/{nombreUsuario}")
    public HttpResponse<Usuario> getUsuariosPorNombreUsuario(@PathVariable String nombreUsuario){
        return usuarioService.getUsuariosPorNombreUsuario(nombreUsuario);
    }

    @GetMapping("/usuarios/cta-facebook/{ctaFacebook}")
    public HttpResponse<Usuario> getUsuariosPorCtaFacebook(@PathVariable String ctaFacebook){
        return usuarioService.getUsuariosPorCtaFacebook(ctaFacebook);
    }

    @GetMapping("/usuarios/cta-twitter/{ctaTwitter}")
    public HttpResponse<Usuario> getUsuariosPorCtaTwitter(@PathVariable String ctaTwitter){
        return usuarioService.getUsuariosPorCtaTwitter(ctaTwitter);
    }

    @GetMapping("/usuarios/cta-instagram/{ctaInstagram}")
    public HttpResponse<Usuario> getUsuariosPorCtaInstagram(@PathVariable String ctaInstagram){
        return usuarioService.getUsuariosPorCtaInstagram(ctaInstagram);
    }

    /**Agrupacion por codigo postal: */
    @GetMapping("/usuarios/cp")
    public HttpResponse<String> getNumeroUsuariosPorCodPostal(){
        return usuarioService.getNumeroUsuariosPorCodPostal();
    }

     /** consulta por numero de teléfono: */
     @GetMapping("/usuarios/telefono/{telefono}")
     public HttpResponse<Usuario> getUsuariosPorTelefono(@PathVariable String telefono){
        return usuarioService.getUsuariosPorTelefono(telefono);
     }
}
