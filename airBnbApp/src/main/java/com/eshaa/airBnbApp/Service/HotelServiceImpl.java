package com.eshaa.airBnbApp.Service;

import com.eshaa.airBnbApp.DTO.HotelDto;
import com.eshaa.airBnbApp.DTO.HotelInfoDto;
import com.eshaa.airBnbApp.DTO.RoomDto;
import com.eshaa.airBnbApp.Entity.Hotel;
import com.eshaa.airBnbApp.Entity.Room;
import com.eshaa.airBnbApp.Exception.ResourceNotFoundException;
import com.eshaa.airBnbApp.Repository.HotelRepository;
import com.eshaa.airBnbApp.Repository.RoomRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;
    private final RoomRepository roomRepository;

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
        hotel.setId(id);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    @Transactional

    public void deleteHotelById(Long id){
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with this Id:" +id));


        for(Room room : hotel.getRoom()){
            inventoryService.deleteAllInventories(room);
            roomRepository.deleteById(room.getId());
        }
        hotelRepository.deleteById(id);


    }

    @Override
    @Transactional

    public void activateHotel(Long hotelId){
        log.info("Activating the hotel with ID: {} ", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with ID:" + hotelId));
        hotel.setActive(true);

        //Assuming only do it once
        for( Room room : hotel.getRoom()){
            inventoryService.initializeRoomForAYear(room);
        }


    }

    @Override
    public HotelInfoDto getHotelInfoById(Long hotelId){
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found with this Id:" +hotelId));

        List<RoomDto> rooms = hotel.getRooms()
                .stream()
                .map((element)-> modelMapper.map(element, RoomDto.class))
                .toList();

        return new HotelInfoDto(modelMapper.map(hotel,HotelDto.class),rooms);
    }



}
