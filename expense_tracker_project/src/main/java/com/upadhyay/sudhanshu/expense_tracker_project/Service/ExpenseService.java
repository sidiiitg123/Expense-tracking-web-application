package com.upadhyay.sudhanshu.expense_tracker_project.Service;

import com.upadhyay.sudhanshu.expense_tracker_project.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAll();
    Expense save(Expense expense);
    Expense findById(Integer id);
    void delete(Integer id);
}
