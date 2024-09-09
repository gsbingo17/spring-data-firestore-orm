package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List; // Add this import statement
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MainApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(MyService myService) {
    return args -> {
      // Call the methods of MyService and print the output
      MyEntity savedEntity = myService.save(new MyEntity("some-id", "some-data"));
      System.out.println("Saved entity: " + savedEntity);

      List<MyEntity> allEntities = myService.findAll();
      System.out.println("All entities: " + allEntities);

      MyEntity foundEntity = myService.findById("some-id");
      System.out.println("Found entity: " + foundEntity);

      //myService.deleteById("some-id");
      //System.out.println("Deleted entity with id: some-id");
    };
  }
}
