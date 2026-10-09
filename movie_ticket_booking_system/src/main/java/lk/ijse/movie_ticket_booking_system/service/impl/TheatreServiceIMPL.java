package lk.ijse.movie_ticket_booking_system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lk.ijse.movie_ticket_booking_system.DAO.TheatreDao;
import lk.ijse.movie_ticket_booking_system.Entity.TheatreEntity;
import lk.ijse.movie_ticket_booking_system.Exceptions.DataNotFoundException;
import lk.ijse.movie_ticket_booking_system.dto.TheatreDTO;
import lk.ijse.movie_ticket_booking_system.service.TheatreService;
import lk.ijse.movie_ticket_booking_system.util.Conversion;
import lk.ijse.movie_ticket_booking_system.util.IDGenerate;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
@Transactional 
public class TheatreServiceIMPL implements TheatreService {
    private final TheatreDao theatreDao;
    private final Conversion conversion;

     @Override
    public void createTheatre(TheatreDTO theatre) {
        theatre.setTheatreId(IDGenerate.theatreId());
       theatreDao.save(conversion.toTheatreEntity(theatre));

        
    }

     @Override
    public TheatreDTO getSelectedTheatre(String theatreId) {
    TheatreEntity theatreEntity= theatreDao.findById(theatreId)
                               .orElseThrow(()-> new DataNotFoundException("theatre not found") );
        return conversion.toTheatreDTO(theatreEntity);
                                
    }

    @Override
    public List<TheatreDTO> getAllTheatres() {
        List<TheatreEntity> allTheatres =theatreDao.findAll();
        return conversion.toTheatreDTOList(allTheatres);
    }

    @Override
    public void updateTheatre(String theatreId,TheatreDTO theatre) {
       TheatreEntity foundtheatre= theatreDao.findById(theatreId)
                               .orElseThrow(()-> new DataNotFoundException("theatre not found") );
                               foundtheatre.setTheatreName(theatre.getTheatreName());
                               foundtheatre.setStatus(theatre.getStatus());
                               foundtheatre.setLocation(theatre.getLocation());
                               foundtheatre.setCapacity(theatre.getCapacity());
                               
                           
                              
    }

    @Override
    public void deleteTheatre(String theatreId) {
        TheatreEntity foundTheatre= theatreDao.findById(theatreId)
                               .orElseThrow(()-> new DataNotFoundException("theatre not found") );
                               theatreDao.delete(foundTheatre);
    }


}
