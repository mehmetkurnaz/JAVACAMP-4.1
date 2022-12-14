package Kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLangugeRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLangugeRepository {
	List<ProgrammingLanguage> programmingLanguages = new ArrayList<ProgrammingLanguage>();
	

	public InMemoryProgrammingLanguageRepository() {
		//programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1, "JAVA"));
		programmingLanguages.add(new ProgrammingLanguage(2, "PHYTON"));
		programmingLanguages.add(new ProgrammingLanguage(3, "C#"));

	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// TODO Auto-generated method stub
		return programmingLanguages;
	}
	@Override
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		programmingLanguage.setId(ProgrammingLanguage.getCounter()+1);
		return programmingLanguage;
	}
	@Override
	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.remove(programmingLanguage.getId());
		return programmingLanguage;
	}
	@Override
	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage, String newProgrammingLanguage) {
		programmingLanguage.setProgrammingLanguage(newProgrammingLanguage);
		return programmingLanguage;
	}
	@Override
	public ProgrammingLanguage findById(ProgrammingLanguage programmingLanguage, int id){
		for (ProgrammingLanguage programmingLanguage2 : programmingLanguages) {
			if(programmingLanguage2.getId() == id) {
				programmingLanguage.setProgrammingLanguage(programmingLanguage2.getProgrammingLanguage());;
			}
		}
		
		return programmingLanguage;
	}

}
