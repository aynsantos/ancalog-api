package com.ancalaghon.ancalog.service;


import com.ancalaghon.ancalog.exception.BusinessException;
import com.ancalaghon.ancalog.model.Client;
import com.ancalaghon.ancalog.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {

    private ClientRepository clientRepository;

    @Transactional
    public Client save(Client client) {
        boolean emailInUse = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(c -> !c.equals(client.getEmail()));
        if(emailInUse) {
            throw new BusinessException("Já existe um cliente cadastrado com esse e-mail");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long clientId) {
        clientRepository.deleteById(clientId);
    }


}
