package practica_3.guia_practica_3.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**@author Christian Eduardo Mendieta Tenesaca */

@Data
@Document(collection = "usuarios")
public class Usuario {
    
    @Id
    private String id;

    private String nombreUsuario;
    private String cuentaTwitter;
    private String cuentaFacebook;
    private String cuentaInstagram;
    private String nombre;
    private String descripcion;
    private List<String> telefonos;
    private Direccion direccion;
}
