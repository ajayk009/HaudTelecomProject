package org.haud.controller;

import java.util.List;

import org.haud.dto.CustomerRequestDto;
import org.haud.dto.CustomerResponseDto;
import org.haud.dto.CustomerSimResponseDto;
import org.haud.dto.UpdateCustomerRequestDto;
import org.haud.mapper.CustomerMapper;
import org.haud.model.AuditTrail;
import org.haud.model.Customer;
import org.haud.service.AuditTrailService;
import org.haud.service.CustomerService;
import org.haud.utils.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.haud.utils.Headers;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AuditTrailService auditTrailService;

	@PostMapping(value="/save")
    public ResponseEntity<CustomerResponseDto> addCustomer(@RequestHeader(Headers.USER_NAME) String userName,@RequestBody CustomerRequestDto request)
	{
		
		AuditTrail auditTrail = new AuditTrail(userName,"create-api");
		auditTrailService.save(auditTrail);

		log.info("Creating customer " + request);
		Request.verifyCustomerPost(request);
		Customer customer = CustomerMapper.toCustomer(request);

		customerService.addCustomer(customer,userName);

		log.info("Customer created in database with id " + customer.getId());

		return new ResponseEntity<>(CustomerMapper.toCustomerResponse(customer), HttpStatus.CREATED);
	}

	@PutMapping(value ="update/{customerid}")
	public ResponseEntity<Void> linkSimCardToCustomer(@RequestHeader(Headers.USER_NAME) String userName,@PathVariable("customerid") long customerId,
			@RequestBody UpdateCustomerRequestDto request)
	{
		AuditTrail auditTrail = new AuditTrail(userName,"apiname");
		auditTrailService.save(auditTrail);

		List<Long> simCardId = request.getSimcardId();

		log.info("Linking sim card to customer , sim card id: " + simCardId + "customer id: " + customerId);
		Request.verifyCustomerPut(customerId, simCardId, customerService);
		customerService.updateCustomer(customerId, simCardId,userName);

		log.info("Customer id :" + customerId + "linked with sim card id :" + simCardId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{customerid}")

	public ResponseEntity<CustomerSimResponseDto> getCustomerSimCard(@PathVariable("customerid") long customerId) {

		log.info("Getting customer's sim with customer id :" + customerId);
		Request.verifyCustomerGet(customerId, customerService);
		Customer customer = customerService.getCustomer(customerId);

		log.info("Customer retrived with id " + customerId);
		return new ResponseEntity<>(CustomerMapper.toCustomerSimResponseDto(customer), HttpStatus.OK);
	}
}
