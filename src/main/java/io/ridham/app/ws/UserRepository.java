package io.ridham.app.ws;

import io.ridham.app.ws.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

}
