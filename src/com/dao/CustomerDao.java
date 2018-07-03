package com.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.domain.Customer;
import com.utils.JDBCUtils;
public class CustomerDao {
    public int getNextCustomerId() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(oid) FROM `customer`";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                return rs.getInt("COUNT(oid)") + 1;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return -1;
    }
    public boolean insert(Customer customer) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
        conn = JDBCUtils.getConnection();
        stmt = conn.createStatement();
        String sql = "INSERT INTO `customer` (oid, name,phonenumber) "+
                    "VALUES("
                    + customer.getOid()
                    + ",'"
                    + customer.getName()
                    + "','"
                    + customer.getPhonenumber()
                    + "')";
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
    public ArrayList<Customer> findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Customer> list = new ArrayList<Customer>();
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `customer`";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setOid(rs.getInt("oid"));
                customer.setName(rs.getString("name"));
                customer.setPhonenumber(rs.getString("phonenumber"));
                list.add(customer);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(rs, stmt, conn);
        }
        return null;
    }
    public Customer find(int oid) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `customer` WHERE oid=" + oid;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setOid(rs.getInt("oid"));
                customer.setName(rs.getString("name"));
                customer.setPhonenumber(rs.getString("phonenumber"));
                return customer;
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
                String sql = "DELETE FROM `customer` WHERE oid=" + oid;
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
        public boolean update(Customer customer) {
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                conn = JDBCUtils.getConnection();
                stmt = conn.createStatement();
                String sql = "UPDATE `customer` SET name='" + customer.getName()
                        + "',phonenumber='"
                        + customer.getPhonenumber()
                        + "' WHERE oid=" + customer.getOid();
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



