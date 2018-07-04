package com.springmvc.dao;

import com.springmvc.entity.Items;

import java.util.List;

public interface ItemsMapper {
    public List<Items> getItemsList();

    public Items getItemsById(Integer id);

    public void updateItems(Items idtems);
}
