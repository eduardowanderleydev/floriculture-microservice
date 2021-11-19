package br.com.eduardobpwj.microservice.floriculture.store.repository;

import br.com.eduardobpwj.microservice.floriculture.store.model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
