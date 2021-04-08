package practica_3.guia_practica_3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import practica_3.guia_practica_3.model.Usuario;
import practica_3.guia_practica_3.repository.UsuarioRepository;
import practica_3.guia_practica_3.util.Response;

/**@author Christian Eduardo Mendieta Tenesaca */

@Service
public class UsuarioService {

    @Autowired
    private MongoTemplate mongotemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    public Response<Usuario> crearUsuario(Usuario nuevoUsuario){
        try {
            boolean existeUsuario = !usuarioRepository.findByNombreUsuario(nuevoUsuario.getNombreUsuario()).isEmpty();
            if(!existeUsuario){
                usuarioRepository.save(nuevoUsuario);
                return new Response<Usuario>(201, "recurso creado con exito!", null);
            }else 
                return new Response<>(400, "Ya existe este nombre de usuario.", null);
        } catch (Exception e) {
            return new Response<>(400, "¡Ocurrio un problema con el servidor! :C", null);
        }
    }


    public Response<Usuario> getUsuarios(){
        return new Response<>(200, "Ok",  usuarioRepository.findAll());
    }


    /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**Consulta por Nombre Usuario, Facebook, Instagram y Twitter: */ 

    public Response<Usuario> getUsuariosPorNombreUsuario(String nombreUsuario){
        return new Response<>(200, "Ok", usuarioRepository.findByNombreUsuario(nombreUsuario));
    }

    public Response<Usuario> getUsuariosPorCtaFacebook(String ctaFacebook){
        return new Response<>(200, "Ok", usuarioRepository.findByCuentaFacebook(ctaFacebook));
    }

    public Response<Usuario> getUsuariosPorCtaTwitter(String ctaTwitter){
        return new Response<>(200, "Ok", usuarioRepository.findByCuentaTwitter(ctaTwitter));
    }

    public Response<Usuario> getUsuariosPorCtaInstagram(String ctaInstagram){
        return new Response<>(200, "Ok", usuarioRepository.findByCuentaInstagram(ctaInstagram));
    }


    /**Agrupacion por codigo postal: */
    public Response<Long> getNumeroUsuariosPorCodPostal(String codigoPostal){
        List<Long> numUsuarios = new ArrayList<>();
        Query query = new Query();
        query.addCriteria(Criteria.where("direccion.codigoPostal").is(codigoPostal));
        numUsuarios.add(mongotemplate.count(query, Usuario.class));
        return new Response<>(200, "Ok", numUsuarios);
    }


    /** consulta por numero de teléfono: */
    public Response<Usuario> getUsuariosPorTelefono(String telefono){
        Query query = new Query();
        query.addCriteria(Criteria.where("telefonos").is(telefono));
        return new Response<>(200, "Ok", mongotemplate.find(query, Usuario.class));
    }
}
