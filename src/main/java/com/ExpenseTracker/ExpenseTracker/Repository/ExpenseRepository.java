package com.ExpenseTracker.ExpenseTracker.Repository;

import com.ExpenseTracker.ExpenseTracker.Domain.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expenses, Long> {

}
