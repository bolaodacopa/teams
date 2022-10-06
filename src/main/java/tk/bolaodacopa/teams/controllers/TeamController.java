package tk.bolaodacopa.teams.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import tk.bolaodacopa.teams.models.Team;
import tk.bolaodacopa.teams.services.TeamService;

@RestController
@RequestMapping(path = "/api/teams")
public class TeamController {

	private final TeamService service;

	@Autowired
	public TeamController(TeamService service) {
		super();
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public List<Team> addAll(@RequestHeader("x-token-subject") String sub, 
			@RequestBody @NotEmpty(message = "Lista de times não pode ser nula.") List<@Valid Team> teams) {
		return this.service.addAll(teams);
	}

	@GetMapping(path = {"/{fifacode}"})
	@ResponseStatus(HttpStatus.OK)
	public Team findByFifacode(@RequestHeader("x-token-subject") String sub, 
			@PathVariable String fifacode) {
		return this.service.getByFifacode(fifacode);
	}

	@GetMapping
	public List<Team> findAll(@RequestHeader("x-token-subject") String sub) {
		return this.service.findAll();
	}
	
	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(
	  @RequestHeader Map<String, String> headers) {		
		String saida = "";
	    for (Map.Entry<String, String> entry : headers.entrySet()) {
	     saida += (entry.getKey() + ":" + entry.getValue().toString()) +" <> ";
	    }	    
	    
	    return new ResponseEntity<String>(
	      saida, HttpStatus.OK);
	}	

}
