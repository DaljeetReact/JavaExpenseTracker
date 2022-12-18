package com.mongo.practicemongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@Document("expense")
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    @Field(name = "category")
    private ExpenseCategories expenseCategories;
    private BigDecimal amount;
}
