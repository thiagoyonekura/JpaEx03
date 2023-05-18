package principal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaManyToMany.Classe;
import jpaManyToMany.Professor;

public class ManyToMany {

	public static void main(String[] args) {

		// Criação do EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaManyToMany");
		EntityManager entitymanager = emf.createEntityManager();
		entitymanager.getTransaction().begin();

		// Criando a entidade Classe
		Classe classe = new Classe("Matematica", null);
		Classe classe2 = new Classe("Geografia", null);
		Classe classe3 = new Classe("Biologia", null);

		// Armazenando Classe
		entitymanager.persist(classe); // salvar o classe no bd
		entitymanager.persist(classe2); // salvar o classe2 no bd
		entitymanager.persist(classe3); // salvar o classe3 no bd

		// Criando um grupo de Classe1
		List<Classe> classes = new ArrayList();
		classes.add(classe);
		// departmentSet1.add(department2);

		// Criando um grupo de Classe2
		List<Classe> classes2 = new ArrayList();
		classes2.add(classe2);

		// Criando um grupo de Classe3
		List<Classe> classes3 = new ArrayList();
		classes3.add(classe3);

		// Criando a entidade professor
		Professor professor1 = new Professor();
		professor1.setTnome("Arthur");
		professor1.setAssunto("Assunto1");
		professor1.setClasses(classes);

		// Criando a entidade professor
		Professor professor2 = new Professor();
		professor2.setTnome("Thiago");
		professor2.setAssunto("Assunto2");
		professor2.setClasses(classes2);

		// Criando a entidade professor
		Professor professor3 = new Professor();
		professor3.setTnome("Marcos");
		professor3.setAssunto("Assunto3");
		professor3.setClasses(classes3);

		// Armazenar professor
		entitymanager.persist(professor1);
		entitymanager.persist(professor2);
		entitymanager.persist(professor3);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emf.close();
	}

}