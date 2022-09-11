package ServiciosUsuario;

public interface InterServiciosUsuario {
    //interfaz creacion
    public List<Usuario> findall();
    //consultar todos los usuarios
    public Usuario findByID(long id);
    //buscar solo una empresa
    public Usuario create(Usuario prmUsuario);
    //crear un usuario
    public usuario update(long, id, Usuario, prmUsuario);
    // Editar un usuario
    public void deleteById(long id);
    // Eliminar un usuario
}