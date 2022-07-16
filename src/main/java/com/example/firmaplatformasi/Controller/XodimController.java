package com.example.firmaplatformasi.Controller;

import com.example.firmaplatformasi.DTO.XodimDTO;
import com.example.firmaplatformasi.DTO.XodimIDDTO;
import com.example.firmaplatformasi.Model.Roles;
import com.example.firmaplatformasi.Model.Vazifa;
import com.example.firmaplatformasi.Model.Xodim;
import com.example.firmaplatformasi.Repositary.RolRepositary;
import com.example.firmaplatformasi.Repositary.VazifaRepositary;
import com.example.firmaplatformasi.Repositary.XodimRepositary;
import com.example.firmaplatformasi.Rollar.RolNomlari;
import com.example.firmaplatformasi.Services.XodimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/XodimController")
public class XodimController {

    @Autowired
    XodimRepositary xodimRepositary;

    @Autowired
    VazifaRepositary vazifaRepositary;

    @Autowired
    RolRepositary rolRepositary;

    @Autowired
    XodimService xodimService;

    @GetMapping("/vazifa")
    public HttpEntity<?> selectVazifa(@PathVariable String login,@PathVariable String paroli){
        Xodim xodim = xodimRepositary.findByEmailAndParol(login,paroli);
        if (xodim.getId()>0){
            return ResponseEntity.ok().body(vazifaRepositary.findByXodim(xodim));
        }
        return ResponseEntity.ok("Topilmadi!");
    }

    @PostMapping("/xodim")
    public HttpEntity<?> xodimM(@RequestBody XodimIDDTO xodimIDDTO){
        return ResponseEntity.ok(xodimService.xodimM(xodimIDDTO));
    }
}
