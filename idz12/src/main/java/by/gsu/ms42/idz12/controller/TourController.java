package by.gsu.ms42.idz12.controller;

import by.gsu.ms42.idz12.dto.TourDto;
import by.gsu.ms42.idz12.facade.ClientTourFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private ClientTourFacade clientTourFacade;

    @Autowired
    public TourController(ClientTourFacade clientTourFacade) {
        this.clientTourFacade = clientTourFacade;
    }

    @GetMapping("/{tourId}")
    public TourDto findOneTour(@PathVariable Long tourId) {
        return clientTourFacade.findOneTour(tourId);
    }

    @GetMapping("/")
    public List<TourDto> findAllTours() {
        return clientTourFacade.findAllTours();
    }

    @DeleteMapping("/{tourId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTourById(@PathVariable Long tourId) {
        clientTourFacade.deleteTourById(tourId);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createTour(@RequestBody TourDto tourDto) {
        clientTourFacade.createTour(tourDto);
    }

    @PutMapping("/{tourId}")
    public void updateTour(@PathVariable Long tourId, @RequestBody TourDto tourDto) {
        clientTourFacade.updateTour(tourId, tourDto);
    }
}
