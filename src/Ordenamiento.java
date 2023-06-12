import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ordenamiento {
//4 metodos, busqueda secuencial binaria, burbuja insercion estatico
    private Menu menu1=new Menu();

    /**
     * Búsqueda secuencial, busca los platos en base al nombre
     * @param nombre
     * @return
     */
    public Plato busquedaNombre(String nombre){
    for (Plato plato1 : menu1.getListaPlatos()) {
        if(plato1.getNombre().equals(nombre)){
            return plato1;
        }
    }
    return null;
}
}
