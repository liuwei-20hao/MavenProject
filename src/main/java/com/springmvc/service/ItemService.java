package com.springmvc.service;

import com.springmvc.entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ItemService {
    public List<Items> getItemsListq();

    public Items getItemsById(Integer id);

    public void updateItems(Items idtems);
}
