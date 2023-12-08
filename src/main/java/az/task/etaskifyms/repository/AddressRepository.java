package az.task.etaskifyms.repository;

import az.task.etaskifyms.entity.address.Address;
import az.task.etaskifyms.entity.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
