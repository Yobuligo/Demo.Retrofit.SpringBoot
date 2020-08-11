package com.example.demoretrofitspringboot.requestParameter;

public class RequestParameterBuilder implements IRequestParameterBuilder {

	private String sortTerm;
	private String sortOrder;
	private Integer pageSize;
	private Integer pageNumber;

	@Override
	public IRequestParameterBuilder setSortTerm(String sortTerm) {
		this.sortTerm = sortTerm;
		return this;
	}

	@Override
	public IRequestParameterBuilder setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
		return this;
	}

	@Override
	public IRequestParameterBuilder setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	@Override
	public IRequestParameterBuilder setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
		return this;
	}

	@Override
	public IRequestParameter build() {
		return new RequestParameter(sortTerm, sortOrder, pageNumber, pageSize);
	}
}
