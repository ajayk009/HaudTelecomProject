package org.haud.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.haud.dto.CustomerRequestDto;
import org.haud.dto.CustomerResponseDto;
import org.haud.dto.CustomerSimResponseDto;
import org.haud.model.Customer;

public class CustomerMapper {

	private CustomerMapper() {
	}

	public static Customer toCustomer(CustomerRequestDto request) {

		return Customer.builder().name(request.getName()).email(request.getEmail()).build();
	}

	public static CustomerResponseDto toCustomerResponse(Customer customer) {

		return CustomerResponseDto.builder().id(customer.getId()).name(customer.getName()).email(customer.getEmail())
				.build();
	}

	public static List<CustomerResponseDto> toCustomerDto(List<Customer> customers) {

		return customers != null
				? customers.stream().map(CustomerMapper::toCustomerResponse).collect(Collectors.toList())
				: new ArrayList<>();
	}

	public static CustomerSimResponseDto toCustomerSimResponseDto(Customer customer) {

		List<Long> simCardId = customer.getSimCards().stream().map(simCard -> simCard.getId())
				.collect(Collectors.toList());

		return CustomerSimResponseDto.builder().customrId(customer.getId()).simCardId(simCardId).build();
	}

}
