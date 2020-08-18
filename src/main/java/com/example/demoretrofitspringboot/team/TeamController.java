package com.example.demoretrofitspringboot.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoretrofitspringboot.requestParameter.IRequestParameter;
import com.example.demoretrofitspringboot.requestParameter.RequestParameterBuilder;

@RestController
@RequestMapping("/api")
public class TeamController {
	@Autowired
	private ITeamService teamService;

	@GetMapping("/teams")
	public Iterable<Team> findAll(
			@RequestParam(name = "sort", required = false) String sort,
			@RequestParam(name = "order", required = false) String order,
			@RequestParam(name = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(name = "pageSize", required = false) Integer pageSize) {

		IRequestParameter requestParameter = new RequestParameterBuilder()
				.setSortTerm(sort)
				.setSortOrder(order)
				.setPageNumber(pageNumber)
				.setPageSize(pageSize)
				.build();

		return teamService.findAll(requestParameter);
	}

	@GetMapping("/teams/{id}")
	public Team findById(@PathVariable("id") Long id) {
		return teamService.findById(id);
	}

	@PostMapping("/teams")
	public Team addTeam(@RequestBody Team team) {
		return teamService.addTeam(team);
	}
}
