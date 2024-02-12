package com.example;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {

    private static SqlSessionFactory factory = null;

    public SqlSessionTemplate() {
        // TODO Auto-generated constructor stub
    }

    public static SqlSessionFactory setSqlSessionFactory() {

        //1. 트랜잭션이 설정되어 있는 파일의 경로를 정의
        String resource = "com/config/SqlConfig.xml";
        System.out.println();

        //2. 설정파일(configuration.xml) 로딩을 위한 입출력 스트림과 연결
        try(Reader reader = Resources.getResourceAsReader(resource)) {

            //3. 설정파일값을 저장하기 위한 SqlSessionFactory를 설정해 줄 SqlSessionFactoryBuilder를 생성
            SqlSessionFactoryBuilder sqlBuilder = new SqlSessionFactoryBuilder();

            //4. sqlBuilder가 설정파일의 정보를 읽어와 SqlSessionFactory로 생성
            factory = sqlBuilder.build(reader);

        } catch(IOException e) {
            e.printStackTrace();
        }

        return factory;
    }//setSqlSessionFactory()

    public static SqlSession getSqlSession() {

        if(setSqlSessionFactory() == null) {
            factory = setSqlSessionFactory();
        }

        //5. 쿼리문에 접근할 수 있도록 sqlSession객체를 리턴
        return factory.openSession(true); //자동커밋 해제(false)
    }//getSqlSession()

}//class SqlSessionTemplate