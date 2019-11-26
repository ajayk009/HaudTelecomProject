package org.haud.service;

import org.haud.model.SimCard;
import org.haud.repository.SimCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SimCardServiceImpl implements SimCardService {

	@Autowired
	private SimCardRepository simCardRepository;

	@Override
	public long createSimCard(SimCard simCard, String userName) {

		log.info("in service impl, adding simcard " + simCard);

		simCard.setCreatedBy(userName);
		simCard.setUpdatedBy(userName);

		log.info("in service impl, adding simcard, repository call ");
		return simCardRepository.save(simCard).getId();
	}
}
