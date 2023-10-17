package mod3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    JTextField nameField;
    JTextField emailField;
    JRadioButton male;
    JRadioButton female;
    JCheckBox check;
    public ContactForm(){
        super("Контактная форма");
        super.setBounds(200, 100,300,230);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2,2,10));

        JLabel name = new JLabel("Ya pomnu penis bolshoi");
        nameField = new JTextField("", 1);
        JLabel email = new JLabel("Ya pomnu penis bolshoi");
        emailField = new JTextField("@", 1);

        container.add(name);
        container.add(nameField);
        container.add(email);
        container.add(emailField);

        male = new JRadioButton("Мужскоой");
        female = new JRadioButton("Jenskiy");
        check = new JCheckBox("Согл?", false);
        JButton send_button = new JButton("Отправить");

        male.setSelected(true);
        container.add(male);
        container.add(female);

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        container.add(check);
        container.add(send_button);

        send_button.addActionListener(new ButtonEventManager());
    }
    class ButtonEventManager implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String isMale = "Мужской";
            if (!male.isSelected()){
                isMale = "Женский";
            }

            boolean checkBox = check.isSelected();

            JOptionPane.showMessageDialog(null,"Ваша почта: " + email +
                    "\nВаш пол: " + isMale +
                    "\nВы согласны?" + checkBox,
                    "Привет, "+name,JOptionPane.PLAIN_MESSAGE);
        }
    }
}
