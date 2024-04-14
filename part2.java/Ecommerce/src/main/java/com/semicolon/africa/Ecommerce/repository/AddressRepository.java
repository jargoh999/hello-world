package com.semicolon.africa.Ecommerce.repository;
import com.semicolon.africa.Ecommerce.data.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressRepository extends JpaRepository<Address,Long> {
}
