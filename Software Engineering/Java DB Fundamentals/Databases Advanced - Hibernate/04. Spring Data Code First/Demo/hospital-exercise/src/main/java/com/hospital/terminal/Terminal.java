package com.hospital.terminal;

import com.hospital.domain.*;
import com.hospital.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.Date;
import java.util.HashSet;

@Component
public class Terminal implements CommandLineRunner{

    @Autowired
    private CommentService commentService;

    @Autowired
    private DiagnoseService diagnoseService;

    @Autowired
    private MedicamentService medicamentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private VisitationService visitationService;

    @Override
    public void run(String... strings) throws Exception {

        Patient patient = new Patient();
        patient.setFirstName("John");
        patient.setLastName("Smith");
        patient.setAddress("Sofia");
        patient.setEmail("john@em.com");
        patient.setMedicalInsurance(true);
        patient.setBirthDate(new Date());
        this.patientService.create(patient);

        Visitation visitation = new Visitation();
        visitation.setDate(new Date());
        visitation.setPatient(patient);
        this.visitationService.create(visitation);

        Diagnose diagnose = new Diagnose();
        diagnose.setName("Hrema");
        diagnose.setPatient(patient);
        this.diagnoseService.create(diagnose);


        Comment comment = new Comment();
        comment.setText("Cool comment");
        comment.setVisitation(visitation);
        this.commentService.create(comment);

        Medicament medicament = new Medicament();
        medicament.setName("Aspirin");
        medicament.setPatients(new HashSet<>());
        medicament.getPatients().add(patient);
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
