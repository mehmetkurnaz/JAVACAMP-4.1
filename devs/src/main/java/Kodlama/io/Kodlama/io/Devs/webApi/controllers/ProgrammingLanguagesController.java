package Kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;
	Scanner scan = new Scanner(System.in);

	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageService.getAll();
	}

	@GetMapping("/add")
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) throws Exception {

		System.out.println("Please enter new programming language : ");
		programmingLanguage.setProgrammingLanguage(scan.nextLine());
		programmingLanguageService.add(programmingLanguage);
		System.out.println("New Programming Language has been added by id " + programmingLanguage.getId());
		return programmingLanguage;
	}

	@GetMapping("/delete")
	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage) {
		System.out.println("Enter the programming language to be deleted");
		programmingLanguage.setProgrammingLanguage(scan.nextLine());
		programmingLanguageService.delete(programmingLanguage);
		System.out.println("Deleted");
		return programmingLanguage;
	}

	@GetMapping("/update")
	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage, String newProgrammingLanguage) {
		System.out.println("Enter programming language to be uptated : ");
		programmingLanguage.setProgrammingLanguage(scan.nextLine());
		System.out.println("Enter new programming language : ");
		newProgrammingLanguage = scan.nextLine();
		System.out.println("UPDATED");
		return programmingLanguage;
	}

	@GetMapping("/findbyid")
	public ProgrammingLanguage findById(ProgrammingLanguage programmingLanguage, int id) {
		System.out.println("Enter id to intended to be found : ");
		id = scan.nextInt();
		programmingLanguageService.findById(programmingLanguage, id);
		System.out.println("Found");
		return programmingLanguage;

	}
}
