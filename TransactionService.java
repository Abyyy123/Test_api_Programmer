package com.example.Testimoni.Service;

import com.example.Testimoni.Model.Transaction;
import com.example.Testimoni.Model.wallet;
import com.example.Testimoni.Repository.TransactionRepository;
import com.example.Testimoni.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletRepository walletRepository;

    public Transaction makeTransaction(Long userId, Double amount, String description) {
        wallet wallet = walletRepository.findByUserId(userId);

        if (wallet != null && wallet.getBalance() >= amount) {
            wallet.setBalance(wallet.getBalance() - amount);
            walletRepository.save(wallet);

            Transaction transaction = new Transaction();
            transaction.setUser(wallet.getUser());
            transaction.setAmount(amount);
            transaction.setDescription(description);

            return transactionRepository.save(transaction);
        }
        return null;
    }
}
