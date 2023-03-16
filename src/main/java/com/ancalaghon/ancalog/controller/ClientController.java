package com.ancalaghon.ancalog.controller;


import com.ancalaghon.ancalog.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class ClientController {


    @GetMapping("/client")
    public List<Client> clientList() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Eren Jaeger");
        client.setPhone("35 99999-8888");
        client.setEmail("erenjaeger@ancalog.com");

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("Mikasa Akerman");
        client2.setPhone("35 98888-7777");
        client2.setEmail("akermanmikasa@ancalog.com");

        return Arrays.asList(client, client2);


    }




}
