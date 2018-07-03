package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.domain.Customer;
import com.domain.Reservation;
import com.utils.JDBCUtils;
public class ReservationDao {
    public boolean insert(Reservation reservation) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        conn = JDBCUtils.getConnection();
        stmt = conn.createStatement();
        
        String sql = "INSERT INTO `reservation` (oid, covers,date, time, table_id, customer_id) "+
                    "VALUES("
                    + reservation.getOid()
                    + ","
                    + reservation.getCovers()
                    + ",'"
                    +reservation.getDate()
                    + "','"
                    +reservation.getTime()
                    + "',"
                    + reservation.getTable_id()
                    +","
                    +reservation.getCustomer_id()
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
    public ArrayList<Reservation> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Reservation> list = new ArrayList<Reservation>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `reservation`";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CustomerDao customerDao = new CustomerDao();
                Customer customer = customerDao.find(rs.getInt("customer_id"));
                Reservation reservation = new Reservation(rs.getInt("covers"),rs.getDate("date"),
                        customer);
                reservation.setOid(rs.getInt("oid"));
                reservation.setTime(rs.getTime("time")); 
                reservation.setTable_id(rs.getInt("table_id"));
                list.add(reservation);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public Reservation find(int oid) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `reservation` WHERE oid=" + oid;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CustomerDao customerDao = new CustomerDao();
                Customer customer = customerDao.find(rs.getInt("customer_id"));
                Reservation reservation = new Reservation(rs.getInt("covers"),rs.getDate("date"),
                        customer);
                reservation.setOid(rs.getInt("oid"));
                reservation.setTime(rs.getTime("time")); 
                reservation.setTable_id(rs.getInt("table_id"));
                return reservation;
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
                String sql = "DELETE FROM `reservation` WHERE oid=" + oid;
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
        
        public boolean update(Reservation reservation) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtils.getConnection();
                stmt = conn.createStatement();
                String sql = "UPDATE `reservation` SET covers=" + reservation.getCovers()
                        + ",time='" + reservation.getTime() + "',date='"
                        + reservation.getDate()
                        + "',table_id=" + reservation.getTable_id()
                        + ",customer_id=" + reservation.getCustomer_id()
                        + " WHERE oid=" + reservation.getOid();
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


