package br.com.eduardobpwj.microservice.floriculture.provider.repository;

import br.com.eduardobpwj.microservice.floriculture.provider.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
