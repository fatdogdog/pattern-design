package cn.lger.service;


import cn.lger.dao.AdminDao;
import cn.lger.dao.AdminDao1;
import cn.lger.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import cn.lger.dao.implement;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Service
public class AdminService {

    //@Resource
    private final Map<String, AdminDao1> strategyMap = new ConcurrentHashMap<>();
    @Autowired
   // private AdminDao adminDao;
    public AdminService(Map<String, AdminDao1> strategyMap)
    {   this.strategyMap.clear();
        strategyMap.forEach((k, v)-> this.strategyMap.put(k, v));
        //this.adminDao = adminDao;
    }

    public Admin findAdminByUsernameAndPassword1(String memberLevel,String username, String password){
        return strategyMap.get(memberLevel).findByUsernameAndPassword1(username,password);
    }
}
