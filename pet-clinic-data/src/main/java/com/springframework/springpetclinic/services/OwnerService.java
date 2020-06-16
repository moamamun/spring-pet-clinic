package com.springframework.springpetclinic.services;

import com.springframework.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByid(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
