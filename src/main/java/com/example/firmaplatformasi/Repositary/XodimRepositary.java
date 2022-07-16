package com.example.firmaplatformasi.Repositary;

import com.example.firmaplatformasi.Model.Xodim;
import org.springframework.data.jpa.repository.JpaRepository;

public interface XodimRepositary extends JpaRepository<Xodim,Integer> {
    Xodim findByEmailAndParol(String email,String parol);
    Xodim findByEmail(String email);
    boolean existsByLavozim(String lavozim);
}
