package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws SQLException {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        VillageDao villageDAO = (VillageDao) context.getBean("villageDAO");
        villageDAO.save();
        villageDAO.selectFirstRow();
        context.registerShutdownHook();
    }
}