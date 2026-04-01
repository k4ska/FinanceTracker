package com.oskar.finance_tracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.oskar.finance_tracker.model.Transaction;
import com.oskar.finance_tracker.model.TransactionType;
import com.oskar.finance_tracker.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

  @Mock
  private TransactionRepository repository;

  @InjectMocks
  private TransactionService service;

  @Test
  public void testGetBalance_CalculatesCorrectly() {
    Transaction t1 = new Transaction(1L, "Salary", 5000.0, null, TransactionType.INCOME);
    Transaction t2 = new Transaction(2L, "Groceries", 150.0, null, TransactionType.EXPENSE);
    when(repository.findAll()).thenReturn(Arrays.asList(t1, t2));

    Double balance = service.getBalance();
    assertEquals(4850.0, balance);

  }
}
