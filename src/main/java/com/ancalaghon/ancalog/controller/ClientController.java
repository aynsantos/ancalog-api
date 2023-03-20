package com.ancalaghon.ancalog.controller;


import com.ancalaghon.ancalog.model.Client;
import com.ancalaghon.ancalog.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

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






}
