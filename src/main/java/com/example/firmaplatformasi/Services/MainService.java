package com.example.firmaplatformasi.Services;

import com.example.firmaplatformasi.Model.Xodim;
import com.example.firmaplatformasi.Repositary.VazifaRepositary;
import com.example.firmaplatformasi.Repositary.XodimRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService  implements UserDetailsService {

    @Autowired
    XodimRepositary xodimRepositary;

    @Autowired
    VazifaRepositary vazifaRepositary;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Xodim> optional = Optional.ofNullable(xodimRepositary.findByEmail(username));
        if (optional.isPresent()){
            return (UserDetails) optional.get();
        }
        throw new UsernameNotFoundException("Ma'lumot topilmadi!");
    }

}
