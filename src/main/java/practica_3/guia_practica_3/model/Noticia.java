package practica_3.guia_practica_3.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**@author Christian Eduardo Mendieta Tenesaca */

@Data
@Document(collection = "noticias")
public class Noticia {
    
    @Id
    private String id;

    private String titulo;
    private String cuerpo;
    private List<String> tags;
    private LocalDate fechaPublicacion;

    private String idUsuario;
}
