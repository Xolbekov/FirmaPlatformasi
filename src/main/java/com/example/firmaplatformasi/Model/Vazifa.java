package com.example.firmaplatformasi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vazifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String vazifaNomi;

    @Column(nullable = false)
    public String vazifaIzoh;

    @Column(nullable = false)
    public String vazifaBVaqt;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    Xodim xodim;

    public Vazifa(String vazifaNomi, String vazifaIzoh, String vazifaBVaqt, Xodim xodim) {
        this.vazifaNomi = vazifaNomi;
        this.vazifaIzoh = vazifaIzoh;
        this.vazifaBVaqt = vazifaBVaqt;
        this.xodim = xodim;
    }
}
