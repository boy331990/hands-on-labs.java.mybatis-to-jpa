package com.nhnent.forward.mybatistojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhnent.forward.mybatistojpa.entity.ItemEntity;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

}
