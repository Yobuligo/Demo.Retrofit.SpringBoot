package com.example.demoretrofitspringboot.requestParameter;

public interface IRequestParameterBuilder {
	IRequestParameterBuilder setSortTerm(String sortTerm);

	IRequestParameterBuilder setSortOrder(String sortOrder);

	IRequestParameterBuilder setPageSize(Integer pageSize);

	IRequestParameterBuilder setPageNumber(Integer pageNumber);

	IRequestParameter build();
}
