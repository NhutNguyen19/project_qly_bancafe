package project.duan.qlybancafe.configuration;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.duan.qlybancafe.constant.PredefinedRole;
import project.duan.qlybancafe.model.Account;
import project.duan.qlybancafe.model.Role;
import project.duan.qlybancafe.repository.AccountRepository;
import project.duan.qlybancafe.repository.RoleRepository;

import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_NAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "admin";

    @Bean
    @ConditionalOnProperty(
            prefix = "spring.datasource",
            name = "driver-class-name",
            havingValue = "org.mariadb.jdbc.Driver"
    )
    ApplicationRunner applicationRunner(
            AccountRepository accountRepository, RoleRepository roleRepository) {
        log.info("Initializing application");
        return args -> {
            // Check if the admin user already exists
            if (accountRepository.findByUsername(ADMIN_NAME).isEmpty()) {
                // Create and save roles
                Role userRole = Role.builder()
                        .name(PredefinedRole.USER_ROLE)
                        .description("User role")
                        .build();
                Role adminRole = Role.builder()
                        .name(PredefinedRole.ADMIN_ROLE)
                        .description("Admin role")
                        .build();
                roleRepository.save(userRole);
                adminRole = roleRepository.save(adminRole); // Update reference to saved adminRole

                // Create and save the admin user with adminRole
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                Account account = Account.builder()
                        .username(ADMIN_NAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .roles(roles)
                        .build();
                accountRepository.save(account);

                log.warn("Admin user has been created with default password: admin, please change it");
            }
            log.info("Application initialization completed .....");
        };
    }
}
