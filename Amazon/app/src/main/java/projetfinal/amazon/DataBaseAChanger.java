package projetfinal.amazon;

import java.util.HashMap;
import java.util.Map;

public class DataBaseAChanger {
    // Je fais ca pcq je commencerai pas la data base a soir
    // Je ferrai une map avec un nom d'utilisateur et un mdp
    public static boolean isUserGood(String name, String password)
    {
        HashMap<String, String> user = new HashMap<>();
        user.put("Yohan", "1234");
        user.put("Xavier", "0123");

        if (user.containsKey(name)) {
            // Vérification si le mot de passe correspond
            return user.get(name).equals(password);
        } else {
            // Le nom d'utilisateur n'existe pas
            return false;
        }



    }
}
