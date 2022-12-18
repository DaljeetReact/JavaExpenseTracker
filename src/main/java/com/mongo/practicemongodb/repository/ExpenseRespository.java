package com.mongo.practicemongodb.repository;

import com.mongo.practicemongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRespository  extends MongoRepository<Expense,String> {
    Optional<Expense> findByName(String name);
}
