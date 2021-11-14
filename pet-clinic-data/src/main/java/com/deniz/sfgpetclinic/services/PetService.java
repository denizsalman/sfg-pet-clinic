package com.deniz.sfgpetclinic.services;

import com.deniz.sfgpetclinic.model.Owner;
import com.deniz.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
