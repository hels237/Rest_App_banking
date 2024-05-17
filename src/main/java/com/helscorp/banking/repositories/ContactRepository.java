package com.helscorp.banking.repositories;

import com.helscorp.banking.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
