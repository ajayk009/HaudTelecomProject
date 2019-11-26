package org.haud.service;

import org.haud.model.SimCard;

public interface SimCardService {
	long createSimCard(SimCard simCard, String userName);
}
