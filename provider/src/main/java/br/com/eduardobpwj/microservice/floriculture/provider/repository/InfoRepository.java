package br.com.eduardobpwj.microservice.floriculture.provider.repository;

import br.com.eduardobpwj.microservice.floriculture.provider.model.InfoProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends CrudRepository<InfoProvider, Long> {

    InfoProvider findByState(String state);

}
