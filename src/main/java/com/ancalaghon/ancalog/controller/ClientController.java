package com.ancalaghon.ancalog.controller;


import com.ancalaghon.ancalog.model.Client;
import com.ancalaghon.ancalog.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientRepository clientRepository;


    @GetMapping
    public List<Client> clientList() {
        return clientRepository.findAll();

    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> findById (@PathVariable Long clientId){
         return clientRepository.findById(clientId)
                 .map(client -> ResponseEntity.ok(client))
                 .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);

    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @RequestBody Client client) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        client.setId(clientId);
        client = clientRepository.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> delete (@PathVariable Long clientId) {
        if (!clientRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        clientRepository.deleteById(clientId);

        return ResponseEntity.noContent().build();
    }






}
