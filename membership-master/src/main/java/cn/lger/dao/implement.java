package cn.lger.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import cn.lger.domain.Admin;
import cn.lger.dao.AdminDao1;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
//@Repository
//@Service("Quick")
@Component("member")
public class implement implements AdminDao1{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Admin findByUsernameAndPassword1(String username, String password) {
        List<Admin> list = jdbcTemplate.query("select * from admin where username = ? AND password = ? AND type = 1", new Object[]{username,password}, new BeanPropertyRowMapper(Admin.class));
        if(list!=null && list.size()>0){
            Admin account = list.get(0);
            return account;
        }else{
            return null;
        }
    }
}
