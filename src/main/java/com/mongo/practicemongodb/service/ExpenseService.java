package com.mongo.practicemongodb.service;

import com.mongo.practicemongodb.model.Expense;
import com.mongo.practicemongodb.repository.ExpenseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseRespository expenseRespository;

    public void  AddExpense(Expense expenseRequest){
       expenseRespository.save(expenseRequest);
    }

    public void  UpdateExpense(Expense expense){
        Expense savedExpense = expenseRespository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Canot find the Expense id %d",expense.getId())
                ));

        savedExpense.setExpenseCategories(expense.getExpenseCategories());
        savedExpense.setName(expense.getName());
        savedExpense.setAmount(expense.getAmount());

        expenseRespository.save(savedExpense);
    }

    public List<Expense> GetAllExpenses(){
      return expenseRespository.findAll();
    }

    public Expense GetExpenseByName(String name){
        return   expenseRespository.findByName(name).orElseThrow(()-> new RuntimeException(
                String.format("Not data Found with this id %s",name )
        ));
    }

    public void  DeleteExpense(String id){
      expenseRespository.deleteById(id);
    }

}
