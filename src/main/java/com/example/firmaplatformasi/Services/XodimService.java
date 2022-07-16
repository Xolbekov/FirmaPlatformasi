package com.example.firmaplatformasi.Services;

import com.example.firmaplatformasi.DTO.XodimIDDTO;
import com.example.firmaplatformasi.Model.Roles;
import com.example.firmaplatformasi.Model.Xodim;
import com.example.firmaplatformasi.Repositary.RolRepositary;
import com.example.firmaplatformasi.Repositary.XodimRepositary;
import com.example.firmaplatformasi.Rollar.RolNomlari;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class XodimService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    RolRepositary rolRepositary;

    @Autowired
    XodimRepositary xodimRepositary;

    public List<Xodim> xodimM(XodimIDDTO xodimIDDTO){
        Optional<Roles> optionalRoles=rolRepositary.findById(xodimIDDTO.getId());
        List<Xodim> staffList1=xodimRepositary.findAll();
        List<Xodim> staffList=new ArrayList<>();
        if (optionalRoles.get().getRoleName().equals(RolNomlari.DIRECTOR) ){
            return xodimRepositary.findAll();

        } else if (optionalRoles.get().getRoleName().equals(RolNomlari.MANAGER)) {
            for (Xodim i:staffList1) {
                if (i.getRoles().getRoleName().equals(RolNomlari.USER))
                    staffList.add(i);
            }
            return  staffList;
        }
        return null;
    }

//    public boolean emailVerification(String userEmail, String userCode){
//        try {
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//            mailMessage.setFrom("farxodabdualiyev2912@gmail.com");
//            mailMessage.setTo(userEmail);
//            mailMessage.setSubject("Email verification");
//            mailMessage.setText("<a href='http://localhost:8080/auth/emailConfirm?userCode="+userCode+"&userEmail="+userEmail+"'>Confirm email</a>");
//            javaMailSender.send(mailMessage);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
}
