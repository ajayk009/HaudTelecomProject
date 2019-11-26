package org.haud.service;

import static org.junit.Assert.assertEquals;
import org.haud.model.SimCard;
import org.haud.repository.SimCardRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class SimCardServiceTest {

	@Mock
	private SimCardRepository simCardRepository;
	@InjectMocks
	private SimCardServiceImpl simCardService;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createSimCardReturnCreatedSimId() {

		SimCard simCard = SimCard.builder().id(1l).imsi(1234l).msisdn(5676l).build();
		Mockito.when(simCardRepository.save(Mockito.any())).thenReturn(simCard);

		assertEquals(1l, simCardService.createSimCard(new SimCard(), "Jack Ma"));
	}
}
