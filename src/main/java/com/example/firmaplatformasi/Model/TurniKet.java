package com.example.firmaplatformasi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TurniKet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public Integer kirishId;

    @Column(nullable = false)
    public Integer chiqishID;

    @OneToOne
    Xodim  xodim;
}
