package net.bestofcode.Facebook.persistence.Repositories;

import net.bestofcode.Facebook.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
