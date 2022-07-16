package com.example.firmaplatformasi.Controller;

import com.example.firmaplatformasi.Model.Vazifa;
import com.example.firmaplatformasi.Model.Xodim;
import com.example.firmaplatformasi.Repositary.VazifaRepositary;
import com.example.firmaplatformasi.Repositary.XodimRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/RaxbarController")
public class RaxbarController {


    @Autowired
    XodimRepositary xodimRepositary;

    @Autowired
    VazifaRepositary vazifaRepositary;

    @PostMapping("/vazifa")
    public HttpEntity<?> insertVazifa(@RequestBody Vazifa vazifa){
        Vazifa vazifa1=new Vazifa();
        vazifa1.setVazifaNomi(vazifa.getVazifaNomi());
        vazifa1.setVazifaIzoh(vazifa.getVazifaIzoh());
        vazifa1.setVazifaBVaqt(vazifa.getVazifaBVaqt());
        vazifaRepositary.save(vazifa1);
        return ResponseEntity.ok().body("Saqlandi!");
    }

}
