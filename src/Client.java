import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
/**
 * The Client class represents a user of the XYTExpress.com application with details such as first name, last name,
 * username, password, and email.
 * @author yohan
 */
public class Client {
    String firstName;
    String lastName;
    String userName;
    String password;
    String email;
    /**
     * Constructs a new instance of the Client class with the specified attributes.
     *
     * @param _firstName The first name of the client.
     * @param _lastName  The last name of the client.
     * @param _userName  The username chosen by the client.
     * @param _password  The password chosen by the client.
     * @param _email     The email address of the client.
     * @throws UnsupportedEncodingException If the UTF-8 encoding is not supported.
     * @throws NoSuchAlgorithmException    If the MD5 algorithm is not available.
     */
    public Client(String _firstName, String _lastName, String _userName, String _password, String _email) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // if client not in dataBase, create client:
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.userName = _userName;
        this.password = _password;
        this.email = _email;

    }
}
