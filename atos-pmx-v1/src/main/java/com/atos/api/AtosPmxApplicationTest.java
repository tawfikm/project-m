/*package com.atos.api;

import java.util.Calendar;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.atos.api.entities.Project;
import com.atos.api.repositories.ProjectRepository;

import net.sf.mpxj.Duration;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.RelationType;
import net.sf.mpxj.Resource;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;
import net.sf.mpxj.TimeUnit;

@SpringBootApplication
public class AtosPmxApplicationTest implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(AtosPmxApplicationTest.class);

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
//		SpringApplication.run(AtosPmxApplicationTest.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		ProjectFile projectFile = new ProjectFile();
		projectFile.getProjectProperties().setAuthor("Hassan");
		projectFile.getProjectProperties().setProjectTitle("MT TMA SIC 2019-2022");

		Resource r1 = addResource(projectFile, "R1");
		Resource r2 = addResource(projectFile, "R2");
		Resource r3 = addResource(projectFile, "R3");
		Resource r4 = addResource(projectFile, "R4");
		Resource r5 = addResource(projectFile, "R5");
		Resource r6 = addResource(projectFile, "R6");

		Calendar rightNow = Calendar.getInstance();

		Task projectExample = projectFile.addTask();
		projectExample.setName("MT TMA SIC 2019-2022");

		Task t1 = projectExample.addTask();
		t1.setName("FC1");

		Task subt1 = t1.addTask();
		subt1.setName("Etude");
		subt1.setDuration(Duration.getInstance(2, TimeUnit.DAYS));
		rightNow.set(2019, 6, 15);
		subt1.setStart(rightNow.getTime());

		Task subt2 = t1.addTask();
		subt2.setName("Dev");
		subt2.setDuration(Duration.getInstance(4, TimeUnit.DAYS));
		rightNow.set(2019, 6, 17);
		subt2.setStart(rightNow.getTime());
		subt2.addPredecessor(subt1, RelationType.FINISH_START, Duration.getInstance(0, TimeUnit.HOURS));

		Task subt3 = t1.addTask();
		subt3.setName("TIG");
		subt3.setDuration(Duration.getInstance(1, TimeUnit.DAYS));
		rightNow.set(2019, 6, 21);
		subt3.setStart(rightNow.getTime());
		subt3.addPredecessor(subt2, RelationType.FINISH_START, Duration.getInstance(0, TimeUnit.HOURS));

		addResourceAssignment(subt1, r1, 2, 0, 2);
		addResourceAssignment(subt2, r3, 4, 0, 4);
		addResourceAssignment(subt2, r5, 4, 0, 4);
		addResourceAssignment(subt3, r2, 1, 0, 1);
		//////////////////////
		Task t2 = projectExample.addTask();
		t2.setName("FC2");

		Task t2_1 = t2.addTask();
		t2_1.setDuration(Duration.getInstance(6, TimeUnit.DAYS));
		t2_1.setName("Etude");
		rightNow.set(2019, 6, 15);
		t2_1.setStart(rightNow.getTime());

		Task t2_2 = t2.addTask();
		t2_2.setName("Dev");
		t2_2.setDuration(Duration.getInstance(20, TimeUnit.DAYS));
		rightNow.set(2019, 6, 23);
		t2_2.setStart(rightNow.getTime());
		t2_2.addPredecessor(t2_1, RelationType.FINISH_START, Duration.getInstance(0, TimeUnit.HOURS));

		Task t2_3 = t2.addTask();
		t2_3.setName("TIG");
		t2_3.setDuration(Duration.getInstance(4, TimeUnit.DAYS));
		rightNow.set(2019, 7, 24);
		t2_3.setStart(rightNow.getTime());
		// t2_3.setActualStart(rightNow.getTime());
		t2_3.addPredecessor(t2_2, RelationType.FINISH_START, Duration.getInstance(0, TimeUnit.HOURS));

		addResourceAssignment(t2_1, r1, 6, 0, 6);
		addResourceAssignment(t2_2, r3, 20, 0, 20);
		addResourceAssignment(t2_2, r4, 20, 0, 20);
		addResourceAssignment(t2_2, r5, 20, 0, 20);
		addResourceAssignment(t2_3, r6, 4, 0, 4);
		////////////////////
//
//		Project project = new Project(projectFile);
//		projectRepository.deleteAll();
//		project.setObjId(ObjectId.get());
//		projectRepository.save(project);
		System.out.println("################### PROJECT INFO #################");
		
		Project proj = projectRepository.findByObjId(new ObjectId("5d4199174e14772df84a6c39"));
		System.out.println(proj);
			
	}

	public ResourceAssignment addResourceAssignment(Task task, Resource r, int DayPeriod, int actualWork,
			int remaigningWork) {

		ResourceAssignment assignment1 = task.addResourceAssignment(r);
		assignment1.setWork(Duration.getInstance(DayPeriod, TimeUnit.DAYS));
		assignment1.setActualWork(Duration.getInstance(actualWork, TimeUnit.HOURS));
		assignment1.setRemainingWork(Duration.getInstance(remaigningWork, TimeUnit.DAYS));
		return assignment1;

	}

	public Resource addResource(ProjectFile pf, String r) {
		Resource res = pf.addResource();
		res.setName(r);
		return res;

	}
}

 * Resource r1 = addResource(projectFile, "R1"); Resource r2 =
 * addResource(projectFile, "R2");
 * 
 * resourceRepository.deleteAll(); resourceRepository.save(new
 * com.atos.api.entities.Resource(r1)); resourceRepository.save(new
 * com.atos.api.entities.Resource(r2));
 * 
 * System.out.println("Resources found with findAll():");
 * System.out.println("-------------------------------"); for
 * (com.atos.api.entities.Resource r : resourceRepository.findAll()) {
 * System.out.println(r.getName()); }
 * System.out.println("-------------------------------");
 * System.out.println("Find By ID:");
 * System.out.println(resourceRepository.findByObjId("5d3058a11b4d4021d0eb9e1a")
 * );
 
// taskRepository.deleteAll();
// taskRepository.save(new com.atos.api.entities.Task(subt1));
// taskRepository.save(new com.atos.api.entities.Task(subt2));
// taskRepository.save(new com.atos.api.entities.Task(subt3));

// System.out.println("tasks found with findAll():");
// System.out.println("-------------------------------");
// for (com.atos.api.entities.Task t : taskRepository.findAll()) {
// System.out.println(t);
// }
project.getTasks().forEach(e -> {
	if(e.getDuration() != null)
	{
		System.out.println("###  Task ID: "+ e.getIdt());
		System.out.println("###  Name: "+ e.getName());
		System.out.println("###  resources: "+ e.getResources());
		System.out.println("###  start Date: "+ e.getStartDate());
		System.out.println("###  finish Date: "+ e.getFinishDate());
		System.out.println("###  % complete: "+ e.getPercentageComplete());
		System.out.println("###  dependencies: "+ e.getPrdecessecors());
	}

});

*/