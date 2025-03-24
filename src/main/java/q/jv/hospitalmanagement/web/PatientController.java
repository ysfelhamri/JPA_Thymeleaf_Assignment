package q.jv.hospitalmanagement.web;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import q.jv.hospitalmanagement.entities.Patient;
import q.jv.hospitalmanagement.repository.PatientRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {

    private PatientRepository patientRepository;
    @GetMapping("/index")
    public String index(Model model, @RequestParam(name="page",defaultValue = "0") int page,@RequestParam(name="size",defaultValue = "4") int size) {
        Page<Patient> patientsPage = patientRepository.findAll(PageRequest.of(page,size));
        model.addAttribute("patients", patientsPage.getContent());
        model.addAttribute("pages",new int[patientsPage.getTotalPages()]);
        model.addAttribute("currentPage",page);
        return "patients";
    }
}
