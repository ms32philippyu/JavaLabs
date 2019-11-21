package by.gsu.ms42.idz12.converter;

import by.gsu.ms42.idz12.dto.ClientDto;
import by.gsu.ms42.idz12.dto.TourDto;
import by.gsu.ms42.idz12.entity.Client;
import by.gsu.ms42.idz12.entity.Tour;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Converter {

    public ClientDto clientToClientDto(Client client) {

        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setFname(client.getFname());
        clientDto.setLname(client.getLname());
        client.setEmail(client.getEmail());
        return clientDto;
    }

    public Client clientDtoToClient(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFname(clientDto.getFname());
        client.setLname(clientDto.getLname());
        client.setEmail(clientDto.getEmail());
        return client;
    }

    public ClientDto clientWithToursToFullClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setFname(client.getFname());
        clientDto.setLname(client.getLname());
        clientDto.setEmail(client.getEmail());
        clientDto.setTours(client.getTours().stream().map(this::tourToTourDto).collect(Collectors.toList()));
        return clientDto;
    }

    public TourDto tourToTourDto(Tour tour) {
        TourDto tourDto = new TourDto();
        tourDto.setId(tour.getId());
        tourDto.setName(tour.getName());
        tourDto.setPrice(tour.getPrice());
        return tourDto;
    }

    public Tour tourDtoToTour(TourDto tourDto){
        Tour tour = new Tour();
        tour.setId(tourDto.getId());
        tour.setName(tourDto.getName());
        tour.setPrice(tourDto.getPrice());
        return tour;
    }
}
