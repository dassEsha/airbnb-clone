package com.eshaa.airBnbApp.Repository;

import com.eshaa.airBnbApp.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
