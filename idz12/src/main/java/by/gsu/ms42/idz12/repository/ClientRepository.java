package by.gsu.ms42.idz12.repository;

import by.gsu.ms42.idz12.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
