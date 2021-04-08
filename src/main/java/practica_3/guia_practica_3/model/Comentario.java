package practica_3.guia_practica_3.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**@author Christian Eduardo Mendieta Tenesaca */

@Data
@Document(collection = "comentarios")
public class Comentario {
    
    @Id
    private String id;

    private LocalDate fechaPublicacion;
    private String cuerpo;

    private String idNoticia;
    private String idUsuario;
}
