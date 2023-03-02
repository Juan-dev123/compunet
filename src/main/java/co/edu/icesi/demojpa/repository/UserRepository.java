package co.edu.icesi.demojpa.repository;

import co.edu.icesi.demojpa.model.IcesiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<IcesiUser, UUID> {
    Optional<IcesiUser> findByCode(String code);
//    @Query("SELECT user FROM IcesiUser user WHERE user.firstName = :name")
//    Optional<IcesiUser> findSomeUserWithName(String name);
}
