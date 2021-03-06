package com.example.demo.Repository;

import com.example.demo.Entity.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard,Long> {
    CreditCard findByCardHolder(String cardHolder);
}
