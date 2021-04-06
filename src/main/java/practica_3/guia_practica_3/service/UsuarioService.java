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
import practica_3.guia_practica_3.util.HttpResponse;

@Service
public class UsuarioService {

    @Autowired
    private MongoTemplate mongotemplate;

    @Autowired
    private UsuarioRepository usuarioRepository;

    
    public HttpResponse<Usuario> crearUsuario(Usuario nuevoUsuario){
        try {
            boolean existeUsuario = !usuarioRepository.findByNombreUsuario(nuevoUsuario.getNombreUsuario()).isEmpty();
            if(!existeUsuario){
                usuarioRepository.save(nuevoUsuario);
                return new HttpResponse<Usuario>(201, "recurso creado con exito!", null);
            }else 
                return new HttpResponse<>(400, "Ya existe este nombre de usuario.", null);
        } catch (Exception e) {
            return new HttpResponse<>(400, "¡Ocurrio un problema con el servidor! :C", null);
        }
    }


    public List<Usuario>getUsuarios(){
        return usuarioRepository.findAll();
    }


    /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**Consulta por Nombre Usuario, Facebook, Instagram y Twitter: */ 

    public HttpResponse<Usuario> getUsuariosPorNombreUsuario(String nombreUsuario){
        return new HttpResponse<>(200, "Ok", usuarioRepository.findByNombreUsuario(nombreUsuario));
    }

    public HttpResponse<Usuario> getUsuariosPorCtaFacebook(String ctaFacebook){
        return new HttpResponse<>(200, "Ok", usuarioRepository.findByCuentaFacebook(ctaFacebook));
    }

    public HttpResponse<Usuario> getUsuariosPorCtaTwitter(String ctaTwitter){
        return new HttpResponse<>(200, "Ok", usuarioRepository.findByCuentaTwitter(ctaTwitter));
    }

    public HttpResponse<Usuario> getUsuariosPorCtaInstagram(String ctaInstagram){
        return new HttpResponse<>(200, "Ok", usuarioRepository.findByCuentaInstagram(ctaInstagram));
    }


    /**Agrupacion por codigo postal: */
    public HttpResponse<String> getNumeroUsuariosPorCodPostal(){
        List<String> agrupacionPorCP = new ArrayList<>();
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<String> listaCP = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            String cp = usuario.getDireccion().getCodigoPostal();
            if(!listaCP.contains(cp)) listaCP.add(cp);
        }

        for(String cp : listaCP){
            int totalCPs = 0;
            for(Usuario usuario: usuarios){
                if(usuario.getDireccion().getCodigoPostal().equals(cp)){
                    totalCPs+=1;
                }
            }
            String grupo = "Existen "+totalCPs+" usuario(s), con el código postal: "+cp+".";
            agrupacionPorCP.add(grupo);
        }
        return new HttpResponse<>(200, "Ok", agrupacionPorCP);
    }


    /** consulta por numero de teléfono: */
    public HttpResponse<Usuario> getUsuariosPorTelefono(String telefono){
        Query query = new Query();
        query.addCriteria(Criteria.where("telefonos").is(telefono));
        return new HttpResponse<>(200, "Ok", mongotemplate.find(query, Usuario.class));
    }

}
