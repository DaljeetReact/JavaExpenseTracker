package com.mongo.practicemongodb.contoller;


import com.mongo.practicemongodb.contoller.dto.ExpenseRequest;
import com.mongo.practicemongodb.model.Expense;
import com.mongo.practicemongodb.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {


    @Autowired
    private  ExpenseService expenseService;

    @PostMapping
    public ResponseEntity AddExpense(@RequestBody Expense expense){
        System.out.println(expense);
        expenseService.AddExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity  UpdateExpense(@RequestBody Expense expense){
        expenseService.UpdateExpense(expense);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public List<Expense> GetAllExpenses(){
        return  expenseService.GetAllExpenses();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> GetExpenseByName(@PathVariable String name){
       return  ResponseEntity.ok(expenseService.GetExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity  DeleteExpense(@PathVariable String id){
        expenseService.DeleteExpense(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
