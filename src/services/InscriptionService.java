package services;

import models.entities.Inscription;
import models.repositories.InscriptionRepository;

public class InscriptionService extends Service<Inscription>{
    public InscriptionService(){
        super();
        this.repository = new InscriptionRepository();
    }
}
