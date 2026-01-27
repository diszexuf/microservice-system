package com.github.diszexuf.personservice.repository;

import com.github.diszexuf.personservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
