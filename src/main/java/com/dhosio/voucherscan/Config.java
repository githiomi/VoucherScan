package com.dhosio.voucherscan;

import com.dhosio.voucherscan.models.Branch;
import com.dhosio.voucherscan.models.User;
import com.dhosio.voucherscan.services.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Config {

    @Bean
    @ConditionalOnProperty(prefix = "app", name = "manual.db.populate", havingValue = "true")
    CommandLineRunner commandLineRunner(UserService service) {
        return args -> {

            User user = new User("Daniel", "Githiomi", "danielgithiomi@gmail.com", "dhosiohoes", LocalDate.of(2001, 8, 27), Branch.GRAND_BAIE.getBranchId());
            service.init(user);

            System.out.println("User Added");

        };
    }
}
