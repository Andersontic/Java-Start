public class repositorio{
  public static void main(String args[]){
   System.out.println("Bienvenidos al repositorio Java-Start"); 
   System.out.println("Prueba Oscar Moreno Github Spring1 Java-Start";
 }
}
enum TipoEmpresa_Enum{
    ADMINISTRADOR, OPERATIVO
}
class Empleado{
    private String Nombre;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public TipoEmpresa_Enum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresa_Enum tipo) {
        this.tipo = tipo;
    }

    private String Correo;
    private TipoEmpresa_Enum tipo;
}

// Spring 3
import java.util.List;

public interface repositorioUsuario extends JpaRepository {
    @Query(value = "select * from Usuario", nativeQuery = true)
    public abstract List <Empresa> findAll();

}








