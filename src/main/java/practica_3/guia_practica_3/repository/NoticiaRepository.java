package practica_3.guia_practica_3.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import practica_3.guia_practica_3.model.Noticia;

/**@author Christian Eduardo Mendieta Tenesaca */

@Repository
public interface NoticiaRepository extends MongoRepository<Noticia, String>{
    
    public List<Noticia> findByIdUsuario(String idUsuario);

}
