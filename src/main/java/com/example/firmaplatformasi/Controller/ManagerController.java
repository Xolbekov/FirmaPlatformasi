package com.example.firmaplatformasi.Controller;

import com.example.firmaplatformasi.DTO.ApiResponse;
import com.example.firmaplatformasi.DTO.XodimDTO;
import com.example.firmaplatformasi.Model.Vazifa;
import com.example.firmaplatformasi.Model.Xodim;
import com.example.firmaplatformasi.Repositary.VazifaRepositary;
import com.example.firmaplatformasi.Repositary.XodimRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ManagerController")
public class ManagerController {


    @Autowired
    XodimRepositary xodimRepositary;

    @Autowired
    VazifaRepositary vazifaRepositary;

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/xodim")
    public ApiResponse insertXodim(@RequestBody XodimDTO xodimDTO){
        Xodim xodim1=new Xodim();
        xodim1.setFish(xodimDTO.getFish());
        xodim1.setLavozim(xodimDTO.getLavozim());
        xodim1.setEmail(xodimDTO.getEmail());
        xodim1.setEmailCode(UUID.randomUUID().toString());
        List<Vazifa> vazifaList=new ArrayList<>();
        for (Vazifa vazifa:xodimDTO.getVazifaList()) {
            Vazifa vazifa1=new Vazifa(vazifa.getVazifaNomi(),vazifa.getVazifaIzoh(),vazifa.getVazifaBVaqt(),xodim1);
            vazifaList.add(vazifa1);
        }
        xodim1.setVazifa(vazifaList);
        boolean verification = emailVerification(xodim1.getEmail(), xodim1.getEmailCode());
        if (verification){
            xodimRepositary.save(xodim1);
            //ApiResponse("Xodim ro'yxatdan o'tdi emailga biz habar yuboramiz", true);
            return new ApiResponse("Emailga biz habar yubordik",true);
        }
        return new ApiResponse("Mavjud emas",false);
    }

    @PostMapping("/vazifa")
    public HttpEntity<?> insertVazifa(@RequestBody Vazifa vazifa){
        Vazifa vazifa1=new Vazifa();
        vazifa1.setVazifaNomi(vazifa.getVazifaNomi());
        vazifa1.setVazifaIzoh(vazifa.getVazifaIzoh());
        vazifa1.setVazifaBVaqt(vazifa.getVazifaBVaqt());
        vazifaRepositary.save(vazifa1);
        return ResponseEntity.ok().body("Saqlandi!");
    }

    public boolean emailVerification(String userEmail, String userCode){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("axsoserver@gmail.com");
            mailMessage.setTo(userEmail);
            mailMessage.setSubject("Email verification");
            mailMessage.setText("<a href='http://localhost:8080/auth/emailConfirm?userCode="+userCode+"&userEmail="+userEmail+"'>Confirm email</a>");
            javaMailSender.send(mailMessage);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
