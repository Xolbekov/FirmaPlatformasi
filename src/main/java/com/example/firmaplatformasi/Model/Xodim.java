package com.example.firmaplatformasi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Xodim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String fish;

    @Column(nullable = false)
    public String lavozim;

    @Email
    @Column(nullable = false, unique = true)
    public String email;

    public String emailCode;

    @Size(min = 8)
    public String parol;


    @OneToOne
    private Roles roles;

    @OneToMany(mappedBy = "xodim",cascade = CascadeType.ALL)
    List<Vazifa> vazifa;
}
