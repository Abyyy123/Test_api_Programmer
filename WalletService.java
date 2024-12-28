package com.example.Testimoni.Service;

import com.example.Testimoni.Model.wallet;
import com.example.Testimoni.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;

    public wallet checkBalance(Long userId){
        return walletRepository.findByUserId(userId);
    }

    public wallet topUpBalance(Long userId, Double amount){
        wallet wallet = walletRepository.findByUserId(userId);

        if (wallet != null){
            wallet.setBalance(wallet.getBalance() + amount);
            return walletRepository.save(wallet);
        }
        return null;
    }
}
