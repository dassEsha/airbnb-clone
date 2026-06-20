package com.eshaa.airBnbApp.Repository;

import com.eshaa.airBnbApp.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
