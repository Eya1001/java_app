package widgets;

import javax.swing.*;
import java.awt.*;

public class LabelTextField extends JPanel {
    private final JTextField textField = new JTextField();
    private String text;
    public LabelTextField(String label){
        super(new GridLayout(1, 2));
        JLabel jlabel = new JLabel(label);
        jlabel.setHorizontalAlignment(JLabel.CENTER);
        jlabel.setVerticalAlignment(JLabel.CENTER);
        this.add(jlabel);
        this.add(textField);
    }

    public String getText() {
        return textField.getText();
    }
}
