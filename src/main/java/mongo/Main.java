package mongo;

import mongo.model.User;
import mongo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final UserRepository userRepository;

    public Main(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll(); // полностью очищаем базу

        List<String> hobbyList = new LinkedList<>(); // создаём список хобби
        hobbyList.add("sleep");
        hobbyList.add("run");

        System.out.println("Сохраняем Ивана и Андрея в базу...");
        userRepository.save(new User("Ivan", "Ivanov", hobbyList)); // сохраняем объект в базу
        System.out.println("Иван сохранён");
        hobbyList.add("read");
        userRepository.save(new User("Andrey", "Kuznecov", hobbyList));
        System.out.println("Андрей сохранён");

        System.out.println("Достаём из базы Ивана по имени...");
        System.out.println(userRepository.getUserByName("Ivan")); // достаём объект по имени и выводим в консоль

        System.out.println("Достаём из базы Андрея по фамилии...");
        System.out.println(userRepository.getUserByLastName("Kuznecov")); // достаём объект по фамилии

        hobbyList.clear();
        System.out.println("Сохраняем в базу Сергея, брата Ивана...");
        userRepository.save(new User("Sergey", "Ivanov", hobbyList)); // сохраняем в базу Сергея, брата Ивана
        System.out.println("Сергей, брат Ивана сохранён");

        System.out.println("Достаём из базы всех пользователей с фамилией Ivanov...");
        for (User user : userRepository.getUsersByLastName("Ivanov")) {
            System.out.println(user);
        }
    }
}
