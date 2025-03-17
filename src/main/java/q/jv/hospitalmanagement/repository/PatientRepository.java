package q.jv.hospitalmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import q.jv.hospitalmanagement.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
