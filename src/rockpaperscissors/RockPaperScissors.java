package rockpaperscissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissors extends JFrame {
    
    private int playerScore = 0;
    private int computerScore = 0;
    private final Random random = new Random();
    private static final Random number = new Random();

    private JLabel scoreLabel;
    private JLabel messageLabel;

    public RockPaperScissors() {
        setTitle("Rock Paper Scissors");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        scoreLabel = new JLabel("Score - You: 0 Computer: 0");
        messageLabel = new JLabel("Choose your weapon!");

        add(scoreLabel);
        add(messageLabel);

        String[] choices = {"Rock", "Paper", "Scissors"};
        for (String choice : choices) {
            JButton button = new JButton(choice);
            button.addActionListener(this::handleChoice);
            add(button);
        }

        setVisible(true);
    }

    private void handleChoice(ActionEvent e) {
        String userChoice = e.getActionCommand();
        String computerChoice = getComputerChoice();
        String result = determineOutcome(userChoice, computerChoice);

        messageLabel.setText(String.format("You chose: %s. Computer chose: %s. %s", userChoice, computerChoice, result));
        scoreLabel.setText(String.format("Score - You: %d Computer: %d", playerScore, computerScore));
    }

    private String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        return choices[random.nextInt(choices.length)];
    }

    private String determineOutcome(String userChoice, String computerChoice) {
        if (userChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a draw! " + getDrawPhrase();
        } else if (wins(userChoice, computerChoice)) {
            playerScore++;
            return "You win! " + getWinPhrase();
        } else {
            computerScore++;
            return "You lose! " + getLosePhrase();
        }
    }

    private boolean wins(String userChoice, String computerChoice) {
        return (userChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors")) ||
                (userChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) ||
                (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equalsIgnoreCase("Paper"));
    }

    private static String getLosePhrase() {
        String[] phrases = {
            "By my sword, victory is ours!",
            "The strength of the knight prevails!",
            "As the shield protects, so have I defended our honor!",
            "Another foe vanquished in the name of valor!",
            "The battle was fierce, but righteousness won!",
            "With honor and steel, victory is secured!",
            "Like a true knight, I emerge victorious!",
            "The dragon is slain, the day is saved!",
            "In the joust of fate, my lance strikes true!",
            "By the code of chivalry, I claim my win!",
            "The castle is safe, our enemies flee in defeat!",
            "As the quest ends, the hero prevails!",
            "With courage as my companion, I cannot lose!",
            "The battle hymns sing of our victory!",
            "A knight's duty is to win, and I have fulfilled mine!",
            "With every swing, my resolve grows stronger!",
            "The tales of this victory will be told for ages!",
            "In the face of adversity, my spirit never wavers!",
            "A true knight stands tallest when victorious!",
            "Victory is not given, it is earned with bravery!"
        };
        return phrases[number.nextInt(phrases.length)];
    }
    
    
    private static String getWinPhrase() {
        String[] phrases = {
            "A knight knows no defeat, only lessons!",
            "The battle is lost, but the war rages on!",
            "Even in defeat, a knight's honor stands tall.",
            "Retreat and regroup; the next victory will be ours!",
            "A minor setback in a lifetime of battles.",
            "Today's loss forges tomorrow's victory.",
            "A valiant effort, but the fates were unkind.",
            "We learn more from defeat than from victory.",
            "A knight's courage is tested in moments of defeat.",
            "Even heroes face setbacks on their quests.",
            "The armor may dent, but my resolve remains unbroken.",
            "A stumble, not a fall; we shall rise again!",
            "In every loss, a lesson; in every defeat, a motive.",
            "The dragon wins this round, but the saga continues.",
            "A knight must face defeat before claiming glory.",
            "Today's defeat seeds tomorrow's triumph.",
            "In the shadow of defeat, our resolve shines brightest.",
            "A scar is a testament to battles fought and lessons learned.",
            "Defeat is but a prelude to a grander victory.",
            "The knight's journey is fraught with challenges, yet we persevere."
        };
        return phrases[number.nextInt(phrases.length)];
    }
    
    private static String getDrawPhrase() {
        String[] phrases = {
            "An evenly matched clash of titans!",
            "Our valor equals, as does our honor.",
            "Two knights, equally matched, share the spoils of battle.",
            "Neither knight yields; our spirits are unbroken!",
            "A stalemate today, but tomorrow, we ride again!",
            "Equal in strength, equal in courage, we stand.",
            "The dance of battle ends in harmony.",
            "Like mirrored shields, we reflect each other's strength.",
            "A draw is but a pause in our epic saga.",
            "Today, we are two sides of the same sword.",
            "In the balance of combat, we find equality.",
            "A tie? Our tales are yet to see their end.",
            "Our blades cross, but neither finds victory today.",
            "As equals we fought, and as equals, we finish.",
            "The heralds will sing of a battle evenly fought.",
            "A truce among warriors, our honor intact.",
            "Let the bards sing of a duel where none could best the other.",
            "We have met as equals on this battlefield.",
            "Today, our rivalry blooms into mutual respect.",
            "A draw on the battlefield, but a victory in camaraderie."
        };
        return phrases[number.nextInt(phrases.length)];
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RockPaperScissors::new);
    }
}
