package cn.lger.dao;

import cn.lger.domain.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

//@Repository
//@Service("Quick")
@Component("addgood")
public class addgood implements GoodDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int operation(Good good) {
        return jdbcTemplate.update("insert into good(good_integral, good_name, good_number,good_price) values(?, ?, ?,?)",
                good.getGoodIntegral(),good.getGoodName(),good.getGoodNumber(),good.getGoodPrice());

    }}
