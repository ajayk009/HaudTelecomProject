package org.haud.service;

import org.haud.model.AuditTrail;
import org.haud.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AuditTrailServiceImpl implements AuditTrailService
{
	
	@Autowired
	private AuditRepository auditRepository;

	@Override
	public void save(AuditTrail auditTrail) 
	{
		
		auditRepository.save(auditTrail);
	
	}
	

}
