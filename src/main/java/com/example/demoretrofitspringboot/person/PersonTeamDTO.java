package com.example.demoretrofitspringboot.person;

import java.util.List;

import com.example.demoretrofitspringboot.team.Team;

public class PersonTeamDTO {
	private Long id;
	private List<Team> teams;

	public Long getId() {
		return id;
	}

	public static Builder createFromBuilder() {
		return new Builder();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public static final class Builder {
		private Long id;
		private List<Team> teams;

		private Builder() {
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setTeams(List<Team> teams) {
			this.teams = teams;
			return this;
		}

		public PersonTeamDTO build() {
			PersonTeamDTO personTeamRequest = new PersonTeamDTO();
			personTeamRequest.id = id;
			personTeamRequest.teams = teams;
			return personTeamRequest;
		}
	}

}