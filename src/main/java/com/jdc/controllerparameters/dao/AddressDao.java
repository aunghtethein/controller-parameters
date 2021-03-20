package com.jdc.controllerparameters.dao;

import com.jdc.controllerparameters.ds.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends CrudRepository<Address, Integer> {
}
