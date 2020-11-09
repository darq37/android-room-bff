package com.darq37.roombackend.service;

import com.darq37.roombackend.domain.SharedList;
import com.darq37.roombackend.repository.SharedListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SharedListService {
    private final SharedListRepository sharedListRepository;

    @Autowired
    public SharedListService(SharedListRepository sharedListRepository) {
        this.sharedListRepository = sharedListRepository;
    }

    public List<SharedList> getSharedLists() {
        return sharedListRepository.findAll();
    }

    public Optional<SharedList> getSharedList(Long id) {
        return sharedListRepository.findById(id);
    }

    public SharedList saveSharedList(SharedList sharedList) {
        return sharedListRepository.save(sharedList);
    }

    public List<SharedList> saveAll(List<SharedList> lists) {
        return sharedListRepository.saveAll(lists);
    }


}
