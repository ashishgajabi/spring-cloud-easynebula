package au.com.easynebula.realestateprojectmanagement.service;

import au.com.easynebula.realestateprojectmanagement.domain.Project;
import au.com.easynebula.realestateprojectmanagement.dto.ProjectDto;

import java.util.List;

public interface ProjectService {

	ProjectDto createProject(ProjectDto newProject);

	List<ProjectDto> getAllProjects();

	ProjectDto getProject(String projectNumber, boolean withProperties);

	void deleteProject(String projectNumber);

	void updateProject(Project updatedProject);
}
