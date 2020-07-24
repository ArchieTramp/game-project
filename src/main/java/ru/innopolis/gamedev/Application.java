package ru.innopolis.gamedev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.innopolis.models.Role;
import ru.innopolis.models.State;
import ru.innopolis.models.User;
import ru.innopolis.repositories.UsersRepository;

import java.util.prefs.PreferenceChangeEvent;

/**
 * @author 18395435
 * @created_at 07/07/2020 - 14:54
 * @project game-project
 */

@SpringBootApplication
@ComponentScan(basePackages = "ru.innopolis")
@EnableJpaRepositories(basePackages = "ru.innopolis.repositories")
@EntityScan(basePackages = "ru.innopolis.models")
public class Application  {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}
