package com.example.Testimoni.Controller;

import com.example.Testimoni.Model.Transaction;
import com.example.Testimoni.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Testimoni/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/")
    public Transaction makeTransaction(@RequestParam Long userId, @RequestParam Double amount, @RequestParam String description) {
        return transactionService.makeTransaction(userId, amount, description);
    }
}
