package com.ExpenseTracker.ExpenseTracker.Controller;

import com.ExpenseTracker.ExpenseTracker.Domain.Expenses;
import com.ExpenseTracker.ExpenseTracker.Service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/getAllExpenses")
    public ResponseEntity<List<Expenses>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @PostMapping("/saveExpenses")
    public ResponseEntity<Expenses> saveExpenses(@RequestBody Expenses expenses){
        //Expenses expenses = new Expenses("Grocery", "Grocery shopping", "Grocery", 100, new Date());
        expenseService.saveExpenses(expenses);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/getExpense/{id}")
    public ResponseEntity<Expenses> getExpenseById(@PathVariable String id){
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @DeleteMapping("/deleteExpenseById/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable String id){
        return ResponseEntity.ok(expenseService.deleteExpensesById(id));
    }

    @PutMapping("/updateExpenseById/{id}")
    public ResponseEntity<Expenses> updateExpenseById(@PathVariable String id ,@RequestBody Expenses expenses){
        return ResponseEntity.ok(expenseService.updateExpenseById(id,expenses));
    }
}
