package lk.ijse.movie_ticket_booking_system.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import lk.ijse.movie_ticket_booking_system.Entity.BookingEntity;
import lk.ijse.movie_ticket_booking_system.Entity.MovieEntity;
import lk.ijse.movie_ticket_booking_system.Entity.PaymentEntity;
import lk.ijse.movie_ticket_booking_system.Entity.ShowEntity;
import lk.ijse.movie_ticket_booking_system.Entity.TheatreEntity;
import lk.ijse.movie_ticket_booking_system.Entity.UserEntity;
import lk.ijse.movie_ticket_booking_system.dto.BookingDTO;
import lk.ijse.movie_ticket_booking_system.dto.MovieDTO;
import lk.ijse.movie_ticket_booking_system.dto.PaymentDTO;
import lk.ijse.movie_ticket_booking_system.dto.ShowDTO;
import lk.ijse.movie_ticket_booking_system.dto.TheatreDTO;
import lk.ijse.movie_ticket_booking_system.dto.UserDTO;
import lombok.RequiredArgsConstructor;




@Component
@RequiredArgsConstructor
public class Conversion {
   private final ModelMapper mapper;
   

    //    User-Conversion
    public UserDTO toUserDTO(UserEntity userEntity) {
        return mapper.map(userEntity, UserDTO.class);
    }

    public UserEntity toUserEntity(UserDTO userDTO) {
        return mapper.map(userDTO, UserEntity.class);
    }

    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        return mapper.map(userEntityList,
                new TypeToken<List<UserDTO>>() {
                }.getType()
        );
    }

    //    Movie-Conversion

    public MovieDTO toMovieDTO( MovieEntity movieEntity) {
        return mapper.map(movieEntity, MovieDTO.class);
    }

    public MovieEntity toMovieEntity(MovieDTO movieDTO) {
        return mapper.map(movieDTO, MovieEntity.class);
    }

    public List<MovieDTO> toMovieDTOList(List<MovieEntity> movieEntities) {
        return mapper.map(movieEntities,
                new TypeToken<List<MovieDTO>>() {
                }.getType()
        );

    }
    //    Theatre-Conversion

    public TheatreDTO toTheatreDTO(TheatreEntity theatreEntity) {
        return mapper.map(theatreEntity, TheatreDTO.class);
    }

    public TheatreEntity toTheatreEntity(TheatreDTO climateActionDTO) {
        return mapper.map(climateActionDTO, TheatreEntity.class);
    }

    public List<TheatreDTO> toTheatreDTOList(List<TheatreEntity> theatreEntities) {
        return mapper.map(theatreEntities,
                new TypeToken<List<TheatreDTO>>() {
                }.getType()
        );
    }
    //    Show-Conversion

    public ShowDTO toShowDTO(ShowEntity showEntity) {
        return mapper.map(showEntity, ShowDTO.class);

    }

    public ShowEntity toshowEntity(ShowDTO showDTO) {
        return mapper.map(showDTO, ShowEntity.class);
    }

    public List<ShowDTO> toShowDTOList(List<ShowEntity> showEntities) {
        return mapper.map(showEntities,
                new TypeToken<List<ShowDTO>>() {
                }.getType()
        );
    }



    //    Booking-Conversion

    public BookingDTO toBookingDTO(BookingEntity bookingEntity) {
        return mapper.map(bookingEntity, BookingDTO.class);
    }

    public BookingEntity toBookingEntity(BookingDTO bookingDTO) {
        return mapper.map(bookingDTO, BookingEntity.class);
    }

    public List<BookingDTO> toBookingDTOList(List<BookingEntity> bookingEntities){
        return mapper.map(bookingEntities,
                new TypeToken<List<BookingDTO>>() {
                }.getType()
        );
    }




    
    //    Payment-Conversion

    public PaymentDTO toPaymentDTO(PaymentEntity paymentEntity) {
        return mapper.map(paymentEntity, PaymentDTO.class);
    }

    public PaymentEntity toPaymentEntity(PaymentDTO paymentDTO) {
        return mapper.map(paymentDTO, PaymentEntity.class);
    }

    public List<PaymentDTO> paymentDTOList(List<PaymentEntity> paymentEntities){
        return mapper.map(paymentEntities,
                new TypeToken<List<PaymentDTO>>() {
                }.getType()
        );


    
}
}


