package com.upadhyay.sudhanshu.expense_tracker_project.Repository;

import com.upadhyay.sudhanshu.expense_tracker_project.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense,Double> {
    Optional<Expense> findById(Integer id);

}
