package com.example.demoretrofitspringboot.requestParameter;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IRequestParameter {
	Pageable getPageable();

	Sort getSort();
}
