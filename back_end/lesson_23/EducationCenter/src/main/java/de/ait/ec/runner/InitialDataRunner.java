package de.ait.ec.runner;

import de.ait.ec.models.User;
import de.ait.ec.repositories.CoursesRepository;
import de.ait.ec.repositories.LessonsRepository;
import de.ait.ec.repositories.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 8/18/2023
 * EducationCenter
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
@Component
@Profile("!test")
public class InitialDataRunner implements CommandLineRunner {

    UsersRepository usersRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        log.info("InitialDataRunner start...");

        if (!usersRepository.existsByRole(User.Role.ADMIN)) {
            User admin = User.builder()
                    .email("admin@ec.com")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.ADMIN)
                    .hashPassword("$2a$10$vhP3Ca6hm0QtXK2jrlVOQ.tReiadb3scp24dakQA6CUHo4oG7cXNO")
                    .build();

            usersRepository.save(admin);

            log.info("Insert admin into database");
        }

        if (usersRepository.count() == 1) {
            User marsel = User.builder()
                    .email("sidikov.marsel@gmail.com")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.STUDENT)
                    .hashPassword("$2a$10$0zDyBrNPtAwae1Gh7Hpm4OQQN2EUNeuLEZPZE6Yu0sfe.s3kLVl1K")
                    .build();

            log.info("Insert marsel into database");

            User alisher = User.builder()
                    .email("alisher@alisher@ec.com")
                    .state(User.State.CONFIRMED)
                    .role(User.Role.MANAGER)
                    .hashPassword("$2a$10$0zDyBrNPtAwae1Gh7Hpm4OQQN2EUNeuLEZPZE6Yu0sfe.s3kLVl1K")
                    .build();

            usersRepository.save(marsel);
            usersRepository.save(alisher);

            log.info("Insert alisher into database");
        }
    }
}
