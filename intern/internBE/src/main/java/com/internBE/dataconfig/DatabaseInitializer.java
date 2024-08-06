package com.internBE.dataconfig;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        // Execute your SQL code here
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS loaigiaodich (\n" +
                "    maLoaigiaodich BIGINT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    tenLoaigiaodich VARCHAR(255))");

        jdbcTemplate.execute("INSERT INTO loaigiaodich (maLoaigiaodich, tenLoaigiaodich)\n" +
                "SELECT NULL, 'Nhà'\n" +
                "FROM DUAL\n" +
                "WHERE NOT EXISTS (\n" +
                "    SELECT 1\n" +
                "    FROM loaigiaodich\n" +
                "    WHERE tenLoaigiaodich = 'Nhà'\n" +
                ");");

        jdbcTemplate.execute("INSERT INTO loaigiaodich (maLoaigiaodich, tenLoaigiaodich)\n" +
                "SELECT NULL, 'Nhà Và Đất'\n" +
                "FROM DUAL\n" +
                "WHERE NOT EXISTS (\n" +
                "    SELECT 1\n" +
                "    FROM loaigiaodich\n" +
                "    WHERE tenLoaigiaodich = 'Nhà Và Đất'\n" +
                ");");

//        jdbcTemplate.execute("INSERT INTO loaigiaodich (maLoaigiaodich, tenLoaigiaodich)\n" +
//                "SELECT NULL, 'Nhà'\n" +
//                "FROM DUAL\n" +
//                "WHERE NOT EXISTS (\n" +
//                "    SELECT 1\n" +
//                "    FROM loaigiaodich\n" +
//                "    WHERE tenLoaigiaodich = 'Nhà'\n" +
//                ");");

//        jdbcTemplate.execute("INSERT INTO role (role_id, roleName, description)\n" +
//                "SELECT NULL, 'Leader', 'NULL'\n" +
//                "FROM DUAL\n" +
//                "WHERE NOT EXISTS (\n" +
//                "    SELECT 1\n" +
//                "    FROM role\n" +
//                "    WHERE roleName = 'Leader'\n" +
//                ");");
//
//        jdbcTemplate.execute("INSERT INTO role (role_id, roleName, description)\n" +
//                "SELECT NULL, 'Owner', 'NULL'\n" +
//                "FROM DUAL\n" +
//                "WHERE NOT EXISTS (\n" +
//                "    SELECT 1\n" +
//                "    FROM role\n" +
//                "    WHERE roleName = 'Owner'\n" +
//                ");");
    }
}
