package com.oskar.finance_tracker.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.oskar.finance_tracker.model.Transaction;
import com.oskar.finance_tracker.service.TransactionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {
  private final TransactionService service;

  @GetMapping
  public List<Transaction> getAll() {
    return service.getAllTransactions();
  }

  @PostMapping
  public Transaction create(@RequestBody Transaction transaction) {
    return service.saveTransaction(transaction);
  }

  @GetMapping("/balance")
  public Double getBalance() {
    return service.getBalance();
  }
}
