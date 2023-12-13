//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.util.Properties;
//
//public class SendEmail {
//
//    private static final String USERNAME = "votre_adresse_email@example.com";
//    private static final String PASSWORD = "votre_mot_de_passe";
//
//    public static void send(String to, String subject, String body) {
//        // Configurer les propriétés du serveur de messagerie
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.example.com"); // Remplacez par l'adresse de votre serveur SMTP
//        props.put("mail.smtp.port", "587"); // Remplacez par le port SMTP approprié
//
//        // Créer la session avec authentification
//        Session session = Session.getInstance(props, new Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(USERNAME, PASSWORD);
//            }
//        });
//
//        try {
//            // Créer le message
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(USERNAME));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//            message.setSubject(subject);
//            message.setText(body);
//
//            // Envoyer le message
//            Transport.send(message);
//
//            System.out.println("E-mail envoyé avec succès.");
//
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//}
