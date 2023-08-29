package org.example;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class VillageDao {

    private DataSource dataSource;

    public VillageDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void save() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("insert into village values ('Latur','Maharashtra')");
    }

    public Map<String, String> selectFirstRow() throws SQLException {
        Connection con = dataSource.getConnection();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = st.executeQuery("select * from village");

        Map<String, String> map = new HashMap<>();

        if (rs.next()) {
            map.put("name", rs.getString("name"));
            map.put("district", rs.getString("district"));
        }

        rs.close();
        st.close();
        con.close();

        System.out.println(map);
        return map;


    }

}
