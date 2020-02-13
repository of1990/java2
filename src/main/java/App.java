import console.ConsoleUI;
import repository.ProductRepository;
import service.Service;
import service.validation.ValidationService;

public class App {
    public static void main(String[] args) {

        ProductRepository repository = new ProductRepository();
        ValidationService validation = new ValidationService(repository);
        Service service = new Service(repository, validation);
        ConsoleUI consoleUI = new ConsoleUI(service);
        consoleUI.execute();
    }
}
