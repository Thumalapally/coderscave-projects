import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ECommerceWebsite {
    private List<Product> products;
    private List<User> users;
    private ShoppingCart shoppingCart;

    public ECommerceWebsite() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.shoppingCart = new ShoppingCart();

        loadProducts();
        loadUsers();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Login");
            System.out.println("3. Register");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    register(scanner);
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void loadProducts() {
        // Load products from products.txt file
        try (Scanner fileScanner = new Scanner(new File("resources/products.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                Product product = new Product(parts[0], parts[1], Double.parseDouble(parts[2]));
                products.add(product);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    private void loadUsers() {
        // Load users from users.txt file
        try (Scanner fileScanner = new Scanner(new File("resources/users.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                User user = new User(parts[0], parts[1], parts[2]);
                users.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }
    }

    private void viewProducts() {
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    private void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        User user = getUserByUsernameAndPassword(username, password);
        if (user != null) {
            System.out.println("Login successful!");
            // Set user as current user
            shoppingCart.setUser(user);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter email: ");
        String email = scanner.next();

        User user = new User(username, password, email);
        users.add(user);
        System.out.println("Registration successful!");
    }

    private void viewCart() {
        System.out.println("Shopping Cart:");
        for (Product product : shoppingCart.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    private void checkout() {
        // Process payment and update user's order history
        System.out.println("Checkout successful!");
    }

    private User getUserByUsernameAndPassword(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }