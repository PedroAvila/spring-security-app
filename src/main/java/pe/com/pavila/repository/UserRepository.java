package pe.com.pavila.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.pavila.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findUserEntityByUsername(String username);

    // @Query("SELECT u FROM UserEntity u WHERE u.username = ?")
    // Optional<UserEntity> findUser(String username);
}
