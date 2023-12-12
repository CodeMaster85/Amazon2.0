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

    static public boolean isUserExist(String _name, String _password)
    {
        File file = new File("Amazon2.0\\src\\dataWish.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String ligne;

            // Lire chaque ligne du fichier
            while ((ligne = br.readLine()) != null) {
                // Diviser la ligne en deux parties : nom et mot de passe
                String[] parties = ligne.trim().split("\\s+");

                // Vérifier si les informations correspondent à la demande
                if (parties.length == 2 && parties[0].equals(_name) && parties[1].equals(_password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
//    public static boolean isValidEmailAddress(String email) {
//        boolean result = true;
//        try {
//            InternetAddress emailAddr = new InternetAddress(email);
//            emailAddr.validate();
//        } catch (AddressException ex) {
//            result = false;
//        }
//        return result;
//    }

}
