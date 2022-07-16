package com.example.firmaplatformasi.DTO;

import com.example.firmaplatformasi.Model.Vazifa;
import lombok.Data;

import java.util.List;

@Data
public class XodimDTO {
    public String fish;
    public String lavozim;
    public String email;
    public String emailCode;
    public String parol;
    List<Vazifa> vazifaList;
}
