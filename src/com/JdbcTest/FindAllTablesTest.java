package com.JdbcTest;


import java.util.ArrayList;
import java.util.Iterator;

import com.dao.TableDao;
import com.domain.Table;

public class FindAllTablesTest {

    public static void main(String[] args) {
        TableDao tablesDao = new TableDao();
        ArrayList<Table> list = tablesDao.findAll();
        Iterator<Table> tableIt = list.iterator();
        while(tableIt.hasNext()) {
            Table table = tableIt.next();
            System.out.println(table.getPlaces());
        }

}
}

