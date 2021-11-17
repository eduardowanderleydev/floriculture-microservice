package br.com.eduardobpwj.microservice.floriculture.provider.service;

import br.com.eduardobpwj.microservice.floriculture.provider.model.InfoProvider;
import br.com.eduardobpwj.microservice.floriculture.provider.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    private InfoRepository repository;

    public InfoProvider getInfoByState(String state) {
        return repository.findByState(state);
    }
}
