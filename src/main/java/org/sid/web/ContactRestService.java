package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ContactRepository;
import org.sid.dao.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin("*")
public class ContactRestService {
	@Autowired
	ContactRepository contactRepository;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}
	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public Optional<Contact> getContact(@PathVariable Long id) {
		return contactRepository.findById(id);
	}
	@RequestMapping(value = "/contacts", method = RequestMethod.POST)
	public Contact save(@RequestBody Contact c) {
		return contactRepository.save(c);
	}
	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
	public Contact save(@PathVariable Long id,@RequestBody Contact c) {
		c.setId(id);
		return contactRepository.save(c);
	}
	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
	public void supprimer(@PathVariable Long id) {
		contactRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/chercherContacts", method = RequestMethod.GET)
	public Page<Contact> chercher(
			@RequestParam(name="mc",defaultValue="") String mc,
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="5")int size) {
		return  contactRepository.chercher("%"+mc+"%", PageRequest.of(page, size));
	}
}
