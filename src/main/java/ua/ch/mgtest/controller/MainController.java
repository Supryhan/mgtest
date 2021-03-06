package ua.ch.mgtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ch.mgtest.model.Contact;
import ua.ch.mgtest.service.ContactService;

import java.util.concurrent.ExecutionException;

@Controller
public class MainController {

	private final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired(required = true)
	private ContactService contactService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView showAll() {
		logger.info("showAll()");
		ModelAndView modelAndView = new ModelAndView("all");
		try {
			modelAndView.addObject("contacts", contactService.getAll().get());
		} catch (InterruptedException | ExecutionException e) {
			System.err.print(e.getMessage());
		}
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showAddForm() {
		logger.info("showAddForm()");
		return new ModelAndView("add_form", "contact", new Contact());
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact) {
		logger.info("addContact()");
		if (StringUtils.isEmpty(contact.getId())) {
			contactService.add(contact);
		} else {
			contactService.update(contact);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView showEditForm(@RequestParam(required = true) String id) {
		logger.info("showEditForm()");
		Object editItem = null;
		try {
			editItem = contactService.get(id).get();
		} catch (InterruptedException | ExecutionException e) {
			System.err.print(e.getMessage());
		}
		return new ModelAndView("add_form", "contact", editItem);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteContact(@RequestParam(required = true) String id) {
		logger.info("deleteContact()");
		contactService.remove(id);
		return "redirect:/";
	}
}
