package practica_3.guia_practica_3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import practica_3.guia_practica_3.model.Comentario;

@Repository
public interface ComentarioRepository extends MongoRepository<Comentario, String>{
    
}