package by.gsu.ms42.idz12.service.impl;

import by.gsu.ms42.idz12.converter.Converter;
import by.gsu.ms42.idz12.dto.TourDto;
import by.gsu.ms42.idz12.entity.Tour;
import by.gsu.ms42.idz12.exception.TourNotFoundException;
import by.gsu.ms42.idz12.repository.TourRepository;
import by.gsu.ms42.idz12.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;
    private Converter converter;

    @Autowired
    public TourServiceImpl(TourRepository tourRepository, Converter converter) {
        this.tourRepository = tourRepository;
        this.converter = converter;
    }

    @Override
    public TourDto findOneTour(Long id) {
        return converter.tourToTourDto(tourRepository.findById(id)
                .orElseThrow(TourNotFoundException::new));
    }

    @Override
    public List<TourDto> findAllTours() {
        return tourRepository.findAll().stream()
                .map(tour -> converter.tourToTourDto(tour))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTourById(Long id) {
        tourRepository.deleteById(id);
    }

    @Override
    public void createTour(TourDto tourDto) {
        tourRepository.save(converter.tourDtoToTour(tourDto));
    }

    @Override
    public void updateTour(Long id, TourDto tourDto) {
        Tour tour = converter.tourDtoToTour(tourDto);
        tourRepository.findById(id)
                .map(foundedTour -> {
                    foundedTour.setName(tour.getName());
                    foundedTour.setPrice(tour.getPrice());
                    return tourRepository.save(foundedTour);
                }).orElseThrow(TourNotFoundException::new);
    }
}
