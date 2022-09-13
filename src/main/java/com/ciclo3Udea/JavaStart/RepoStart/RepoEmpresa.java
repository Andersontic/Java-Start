package com.ciclo3Udea.JavaStart.RepoStart;

import com.ciclo3Udea.JavaStart.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoEmpresa extends JpaRepository<Empresa, Integer> {
}
