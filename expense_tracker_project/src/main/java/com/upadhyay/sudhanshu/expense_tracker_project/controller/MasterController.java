package com.upadhyay.sudhanshu.expense_tracker_project.controller;

import com.upadhyay.sudhanshu.expense_tracker_project.Service.ExpenseService;
import com.upadhyay.sudhanshu.expense_tracker_project.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/apl/v1")
public class MasterController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> get(){
        List<Expense> expenses=expenseService.findAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
    @PostMapping("/expenses")
    public ResponseEntity<Expense> save(@RequestBody Expense expense){
        Expense e=expenseService.save(expense);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
    @GetMapping ("/expenses/{id}")
    public ResponseEntity<Expense> getId(@PathVariable("id") Integer id){
        Expense e=expenseService.findById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
    @DeleteMapping ("/expenses/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        expenseService.delete(id);
        return new ResponseEntity<String>("expense is deleted successfully", HttpStatus.OK);
    }
//
//    @RequestMapping("/")
//    public ModelAndView home() {
//        ModelAndView mov = new ModelAndView("home");
//        mov.addObject("message", "list of expenses");
//
//        List<Expense> expenses = expenseService.findAll();
//       mov.addObject("expenses",expenses);
//
//        return mov;
//    }
//    @RequestMapping("/expense")
//    public ModelAndView addExpense() {
//        ModelAndView mov = new ModelAndView("expense");
//        mov.addObject("expense", new Expense());
//        return mov;
//    }
//    @RequestMapping(value = "/expense",method = RequestMethod.POST)
//    public String save(@ModelAttribute("expense") Expense expense) {
//        expenseService.save(expense);
//        return "redirect:/";
//    }
}
