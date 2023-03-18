package Even;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import entity.Players;


public class QuizGame implements ActionListener {

    public JFrame frame;
    private JLabel questionLabel;
    private ButtonGroup answerButtonGroup;
    private JRadioButton[] answerButtons;
    private JButton submitButton;
    private int currentQuizIndex;
    private int score;
    private ArrayList<Integer> quizIndices;
    Window Game;
    Players countscore;
    // public Player QI;

    private DuolingoQuiz[] quizzes = {
            new DuolingoQuiz("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Madrid"}, 1),
            new DuolingoQuiz("What is the largest ocean?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3),
            new DuolingoQuiz("What is the currency of Japan?", new String[]{"Yen", "Won", "Dollar", "Euro"}, 0),
            new DuolingoQuiz("What is the highest mountain in the world?", new String[]{"Mount Everest", "K2", "Kilimanjaro", "Denali"}, 0),
            new DuolingoQuiz("What is the smallest country in the world?", new String[]{"Monaco", "Nauru", "San Marino", "Vatican City"}, 3),
            new DuolingoQuiz("What is the largest country in South America?", new String[]{"Brazil", "Argentina", "Colombia", "Peru"}, 0),
            new DuolingoQuiz("What is the smallest continent?", new String[]{"Europe", "Australia", "South America", "Antarctica"}, 1),
            new DuolingoQuiz("What is the hottest continent?", new String[]{"Africa", "South America", "Asia", "Australia"}, 0),
            new DuolingoQuiz("What is the longest river in the world?", new String[]{"Amazon", "Nile", "Mississippi", "Yangtze"}, 1),
            new DuolingoQuiz("What is the largest desert in the world?", new String[]{"Gobi", "Kalahari", "Sahara", "Mojave"}, 2),
            new DuolingoQuiz("What is the national language of Brazil?", new String[]{"Portuguese", "Spanish", "English", "French"}, 0),
            new DuolingoQuiz("What is the tallest animal in the world?", new String[]{"Elephant", "Giraffe", "Horse", "Zebra"}, 1),
            new DuolingoQuiz("Who is the best ComputerScience teacher :) in KMITL?", new String[]{"T.Santana", "T.Haha", "T.Ha", "T.Santa"}, 0),
            new DuolingoQuiz("What is the fastest animal in the world?", new String[]{"Cheetah", "Peregrine falcon", "	Ostrich", "Swordfish"}, 1),
            new DuolingoQuiz("Which is the smallest planet in our solar system?", new String[]{"Earth", "Venus", "Jupiter", "Mercury"}, 3),
            new DuolingoQuiz("What is the study of animal life called?", new String[]{"Anatomy", "Botany", "Zoology", "Ecology"}, 2),
            new DuolingoQuiz("What is the chemical symbol for gold?", new String[]{"Ag", "Au", "Pt", "Pb"}, 1),
            new DuolingoQuiz("Who is the founder of Microsoft?", new String[]{"Jeff Bezos", "Steve Jobs", "Bill Gates", "Mark Zuckerberg"}, 2),
            new DuolingoQuiz("Who was the first person to step on the moon?", new String[]{"Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin", "Michael Collins"}, 0),
            new DuolingoQuiz("What is the capital city of Australia?", new String[]{"Sydney", "Perth", "Canberra", "Melbourne"}, 2),
            new DuolingoQuiz("Who painted the Mona Lisa?", new String[]{"Vincent van Gogh", "Claude Monet", "Pablo Picasso", "Leonardo da Vinci"}, 3),
            new DuolingoQuiz("Who wrote the play 'Romeo and Juliet'?", new String[]{"William Shakespeare", "Oscar Wilde", "George Bernard Shaw", "Tennessee Williams"}, 0),
            new DuolingoQuiz("Who is the founder of Facebook?", new String[]{"Jeff Bezos", "Steve Jobs", "Bill Gates", "Mark Zuckerberg"}, 3),
            new DuolingoQuiz("What is the national animal of Australia?", new String[]{"Kangaroo", "Koala", "Platypus", "Tasmanian Devil"}, 0)
            
    };

    public QuizGame() {
        // shuffle the quiz indices
        quizIndices = new ArrayList<Integer>();
        for (int i = 0; i < quizzes.length; i++) {
            quizIndices.add(i);
        }
        Collections.shuffle(quizIndices);

        // set up the GUI components
        frame = new JFrame("Duolingo Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        questionLabel = new JLabel();
        panel.add(questionLabel);

        answerButtonGroup = new ButtonGroup();
        answerButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JRadioButton();
            answerButtonGroup.add(answerButtons[i]);
            panel.add(answerButtons[i]);
        }

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
        frame.setResizable(false);

        // display the first quiz
        currentQuizIndex = 0;
        displayQuiz(currentQuizIndex);
    }

    private void displayQuiz(int index) {
        // display the question
        questionLabel.setText(quizzes[quizIndices.get(index)].getQuestion());

        // display the answer choices
        String[] answerChoices = quizzes[quizIndices.get(index)].getAnswerChoices();
        for (int i = 0; i < 4; i++) {
            answerButtons[i].setText(answerChoices[i]);
        }

        // clear the selected answer
        answerButtonGroup.clearSelection();
    }

    private void checkAnswer() {
        // check if an answer is selected
        if (answerButtonGroup.getSelection() == null) {
            JOptionPane.showMessageDialog(frame, "Please select an answer.");
            return;
        }

        // check if the selected answer is correct
        int selectedAnswerIndex = -1;
        for (int i = 0; i < 4; i++) {
            if (answerButtons[i].isSelected()) {
                selectedAnswerIndex = i;
                break;
            }
        }
        if (quizzes[quizIndices.get(currentQuizIndex)].getCorrectAnswerIndex() == selectedAnswerIndex) {
            JOptionPane.showMessageDialog(frame, "Correct! You get 1 point.");
            countscore.score++;
            score++;
        } else {
            JOptionPane.showMessageDialog(frame, "Incorrect. You get 0 points.");
        }

        // move on to the next quiz or end the quiz
        currentQuizIndex++;
        // if (currentQuizIndex == 12) {
        //     JOptionPane.showMessageDialog(frame, "Quiz completed. Your score is " + score + ".");
        //     System.exit(0);
        if (currentQuizIndex == 1) {
            JOptionPane.showMessageDialog(frame, "Quiz completed. Your score is " + score + ".");
            // System.exit(0);
            
            frame.setVisible(false);

        } else {
            displayQuiz(currentQuizIndex);
        }
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == submitButton) {
            checkAnswer();
        }
    }

}

class DuolingoQuiz {
    private String question;
    private String[] answerChoices;
    private int correctAnswerIndex;

    public DuolingoQuiz(String question, String[] answerChoices, int correctAnswerIndex) {
        this.question = question;
        this.answerChoices = answerChoices;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswerChoices() {
        return answerChoices;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}


       
