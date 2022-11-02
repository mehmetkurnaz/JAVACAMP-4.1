package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLangugeRepository {
	List<ProgrammingLanguage> getAll();

	public ProgrammingLanguage add(ProgrammingLanguage programmingLanguage);

	public ProgrammingLanguage delete(ProgrammingLanguage programmingLanguage);

	public ProgrammingLanguage update(ProgrammingLanguage programmingLanguage, String newProgrammingLanguage);

	public ProgrammingLanguage findById(ProgrammingLanguage programmingLanguage, int id);

}
