package com.springmvc.service.impl;

import com.springmvc.dao.ItemsMapper;
import com.springmvc.entity.Items;
import com.springmvc.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
@Service
public class ItemServiceImpl  implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> getItemsListq() {
        return itemsMapper.getItemsList();
    }

    public Items getItemsById(Integer id) {
        return itemsMapper.getItemsById(id);
    }

    public void updateItems(Items items) {
        itemsMapper.updateItems(items);
    }
}
