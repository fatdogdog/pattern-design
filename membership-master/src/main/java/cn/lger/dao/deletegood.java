package cn.lger.dao;

import cn.lger.domain.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Repository
//@Service("Quick")
@Component("deletegood")
public class deletegood implements GoodDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int operation(Commodity ommodity) {
        return jdbcTemplate.update("DELETE from commodity where id = ? ",ommodity.getId());

    }}
