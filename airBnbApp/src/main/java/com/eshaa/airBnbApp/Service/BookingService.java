package com.eshaa.airBnbApp.Service;

import com.eshaa.airBnbApp.DTO.BookingDto;
import com.eshaa.airBnbApp.DTO.BookingRequest;
import com.eshaa.airBnbApp.DTO.GuestDto;

import java.util.List;

public interface BookingService {

    BookingDto initialiseBooking(BookingRequest bookingRequest);

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
