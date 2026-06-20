package com.eshaa.airBnbApp.DTO;

import lombok.Data;
import java.math.BigDecimal;


@Data
public class RoomDto {


    private long id;
    private String type;
    private BigDecimal hotelprice;
    private String[] photos;
    private String[] amenities;
    private Integer totalcount;
    private Integer capacity;

}
