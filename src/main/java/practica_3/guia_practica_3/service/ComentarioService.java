package practica_3.guia_practica_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica_3.guia_practica_3.model.Comentario;
import practica_3.guia_practica_3.repository.ComentarioRepository;
import practica_3.guia_practica_3.repository.NoticiaRepository;
import practica_3.guia_practica_3.repository.UsuarioRepository;

@Service
public class ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @Autowired
    private NoticiaRepository noticiaRepository;


    public boolean crearComentario(Comentario nuevoComentario, String idUsuario, String idNoticia){
        boolean existeUsuario = UsuarioRepository.findById(idUsuario).isPresent();
        boolean existeNoticia = noticiaRepository.findById(idNoticia).isPresent();
        if(existeUsuario && existeNoticia){
            nuevoComentario.setIdUsuario(idUsuario);
            nuevoComentario.setIdNoticia(idNoticia);
            comentarioRepository.save(nuevoComentario);
            return true;
        }else return false;
    }


    public List<Comentario>getComentarios(){
        return comentarioRepository.findAll();
    }
}
