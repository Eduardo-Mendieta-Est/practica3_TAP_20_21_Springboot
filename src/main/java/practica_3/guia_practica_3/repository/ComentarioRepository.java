package practica_3.guia_practica_3.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import practica_3.guia_practica_3.model.Comentario;

/**@author Christian Eduardo Mendieta Tenesaca */

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String>{
    
    public List<Comentario> findByIdUsuario(String idUsuario);
    public List<Comentario> findByIdNoticia(String idNoticia);
    public List<Comentario> findByFechaPublicacion(LocalDate fechaPublicacion);
}
