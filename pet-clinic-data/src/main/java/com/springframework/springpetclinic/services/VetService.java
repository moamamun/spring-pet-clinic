package com.springframework.springpetclinic.services;

import com.springframework.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService extends CrudService<Vet, Long>{

    Vet findByid(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
