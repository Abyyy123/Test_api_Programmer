package com.example.Testimoni.Controller;

import com.example.Testimoni.Model.wallet;
import com.example.Testimoni.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Testimoni/wallets")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/{userId}")
    public wallet checkBalance(@PathVariable Long userId) {
        return walletService.checkBalance(userId);
    }

    @PostMapping("/topup")
    public wallet topUpBalance(@RequestParam Long userId, @RequestParam Double amount) {
        return walletService.topUpBalance(userId, amount);
    }
}
