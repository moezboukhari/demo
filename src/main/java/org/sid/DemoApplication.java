package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.dao.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
private ContactRepository contactRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		DateFormat df=new SimpleDateFormat("DD/MM/YYYY");
		contactRepository.save(new Contact("boukhari", "moez", df.parse("10/10/1979"), "moez.boukhari@gmail.com",98625866, "moez.jpeg"));
		contactRepository.save(new Contact("nom1", "walid", df.parse("10/10/1979"), "moez.boukhari@gmail.com",98625866, "moez.jpeg"));
		contactRepository.save(new Contact("xxx", "sami", df.parse("10/10/1979"), "moez.boukhari@gmail.com",98625866, "moez.jpeg"));
		contactRepository.findAll().forEach(c->{System.out.println(c.getNom()+" "+c.getPrenom());});
		
	}
}
