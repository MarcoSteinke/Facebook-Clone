package net.bestofcode.Facebook.persistence.Repositories;

import net.bestofcode.Facebook.model.profile.Email;
import net.bestofcode.Facebook.persistence.DTO.UserDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, String> {

    public UserDTO findByEmail(String email);
}
