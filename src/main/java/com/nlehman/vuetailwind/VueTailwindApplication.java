package com.nlehman.vuetailwind;

import com.nlehman.vuetailwind.entities.Product;
import com.nlehman.vuetailwind.entities.User;
import com.nlehman.vuetailwind.repositories.ProductRepository;
import com.nlehman.vuetailwind.repositories.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EntityScan(basePackages = {"com.nlehman.vuetailwind.entities"})
@EnableJpaRepositories(basePackages = {"com.nlehman.vuetailwind.repositories"})
public class VueTailwindApplication {

    private static final Logger log = LoggerFactory.getLogger(VueTailwindApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(VueTailwindApplication.class, args);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CommandLineRunner demo(ProductRepository repository, UserRepository userRepository) {
        return (args) -> {
            User nlehman = new User();
            nlehman.setUsername("nlehman");
            nlehman.setName("Nathan Lehman");
            nlehman.setPassword(passwordEncoder().encode("nlehmanpw"));
            userRepository.save(nlehman);
            User jhester = new User();
            jhester.setUsername("jhester");
            jhester.setName("John Hester");
            jhester.setPassword(passwordEncoder().encode("jhesterpw"));
            userRepository.save(jhester);
            User cstone = new User();
            cstone.setUsername("cstone");
            cstone.setName("Chris Stone");
            cstone.setPassword(passwordEncoder().encode("cstonepw"));
            userRepository.save(cstone);

            log.info("Users found with findAll():");
            log.info("______________________________");
            for (User user : userRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            Product ace = new Product("Ace");
            Product acoustic = new Product("Acoustic");
            Product analog = new Product("Analog");
            Product wcAbstract = new Product("Abstract");
            Product alleyCat = new Product("Alley Cat");
            Product acousticord = new Product("Acousticord");
            Product aloft = new Product("Aloft");
            Product blitz = new Product("Blitz");
            Product fortuny = new Product("Fortuny2");
            ace.setImage("fabrics/kace-hot.jpg");
            acoustic.setImage("fabrics/kacoustic-ardent.jpg");
            analog.setImage("fabrics/kanalog-grapefruit.jpg");
            wcAbstract.setImage("fabrics/kabstract-antique_silver.jpg");
            alleyCat.setImage("fabrics/kalley_cat-stone_wash.jpg");
            acousticord.setImage("fabrics/kacousticord-heather.jpg");
            aloft.setImage("fabrics/kaloft-plains.jpg");
            blitz.setImage("fabrics/kblitz-prisma.jpg");
            fortuny.setImage("fabrics/kfortuny-arundel.jpg");
            wcAbstract.setCategory(com.nlehman.vuetailwind.models.Product.WALLCOVERING);
            alleyCat.setCategory(com.nlehman.vuetailwind.models.Product.WALLCOVERING);
            acousticord.setCategory(com.nlehman.vuetailwind.models.Product.WALLCOVERING);
            aloft.setCategory(com.nlehman.vuetailwind.models.Product.PRIVACY_CURTAIN);
            blitz.setCategory(com.nlehman.vuetailwind.models.Product.PRIVACY_CURTAIN);
            fortuny.setCategory(com.nlehman.vuetailwind.models.Product.PRIVACY_CURTAIN);
            repository.save(ace);
            repository.save(acoustic);
            repository.save(analog);
            repository.save(wcAbstract);
            repository.save(alleyCat);
            repository.save(acousticord);
            repository.save(aloft);
            repository.save(blitz);
            repository.save(fortuny);

            log.info("Products found with findAll():");
            log.info("______________________________");
            for (Product product : repository.findAll()) {
                log.info(product.toString());
            }
            log.info("");

            Product product = repository.findById(1L);
            log.info("Product found with findById(1L):");
            log.info("________________________________");
            log.info(product.toString());
            log.info("");

            log.info("Product found with findByName('Ace'):");
            log.info("_____________________________________");
            repository.findByName("Ace").forEach(p -> {
                log.info(p.toString());
            });
            log.info("");
        };
    }

}
