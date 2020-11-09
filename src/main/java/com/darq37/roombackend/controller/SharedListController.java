package com.darq37.roombackend.controller;

import com.darq37.roombackend.domain.SharedList;
import com.darq37.roombackend.service.SharedListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shared")
public class SharedListController {
    private final SharedListService service;

    @Autowired
    public SharedListController(SharedListService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<SharedList> getLists() {
        System.out.println("Shared lists synced");
        return service.getSharedLists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<SharedList> getList(@PathVariable Long id) {
        return service.getSharedList(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(method = RequestMethod.POST)
    public SharedList saveSharedList(@RequestBody SharedList list) {
        return service.saveSharedList(list);
    }

}
