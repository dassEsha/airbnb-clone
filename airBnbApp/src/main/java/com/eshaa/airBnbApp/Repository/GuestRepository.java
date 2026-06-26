package com.eshaa.airBnbApp.Repository;

import com.eshaa.airBnbApp.Entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
