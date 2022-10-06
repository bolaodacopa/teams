package tk.bolaodacopa.teams.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.bolaodacopa.teams.models.Team;
import tk.bolaodacopa.teams.repository.TeamRepository;

@Service
public class TeamService {

	private final TeamRepository teamRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public List<Team> addAll(List<Team> teams) {
		return teamRepository.saveAll(teams);
	}

	public Team getByFifacode(String fifacode) {		
		Team team = teamRepository.findByFifacode(fifacode)
				.orElseThrow(() -> new RuntimeException("Time não encontrado: " + fifacode));		
		return team;
	}

	public List<Team> findAll() {
		return teamRepository.findAll();
	}

}
