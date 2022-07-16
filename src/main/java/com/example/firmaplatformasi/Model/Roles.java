package com.example.firmaplatformasi.Model;

import com.example.firmaplatformasi.Rollar.RolNomlari;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RolNomlari roleName;

    @Override
    public String getAuthority() {
        return roleName.toString();
    }
}

