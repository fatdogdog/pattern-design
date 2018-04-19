package cn.lger.dao;

import cn.lger.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

//@Repository
//@Service("Quick1")
@Component("supermember")
public class implement_adminDao1 implements AdminDao1{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Admin findByUsernameAndPassword1(String username, String password) {
        List<Admin> list = jdbcTemplate.query("select * from admin where username = ? AND password = ? AND type = 2", new Object[]{username,password}, new BeanPropertyRowMapper(Admin.class));
        if(list!=null && list.size()>0){
            Admin account = list.get(0);
            return account;
        }else{
            return null;
        }
    }
}
