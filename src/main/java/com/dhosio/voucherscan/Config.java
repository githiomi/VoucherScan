package com.dhosio.voucherscan;

import com.dhosio.voucherscan.models.Branch;
import com.dhosio.voucherscan.models.User;
import com.dhosio.voucherscan.services.impl.UserService;
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
                    new User("Faith", "Wamaitha", "wamaitha@gmail.com", "faithwama", LocalDate.of(1998, 7, 17), Branch.FLIC_EN_FLAC.getBranchId()),
                    new User("Daniel", "Githiomi", "danielgithiomi@gmail.com", "dhosiohoes", LocalDate.of(2001, 8, 27), Branch.GRAND_BAIE.getBranchId()),
                    new User("Nabila", "Modan", "nabilamodan@icloud.com", "amadmodan", LocalDate.of(2002, 4, 28), Branch.QUATRE_BORNES.getBranchId())
            );

            service.saveAllUsers(users);
            System.out.println("Users Added");

        };
    }
}
