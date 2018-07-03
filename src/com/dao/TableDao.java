package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.domain.Table;
import com.utils.JDBCUtils;
public class TableDao {
    public boolean insert(Table table) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        conn = JDBCUtils.getConnection();
        stmt = conn.createStatement();
        String sql = "INSERT INTO `table` (oid, number,places, used) "+
                    "VALUES("
                    + table.getOid()
                    + ","
                    + table.getNumber()
                    + ","
                    + table.getPlaces()
                    + ","
                    + table.getUsed()
                    + ")";
            int num = stmt.executeUpdate(sql);
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return false;
    }
    public ArrayList<Table> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Table> list = new ArrayList<Table>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `table`";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Table table = new Table();
                table.setOid(rs.getInt("oid"));
                table.setNumber(rs.getInt("number"));
                table.setUsed(rs.getInt("used"));
                table.setPlaces(rs.getInt("places"));
                list.add(table);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public Table find(int oid) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `table` WHERE oid=" + oid;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Table table = new Table();
                table.setOid(rs.getInt("oid"));
                table.setNumber(rs.getInt("number"));
                table.setUsed(rs.getInt("used"));
                table.setPlaces(rs.getInt("places"));
                return table;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.release(rs, stmt, conn);
            }
            return null;
        }
        public boolean delete(int oid) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtils.getConnection();
                stmt = conn.createStatement();
                String sql = "DELETE FROM `table` WHERE oid=" + oid;
                int num = stmt.executeUpdate(sql);
                if (num > 0) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.release(rs, stmt, conn);
            }
            return false;
        }
        public boolean update(Table table) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtils.getConnection();
                stmt = conn.createStatement();
                String sql = "UPDATE `table` SET number=" + table.getNumber()
                        + ",used=" + table.getUsed() + ",places="
                        + table.getPlaces()
                        + " WHERE oid=" + table.getOid();
                int num = stmt.executeUpdate(sql);
                if (num > 0) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.release(rs, stmt, conn);
            }
            return false;
        }
    }


