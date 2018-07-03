package com.JdbcTest;

import com.dao.TableDao;
import com.domain.Table;

public class UpdateTableTest {

    public static void main(String[] args) {
        TableDao tableDao = new TableDao();
        Table table = new Table();
        table.setOid(11);
        table.setNumber(11);
        table.setPlaces(28);
        table.setUsed(0);
        System.out.println(tableDao.update(table));
    }

}
