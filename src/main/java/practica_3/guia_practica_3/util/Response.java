package practica_3.guia_practica_3.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**@author Christian Eduardo Mendieta Tenesaca */

@Data
@AllArgsConstructor
public class Response<T> {
    
    private int codigoHttp;
    private String descripcion;
    private List<T> cuerpo;
}
