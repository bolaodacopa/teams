package tk.bolaodacopa.teams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tk.bolaodacopa.teams.models.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {	
	Optional<Team> findByFifacode(String fifacode);
}
