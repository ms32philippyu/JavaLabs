package by.gsu.ms42.idz12.service;

import by.gsu.ms42.idz12.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto findOneClient(Long id);

    List<ClientDto> findAllClients();

    void deleteClientById(Long id);

    void createClient(ClientDto clientDto);

    void updateClient(Long id, ClientDto clientDto);

    void addTourToClient(Long clientId, Long tourId);

    ClientDto getClientInfoWithTours(Long clientId);
}
