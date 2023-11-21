package com.project.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.inventory.entity.InventoryEntity;



public interface InventoryRepo extends JpaRepository<InventoryEntity, Integer> {

}
