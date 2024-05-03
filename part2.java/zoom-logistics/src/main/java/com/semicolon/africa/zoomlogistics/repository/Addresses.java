package com.semicolon.africa.zoomlogistics.repository;

import com.semicolon.africa.zoomlogistics.data.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addresses extends JpaRepository<Address,Long> {
     Address findAddressById(Long id);
}
