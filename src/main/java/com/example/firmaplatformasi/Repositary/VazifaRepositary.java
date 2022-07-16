package com.example.firmaplatformasi.Repositary;

import com.example.firmaplatformasi.Model.Vazifa;
import com.example.firmaplatformasi.Model.Xodim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VazifaRepositary extends JpaRepository<Vazifa,Integer> {
    Optional<Vazifa> findByXodim(Xodim xodim);
}
