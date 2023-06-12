import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Menu {
private List<Plato> listaPlatos=new ArrayList<>();
private Plato plato1;



    public boolean ingresarPlato(Plato p){
        if (BuscarPorNombre(p.getNombre())==null){
            listaPlatos.add(p);
            return true;
        }else {
            return false;
        }
    }
    public Plato BuscarPorNombre(String nombre) {
        for (Plato p: listaPlatos) {
            if (p.getNombre().equals(nombre)){
                return p;
            }

        }
        return null;
    }
    public void datosQuemados(){
    listaPlatos.add(new Plato("Plato1",2.5, 3.4,4));
    listaPlatos.add(new Plato("Plato1",2.5, 3.4,4));
    listaPlatos.add(new Plato("Plato1",2.5, 3.4,4));
    listaPlatos.add(new Plato("Plato1",2.5, 3.4,4));
    listaPlatos.add(new Plato("Plato1",2.5, 3.4,4));
    }
    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }
    public boolean ModificarDatos(String nombre, double precio, double calorias, int tiempo) {
        Plato p1=BuscarPorNombre(nombre);
        if (p1!=null){
            p1.setPrecio(precio);
            p1.setCalorias(calorias);
            p1.setTiempo(tiempo);
            return true;
        }
        return false;
    }
    public Plato eliminarPlato(String nombre){
        Plato p1;
        for (int i=0;i<listaPlatos.size();i++){
            p1=listaPlatos.get(i);
            if (p1.getNombre().equals(nombre)){
                listaPlatos.remove(i);
                return p1;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Menu:" +
                "ListaPlatos:" + listaPlatos;
    }
}
