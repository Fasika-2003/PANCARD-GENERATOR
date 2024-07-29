import java.util.*;

public class PANCardGenerator {

    private static final String ALPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String FOURTH_CHAR_OPTIONS = "PCAFHRT";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first letter of the applicant's surname: ");
        String surnameInitial = scanner.nextLine();
        if (surnameInitial.length() != 1 || !Character.isLetter(surnameInitial.charAt(0))) {
            System.out.println("Invalid input. Please enter a single letter.");
        } else {
            System.out.println(generatePAN(surnameInitial.toUpperCase()));
        }
        scanner.close();
    }
    public static String generatePAN(String surnameInitial) {
        Random random = new Random();

        // Generate first three random alphabets
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            pan.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
        }

        // Fourth character (P-individual , C- Company , A- Association, F-Firm , H-HUF, T-Trust)
        pan.append(FOURTH_CHAR_OPTIONS.charAt(random.nextInt(FOURTH_CHAR_OPTIONS.length())));

        // Fifth character (initial of the applicant's surname)
        pan.append(surnameInitial.toUpperCase());

        // Next four random digits
        for (int i = 0; i < 4; i++) {
            pan.append(random.nextInt(10));
        }

        // Last character (random alphabet)
        pan.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
        System.out.print(" Pancard number : ");

        return pan.toString();
    }
}