package co.edu.icesi.demojpa.repository;

import co.edu.icesi.demojpa.model.IcesiRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<IcesiRole, UUID> {

}
