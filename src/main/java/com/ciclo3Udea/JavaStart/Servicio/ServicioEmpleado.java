package com.ciclo3Udea.JavaStart.Servicio;


import com.ciclo3Udea.JavaStart.RepoStart.RepoEmpleado;
import com.ciclo3Udea.JavaStart.entidades.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioEmpleado {
    @Autowired
    RepoEmpleado repoEmpleado;

    //Metodo para ver todos los empleados registrados
    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadoList= new ArrayList<>();
        repoEmpleado.findAll().forEach(empleado -> empleadoList.add(empleado));
        return empleadoList;
    }

    //Metodo para buscar empleados por ID
    public Optional<Empleado> getEmpleadoById(Integer id){ //Existe optional y asi se podria usar

        return repoEmpleado.findById(id);
    }

    //Metodo para buscar empleados por empresa
    public ArrayList<Empleado> obtenerPorEmpresa(Integer id){
        return repoEmpleado.findByEmpresa(id);
    }

    //Metodo para guardar o actualizar registros en Empleados
    public Empleado saveOrUpdateEmpleado(Empleado empleado){
        return repoEmpleado.save(empleado);
    }

    //Metodo para eliminar un registro de Empleado por Id
    public boolean deleteEmpleado(Integer id){
        repoEmpleado.deleteById(id);
        if(this.repoEmpleado.findById(id).isPresent()){
            return false;
        }
        return true;
    }

}
