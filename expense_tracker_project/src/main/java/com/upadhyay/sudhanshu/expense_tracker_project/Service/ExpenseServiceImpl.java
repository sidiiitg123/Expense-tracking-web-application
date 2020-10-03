package com.upadhyay.sudhanshu.expense_tracker_project.Service;

import com.upadhyay.sudhanshu.expense_tracker_project.Repository.ExpenseRepo;
import com.upadhyay.sudhanshu.expense_tracker_project.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{


    @Autowired
    ExpenseRepo expenseRepo;

    @Override
    public List<Expense> findAll() {
       return expenseRepo.findAll();
    }

    @Override
    public Expense save(Expense expense) {
        Date currentSqlDate = new Date(System.currentTimeMillis());
        expense.setCreatedAt(currentSqlDate);
        expenseRepo.save(expense);
        return expense;
    }

    @Override
    public Expense findById(Integer id) {
       if(expenseRepo.findById(id).isPresent()){
           return expenseRepo.findById(id).get();

       }
       return null;
    }

    @Override
    public void delete(Integer id) {
        Expense e=findById(id);
        expenseRepo.delete(e);
    }
}
