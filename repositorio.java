import anotaciones.*;

import java.util.ArrayList;
import java.util.Optional;


public class repositorio{
  public static void main(String args[]){

   System.out.println("Bienvenidos al repositorio Java-Start"); 
 }
}

// CLASE EMPLEADO
public class Empleado{

    private int id;
    private String nombre;
    private String correo;
    private Empresa empresa;
    private String rol;

    public Empleado() {
    }

    public Empleado(String nombre, String correo, Empresa empresa, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepository;

    public List <Empleado> getAllEmpleado(){
        List <Empleado> empleadoList = new ArrayList<>();
        empleadoRepository.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    public Optional <Empleado> getEmpleadoById(Integer id){
        return empleadoRepository.findById(id);
    }

    public ArrayList <Empleado> obtenerPorEmpresa(Integer id){
        return empleadoRepository.findByEmpresa(id);
    }

    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public boolean deleteEmpleado(Integer id){
        empleadoRepository.deleteById(id);
        return !this.empleadoRepository.findById(id).isPresent();
    }
}


//CREACION DEL CONTROLADOR Y SERVICIO EMPLEADO

  public class ControladorEmpleados {

      @GetMapping("/empleados")
      public List<Empleado> verEmpleados(){
          return empleadoService.getAllEmpleado();
      }

      @PostMapping("/empleados")
      public Optional<Empleado> guardarEmpleado(@RequestBody Empleado empl){
          return Optional.ofNullable(this.empleadoService.saveOrUpdateEmpleado(empl));
      }
      @GetMapping(path = "empleados/{id}")
      public Optional<Empleado> empleadoPorID(@PathVariable("id") Integer id){
          return this.empleadoService.getEmpleadoById(id);
      }

      @GetMapping("/enterprises/{id}/empleados")
      public ArrayList<Empleado> EmpleadoPorEmpresa(@PathVariable("id") Integer id){
          return this.empleadoService.obtenerPorEmpresa(id);
      }

      @PatchMapping("/empleados/{id}")
      public Empleado actualizarEmpleado(@PathVariable("id") Integer id, @RequestBody Empleado empleado){
          Empleado empl=empleadoService.getEmpleadoById(id).get();
          empl.setNombre(empleado.getNombre());
          empl.setCorreo(empleado.getCorreo());
          empl.setEmpresa(empleado.getEmpresa());
          empl.setRol(empleado.getRol());
          return empleadoService.saveOrUpdateEmpleado(empl);
      }

      @DeleteMapping("/empleados/{id}")
      public String DeleteEmpleado(@PathVariable("id") Integer id){
          boolean respuesta=empleadoService.deleteEmpleado(id);
          if (respuesta){
              return "Se pudo eliminar correctamente el empleado con identificacion "+id;
          }
          return "No se puedo eliminar correctamente el empleado con identificacion"+id;
      }
  }