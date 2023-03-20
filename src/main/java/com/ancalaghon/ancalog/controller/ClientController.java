package com.ancalaghon.ancalog.controller;


import com.ancalaghon.ancalog.model.Client;
import com.ancalaghon.ancalog.repository.ClientRepository;
import com.ancalaghon.ancalog.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/client")
@Api(tags = "Client Controller")
public class ClientController {

    private ClientRepository clientRepository;
    private ClientService clientService;


    @GetMapping
    @ApiOperation("Find All Clients")
    public List<Client> clientList() {
        return clientRepository.findAll();

    }

    @GetMapping("/{clientId}")
    @ApiOperation("Find Client By Id")
    public ResponseEntity<Client> findById (@PathVariable Long clientId){
         return clientRepository.findById(clientId)
                 .map(client -> ResponseEntity.ok(client))
                 .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ApiOperation("Create Client")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.save(client);

    }

    @PutMapping("/{clientId}")
    @ApiOperation("Update Client")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @Valid @RequestBody Client client) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientService.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    @ApiOperation("Delete Client")
    public ResponseEntity<Void> delete (@PathVariable Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        clientService.delete(clientId);

        return ResponseEntity.noContent().build();
    }



}
