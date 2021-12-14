package services;

import models.entities.Customer;
import models.entities.Person;
import models.entities.Trainer;
import models.repositories.PersonRepository;
import models.repositories.Repository;

import java.util.List;

public class PersonService extends Service<Person>{

    public PersonService() {
        super();
        this.repository = new PersonRepository();
    }
    public List<Trainer> findTrainers(){
        return ((PersonRepository) repository).findTrainers();
    }
    public List<Customer> findCustomers(){
        return ((PersonRepository) repository).findCustomers();
    }
}
