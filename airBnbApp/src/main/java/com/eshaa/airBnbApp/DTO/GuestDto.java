package com.eshaa.airBnbApp.DTO;

import com.eshaa.airBnbApp.Entity.Enums.Gender;
import com.eshaa.airBnbApp.Entity.User;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
