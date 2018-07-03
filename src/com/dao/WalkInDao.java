package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.domain.WalkIn;
import com.utils.JDBCUtils;
public class WalkInDao {
    public boolean insert(WalkIn walkIn) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        conn = JDBCUtils.getConnection();
        stmt = conn.createStatement();        
        String sql = "INSERT INTO `walkin` (oid, covers,date, time, table_id) "+
                    "VALUES("
                    + walkIn.getOid()
                    + ","
                    + walkIn.getCovers()
                    + ",'"
                    +walkIn.getDate()
                    + "','"
                    +walkIn.getTime()
                    + "',"
                    + walkIn.getTable_id()
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
    public ArrayList<WalkIn> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<WalkIn> list = new ArrayList<WalkIn>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `walkin`";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                WalkIn walkIn = new WalkIn(rs.getInt("covers"),rs.getDate("date"));
                walkIn.setOid(rs.getInt("oid"));
                walkIn.setTime(rs.getTime("time")); 
                walkIn.setTable_id(rs.getInt("table_id"));
                list.add(walkIn);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public WalkIn find(int oid) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `walkin` WHERE oid=" + oid;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                WalkIn walkIn = new WalkIn(rs.getInt("covers"),rs.getDate("date"));                walkIn.setOid(rs.getInt("oid"));
                walkIn.setOid(rs.getInt("oid"));
                walkIn.setTime(rs.getTime("time")); 
                walkIn.setTable_id(rs.getInt("table_id"));
                return walkIn;
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
                String sql = "DELETE FROM `walkin` WHERE oid=" + oid;
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
        public boolean update(WalkIn walkIn) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtils.getConnection();
                stmt = conn.createStatement();
                String sql = "UPDATE `walkin` SET covers=" + walkIn.getCovers()
                        + ",time='" + walkIn.getTime() + "',date='"
                        + walkIn.getDate()
                        + "',table_id=" + walkIn.getTable_id()
                        + " WHERE oid=" + walkIn.getOid();
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


