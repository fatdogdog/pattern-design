package cn.lger.dao;

import cn.lger.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-13.
 */
@Repository
//JpaRepository<T, ID extends Serializable>  T为实体类，ID为主键类型
public interface AdminDao extends JpaRepository<Admin, Integer>{

    Admin findByUsernameAndPassword(String username, String password);

}
