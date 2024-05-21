package com.helscorp.banking.repositories;

import com.helscorp.banking.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

    List<Contact> findAllByUserId(Integer userId);
}
