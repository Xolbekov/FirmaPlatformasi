package com.example.firmaplatformasi.Controller;

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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/DirektorController")
public class DirektorController {

    @Autowired
    XodimRepositary xodimRepositary;

    @Autowired
    VazifaRepositary vazifaRepositary;

    @Autowired
    JavaMailSender javaMailSender;

    @PostMapping("/xodim")
    public HttpEntity<?> insertXodim(@RequestBody XodimDTO xodimDTO){
        Xodim xodim1=new Xodim();
        xodim1.setFish(xodimDTO.getFish());
        xodim1.setLavozim(xodimDTO.getLavozim());
        xodim1.setEmail(xodimDTO.getEmail());
        xodim1.setParol(xodimDTO.getParol());
        xodimRepositary.save(xodim1);
        return ResponseEntity.ok().body("Saqlandi!");
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

    @GetMapping("/select")
    public HttpEntity<?> selectAll()
    {
        return ResponseEntity.ok().body(xodimRepositary.findAll());
    }

//    public boolean EmailgaXabarYuborish(String email,String emailCode){
//        try{
//            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
//            simpleMailMessage.setFrom("TEST@gmail.com");
//            simpleMailMessage.setTo(email);
//            simpleMailMessage.setSubject("http://localhost:8080/XodimController/parol");
//            simpleMailMessage.setText(emailCode);
//            javaMailSender.send(simpleMailMessage);
//            return true;
//        }
//        catch(Exception ex){
//            ex.getStackTrace();
//            return false;
//        }
//    }
}
