package com.helscorp.banking.repositories;

import com.helscorp.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<String> findByIban(String iban);
}
