package ServiciosUsuario;

import java.util.List;


public interface InterServiciosUsuario {
    //get
    public List<Usuario> getAll();

    //post
    public Usuario create(Usuario usuario);

    //get
    public Usuario getById(long Id);

    //patch
    public Usuario update(long Id, Usuario usuario);

    //delete
    public boolean delete(long Id);
}





