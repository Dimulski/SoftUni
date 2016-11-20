package app.terminal;

import app.domain.*;
import app.service.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashSet;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private CommentService commentService;

    @Autowired
    private DiagnoseService diagnoseService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitationService visitationService;

    @Override
    public void run(String... strings) throws Exception {

        Patient patient = new Patient();
        patient.setFirstName("Pesho");
        patient.setLastName("Peshev");
        patient.setAddress("Sofia");
        patient.setEmail("pesho@abv.com");
        patient.setBirthDate(new Date());
        patient.setHasMedicalInsurance(true);
        Doctor doctor = new Doctor();
        doctor.setName("Stefan");
        doctor.setSpecialty("Surgeon");
        Visitation visitation = new Visitation();
        visitation.setDate(new Date());
        visitation.setPatient(patient);
        visitation.setDoctor(doctor);
        Diagnose diagnose = new Diagnose();
        diagnose.setName("Cold");
        diagnose.setPatient(patient);
        Comment comment = new Comment();
        comment.setText("Cool comment");
        comment.setVisitation(visitation);
        comment.setDiagnose(diagnose);
        Medicament medicament = new Medicament();
        medicament.setName("Aspirin");
        medicament.setPatients(new HashSet<>());
        medicament.getPatients().add(patient);

        this.patientService.create(patient);
        this.doctorService.create(doctor);
        this.visitationService.create(visitation);
        this.diagnoseService.create(diagnose);
        this.commentService.create(comment);
        this.medicamentService.create(medicament);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = bufferedReader.readLine()).equals("Stop")){
            long id = Long.parseLong(line);
            Patient p = this.patientService.retrieve(id);
            System.out.println(p.toString());
        }
    }
}
