import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Client {
    String firstName;
    String lastName;
    String userName;
    String password;
    String email;




    public Client(String _firstName, String _lastName, String _userName, String _password, String _email) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // if client not in dataBase, create client:
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.userName = _userName;
        this.password = _password;

        byte[] passwdBytes = this.password.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] passwdMD5ed = md.digest(passwdBytes); // where le hash == hash
        this.email = _email;
        // add on database new client

        // sent email verification
        // email = xytexpressshipping@gmail.com



    }
}
