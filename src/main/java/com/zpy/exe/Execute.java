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

import com.zpy.dao.ClientsMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class Execute {
    public String resources="com/zpy/exe/mybatis-config.xml";
    public SqlSession init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        return session;
    }

    public static void main(String[] args) throws IOException{
        Execute exe = new Execute();
        SqlSession session = exe.init();
        try{
            ClientsMap map=session.getMapper(ClientsMap.class);
            HashMap hashMap=map.selectClient("150402196910041536");
            System.out.println(hashMap);
        }finally{
            session.close();
        }
    }
}
