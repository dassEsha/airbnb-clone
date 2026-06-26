# Airbnb Backend Clone
## Overview
#### Airbnb Backend Clone is a scalable backend application built using Spring Boot that replicates the core functionalities of Airbnb. The system enables users to register, authenticate, list properties, search accommodations, make bookings, and manage reservations through secure REST APIs.

#### The project focuses on backend architecture, authentication, authorization, database design, and API development following industry-standard practices
# Hotel Booking Management System API

A RESTful API for managing hotels, rooms, bookings, inventory, and user authentication.

## Features

- User Authentication (Signup, Login, Verification)
- Hotel Management
- Room Management
- Inventory Management
- Hotel Search
- Booking Management
- Guest Management
- Payment Processing
- Automated Booking Reset Cron Job

---

## APIs Endpoints
### Hotel Manager

### Hotels

- POST /api/v1/admin/hotels
- GET /api/v1/admin/hotels

- GET /api/v1/admin/hotels/{hotelId}
- PATCH /api/v1/admin/hotels/{hotelId}
- DELETE /api/v1/admin/hotels/{hotelId}

### Rooms

- POST /api/v1/admin/hotels/{hotelId}/rooms
- GET /api/v1/admin/hotels/{hotelId}/rooms/{roomId}
- PATCH /api/v1/admin/hotels/{hotelId}/rooms/{roomId}
- DELETE /api/v1/admin/hotels/{hotelId}/rooms/{roomId}

### Bookings

- GET /api/v1/admin/bookings
  - Query Params: hotelId, startDate, endDate, status

- POST /api/v1/admin/reports
  - Query Params: startDate, endDate

### Inventory

- PATCH /api/v1/admins/inventory/{hotelId}/{roomId}/{date}

---

## Guest

### Hotel Search

- GET /api/v1/hotels/search
  - Query Params: city, checkinDate, checkoutDate, numberOfRooms
  - Response: Paginated

- GET /api/v1/hotels/{hotelId}
  - Query Params: checkinDate, checkoutDate, numberOfRooms

- GET /api/v1/hotels/{hotelId}/rooms/{roomId}

### Booking

- POST /api/v1/bookings

- POST /api/v1/guests

- PATCH /api/v1/bookings
  - Request Body: array of guestId, paymentMethod

- POST /api/v1/payments/{bookingId}

### Booking Management

- GET /api/v1/bookings

- GET /api/v1/bookings/{bookingId}

- PATCH /api/v1/bookings/cancel

---

## User

### Authentication

- POST /api/v1/auth/login

- POST /api/v1/auth/signup

- POST /api/v1/auth/verify

---

## System

- PATCH /api/v1/bookings/resetBookings
  - Cron Job: Every 1 minute
 
---
## Author

**Isha Das**

MCA Student, MANIT Bhopal

Backend Development | Java | Spring Boot | Database Systems
