package org.haud.controller;

import org.haud.dto.SimRequestDto;
import org.haud.dto.SimResponseDto;
import org.haud.mapper.SimMapper;
import org.haud.model.SimCard;
import org.haud.service.SimCardService;
import org.haud.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.haud.utils.Headers;

@RestController
@RequestMapping("/simcard")
@Slf4j
public class SimCardController {

	@Autowired
	private SimCardService simCardService;

	@PostMapping(name="/save")
	public ResponseEntity<SimResponseDto> addSimCard(@RequestHeader(Headers.USER_NAME) String userName,@RequestBody SimRequestDto request) {

		log.info("Creating sim card " + request);
		Request.verifySimCardPost(request);
		SimCard simCard = SimMapper.toSimCard(request);
		simCardService.createSimCard(simCard, userName);
		log.info("sim card created with id " + simCard.getId());
		return new ResponseEntity<>(SimMapper.toSimCardResponse(simCard), HttpStatus.CREATED);
	}
}
