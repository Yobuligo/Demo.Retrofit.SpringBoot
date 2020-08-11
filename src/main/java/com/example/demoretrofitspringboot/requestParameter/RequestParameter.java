package com.example.demoretrofitspringboot.requestParameter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

public class RequestParameter implements IRequestParameter {

	private String sortTerm;
	private String sortOrder;
	private Integer pageSize;
	private Integer pageNumber;

	public RequestParameter(String sortTerm, String sortOrder, Integer pageNumber, Integer pageSize) {
		this.sortTerm = sortTerm;
		this.sortOrder = sortOrder;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	@Override
	public Pageable getPageable() {
		return createPageable();
	}

	@Override
	public Sort getSort() {
		return createSort();
	}

	private Sort createSort() {
		if (sortTerm == null) {
			return null;
		}

		List<Order> orders = new ArrayList<>();
		Direction defaultDirection = getDefaultDirection();

		String[] sorts = sortTerm.split(",");
		for (String sort : sorts) {
			Direction sortDirection = defaultDirection;
			String[] sortExpressions = sort.split(":");
			if (sortExpressions.length > 1) {
				if (sortExpressions[1].equals("asc")) {
					sortDirection = Sort.Direction.ASC;
				} else {
					sortDirection = Sort.Direction.DESC;
				}
			}

			orders.add(new Order(sortDirection, sortExpressions[0]));
		}

		return Sort.by(orders);
	}

	private Pageable createPageable() {
		if ((pageNumber != null) && (pageSize != null)) {
			if (sortTerm != null) {
				return PageRequest.of(pageNumber, pageSize, createSort());
			} else {
				return PageRequest.of(pageNumber, pageSize);
			}
		}

		return null;
	}

	private Direction getDefaultDirection() {
		if (sortOrder == null) {
			return Sort.Direction.ASC;
		}

		if (sortOrder.equals("asc")) {
			return Sort.Direction.ASC;
		}

		return Sort.Direction.DESC;
	}

}
