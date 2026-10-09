package lk.ijse.movie_ticket_booking_system.Exceptions;

public class InvalidRequestException extends RuntimeException {
  public InvalidRequestException(String message) {
        super(message);
    }
}
