package com.example.firmaplatformasi.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String xabar;
    private Boolean holat;
    private Object object;

    public ApiResponse(String xabar, Boolean holat) {
        this.xabar = xabar;
        this.holat = holat;
    }
}