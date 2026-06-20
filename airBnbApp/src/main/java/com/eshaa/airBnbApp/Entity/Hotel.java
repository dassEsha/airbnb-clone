package com.eshaa.airBnbApp.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    private String city;

    @Column(columnDefinition = "Text[]")
    private String[] photos;

    @Column(columnDefinition = "Text[]")
    private String[] amenities;

    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Embedded
    private HotelContactInfo contactInfo;

    @Column(nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY)
    private List<Room> room;

    @ManyToOne
    private User owner;
}
