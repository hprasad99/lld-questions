## Functional Requirements
1. Room Booking: Ability to book a room for a specific period
2. Room Availability: Check if rooms are available for given dates.
3. Booking Modification: Modify existing bookings (change dates, room type)
4. Booking Cancellation: Cancel an existing booking
5. Customer Management: Manage customer information (add, edit, retrieve)
6. Room Management: Manage room information (add, edit, delete room date)

## Non-functional Requirements
1. Performance: System should be able to handle 1000 concurrent users
2. Reliability: The system should be available 99.9% of the time.
3. Scalability: Should be able to scale horizontally to handle increased load.
4. Security: Secure storage of customer data with encryption and secure API access.

## Storage Estimates
1. 100 rooms --> 2 bookings/week
2. 52 weeks in an year, 2 bookings in a week hence 104 bookings per week for checkin and checkout.
3. Customer Data and Booking Data are main storages

**Fixed Size**
```
Integer: 4 Bytes
Dates: 8 Bytes
Double: 8 Bytes
String(Status): Approximately 20 bytes
Adding these up: 20bytes
```
Customer data and Booking Data along with additional metadata, indexing information, or overhead from database management system.
It rounds up to 1KB of data.
* Bookings: 100 rooms * 104 bookings * 1KB = 10,400KB (10.4MB)
* Customers: Similar unique customers as bookings = 10.4MB

## Database Schema

### Rooms
RoomID (PK)
Type
Description
Price

### Customers
CustomerID (PK)
Name
Email
Phone

### Bookings
BookingID (PK)
CustomerID (FK)
RoomID (FK)
StartDate
EndDate
TotalPrice
Status (Booked, Cancelled, Completed)

### API Design

GET /rooms/availability
> Input: startData, endDate
> Output: list of available rooms

POST /bookings/{bookingId}
> Input: BookingID, updated booking Data
> Output: Booking confirmation

PUT /bookings/{bookingId}
> Input: BookingID, updated booking data
> Output: Updated booking information

GET /customers/{customerId}
> Input: CustomerId
> Output: CustomerInformation

