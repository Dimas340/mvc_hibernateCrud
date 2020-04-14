package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.Collection;

@Service("MyUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private web.service.Service service;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = service.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException(name);
        }
        return user;
    }
}
