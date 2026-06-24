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

# Base URL

```http
/api/v1
```

---

# Authentication APIs

## Login

```http
POST /auth/login
```

### Request Body

```json
{
  "email": "user@example.com",
  "password": "password"
}
```

---

## Signup

```http
POST /auth/signup
```

### Request Body

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password"
}
```

---

## Verify User

```http
POST /auth/verify
```

---

# Hotel Manager APIs

## Create Hotel

```http
POST /admin/hotels
```

---

## Get All Hotels

```http
GET /admin/hotels
```

---

## Get Hotel By ID

```http
GET /admin/hotels/{hotelId}
```

---

## Update Hotel

```http
PATCH /admin/hotels/{hotelId}
```

---

## Delete Hotel

```http
DELETE /admin/hotels/{hotelId}
```

---

# Room Management

## Create Room

```http
POST /admin/hotels/{hotelId}/rooms
```

---

## Get Room

```http
GET /admin/hotels/{hotelId}/rooms/{roomId}
```

---

## Update Room

```http
PATCH /admin/hotels/{hotelId}/rooms/{roomId}
```

---

## Delete Room

```http
DELETE /admin/hotels/{hotelId}/rooms/{roomId}
```

---

# Booking Management (Admin)

## Get Bookings

```http
GET /admin/bookings
```

### Query Parameters

| Parameter | Type | Description |
|------------|------|-------------|
| hotelId | String | Hotel ID |
| startDate | Date | Booking start date |
| endDate | Date | Booking end date |
| status | String | Booking status |

Example:

```http
GET /admin/bookings?hotelId=123&status=CONFIRMED
```

---

## Get Reports

```http
POST /admin/reports
```

### Query Parameters

| Parameter | Type |
|------------|------|
| startDate | Date |
| endDate | Date |

---

# Inventory Management

## Update Inventory

```http
PATCH /admin/inventory/{hotelId}/{roomId}/{date}
```

---

# Guest APIs

## Search Hotels

```http
GET /hotels/search
```

### Query Parameters

| Parameter | Description |
|------------|-------------|
| city | City name |
| checkinDate | Check-in date |
| checkoutDate | Check-out date |
| numberOfRooms | Number of rooms |

### Response

Paginated list of available hotels.

---

## Get Hotel Details

```http
GET /hotels/{hotelId}
```

### Query Parameters

| Parameter | Description |
|------------|-------------|
| checkinDate | Check-in date |
| checkoutDate | Check-out date |
| numberOfRooms | Number of rooms |

---

## Get Room Details

```http
GET /hotels/{hotelId}/rooms/{roomId}
```

---

# Guest Management

## Create Guest

```http
POST /guests
```

---

# Booking APIs

## Create Booking

```http
POST /bookings
```

---

## Update Booking

```http
PATCH /bookings
```

### Request Body

```json
{
  "guestIds": ["guestId1", "guestId2"],
  "paymentMethod": "UPI"
}
```

---

## Get All Bookings

```http
GET /bookings
```

---

## Get Booking By ID

```http
GET /bookings/{bookingId}
```

---

## Cancel Booking

```http
PATCH /bookings/cancel
```

---

# Payment APIs

## Process Payment

```http
POST /payments/{bookingId}
```

---

# System APIs

## Reset Expired Bookings

```http
PATCH /bookings/resetBookings
```

### Description

Automatically executed through a Cron Job every 1 minute to reset expired or incomplete bookings.

---

# HTTP Status Codes

| Code | Description |
|--------|-------------|
| 200 | Success |
| 201 | Resource Created |
| 400 | Bad Request |
| 401 | Unauthorized |
| 403 | Forbidden |
| 404 | Not Found |
| 500 | Internal Server Error |

---
