package ServiciosUsuario;

import java.util.List;


public interface InterServiciosUsuario {

    public list<User> getAll;
    //interfaz creacion
    List<User> findall();
    //consultar todos los usuarios
    public User findByID(long id);
    //buscar solo una empresa
    public User create(User prmUser);
    //crear un usuario
    public User update(long, id, User, prmUser);
    // Editar un usuario
    public void deleteById(long id);
    // Eliminar un usuario
}



