package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Harry", "Potter", "potter@hogwarts.com");
      User user2 = new User("Hermione", "Granger", "granger@hogwarts.com");
      User user3 = new User("Ron", "Weasley", "weasley@hogwarts.com");
      User user4 = new User("Remus", "Lupin", "lupin@hogwarts.com");

      Car car1 = new Car("Lightning", 2021);
      Car car2 = new Car("Nimbus", 1001);
      Car car3 = new Car("Cleanliness", 7);
      Car car4 = new Car("Comet", 290);

      userService.add(user1.setCar(car1).setUser(user1));
      userService.add(user2.setCar(car2).setUser(user2));
      userService.add(user3.setCar(car3).setUser(user3));
      userService.add(user4.setCar(car4).setUser(user4));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }
}
