package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        //Добавляем пользователей
        UserService userService = context.getBean(UserService.class);
        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
        List<User> users = userService.listUsers();

        //Добавляем автомобили
        CarService carService = context.getBean(CarService.class);
        carService.add(new Car("User1", 111, "e777kx"));
        carService.add(new Car("User2", 222, "b666op"));
        carService.add(new Car("User3", 333, "a123aa"));
        carService.add(new Car("User4", 444, "o000oo"));

        List<Car> cars = carService.listCars();

        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = ");
            System.out.println();
        }

        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("Name = " + car.getName());
            System.out.println("Series = " + car.getSeries());
            System.out.println("Number = " + car.getNumber());
            System.out.println("User = " + car.getUser());
            System.out.println();
        }


        System.out.println(carService.getUserBySeries(111, "e777kx").toString());
        System.out.println(carService.getUserBySeries(222, "b666op").toString());
        System.out.println(carService.getUserBySeries(333, "a123aa").toString());
        System.out.println(carService.getUserBySeries(444, "o000oo").toString());
        System.out.println();


        context.close();
    }
}
