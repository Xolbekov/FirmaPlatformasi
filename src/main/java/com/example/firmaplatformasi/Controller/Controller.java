package com.example.firmaplatformasi.Controller;

import com.example.firmaplatformasi.DTO.XodimDTO;
import com.example.firmaplatformasi.Model.Xodim;
import com.example.firmaplatformasi.Repositary.VazifaRepositary;
import com.example.firmaplatformasi.Repositary.XodimRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Controller {

    @Autowired
    XodimRepositary xodimRepositary;

    @Autowired
    VazifaRepositary vazifaRepositary;

    @Autowired
    JavaMailSender javaMailSender;


    @PostMapping("/insert")
    public HttpEntity<?> direktor(@RequestBody XodimDTO dto){
        if (dto.getLavozim().equals("Direktor") && xodimRepositary.existsByLavozim(dto.getLavozim())){
            Xodim xodim=new Xodim();
            xodim.setFish(dto.getFish());
            xodim.setLavozim(dto.getLavozim());
            xodim.setEmail(dto.getEmail());
            xodim.setParol(dto.getParol());
            xodimRepositary.save(xodim);
            return ResponseEntity.ok().body("Saqlandi!");
        } else {
            if (xodimRepositary.existsByLavozim("Direktor")){

            }
        }
        return ResponseEntity.ok().body("Saqlanmadi!");
    }



}
