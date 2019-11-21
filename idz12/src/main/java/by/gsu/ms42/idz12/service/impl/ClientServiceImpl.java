package by.gsu.ms42.idz12.service.impl;

import by.gsu.ms42.idz12.converter.Converter;
import by.gsu.ms42.idz12.dto.ClientDto;
import by.gsu.ms42.idz12.entity.Client;
import by.gsu.ms42.idz12.entity.Tour;
import by.gsu.ms42.idz12.exception.ClientNotFoundException;
import by.gsu.ms42.idz12.repository.ClientRepository;
import by.gsu.ms42.idz12.service.ClientService;
import by.gsu.ms42.idz12.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    private TourService tourService;
    private Converter converter;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository, TourService tourService, Converter converter) {
        this.clientRepository = clientRepository;
        this.tourService = tourService;
        this.converter = converter;
    }

    @Override
    public ClientDto findOneClient(Long id) {
        return converter.clientToClientDto(clientRepository.findById(id)
                .orElseThrow(ClientNotFoundException::new));
    }

    @Override
    public List<ClientDto> findAllClients() {
        return clientRepository.findAll().stream()
                .map(client -> converter.clientWithToursToFullClientDto(client))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void createClient(ClientDto clientDto) {
        clientRepository.save(converter.clientDtoToClient(clientDto));
    }

    @Override
    public void updateClient(Long id, ClientDto clientDto) {
        Client client = converter.clientDtoToClient(clientDto);
        clientRepository.findById(id)
                .map(foundedClient -> {
                    foundedClient.setFname(client.getFname());
                    foundedClient.setLname(client.getLname());
                    foundedClient.setEmail(client.getEmail());
                    return clientRepository.save(foundedClient);
                }).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void addTourToClient(Long clientId, Long tourId) {
        Client client = clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
        Tour tour = converter.tourDtoToTour(tourService.findOneTour(tourId));
        if (!client.getTours().contains(tour)) {
            client.getTours().add(tour);
            clientRepository.save(client);
        } else {
            throw new ClientNotFoundException();
        }
    }

    @Override
    public ClientDto getClientInfoWithTours(Long clientId) {
        return converter.clientWithToursToFullClientDto(clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new));
    }
}
