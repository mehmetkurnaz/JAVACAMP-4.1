package Kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLangugeRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {
	private ProgrammingLangugeRepository programmingLangugeRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLangugeRepository programmingLangugeRepository) {
		super();
		this.programmingLangugeRepository = programmingLangugeRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		// Business rules
		return programmingLangugeRepository.getAll();
	}

	@Override
	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage) throws Exception {
		// Business rule1 : Programming language cannot be blank!
		if (programmingLanguage.getProgrammingLanguage().equals(" ")) {
			throw new Exception("Programming language cannot be blank!");
		}
		// Business rule2 : Programming languages can not be repeated.
		List<ProgrammingLanguage> programmingLanguages2 = programmingLangugeRepository.getAll();

		for (ProgrammingLanguage programmingLanguage2 : programmingLanguages2) {
			if (programmingLanguage2.getProgrammingLanguage().equals(programmingLanguage.getProgrammingLanguage())) {
				throw new Exception("Programming languages can not be repeated!");
			}
		}
		return programmingLangugeRepository.add(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage) {
		// Business rules
		return programmingLangugeRepository.delete(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage, String newProgrammingLanguage) {
		// Business rules
		return programmingLangugeRepository.update(programmingLanguage, newProgrammingLanguage);
	}

	@Override
	public ProgrammingLanguage findById(ProgrammingLanguage programmingLanguage, int id) {
		// Business rules
		return programmingLangugeRepository.findById(programmingLanguage, id);
	}

}
