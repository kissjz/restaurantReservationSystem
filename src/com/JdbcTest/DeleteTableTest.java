package com.JdbcTest;

import com.dao.TableDao;

public class DeleteTableTest {

    public static void main(String[] args) {
        TableDao tableDao = new TableDao();
        boolean b = tableDao.delete(8);
        System.out.print(b);
    }

}
