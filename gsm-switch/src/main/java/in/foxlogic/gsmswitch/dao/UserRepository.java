package in.foxlogic.gsmswitch.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.foxlogic.gsmswitch.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUserName(String userName);

}
