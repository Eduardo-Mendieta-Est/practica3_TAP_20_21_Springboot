package practica_3.guia_practica_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica_3.guia_practica_3.model.Usuario;
import practica_3.guia_practica_3.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public boolean crearUsuario(Usuario nuevoUsuario){
        usuarioRepository.save(nuevoUsuario);
        return true;
    }

    public List<Usuario>getUuarios(){
        return usuarioRepository.findAll();
    }

}
