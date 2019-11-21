package by.gsu.ms42.idz12.facade.impl;

import by.gsu.ms42.idz12.dto.ClientDto;
import by.gsu.ms42.idz12.dto.TourDto;
import by.gsu.ms42.idz12.facade.ClientTourFacade;
import by.gsu.ms42.idz12.service.ClientService;
import by.gsu.ms42.idz12.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientTourFacadeImpl implements ClientTourFacade {

    private ClientService clientService;
    private TourService tourService;

    @Autowired
    public ClientTourFacadeImpl(ClientService clientService, TourService tourService) {
        this.clientService = clientService;
        this.tourService = tourService;
    }

    //------------------------------------------Client service----------------------------------------------------------

    @Override
    public ClientDto findOneClient(Long id) {
        return clientService.findOneClient(id);
    }

    @Override
    public List<ClientDto> findAllClients() {
        return clientService.findAllClients();
    }

    @Override
    public void deleteClientById(Long id) {
        clientService.deleteClientById(id);
    }

    @Override
    public void createClient(ClientDto clientDto) {
        clientService.createClient(clientDto);
    }

    @Override
    public void updateClient(Long id, ClientDto clientDto) {
        clientService.updateClient(id, clientDto);
    }

    @Override
    public void addTourToClient(Long clientId, Long tourId) {
        clientService.addTourToClient(clientId, tourId);
    }

    @Override
    public ClientDto getClientInfoWithTours(Long clientId) {
        return clientService.getClientInfoWithTours(clientId);
    }

    //--------------------------------------------Tour Service----------------------------------------------------------

    @Override
    public TourDto findOneTour(Long id) {
        return tourService.findOneTour(id);
    }

    @Override
    public List<TourDto> findAllTours() {
        return tourService.findAllTours();
    }

    @Override
    public void deleteTourById(Long id) {
        tourService.deleteTourById(id);
    }

    @Override
    public void createTour(TourDto tourDto) {
        tourService.createTour(tourDto);
    }

    @Override
    public void updateTour(Long id, TourDto tourDto) {
        tourService.updateTour(id, tourDto);
    }
}
