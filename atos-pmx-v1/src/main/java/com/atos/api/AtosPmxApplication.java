package com.atos.api;

import java.util.Arrays;
import java.util.Calendar;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atos.api.entities.Project;
import com.atos.api.entities.Resource;
import com.atos.api.entities.Task;
import com.atos.api.repositories.AssignmentRepository;
import com.atos.api.repositories.ProjectRepository;
import com.atos.api.repositories.ResourceRepository;
import com.atos.api.repositories.TaskRepository;
import com.atos.api.web.ProjectController;

import ch.qos.logback.core.net.SyslogOutputStream;

@SpringBootApplication
public class AtosPmxApplication implements CommandLineRunner {

	// private static final Logger logger =
	// LoggerFactory.getLogger(AtosPmxApplication.class);

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private AssignmentRepository assignmentRepository;

	@Autowired
	private ProjectController projectController;

	public static void main(String[] args) {
		SpringApplication.run(AtosPmxApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * projectRepository.deleteAll();
		 *  project.setObjId(ObjectId.get());
		 * projectRepository.save(project);
		 */
//		 projectRepository.deleteAll();
//		 Project projet = new Project();
//		 projet.setObjId(ObjectId.get());
//		
//		 Resource resource1 = new Resource("RR1", "test", "test@gmail.com");
//		 Resource resource2 = new Resource("RR2", "dev", "test@gmail.com");
//		 Resource resource3 = new Resource("RR3", "tig", "test@gmail.com");
//		
//		 Calendar now = Calendar.getInstance();
//		 now.set(2019, 8, 8);
//		 Task t1 = new Task("etude", 10, now.getTime(), null, 2);
//		 t1.getResources().add(resource1.getName());
//		 now.set(2019, 8, 11);
//		 Task t2 = new Task("dev", 10, now.getTime(), null, 2);
//		 t2.setPredecessors(t1.getIdt());
//		 t2.getResources().add(resource2.getName());
//		 now.set(2019, 8, 14);
//		 Task t3 = new Task("test", 10, now.getTime(), null, 1);
//		 t3.getResources().add(resource3.getName());
//		 t3.setPredecessors(t2.getIdt());
//		 taskRepository.deleteAll();
//		 resourceRepository.deleteAll();
//		 taskRepository.saveAll(Arrays.asList(t1, t2, t3));
//		 resourceRepository.saveAll(Arrays.asList(resource1, resource2, resource3));
//		 projet.getResources().addAll(Arrays.asList(resource1, resource2, resource3));
//		 projet.getTasks().addAll(Arrays.asList(t1, t2, t3));
//		 projet.setProjectManager("tawfik");
//		 projet.setProjectTitle("this is a title");
//		 projet.setDateCreation(Calendar.getInstance().getTime());
//		 projet.setDescription("description");
//		 projectRepository.save(projet);

		System.out.println("################### PROJECT INFO #################");
//		System.out.println(projectRepository.findByObjId(new ObjectId("")));

	}

}
/*
 * Project projet = new Project(); projet.setObjId(ObjectId.get());
 * 
 * Resource resource1 = new Resource("R1", "test", "test@gmail.com"); Resource
 * resource2 = new Resource("R2", "dev", "test@gmail.com"); Resource resource3 =
 * new Resource("R3", "tig", "test@gmail.com");
 * 
 * Calendar now = Calendar.getInstance(); now.set(2019, 8, 8); Task t1 = new
 * Task("etude", 10, now.getTime(), null, "2d");
 * t1.getResources().add(resource1.getName()); now.set(2019, 8, 11); Task t2 =
 * new Task("dev", 10, now.getTime(), null, "2d");
 * t2.getResources().add(resource2.getName()); now.set(2019, 8, 14); Task t3 =
 * new Task("test", 10, now.getTime(), null, "1d");
 * t3.getResources().add(resource3.getName());
 * 
 * taskRepository.saveAll(Arrays.asList(t1, t2, t3));
 * resourceRepository.saveAll(Arrays.asList(resource1, resource2, resource3));
 * projet.getResources().addAll(Arrays.asList(resource1, resource2, resource3));
 * projet.getTasks().addAll(Arrays.asList(t1, t2, t3));
 * projet.setProjectAuthor("manager"); projet.setProjectTitle("project title");
 * 
 * projectRepository.save(projet); Project proj =
 * projectRepository.findByObjId(new ObjectId("5d4199174e14772df84a6c39"));
 * 
 * proj.getTasks().forEach(e -> { if(e.getDuration() != null) {
 * System.out.println("## # Task ID: "+ e.getIdt());
 * System.out.println("### Name: "+ e.getName());
 * System.out.println("### resources: "+ e.getResources());
 * System.out.println("### start Date: "+ e.getStartDate());
 * System.out.println("### finish Date: "+ e.getFinishDate());
 * System.out.println("### % complete: "+ e.getPercentageComplete());
 * System.out.println("### dependencies: "+ e.getPrdecessors()); } }); Project
 * proj = projectRepository.findByObjId(new
 * ObjectId("5d4d50ba1920eb96bc313639"));
 * projectController.getChartdata("5d4d50ba1920eb96bc313639") .forEach(e ->
 * System.out.println("### " + e) );; proj.getTasks().forEach(e -> {
 * if(e.getDuration() != null) { System.out.println("##	#  Task ID: "+
 * e.getIdt()); System.out.println("###  Name: "+ e.getName());
 * System.out.println("###  resources: "+ e.getResources());
 * System.out.println("###  start Date: "+ e.getStartDate());
 * System.out.println("###  finish Date: "+ e.getFinishDate());
 * System.out.println("###  % complete: "+ e.getPercentageComplete());
 * System.out.println("###  dependencies: "+ e.getPrdecessors());
 * System.out.println("###  duration: "+ e.getDuration());
 * 
 * } });
 */