package com.charliecodefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.List;

//////////////////////////////////////////////////////////
@SpringBootApplication
//////////////////////////////////////////////////////////
//@ComponentScan(basePackages = "com.charliecodefactory")
//@EnableAutoConfiguration
//@Configuration
//////////////////////////////////////////////////////////
@RestController
public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello, SpringBoot");

        SpringApplication.run(Main.class, args);
    }
    
//////////////////////////////////////////////////////////
    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response = new GreetResponse(
                "Hello, SpringBoot",
                List.of("Java", "Golang", "Javascript"),
                new Person("Charlie", 46, 30_000)
        );
        return response;
    }

    record Person (
            String name,
            int age,
            double savings
    ) {}

    record GreetResponse (
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ) {}

//////////////////////////////////////////////////////////
//    @GetMapping("/greet")
//    public GreetResponse greet() {
//        return new GreetResponse("Hello, SpringBoot");
//    }
//
//    record GreetResponse (String greet) {}
//////////////////////////////////////////////////////////
//    @GetMapping("/greet")
//    public GreetResponse greet() {
//        return new GreetResponse("Hello, SpringBoot");
//    }
//
//    class GreetResponse {
//        private final String greet;
//
//        GreetResponse(String greet) {
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" + "greet='" + greet + '\'' + '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
//////////////////////////////////////////////////////////


}
