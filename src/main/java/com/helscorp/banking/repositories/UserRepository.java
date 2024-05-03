package com.helscorp.banking.repositories;

import com.helscorp.banking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {

    /**********************************spring data pattern (sdp)*************************************/
    //select * from user where firstName = :firstName
    public List<User> findAllByFirstName(String firstName);


    //select * from user where firstName  like '%max%'
    public List<User> findAllByFirstNameContaining(String firstName);

    //select * from user u inner join account a on a.id = u.id_account where and a.iban = '1234567254127'
    public List<User> findAllByAccountIban(String iban);


    //select * from user where firstName like '%firsName%' and email = :email
    public List<User> findAllByFirstNameContainingIgnoreCaseAndEmail(String firstName , String email);

    /**********************************@Query for using jpql (jackarta persistence api query language) *************************************/
    @Query("from User where firstName = :firstName")
    public List<User> searchByFirstName(String firstName);

    //select * from user where firstName  like '%max%'
    @Query("from User where firstName like '%:firstName@'")
    public List<User> searchAllByFirstNameContaining(String firstName);

    //select * from user u inner join account a on a.id = u.id_account where and a.iban = '1234567254127'
    @Query("from User u inner join Account a on a.id = u.id_account where a.iban = :iban")
    public List<User> searchByAccountIban(String iban);


    /********************************* native query with @Query *************************************/

    @Query(value = "select * from user where firstName = :firstName",nativeQuery = true)
    public List<User> searchByFirstNameNative(String firstName);

    //select * from user where firstName  like '%max%'
    @Query(value = "select * from user where firstName like '%:firstName@'",nativeQuery = true)
    public List<User> searchAllByFirstNameContainingNative(String firstName);

    //select * from user u inner join account a on a.id = u.id_account where and a.iban = '1234567254127'
    @Query(value = "select * from user u inner join account a on a.id = u.id_account where a.iban = :iban",nativeQuery = true)
    public List<User> searchByAccountIbanNative(String iban);




}
