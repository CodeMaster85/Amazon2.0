/**
 * The Main class serves as the entry point for the XYTExpress.com application.
 * It initializes the login window, allowing users to access the main features of the application.
 *
 * <p>The main method instantiates the {@link LoginWindow} class, which is responsible for user authentication
 * and navigation to the principal functionalities of the application.</p>
 *
 * <p>This application follows a graphical user interface (GUI) approach, where the main interaction
 * occurs through various windows and panels.</p>
 *
 * <p>Upon execution, the main method creates an instance of the {@link LoginWindow}, presenting users with
 * the login interface. From here, users can enter their credentials to access the XYTExpress.com application.</p>
 *
 * <p>This class encapsulates the launch point of the application, ensuring the initiation of the user interface
 * and facilitating the seamless flow into the application's core functionality.</p>
 *
 * @see LoginWindow
 * @author Yohan Chuet, Thomas Fortier and Xavier Belzile
 * @version 1.0
 */
public class Main {
    /**
     * The main method that initializes the XYTExpress.com application.
     *
     * <p>Upon execution, it creates an instance of the {@link LoginWindow} class, initiating the login interface
     * for user authentication and access to the main features of the application.</p>
     *
     * @param args Command-line arguments (not utilized in this application).
     */
    public static void main(String[] args) {
        new LoginWindow();
    }
}