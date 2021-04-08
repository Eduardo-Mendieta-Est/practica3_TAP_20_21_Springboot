package practica_3.guia_practica_3.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import practica_3.guia_practica_3.model.Comentario;
import practica_3.guia_practica_3.repository.ComentarioRepository;
import practica_3.guia_practica_3.repository.NoticiaRepository;
import practica_3.guia_practica_3.repository.UsuarioRepository;
import practica_3.guia_practica_3.util.Response;

/**@author Christian Eduardo Mendieta Tenesaca */

@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public Response<Comentario> crearComentario(Comentario nuevoComentario, String idUsuario, String idNoticia){
        try {
            boolean existeUsuario = UsuarioRepository.findById(idUsuario).isPresent();
            boolean existeNoticia = noticiaRepository.findById(idNoticia).isPresent();
            if(existeUsuario && existeNoticia){
                nuevoComentario.setIdUsuario(idUsuario);
                nuevoComentario.setIdNoticia(idNoticia);
                comentarioRepository.save(nuevoComentario);
                return new Response<>(201, "Recurso Creado con exito!",null);
            }else return new Response<>(400, "Intenta acceder a un recurso inexistente!",null);
        } catch (Exception e) {
            return new Response<>(500, "Error en el servidor! :c!",null);
        }
    }


    public Response<Comentario> getComentarios(){
        return new Response<>(200, "Ok", comentarioRepository.findAll());
    }


    public Response<Comentario> getComentariosPorNoticia(String idNoticia){
        return new Response<>(200, "Ok",comentarioRepository.findByIdNoticia(idNoticia));
    }

    public Response<Comentario> getComentariosPorUsuario(String idUsuario){
        return new Response<>(200, "Ok",comentarioRepository.findByIdUsuario(idUsuario));
    }

    public Response<Comentario> getComentariosPorFecha(LocalDate fechaPublicacion){
        return new Response<>(200, "Ok",comentarioRepository.findByFechaPublicacion(fechaPublicacion));
    }

    /* -------------------- Consultas Frecuentes sobre la base de datos -------------------- */ 

    /**numero de noticias por usuario, noticia y dia: */ 
    public Response<Long> getNumComentariosPorUsuario(String idUsuario){
        return countComentarios("idUsuario", idUsuario, false, null);
    }


    public Response<Long> getNumComentariosPorNoticia(String idNoticia){
        return countComentarios("idNoticia", idNoticia, false, null);
    }

    public Response<Long> getNumComentariosPorDia(LocalDate fechaPublicacion){
        return countComentarios("fechaPublicacion", null, true, fechaPublicacion);
    }


    /** Solo por motivos de ejercicio: */
    private Response<Long> countComentarios(String key, String value, boolean isDate, LocalDate dateValue){
        List<Long> numComentarios = new ArrayList<>();
        Query query = new Query();
        Criteria criteria = (!isDate) ? Criteria.where(key).is(value) : Criteria.where(key).is(dateValue);
        query.addCriteria(criteria);
        numComentarios.add(mongoTemplate.count(query, Comentario.class));
        return new Response<>(200, "Ok", numComentarios);
    }
}
