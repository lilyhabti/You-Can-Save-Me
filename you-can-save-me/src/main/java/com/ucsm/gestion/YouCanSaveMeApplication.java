package com.ucsm.gestion;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class YouCanSaveMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YouCanSaveMeApplication.class, args);
	}

//	@Bean
//	CommandLineRunner start(AccountService accountService,AnimalService animalService,MembreService membreService,TaskService taskService) {
//		
//		return args -> {
//			accountService.addNewRole(new AppRole(null,"ADMIN"));
//			accountService.addNewRole(new AppRole(null,"VISITEUR"));
//			accountService.addNewRole(new AppRole(null,"MEMBRE"));
//			
//			accountService.addNewAdmin(new Admin(null,"EL HABTI","Fatiha","Red","12345","fatihaelhabti@gmail.com","071425263",new ArrayList<>(),true));
//			
//			accountService.register(new Visiteur(null,"EL HABTI","Fatiha","Sunshine","12345","fatihaelhabti@gmail.com","071425263",new ArrayList<>(),null,"Femme","Musique"));
//			
//			membreService.save(new Membre(null, "EL HABTI", "Fatiha", "Amy", "12345", "fatihaelhabti@gmail.com", "071425263", new ArrayList<>(), false, null, "Etudiant", 21, new ArrayList<>()));
//	
//			animalService.save(new Animal(null, "Luna", "Chien", "description1", null, 6, null, true, false, new HashSet<>()));
//			
////			taskService.save(new Task(null, "rendez-vous ", "Luna se sent malade", "sante", null, null, "en cours", new HashSet<>(), new Membre(1L, "EL HABTI", "Fatiha", "Amy", "12345", "fatihaelhabti@gmail.com", "071425263", new ArrayList<>(), false, null, "Etudiant", 21, new ArrayList<>())));
//		};
//	}
}
