/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Hardik
 */
public class circleDAOimpl {

    private Circle c;
    private DataSource ds;

    Connection con;
    Statement st;
    ResultSet rs;

    public Circle getC() {
        return c;
    }

    public void setC(Circle c) {
        this.c = c;
    }

    public DataSource getDs() {
        return ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }

    public void getConn() {

        try {
            con = ds.getConnection();
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void createCircle() {

        try {

            getConn();

            String sql = "CREATE TABLE circle("
                    + "c_id INTEGER,"
                    + "c_name VARCHAR(20))";

            st.execute(sql);

            System.out.println("....Table Created....");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertCircle() {

        try {
            getConn();

            int id = getC().getC_id();
            String nm = getC().getC_name();

            System.out.println("id .:" + id);
            System.out.println("name .:" + nm);

            String sql = "INSERT INTO circle VALUES(" + id + ",'" + nm + "')";

            int i = st.executeUpdate(sql);

            if (i > 0) {
                System.out.println(".....1 Record Inserted.....");
            } else {
                System.out.println(".....Error.....");
            }

        } catch (SQLException ex) {

            System.out.println(ex);
        }
    }

    public void getCircleForID(int id) {

        try {
            getConn();

            String sql = "SELECT * FROM circle WHERE c_id = ?";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();
            System.out.println("-----------------------");
            System.out.println("ID\tNAME");
            System.out.println("-----------------------");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
            }
            System.out.println("-----------------------");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void getCircle() {

        try {
            getConn();

            String sql = "SELECT * FROM circle";

            rs = st.executeQuery(sql);

            System.out.println("-----------------------");
            System.out.println("ID\tNAME");
            System.out.println("-----------------------");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
            }
            System.out.println("-----------------------");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
