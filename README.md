# Movie Ticket Booking System

This project is for booking movie tickets through online. Customers can browse movies, view shows, select seats, book tickets, and make payments. Admins can manage users, movies, theatres, shows, bookings, and payments.

## Project Architecture

This project follows a layered architecture:

```
Controller → Service → DAO (Repository) → Database
```

- **Controller** — handles HTTP requests and responses only
- **Service** — contains business logic and validation rules
- **DAO** — Spring Data JPA repositories for database access
- **Entity** — JPA classes representing database tables
- **DTO** — objects used to transfer data between client and server
- **Exception** — custom exceptions
- **config** — Spring Security and JWT configuration

## Technologies Used

- Java 25
- Spring Boot 4.1.1
- Spring Data JPA
- Spring Security with JWT Authentication
- MySQL
- Maven
- Lombok
- ModelMapper

## Database Configuration

The application uses MySQL.

| Entity | Description |
|---|---|
| **User** | System users with role `ADMIN` or `CUSTOMER` |
| **Movie** | Movie details |
| **Theatre** | Theatre details |
| **Show** | A specific screening of a movie at a theatre |
| **Booking** | A customer's ticket booking |
| **Payment** | Payment for a booking |

**Relationships:**
- User 1 : M Booking
- Movie 1 : M Show
- Theatre 1 : M Show
- Show 1 : M Booking
- Booking 1 : 1 Payment

## API Endpoints

### Authentication
```
POST /api/auth/signup
POST /api/auth/signin
```

### Users
```
GET    /api/users
GET    /api/users/{id}
PUT    /api/users/{id}
DELETE /api/users/{id}
```

### Movies
```
POST   /api/movies
GET    /api/movies
GET    /api/movies/{id}
PUT    /api/movies/{id}
DELETE /api/movies/{id}
```

### Theatres
```
POST   /api/theatres
GET    /api/theatres
GET    /api/theatres/{id}
PUT    /api/theatres/{id}
DELETE /api/theatres/{id}
```

### Shows
```
POST   /api/shows
GET    /api/shows
GET    /api/shows/{id}
PUT    /api/shows/{id}
DELETE /api/shows/{id}
```

### Bookings
```
POST /api/bookings
GET  /api/bookings/{id}
GET  /api/bookings/bookings
PUT  /api/bookings/{id}/cancel
```

### Payments
```
POST /api/payments
GET  /api/payments/{id}
```

## Authentication Instructions

The API uses JWT (JSON Web Token) authentication.

1. Sign up a new account
2. Sign in to receive a JWT token
3. Use the token on every subsequent request by adding it to the request header
4. Public endpoints (no token required): all other endpoints require a valid token. Specific actions are further restricted to the `ADMIN` role.

## Sample API Requests

**Sign Up**
```json
{
  "userName": "Anjula",
  "email": "anjula@gmail.com",
  "password": "123456"
}
```

**Sign In**
```json
{
  "email": "anjula@gmail.com",
  "password": "123456"
}
```

**Response**
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9...",
  "userId": "CA-7cd4138d-bfff-49ea-b367-6aa501de1f4d",
  "userName": "Anjula",
  "email": "anjula@gmail.com",
  "role": "CUSTOMER"
}
```

**Create Booking**
```json
{
  "showId": "UA-xxxxxxxx",
  "userId": "CA-xxxxxxxx",
  "seatNumbers": ["A1", "A2", "A3"],
  "numberOfTickets": 3
}
```

## How to Run the Project

1. Download the ZIP files of the front end and back end.
2. Extract them and open with an app like VS Code, NetBeans, etc.
3. Then run the back end.
4. Next, go to the front end and open the terminal. Type `npm start` and press Enter.
