package real.rft.repository;

import org.springframework.data.repository.CrudRepository;
import real.rft.domain.RftUser;

public interface RftUserRepository extends CrudRepository<RftUser, Long> {
    RftUser findByUsername(String username);
    RftUser getById(Long id);
}
