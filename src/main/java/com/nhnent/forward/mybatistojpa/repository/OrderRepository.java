package com.nhnent.forward.mybatistojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhnent.forward.mybatistojpa.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

}
