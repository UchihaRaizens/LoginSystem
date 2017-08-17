package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

	Permission findByName(String name);
}
