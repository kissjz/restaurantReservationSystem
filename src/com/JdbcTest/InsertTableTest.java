package com.JdbcTest;

import com.dao.TableDao;
import com.domain.Table;

public class InsertTableTest {

    public static void main(String[] args) {
        TableDao tableDao = new TableDao();
        Table table = new Table();
        table.setOid(11);
        table.setNumber(11);
        table.setPlaces(50);
        table.setUsed(0);
        boolean b = tableDao.insert(table);
        System.out.println(b);
    }

}
