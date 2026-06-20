package com.eshaa.airBnbApp.Repository;

import com.eshaa.airBnbApp.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
