package br.com.eduardobpwj.microservice.floriculture.transporter.repository;

import br.com.eduardobpwj.microservice.floriculture.transporter.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {

}
