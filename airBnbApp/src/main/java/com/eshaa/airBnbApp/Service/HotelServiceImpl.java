package com.eshaa.airBnbApp.Service;

import com.eshaa.airBnbApp.DTO.HotelDto;
import com.eshaa.airBnbApp.Entity.Hotel;
import com.eshaa.airBnbApp.Exception.ResourceNotFoundException;
import com.eshaa.airBnbApp.Repository.HotelRepository;
import com.eshaa.airBnbApp.Entity.HotelContactInfo;

import com.eshaa.airBnbApp.Repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;



@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto){
        log.info("Creating a new hotel with name : {} ", hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with ID : {}", hotelDto.getId());
        return modelMapper.map(hotel,HotelDto.class);
    }
    @Override
    public HotelDto getHotelById(Long id){
        log.info("Getting the hotel with ID: {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID:" + id));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto ){
        log.info("Updating the hotel with ID: {}", id);
        Hotel hotel = hotelRepository
                    .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with this Id"));
        modelMapper.map(hotelDto, hotel);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public boolean deleteHotelById(Long id){
        return null;
    }


}
