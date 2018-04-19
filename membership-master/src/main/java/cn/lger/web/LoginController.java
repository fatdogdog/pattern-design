package cn.lger.web;

import cn.lger.dao.implement_adminDao1;
import cn.lger.domain.Admin;
import cn.lger.dao.AdminDao1;
import cn.lger.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.lger.dao.implement;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-19.
 */
@Controller
//@SpringBootApplication
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AdminService AdminService;
   // @Qualifier("Quick")
   // AdminDao1 adminDao1;
  //  @Autowired
   // @Qualifier("Quick1")
   // AdminDao1 adminDao2;
    //@Resource
    //@Autowired
   // AdminService a= new AdminService(adminDao1);


    @RequestMapping(method = RequestMethod.GET)
    public String getLoginView(HttpServletRequest request){
        if (null != request.getSession().getAttribute("admin")){
            return "index";
        }
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(String username, String password, int type,HttpServletRequest request){

        if (null != request.getSession().getAttribute("admin"))
            return "index";
        else {
            Admin admin = null;
            System.out.println(type);
            if (type == 1){

            String member = "member";
             admin = AdminService.findAdminByUsernameAndPassword1(member,username, password);}
            else {

                String member = "supermember";
                admin = AdminService.findAdminByUsernameAndPassword1(member,username, password);}
            if (admin != null)
                request.getSession().setAttribute("admin", admin);

            else {
                request.setAttribute("msg", "用户不存在或者密码错误！");
               // request.setAttribute("msg", type);
                return "login";
            }
        }
        return "index";
    }
}
