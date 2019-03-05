package springcloud.client.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springcloud.client.entity.Person;

public interface PersonResposity extends JpaRepository<Person,Long>{
}
