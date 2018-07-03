package com.JdbcTest;

import com.dao.TableDao;
import com.domain.Table;

public class FindTableByIdTest {

    public static void main(String[] args) {
        TableDao tableDao = new TableDao();
        Table table = tableDao.find(1);
        System.out.println("id = 1: " + table.getPlaces());
    }

}
