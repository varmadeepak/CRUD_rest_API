package com.ExpenseTracker.ExpenseTracker.Service;

import com.ExpenseTracker.ExpenseTracker.Domain.Expenses;
import com.ExpenseTracker.ExpenseTracker.Repository.ExpenseRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    public List<Expenses> getAllExpenses(){
        return  expenseRepository.findAll();
    }
    public void saveExpenses(Expenses expenses){
        expenseRepository.save(expenses);
    }
    public Expenses getExpenseById(String Id){
        return expenseRepository.findById(Long.parseLong(Id)).orElseThrow(()->new RuntimeException("Expense not found"));
    }
    public String deleteExpensesById(String id){
        Expenses expense = getExpenseById(id);
        expenseRepository.delete(expense);
        return "Expense deleted successfully";
    }

    public Expenses updateExpenseById(String id,Expenses expenses) {
        Expenses expense = getExpenseById(id);
        expense.setExpenseName(expenses.getExpenseName());
        expense.setExpenseDescription(expenses.getExpenseDescription());
        expense.setExpenseCategory(expenses.getExpenseCategory());
        expense.setAmount(expenses.getAmount());
        expense.setDate(expenses.getDate());
        expenseRepository.save(expense);
        return expense;
    }
}
