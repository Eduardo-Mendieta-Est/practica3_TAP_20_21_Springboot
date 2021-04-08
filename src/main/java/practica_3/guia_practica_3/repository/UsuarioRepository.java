package practica_3.guia_practica_3.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import practica_3.guia_practica_3.model.Direccion;
import practica_3.guia_practica_3.model.Usuario;

/**@author Christian Eduardo Mendieta Tenesaca */

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{
    
    public List<Usuario> findByNombreUsuario(String nombreUsuario);
    public List<Usuario> findByCuentaFacebook(String cuentaFacebook);
    public List<Usuario> findByCuentaTwitter(String cuentaTwitter);
    public List<Usuario> findByCuentaInstagram(String cuentaInstagram);
    public List<Usuario> findByDireccion(Direccion direccion);
}
