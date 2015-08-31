package org.frenchman.borrowings.ui.rest;
 
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.frenchman.borrowings.application.internal.service.PersonService;
import org.frenchman.borrowings.domain.items.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * Handles requests for the application home page.
 */
@Controller
public class PersonController {
   
  private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
  
  @Inject
  private PersonService personService;
  
  /**
   * Simply selects the home view to render by returning its name.
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    logger.info("Welcome home! The client locale is {}.", locale);
    Date date = new Date();
    DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
    String formattedDate = dateFormat.format(date);
    model.addAttribute("serverTime", formattedDate );
    return "home";
  }
   
  @RequestMapping(value="/persons", method=RequestMethod.GET)
  @ResponseBody
  public List<Person> getAllPersons() {
    logger.info("Inside getAllPersons() method...");
    return personService.getAllPersons();
  }
   
  @RequestMapping(value="/person/{surname}", method=RequestMethod.GET)
  @ResponseBody
  public Person getPersonBySurname(@PathVariable("surname") String surname) {
    Person person = personService.getPersonBySurname(surname);
    if (person != null) {
      logger.info("Inside getPersonBySurname, returned: {}", person);
    } else {
      logger.info("Inside getPersonBySurname, surname: {}, NOT FOUND!", surname);
    }
    return person;
  }
 
  @RequestMapping(value="/person/delete/{surname}", method=RequestMethod.GET)
  @ResponseBody
  public Person deletePersonBySurname(@PathVariable("surname") String surname) {
    Person person = personService.deletePersonBySurname(surname);
    if (person != null) {
      logger.info("Inside deletePersonBySurname, deleted: {}", person);
    } else {
      logger.info("Inside deletePersonBySurname, surname: {}, NOT FOUND!", surname);
    }
    return person;
  }
 
  @RequestMapping(value="/person/create", method=RequestMethod.GET)
  public ModelAndView addPerson() {
    return new ModelAndView("addPerson", "command", new Person());
  }
   
  @RequestMapping(value="/person/addPerson", method=RequestMethod.POST)
  @ResponseBody
  public Person addPerson(@ModelAttribute("person") Person person) {
    if (person != null) {
      logger.info("Inside addPerson, adding: {}" + person);
      personService.save(person);
    } else {
      logger.info("Inside addPerson...");
    }
    return person;
  }
}