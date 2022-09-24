package com.ciclo3Udea.JavaStart.Servicio;

import com.ciclo3Udea.JavaStart.RepoStart.RepoEmpresa;
import com.ciclo3Udea.JavaStart.entidades.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioEmpresa {
    @Autowired
    RepoEmpresa repoEmpresa;

    // Método para retornar la lista de empresas mediante metodos heredados de jpaRepository
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        repoEmpresa.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }

// Metodo que me trae un objeto de tipo empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Integer id){
        return repoEmpresa.findById(id).get();
    }

    // Metodo para guardar o actualizar objetos de tipo empresa
    public Empresa saveOrUpdateEmpresa(Empresa empresa){
        Empresa emp = repoEmpresa.save(empresa);
        return emp;
        }


// Metodo para eliminar empresas
    public boolean borrarEmpresa(Integer id){
        repoEmpresa.deleteById(id);

        if (repoEmpresa.findById(id) !=null){
            return true;
        }
        return false;

    }


}
