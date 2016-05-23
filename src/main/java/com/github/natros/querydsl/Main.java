package com.github.natros.querydsl;

import com.github.natros.querydsl.entities.Master;
import com.github.natros.querydsl.entities.QMaster;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;

import javax.sql.DataSource;
import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        SQLQueryFactory queryFactory = new SQLQueryFactory(new Configuration(MySQLTemplates.DEFAULT), dataSource());
        List<Master> list = queryFactory.selectFrom(QMaster.master).fetch();
    }

    private static DataSource dataSource() {
        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/master?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root123");
        return ds;
    }
}
