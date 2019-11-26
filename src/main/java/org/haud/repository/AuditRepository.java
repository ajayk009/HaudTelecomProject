package org.haud.repository;

import org.haud.model.AuditTrail;
import org.haud.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditTrail, Long>
{
	

}
