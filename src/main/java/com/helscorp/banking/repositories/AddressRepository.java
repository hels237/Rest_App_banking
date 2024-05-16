package com.helscorp.banking.repositories;

import com.helscorp.banking.dto.AddressDto;
import com.helscorp.banking.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
