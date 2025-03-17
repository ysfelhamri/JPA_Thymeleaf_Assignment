package q.jv.hospitalmanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import q.jv.hospitalmanagement.entities.Patient;
import q.jv.hospitalmanagement.repository.PatientRepository;

import java.util.Date;

@SpringBootApplication
public class HospitalManagementApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient = new Patient();
        patient.setId(null);
        patient.setName("Youssef");
        patient.setDateOfBirth(new Date());
        patient.setSick(true);
        patient.setScore(12);

        patientRepository.save(patient);

        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,25));

        Patient patient3 = Patient.builder()
                .name("Ali")
                .dateOfBirth(new Date())
                .sick(true)
                .score(10)
                .build();
        patientRepository.save(patient3);

    }
}
