package com.ciclo3Udea.JavaStart.Servicio;

import com.ciclo3Udea.JavaStart.RepoStart.RepoMovimientos;
import com.ciclo3Udea.JavaStart.entidades.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioMovimientos {
    @Autowired
    RepoMovimientos repoMovimientos;

    public List<MovimientoDinero> getAllMovimientos(){
        List<MovimientoDinero> movimientosList = new ArrayList<>();
        repoMovimientos.findAll().forEach(movimiento -> movimientosList.add(movimiento));
        return movimientosList;
    }

    public MovimientoDinero getMovimientoById(Integer id){
        return repoMovimientos.findById(id).get();
    }

    public MovimientoDinero saveOrUpdateMovimiento(MovimientoDinero movimientoDinero){
        MovimientoDinero mov= repoMovimientos.save(movimientoDinero);
        return mov;
    }

    public boolean deleteMovimiento(Integer id){
        repoMovimientos.deleteById(id);
        if(this.repoMovimientos.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpleado(Integer id) {
        return repoMovimientos.findByEmpleado(id);
    }

    public ArrayList<MovimientoDinero> obtenerPorEmpresa(Integer id) {
        return repoMovimientos.findByEmpresa(id);
    }

}



