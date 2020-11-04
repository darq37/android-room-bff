package com.darq37.roombackend.controller;

import com.darq37.roombackend.domain.SharedList;
import com.darq37.roombackend.domain.User;
import com.darq37.roombackend.service.SharedListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shared")
public class SharedListController {
    private final SharedListService service;

    public SharedListController(SharedListService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SharedList> getLists(){
        return service.getSharedLists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<SharedList> getList(@PathVariable Long id){
        return service.getSharedList(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
