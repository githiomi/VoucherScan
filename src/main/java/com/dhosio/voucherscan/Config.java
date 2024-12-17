package com.dhosio.voucherscan;

import com.dhosio.voucherscan.models.Enums.Branch;
import com.dhosio.voucherscan.models.Enums.Gender;
import com.dhosio.voucherscan.models.User;
import com.dhosio.voucherscan.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Config {

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "manual.db.populate", havingValue = "true")
    CommandLineRunner commandLineRunner(UserService service) {
        return args -> {

            List<User> users = Arrays.asList(
                    new User("Faith", "Wamaitha", Gender.FEMALE, "wamaitha@gmail.com", "faithwama", LocalDate.of(1998, 7, 17), Branch.FLIC_EN_FLAC.getBranchId()),
                    new User("Daniel", "Githiomi", Gender.MALE, "danielgithiomi@gmail.com", "dhosiohoes", LocalDate.of(2001, 8, 27), Branch.GRAND_BAIE.getBranchId()),
                    new User("Nabila", "Modan", Gender.OTHER, "nabilamodan@icloud.com", "amadmodan", LocalDate.of(2002, 4, 28), Branch.QUATRE_BORNES.getBranchId()),
                    new User("Yusuf", "Voisin", Gender.MALE, "yusufvoisin@gmail.com", "voisin35k", LocalDate.of(1980, 12, 16), Branch.ROSE_BELLE.getBranchId())
            );

            service.saveAllUsers(users);
            System.out.println("Users Added");

        };
    }
}
