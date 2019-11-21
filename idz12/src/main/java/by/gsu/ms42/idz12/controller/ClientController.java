package by.gsu.ms42.idz12.controller;

import by.gsu.ms42.idz12.dto.AddTourToUserRequest;
import by.gsu.ms42.idz12.dto.ClientDto;
import by.gsu.ms42.idz12.facade.ClientTourFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientTourFacade clientTourFacade;

    @Autowired
    public ClientController(ClientTourFacade clientTourFacade) {
        this.clientTourFacade = clientTourFacade;
    }

    @GetMapping("/{clientId}")
    public ClientDto findOneClient(@PathVariable Long clientId) {
        return clientTourFacade.findOneClient(clientId);
    }

    @GetMapping("/")
    public List<ClientDto> findAllClients() {
        return clientTourFacade.findAllClients();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody ClientDto clientDto) {
        clientTourFacade.createClient(clientDto);
    }

    @DeleteMapping("/{clientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable Long clientId) {
        clientTourFacade.deleteClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public void updateClient(@PathVariable Long clientId, @RequestBody ClientDto clientDto) {
        clientTourFacade.updateClient(clientId, clientDto);
    }

    @PostMapping("/addTourToClient")
    public void addTourToClient(@RequestBody AddTourToUserRequest addTourToUserRequest) {
        clientTourFacade.addTourToClient(addTourToUserRequest.getClientId(), addTourToUserRequest.getTourId());
    }

    @GetMapping("/{clientId}/tours/")
    public ClientDto getClientInfoWithTours(@PathVariable Long clientId) {
        return clientTourFacade.getClientInfoWithTours(clientId);
    }
}
