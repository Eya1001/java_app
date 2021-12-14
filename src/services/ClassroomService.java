package services;

import models.entities.Classroom;
import models.repositories.ClassroomRepository;

public class ClassroomService extends Service<Classroom>{
    public ClassroomService(){
        super();
        this.repository = new ClassroomRepository();
    }
}
