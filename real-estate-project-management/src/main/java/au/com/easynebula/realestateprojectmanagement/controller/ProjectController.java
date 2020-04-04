package au.com.easynebula.realestateprojectmanagement.controller;

import au.com.easynebula.realestateprojectmanagement.dto.ProjectDto;
import au.com.easynebula.realestateprojectmanagement.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/projects")
public class ProjectController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

	private final ProjectService service;

	@Autowired
	public ProjectController(final ProjectService service) {
		this.service = service;
	}

	@GetMapping
	public List<ProjectDto> getAllProjects() {
		return service.getAllProjects();
	}

	@GetMapping("/{projectNumber}")
	public ProjectDto getproject(@PathVariable("projectNumber") final String projectNumber,
	                             @RequestParam(value = "withProperties", required = false, defaultValue = "false") final boolean withProperties) {
		return service.getProject(projectNumber, withProperties);
	}

	@PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ProjectDto createAgent(@RequestBody final ProjectDto newProject) {
		return service.createProject(newProject);
	}
}
