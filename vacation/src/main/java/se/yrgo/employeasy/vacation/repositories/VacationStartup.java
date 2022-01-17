package se.yrgo.employeasy.vacation.repositories;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.yrgo.employeasy.vacation.entities.OpenDate;

import java.util.List;

@Component
public class VacationStartup implements CommandLineRunner {

    private final VacationRepository vacationRepository;

    public VacationStartup(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        vacationRepository.saveAll(List.of(
            new OpenDate(
                "developer"
            )
        ));
    }
}