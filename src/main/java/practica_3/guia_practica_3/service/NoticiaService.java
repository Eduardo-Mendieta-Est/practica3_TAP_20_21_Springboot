package practica_3.guia_practica_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import practica_3.guia_practica_3.model.Noticia;
import practica_3.guia_practica_3.repository.NoticiaRepository;
import practica_3.guia_practica_3.repository.UsuarioRepository;
import practica_3.guia_practica_3.util.Response;

/**@author Christian Eduardo Mendieta Tenesaca */

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Response<Noticia> crearNoticia(Noticia nuevaNoticia, String idUsuario){
        try {
            if(usuarioRepository.findById(idUsuario).isPresent()){
                nuevaNoticia.setIdUsuario(idUsuario);
                noticiaRepository.save(nuevaNoticia);
                return new Response<>(201, "Recurso Creado con exito!",null);
            }else return new Response<>(400, "Intenta acceder a un recurso inexistente!",null);
        } catch (Exception e) {
            return new Response<>(500, "Error en el servidor! :c!",null);
        }
    }


    public Response<Noticia> getNoticias(){
        return new Response<>(200, "Ok", noticiaRepository.findAll());
    }


    /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**noticias por usuario: */ 
    public Response<Noticia> getNoticiasPorUsuario(String idUsuario){
        return new Response<>(200, "Ok", noticiaRepository.findByIdUsuario(idUsuario));
    }

    /** Obtener 10 ultimas noticias publicadas */
    public Response<Noticia> getUltimasNoticias(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.DESC, "fechaPublicacion")).limit(2);
        return new Response<>(200, "Ok",mongoTemplate.find(query, Noticia.class));
    }
}
