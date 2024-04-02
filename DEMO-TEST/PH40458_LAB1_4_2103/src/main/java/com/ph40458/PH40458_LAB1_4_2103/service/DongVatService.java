package com.ph40458.PH40458_LAB1_4_2103.service;

import com.ph40458.PH40458_LAB1_4_2103.entity.DongVat;

import java.util.ArrayList;
import java.util.List;

public class DongVatService {
    private List<DongVat> listdv = new ArrayList<>();

    public DongVatService() {
        listdv.add(new DongVat(1, "Category 1", 1, true, 1, "1"));
        listdv.add(new DongVat(2, "Category 1", 1, true, 1, "1"));
        listdv.add(new DongVat(3, "Category 1", 1, true, 1, "1"));
        listdv.add(new DongVat(4, "Category 1", 1, true, 1, "1"));
        listdv.add(new DongVat(5, "Category 1", 1, true, 1, "1"));
    }

    public List<DongVat> getAll() {
        return listdv;
    }


    public void remove(String id) {
        for (int i = 0; i < listdv.size(); i++) {
            if (listdv.get(i).equals(id)) {
                listdv.remove(i);
            }
        }
    }

    public void add(DongVat dv) {
        listdv.add(dv);
    }
}
