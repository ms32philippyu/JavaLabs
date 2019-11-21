package by.gsu.ms42.idz12.service;

import by.gsu.ms42.idz12.dto.TourDto;

import java.util.List;

public interface TourService {

    TourDto findOneTour(Long id);

    List<TourDto> findAllTours();

    void deleteTourById(Long id);

    void createTour(TourDto tourDto);

    void updateTour(Long id, TourDto tourDto);
}
