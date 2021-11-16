package com.deniz.sfgpetclinic.services;

import com.deniz.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
