package practica_3.guia_practica_3.controller;

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
import practica_3.guia_practica_3.util.Response;


/**@author Christian Eduardo Mendieta Tenesaca */

@RestController
@RequestMapping("app")
@CrossOrigin("*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public Response<Usuario> crearUsuario(@RequestBody Usuario nuevoUsuario){
        return usuarioService.crearUsuario(nuevoUsuario);
    }


    @GetMapping("/usuarios")
    public Response<Usuario>getUuarios(){
        return usuarioService.getUsuarios();
    }

     /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**Consulta por Nombre Usuario, Facebook, Instagram y Twitter: */

    @GetMapping("/usuarios/nombre-usuario/{nombreUsuario}")
    public Response<Usuario> getUsuariosPorNombreUsuario(@PathVariable String nombreUsuario){
        return usuarioService.getUsuariosPorNombreUsuario(nombreUsuario);
    }

    @GetMapping("/usuarios/cta-facebook/{ctaFacebook}")
    public Response<Usuario> getUsuariosPorCtaFacebook(@PathVariable String ctaFacebook){
        return usuarioService.getUsuariosPorCtaFacebook(ctaFacebook);
    }

    @GetMapping("/usuarios/cta-twitter/{ctaTwitter}")
    public Response<Usuario> getUsuariosPorCtaTwitter(@PathVariable String ctaTwitter){
        return usuarioService.getUsuariosPorCtaTwitter(ctaTwitter);
    }

    @GetMapping("/usuarios/cta-instagram/{ctaInstagram}")
    public Response<Usuario> getUsuariosPorCtaInstagram(@PathVariable String ctaInstagram){
        return usuarioService.getUsuariosPorCtaInstagram(ctaInstagram);
    }

    /**Agrupacion por codigo postal: */
    @GetMapping("/usuarios/cp/{codigoPostal}")
    public Response<Long> getNumeroUsuariosPorCodPostal(@PathVariable String codigoPostal){
        return usuarioService.getNumeroUsuariosPorCodPostal(codigoPostal);
    }

     /** consulta por numero de teléfono: */
     @GetMapping("/usuarios/telefono/{telefono}")
     public Response<Usuario> getUsuariosPorTelefono(@PathVariable String telefono){
        return usuarioService.getUsuariosPorTelefono(telefono);
     }
}
