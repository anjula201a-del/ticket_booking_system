package lk.ijse.movie_ticket_booking_system.util;

import java.util.UUID;

public class IDGenerate {

    public static String userId(){
        return "CA-"+UUID.randomUUID();
    }
    public static String movieId(){
        return "AC-"+UUID.randomUUID();
    }
    public static String theatreId(){
        return "GL-"+UUID.randomUUID();
    }
    public static String showId(){
        return "UA-"+UUID.randomUUID();
    }
    public static String bookingId(){
        return "US-"+UUID.randomUUID();
    }

    public static String paymentId(){
        return "US-"+UUID.randomUUID();
    }

}
