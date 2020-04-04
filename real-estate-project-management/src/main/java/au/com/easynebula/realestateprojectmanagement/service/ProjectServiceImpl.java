package au.com.easynebula.realestateprojectmanagement.service;

import au.com.easynebula.realestateprojectmanagement.domain.Project;
import au.com.easynebula.realestateprojectmanagement.dto.ProjectDto;
import au.com.easynebula.realestateprojectmanagement.dto.Property;
import au.com.easynebula.realestateprojectmanagement.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.Collections.EMPTY_LIST;
import static org.springframework.http.HttpStatus.OK;

@Service
@RefreshScope
public class ProjectServiceImpl implements ProjectService {

	private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

	private final ProjectRepository repository;

	private final RestTemplate restTemplate;

	@Value("${propertyServiceUrl}")
	private String propertyServiceUrl;

	@Autowired
	public ProjectServiceImpl(final ProjectRepository repository, final RestTemplate restTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
	}

	@Override
	public ProjectDto createProject(final ProjectDto newProject) {
		final Project project = new Project();
		BeanUtils.copyProperties(newProject, project);
		final Project savedProject = repository.save(project);
		newProject.setId(savedProject.getId());
		return newProject;
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		final List<Project> all = repository.findAll();
		final List<ProjectDto> projectDtos = new ArrayList<>();
		all.forEach(project -> {
			final ProjectDto projectDto = new ProjectDto();
			BeanUtils.copyProperties(project, projectDto);
			projectDtos.add(projectDto);
		});
		return projectDtos;
	}

	@Override
	public ProjectDto getProject(final String projectNumber, final boolean withProperties) {
		final Optional<Project> byProjectNumber = repository.findByProjectNumber(projectNumber);
		final ProjectDto projectDto = new ProjectDto();
		return byProjectNumber.map(project -> {
			if(withProperties) {
				getPropertyDetails(projectNumber, projectDto);
			}
			BeanUtils.copyProperties(project, projectDto);
			return projectDto;
		}).orElse(null);
	}

	private void getPropertyDetails(final String projectNumber, final ProjectDto projectDto) {
		final ResponseEntity<Property[]> forEntity = restTemplate.getForEntity(propertyServiceUrl, Property[].class, projectNumber);
		final Predicate<ResponseEntity<Property[]>> predicate = responseEntity -> responseEntity.hasBody()
				&& (responseEntity.getStatusCode() == OK)
				&& responseEntity.getBody() != null;
		final List<Property> properties = predicate.test(forEntity) ? asList(forEntity.getBody()) : EMPTY_LIST;
		projectDto.setProperties(properties);
	}

	@Override
	public void deleteProject(final String projectNumber) {

	}

	@Override
	public void updateProject(final Project updatedProject) {

	}
}
