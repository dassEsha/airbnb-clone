package com.eshaa.airBnbApp.DTO;

import com.eshaa.airBnbApp.Entity.HotelContactInfo;
import lombok.Data;

@Data
public class HotelDto {

    private long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;


}
