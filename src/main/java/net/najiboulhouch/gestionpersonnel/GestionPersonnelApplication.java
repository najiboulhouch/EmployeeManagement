package net.najiboulhouch.gestionpersonnel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class GestionPersonnelApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionPersonnelApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

   /* @Bean
    CommandLineRunner startApp(EmployeeService employeeService , FonctionService fonctionService){

        return args -> {
            Fonction fonction = new Fonction("INFO", "IN");
            fonctionService.save(fonction);

            //restConfiguration.exposeIdsFor(Compte.class);
            employeeService.save(new Employee("AB6589","OULHOUCH","NAJIB",new Date(),
                    "Sale","34 rue des binelles", "MAROCAINE", EtatCivil.MARIE,"0678880",
                    4500,"najib@gmail.com",fonction,"photo.png"));
            employeeService.save(new Employee("AB658s9","OULsHOUCH","NAJIB",new Date(),
                    "Sale","34 rue des binellses", "MAROCAsINE", EtatCivil.MARIE,"0678880",
                    4500,"najibs@gmail.com",fonction,"photo.png"));
            employeeService.findAll().forEach(cp -> {
                System.out.println(cp.getCin());
                System.out.println(cp.getSalaire());
            });
        };
    }*/
}
