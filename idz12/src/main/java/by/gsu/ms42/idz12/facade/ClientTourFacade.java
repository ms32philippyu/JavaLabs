package by.gsu.ms42.idz12.facade;

import by.gsu.ms42.idz12.dto.ClientDto;
import by.gsu.ms42.idz12.dto.TourDto;

import java.util.List;

public interface ClientTourFacade {

    //--------------------------------------------------Client----------------------------------------------------------

    ClientDto findOneClient(Long id);

    List<ClientDto> findAllClients();

    void deleteClientById(Long id);

    void createClient(ClientDto clientDto);

    void updateClient(Long id, ClientDto clientDto);

    void addTourToClient(Long clientId, Long tourId);

    ClientDto getClientInfoWithTours(Long clientId);

    //--------------------------------------------------Tour------------------------------------------------------------

    TourDto findOneTour(Long id);

    List<TourDto> findAllTours();

    void deleteTourById(Long id);

    void createTour(TourDto tourDto);

    void updateTour(Long id, TourDto tourDto);
}
