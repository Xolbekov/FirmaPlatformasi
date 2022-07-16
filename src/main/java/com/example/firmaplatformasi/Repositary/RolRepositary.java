package com.example.firmaplatformasi.Repositary;

import com.example.firmaplatformasi.Model.Roles;
import com.example.firmaplatformasi.Rollar.RolNomlari;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepositary extends JpaRepository<Roles,Integer> {
    Roles findByRoleName(RolNomlari roleName);
}
