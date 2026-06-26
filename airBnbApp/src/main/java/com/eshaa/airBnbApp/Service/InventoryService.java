package com.eshaa.airBnbApp.Service;

import com.eshaa.airBnbApp.DTO.HotelDto;
import com.eshaa.airBnbApp.DTO.HotelSearchRequest;
import com.eshaa.airBnbApp.Entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);


}
