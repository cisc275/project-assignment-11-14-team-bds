package views.screens;
import entities.Collidable;
import views.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Quiz extends Screen{
    List<Question> questions = new ArrayList<>();
    List<JButton> currentAnswers = new ArrayList<>();

    private String filepath = "res/quiz/clapper_rail";
    private Screen prev;
    private int currentQuestion = 0;
    class Question {
        String question;
        String correct;
        List<String> answers = new ArrayList<>();
    }

    public Quiz(int w, int h, View v) {
        super(w, h, v);
        setLayout(new GridLayout(5,1));
        buildQuiz(filepath);
        displayQuestion();
    }

    public void displayQuestion() {
        this.removeAll();
        this.revalidate();
        this.repaint();
        Question q = questions.get(currentQuestion);
        JLabel t = new JLabel(q.question);
        t.setFont(new Font("Sanserif", Font.BOLD, 12));
        this.add(new JLabel(q.question));
        currentAnswers.clear();
        for (String s : q.answers) {
            this.add(buttonFactory(s, (e) -> {
                if (s.equals(q.correct)){
                    System.out.println("Correct");
                    setBackground(Color.GREEN);
                } else {
                    System.out.println("Incorrect");
                    setBackground(Color.RED);
                }
                currentQuestion++;
                if (currentQuestion >= questions.size()) {
                    currentQuestion = 0;
                    view.changePanel(View.RAIL);
                }
                displayQuestion();
            }));
        }
    }

    @Override
    public List<JButton> getButtons() {
        return currentAnswers;
    }

    public JButton buttonFactory(String s, ActionListener e) {
        JButton b = new JButton(s);
        b.addActionListener(e);
        currentAnswers.add(b);
        return b;
    }
    public void buildQuiz(String filepath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String s = reader.readLine();
            while (s != null) {
                Question q = new Question();
                q.question = s;
                q.correct = reader.readLine();
                q.answers.add(reader.readLine());
                q.answers.add(reader.readLine());
                q.answers.add(reader.readLine());
                q.answers.add(reader.readLine());
                questions.add(q);
                s = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            return;
        }
    }
    public boolean checkCorrect(Question q, String answer) {
        return answer.equals(q.correct);
    }
    @Override
    public void render(List<Collidable> c ) {}
}

