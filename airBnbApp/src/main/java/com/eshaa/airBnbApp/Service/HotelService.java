package com.eshaa.airBnbApp.Service;

import com.eshaa.airBnbApp.DTO.HotelDto;
import com.eshaa.airBnbApp.DTO.HotelInfoDto;
import com.eshaa.airBnbApp.Entity.Hotel;

public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long hotelId);

    public HotelInfoDto getHotelInfoById(Long hotelId);


}
