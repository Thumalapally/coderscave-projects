import java.util.Scanner;

public class OnlineQuizPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quiz questions and answers
        String[] questions = {
            "What is the capital of France?",
            "What is 2 + 2?",
            "What is the largest planet in our solar system?"
        };
        String[] answers = {
            "Paris",
            "4",
            "Jupiter"
        };
        String[] optionsA = {
            "London",
            "3",
            "Earth"
        };
        String[] optionsB = {
            "Paris",
            "4",
            "Saturn"
        };
        String[] optionsC = {
            "Berlin",
            "5",
            "Jupiter"
        };
        String[] optionsD = {
            "Rome",
            "6",
            "Mars"
        };

        // Quiz scores
        int score = 0;

        // Display quiz instructions
        System.out.println("Welcome to the online quiz platform!");
        System.out.println("Please answer the following questions:");
        System.out.println("----------------------------");

        // Loop through each question
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);

            // Display options for multiple-choice questions
            if (i == 0 || i == 2) {
                System.out.println("A) " + optionsA[i]);
                System.out.println("B) " + optionsB[i]);
                System.out.println("C) " + optionsC[i]);
                System.out.println("D) " + optionsD[i]);
                System.out.print("Enter your answer (A, B, C, or D): ");
                char answer = scanner.next().charAt(0);

                // Check if answer is correct
                if (answer == 'B' || answer == 'b') {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + answers[i]);
                }
            } else {
                // Display input field for short-answer questions
                System.out.print("Enter your answer: ");
                String answer = scanner.next();

                // Check if answer is correct
                if (answer.equalsIgnoreCase(answers[i])) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + answers[i]);
                }
            }

            System.out.println("----------------------------");
        }

        // Display final score
        System.out.println("Your final score is " + score + " out of " + questions.length);
        System.out.println("Thanks for taking the quiz!");
    }
}