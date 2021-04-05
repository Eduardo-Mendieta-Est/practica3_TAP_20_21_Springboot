package practica_3.guia_practica_3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import practica_3.guia_practica_3.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
}
