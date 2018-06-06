package com.zpy.exe;

/*
 * mybatis主要的类
 * SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBuilder.build(参数);
 * SqlSession sqlSession=sqlSessionFactory.openSession()
 *
 *
 *
 *
 *
 */

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Execute {


    String xmlResource = "classpath:mybatis-config.xml";
    public void init() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream(xmlResource);
        //inputStream.
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {
            //sqlSession.selectone("");
        }finally {
            sqlSession.close();
        }
    }



}
