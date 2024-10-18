package cl.ricardo.projectManagement.business;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    
    public static String hashPassword(String password) {
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
        return hashed;
    }
    
    public static boolean hasPasswordMatch(String hashedPassword, String candidate){
        return BCrypt.checkpw(candidate, hashedPassword);
    }

//    public static void main(String[] args) {
//        String password = "ricardo1234";
//        String candidate = "ricardo1234";
//
//        // gensalt's log_rounds parameter determines the complexity
//        // the work factor is 2**log_rounds, and the default is 10
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
//
//        // Check that an unencrypted password matches one that has
//        // previously been hashed
//        System.out.println(hashed);
//        if (BCrypt.checkpw(candidate, hashed)) {
//            System.out.println("It matches");
//        } else {
//            System.out.println("It does not match");
//        }
//    }
}
