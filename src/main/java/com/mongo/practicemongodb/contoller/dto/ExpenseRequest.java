package com.mongo.practicemongodb.contoller.dto;

import com.mongo.practicemongodb.model.ExpenseCategories;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExpenseRequest {
    public String name;
    public ExpenseCategories expenseCategories;
    public String amount;
}
