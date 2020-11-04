package com.darq37.roombackend.repository;

import com.darq37.roombackend.domain.SharedList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharedListRepository extends JpaRepository<SharedList, Long> {
}
