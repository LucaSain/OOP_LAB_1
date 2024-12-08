package Lab_6_New;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class PersonForm extends JFrame {
    private JTextField nameField;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JTextArea jobDescriptionArea;
    private JScrollBar experienceScrollBar;
    private JTextField experienceField;
    private JComboBox<String> locationComboBox;
    private final List<Person> persons;
    private ButtonGroup genderGroup;

    public PersonForm() {
        persons = new ArrayList<>();

        setTitle("Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        initUIComponents(gbc);
    }

    private void initUIComponents(GridBagConstraints gbc) {
        addLabel("Name", 0, 0, gbc);
        nameField = createTextField(1, 0, gbc);

        addLabel("Gender", 0, 1, gbc);
        addGenderPanel(1, 1, gbc);

        addLabel("Job Description", 0, 2, gbc);
        addJobDescriptionArea(1, 2, gbc);

        addLabel("Experience (years)", 0, 3, gbc);
        addExperienceField(1, 3, gbc);

        addExperienceScrollBar(1, 4, gbc);

        addLabel("Location", 0, 5, gbc);
        addLocationComboBox(1, 5, gbc);

        addButton("Add", new AddButtonListener(), 0, 6, gbc);
        addButton("Show All", new ShowAllButtonListener(), 1, 6, gbc);
        addButton("Save", new SaveAllButtonListener(), 2, 6, gbc);
    }

    private void addLabel(String text, int x, int y, GridBagConstraints gbc) {
        JLabel label = new JLabel(text);
        gbc.gridx = x;
        gbc.gridy = y;
        add(label, gbc);
    }

    private JTextField createTextField(int x, int y, GridBagConstraints gbc) {
        JTextField textField = new JTextField();
        gbc.gridx = x;
        gbc.gridy = y;
        add(textField, gbc);
        return textField;
    }

    private void addGenderPanel(int x, int y, GridBagConstraints gbc) {
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);

        gbc.gridx = x;
        gbc.gridy = y;
        add(genderPanel, gbc);
    }

    private void addJobDescriptionArea(int x, int y, GridBagConstraints gbc) {
        jobDescriptionArea = new JTextArea(5, 20);
        jobDescriptionArea.setLineWrap(true);
        jobDescriptionArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(jobDescriptionArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        gbc.gridx = x;
        gbc.gridy = y;
        add(scrollPane, gbc);
    }

    private void addExperienceField(int x, int y, GridBagConstraints gbc) {
        experienceField = new JTextField("0", 3);
        experienceField.setEditable(false);
        gbc.gridx = x;
        gbc.gridy = y;
        add(experienceField, gbc);
    }

    private void addExperienceScrollBar(int x, int y, GridBagConstraints gbc) {
        experienceScrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 0, 1, 0, 101);
        experienceScrollBar.addAdjustmentListener(e ->
                experienceField.setText(String.valueOf(experienceScrollBar.getValue()))
        );

        gbc.gridx = x;
        gbc.gridy = y;
        add(experienceScrollBar, gbc);
    }

    private void addLocationComboBox(int x, int y, GridBagConstraints gbc) {
        locationComboBox = new JComboBox<>(new String[]{"Antarctica", "Ionia", "Eleea", "Arcadia", "Thesalia"});
        gbc.gridx = x;
        gbc.gridy = y;
        add(locationComboBox, gbc);
    }

    private void addButton(String text, ActionListener listener, int x, int y, GridBagConstraints gbc) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        gbc.gridx = x;
        gbc.gridy = y;
        add(button, gbc);
    }


    private void clearFields() {
        nameField.setText("");
        genderGroup.clearSelection();
        jobDescriptionArea.setText("");
        experienceScrollBar.setValue(0);
        locationComboBox.setSelectedIndex(0);
    }

    private class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not specified";
            String jobDescription = jobDescriptionArea.getText();
            int experience = experienceScrollBar.getValue();
            String location = (String) locationComboBox.getSelectedItem();

            persons.add(new Person(name, gender, jobDescription, experience, location));
            JOptionPane.showMessageDialog(null, "Person added successfully!");
            clearFields();
        }
    }

    private class ShowAllButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(
                    ()->{
                      DisplayAll da = new DisplayAll();
                      da.setVisible(true);
                  }
            );

        }
    }

    private class SaveAllButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(
                    ()->{
                        try(
                                FileWriter fw = new FileWriter("all.txt");
                                BufferedWriter writer = new BufferedWriter(fw);) {

                            for(Person p : persons){
                                writer.append(String.valueOf(p));
                                writer.newLine();
                            }
                            JOptionPane.showMessageDialog(null, "Written successfully to all.txt");
                        }
                        catch (Exception exception){
                            System.out.println(exception.toString());
                        }
                    }
            );

        }
    }


    public class DisplayAll extends JFrame {
        DisplayAll() {
            setTitle("All Persons");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Use DISPOSE_ON_CLOSE to allow closing without exiting
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            initUIComponents(gbc);
        }

        void initUIComponents(GridBagConstraints gbc) {
            // Create a text area to display person details
            JTextArea textComponent = new JTextArea(10, 30); // Adjusted dimensions
            textComponent.setLineWrap(true);
            textComponent.setWrapStyleWord(true);
            textComponent.setEditable(false); // Make it read-only

            // Populate text from 'persons'
            StringBuilder text = new StringBuilder();
            for (Person p : persons) {
                text.append(p).append("\n"); // Add a newline for better readability
            }
            textComponent.setText(text.toString());

            // Add the text area to a scroll pane
            JScrollPane scrollPane = new JScrollPane(textComponent);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

            // Add the scroll pane to the frame
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(scrollPane, gbc);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PersonForm form = new PersonForm();
            form.setVisible(true);
        });
    }
}
