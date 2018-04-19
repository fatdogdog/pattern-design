package cn.lger.dao;

import cn.lger.domain.Member;
import org.springframework.stereotype.Repository;

/**
 * Code that Changed the World
 * Pro said
 * Created by Pro on 2017-12-13.
 */
@Repository
//JpaRepository<T, ID extends Serializable>  T为实体类，ID为主键类型
public interface GoodsmanagementDao {


        Member save(String username, String password);
}
