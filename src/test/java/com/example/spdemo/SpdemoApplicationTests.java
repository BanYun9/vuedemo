package com.example.spdemo;

import com.example.spdemo.entity.A01;
import com.example.spdemo.mapper.A01Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpdemoApplicationTests {

    @Autowired
    private A01Mapper mapper;

    @Test
    void contextLoads() {
        A01 a01 = mapper.selectOne();
        System.out.println(a01.toString());
    }

    @Test
    public void testJdbc() throws Exception {
        // 1、注册驱动
        Class.forName("dm.jdbc.driver.DmDriver");
        // 2、获取连接
        String url = "jdbc:dm://localhost:5236:DMSERVER";
        String username = "SX_01";
        String password = "beidasoft";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、执行SQL 返回结果
        Statement statement = connection.createStatement();
        String sql = "select * from A01 where a00 = '42AAD005-45BE-AFB6-3908-0085C45FA54C'";
        ResultSet resultSet = statement.executeQuery(sql);
        // 4、处理结果集
        List<A01> a01List = new ArrayList<>();
        while (resultSet.next()) {
            String A00 = resultSet.getString("A00");
            String A0101 = resultSet.getString("A0101");
            String A0104 = resultSet.getString("A0104");
            Date A0107 = resultSet.getDate("A0107");
            A01 a01 = new A01();
            a01.setA00(A00);
            a01.setA0101(A0101);
            a01.setA0104(A0104);
            a01.setA0107(A0107);
            a01List.add(a01);
        }
        // 5、释放资源
        statement.close();
        connection.close();
        resultSet.close();
        for (A01 a01 : a01List) {
            System.out.println(a01);
        }
    }

}
