package com.ExpenseTracker.ExpenseTracker.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "expense_name")
    private String expenseName;
    @Column(name = "description")
    private String expenseDescription;
    @Column(name = "category")
    private String expenseCategory;
    @Column(name = "expense_amount")
    private int amount;
    @Column(name = "date")
    private Date date;
}
