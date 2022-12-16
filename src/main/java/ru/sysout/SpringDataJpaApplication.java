package ru.sysout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sysout.dao.*;
import ru.sysout.model.*;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDataJpaApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

//    @PostConstruct
//    void init() {
//        EmployeeCustomer employeeCustomer = new EmployeeCustomer();
//        employeeCustomer.setMonthsInCompany(10);
//        employeeCustomer.setName("Petr");
//        customerRepository.save(employeeCustomer);
//
//        ExternalCustomer externalCustomer = new ExternalCustomer();
//        externalCustomer.setSum(110);
//        externalCustomer.setName("Vasya");
//        customerRepository.save(externalCustomer);
//
//        Customer customer=new Customer();
//        customer.setName("ldld");
//        customerRepository.save(customer);
//    }

    @PostConstruct
    void init() {
        Teacher teacher = new Teacher();
        Post post = new Post();
        post.setName("Доцент");
        postRepository.save(post);
        teacher.setPost(post);
        teacher.setSurname("Корепанов");
        personRepository.save(teacher);

        Student student = new Student();
        Group group = new Group();
        group.setNumber("Б19-791-1");
        groupRepository.save(group);
        student.setGroup(group);
        student.setSurname("Назаров");
        personRepository.save(student);

        Person person = new Person();
        person.setSurname("Иванов");
        personRepository.save(person);
    }

    @Override
    public void run(String... args) throws Exception, InterruptedException {
        System.out.println("Все персоны:");
        for (int i = 0; i < personRepository.findAll().size(); i++) {
            System.out.println(personRepository.findAll().get(i).getSurname());
        }
        System.out.println();
        System.out.println("Все студенты:");
        for (int i = 0; i < studentRepository.findAll().size(); i++) {
            System.out.println(studentRepository.findAll().get(i).getSurname());
        }
        System.out.println();
        System.out.println("Все преподаватели:");
        for (int i = 0; i < teacherRepository.findAll().size(); i++) {
            System.out.println(teacherRepository.findAll().get(i).getSurname());
        }
    }
}
