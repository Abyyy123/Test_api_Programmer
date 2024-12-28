package com.example.Testimoni.Repository;

import com.example.Testimoni.Model.wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<wallet, Long> {
    wallet findByUserId(Long UserId);
}
