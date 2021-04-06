package practica_3.guia_practica_3.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HttpResponse<T> {
    
    private int codigoHttp;
    private String descripcion;
    private List<T> cuerpo;
}
