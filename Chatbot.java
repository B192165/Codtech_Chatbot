import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Chatbot extends JFrame implements ActionListener {
    private JTextField userInputField;
    private JTextArea chatArea;


    public Chatbot() {
        setTitle("Chatbot");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        userInputField = new JTextField();
        userInputField.addActionListener(this);
        add(userInputField, BorderLayout.SOUTH);


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);


        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String userInput = userInputField.getText();
        appendToChatArea("You: " + userInput);
        userInputField.setText("");
        generateResponse(userInput);
    }


    private void generateResponse(String userInput) {
        String botResponse = "";
        if (userInput.equalsIgnoreCase("hi") || userInput.equalsIgnoreCase("hello")) {
            botResponse = "Bot: Hii";
        } else if (userInput.equalsIgnoreCase("how are you")) {
            botResponse = "Bot: Fine, thank you for asking.";
        } else if (userInput.toLowerCase().contains("weather")) {
            botResponse = "Bot: It's sunny.";
        } else if(userInput.toLowerCase().contains("favorite movie")){
            botResponse = "Bot: My favourite movie is the Matrix.";
        }else if(userInput.toLowerCase().contains("good quotes")){
            botResponse = "Bot: Here's a good quote: 'The only wayto do great work is to love what you do.'- Steve Jobs";
        }else if(userInput.toLowerCase().contains("internship")){
            botResponse = "Bot: You can explore internships opportunities in software development, data science, cyber security,and more";
        }else if(userInput.toLowerCase().contains("job")){
            botResponse = "Bot: Job opportunities in Cse include software development, data analysis";
        }else if(userInput.toLowerCase().contains("thank you")){
            botResponse = "Bot: You're welcome if you have any more questions, feel free to ask.";
        }else if(userInput.toLowerCase().contains("bye")){
            botResponse = "Bot: Goodbye! Have a great day!";
        }
        else {
            botResponse = "Bot: I'm sorry, I don't understand.";
        }
        appendToChatArea(botResponse);
    }


    private void appendToChatArea(String message) {
        chatArea.append(message + "\n");
    }


    public static void main(String[] args) {
        new Chatbot();
    }
}