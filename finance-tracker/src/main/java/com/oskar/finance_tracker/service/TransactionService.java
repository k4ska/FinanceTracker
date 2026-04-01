package com.oskar.finance_tracker.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.oskar.finance_tracker.model.Transaction;
import com.oskar.finance_tracker.model.TransactionType;
import com.oskar.finance_tracker.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final TransactionRepository repository;

  public List<Transaction> getAllTransactions() {
    return repository.findAll();
  }

  public Transaction saveTransaction(Transaction transaction) {
    return repository.save(transaction);
  }

  public Double getBalance() {
    List<Transaction> transactions = repository.findAll();
    return transactions.stream()
        .mapToDouble(t -> t.getType() == TransactionType.INCOME ? t.getAmount() : -t.getAmount())
        .sum();
  }
}
