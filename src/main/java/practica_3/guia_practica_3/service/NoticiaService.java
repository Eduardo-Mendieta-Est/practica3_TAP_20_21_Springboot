package practica_3.guia_practica_3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import practica_3.guia_practica_3.model.Noticia;
import practica_3.guia_practica_3.repository.NoticiaRepository;
import practica_3.guia_practica_3.repository.UsuarioRepository;

@Service
public class NoticiaService {
   
    @Autowired
    private NoticiaRepository noticiaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public boolean crearNoticia(Noticia nuevaNoticia, String idUsuario){
        if(usuarioRepository.findById(idUsuario).isPresent()){
            nuevaNoticia.setIdUsuario(idUsuario);
            noticiaRepository.save(nuevaNoticia);
            return true;
        }else return false;
    }


    public List<Noticia> getNoticias(){
        return noticiaRepository.findAll();
    }


    public List<Noticia> getNoticiasPorUsuario(String idUsuario){
        return noticiaRepository.findByIdUsuario(idUsuario);
    }
}
