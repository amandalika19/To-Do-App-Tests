import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class AddGUI extends JFrame implements ActionListener {

    //Fields to enter text
    JTextField enterName;
    JTextField enterDate;

    //Button
    JButton addButton;
    JButton cancelButton;

    //Message label
    JLabel text;

    //Category radio buttons
    JRadioButton red;
    JRadioButton orange;
    JRadioButton blue;
    JRadioButton purple;
    JRadioButton yellow;
    JRadioButton green;
    ButtonGroup catButtons;

    //Importance radio buttons
    JRadioButton low;
    JRadioButton normal;
    JRadioButton high;
    ButtonGroup impButtons;

    //Status radio buttons
    JRadioButton pending;
    JRadioButton started;
    JRadioButton partial;
    JRadioButton completed;
    ButtonGroup statButtons;

    public AddGUI() {
        //setting frame
        this.setSize(650,350);
        this.setTitle("Add New To Do");
        this.setLayout(new GridBagLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setLocation(300, 300);

        //setting layout
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5,10,5,10);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 1.0;

        //adding title
        JLabel title = new JLabel("Add New To Do");
        title.setFont(new Font("Tahoma", Font.PLAIN, 14));
        c.gridwidth = 4;
        c.gridx= 0;
        c.gridy = 0;
        add(title, c);

        //adding name label and text box
        JLabel labelName = new JLabel("Name: ", SwingConstants.LEFT);
        c.gridwidth = 1;
        c.gridx= 0;
        c.gridy = 1;
        add(labelName, c);

        enterName = new JTextField(100);
        enterName.setMinimumSize(new Dimension(100,20));
        c.gridwidth = 6;
        c.gridx= 1;
        c.gridy = 1;
        add(enterName, c);

        //adding date label and text box
        JLabel labelDate = new JLabel("Date: ", SwingConstants.LEFT);
        c.gridwidth = 1;
        c.gridx= 0;
        c.gridy = 2;
        add(labelDate, c);

        enterDate = new JTextField(100);
        enterDate.setMinimumSize(new Dimension(100,20));
        c.gridwidth = 6;
        c.gridx= 1;
        c.gridy = 2;
        add(enterDate, c);

        //adding category label and text box
        JLabel labelCat = new JLabel("Category: ", SwingConstants.LEFT);
        c.gridwidth = 1;
        c.gridx= 0;
        c.gridy = 3;
        add(labelCat, c);

        //setting radio buttons
        red = new JRadioButton();
        red.setText("Red");
        orange = new JRadioButton();
        orange.setText("Orange");
        blue = new JRadioButton();
        blue.setText("Blue");
        purple = new JRadioButton();
        purple.setText("Purple");
        yellow = new JRadioButton();
        yellow.setText("Yellow");
        green = new JRadioButton();
        green.setText("Green");

        catButtons = new ButtonGroup();
        catButtons.add(red);
        catButtons.add(orange);
        catButtons.add(blue);
        catButtons.add(purple);
        catButtons.add(yellow);
        catButtons.add(green);

        c.gridwidth = 1;
        c.gridx= 1;
        c.gridy = 3;
        add(red, c);

        c.gridx= 2;
        c.gridy = 3;
        add(orange, c);

        c.gridx= 3;
        c.gridy = 3;
        add(blue, c);

        c.gridx= 4;
        c.gridy = 3;
        add(purple, c);

        c.gridx= 5;
        c.gridy = 3;
        add(yellow, c);

        c.gridx= 6;
        c.gridy = 3;
        add(green, c);

        //adding importance label and text box
        JLabel labelImportance = new JLabel("Importance: ", SwingConstants.LEFT);
        c.gridwidth = 1;
        c.gridx= 0;
        c.gridy = 4;
        add(labelImportance, c);

        //setting radio buttons
        low = new JRadioButton();
        low.setText("Low");
        normal = new JRadioButton();
        normal.setText("Normal");
        high = new JRadioButton();
        high.setText("High");

        impButtons = new ButtonGroup();
        impButtons.add(low);
        impButtons.add(normal);
        impButtons.add(high);

        c.gridwidth = 1;
        c.gridx= 1;
        c.gridy = 4;
        add(low, c);

        c.gridx= 2;
        c.gridy = 4;
        add(normal, c);

        c.gridx= 3;
        c.gridy = 4;
        add(high, c);

        //adding status label and text box
        JLabel labelStatus = new JLabel("Status: ", SwingConstants.LEFT);
        c.gridwidth = 1;
        c.gridx= 0;
        c.gridy = 5;
        add(labelStatus, c);

        //setting radio buttons
        pending = new JRadioButton();
        pending.setText("Pending");
        started = new JRadioButton();
        started.setText("Started");
        partial = new JRadioButton();
        partial.setText("Partial");
        completed = new JRadioButton();
        completed.setText("Completed");

        statButtons = new ButtonGroup();
        statButtons.add(pending);
        statButtons.add(started);
        statButtons.add(partial);
        statButtons.add(completed);

        c.gridwidth = 1;
        c.gridx= 1;
        c.gridy = 5;
        add(pending, c);

        c.gridx= 2;
        c.gridy = 5;
        add(started, c);

        c.gridx= 3;
        c.gridy = 5;
        add(partial, c);

        c.gridx= 4;
        c.gridy = 5;
        add(completed, c);

        //adding message box
        text = new JLabel("  ", SwingConstants.CENTER);
        text.setFont(new Font("Tahoma", Font.PLAIN, 13));
        c.gridwidth = 7;
        c.gridx= 0;
        c.gridy = 6;
        add(text, c);

        //adding add button
        addButton = new JButton("Add Todo");
        addButton.addActionListener(this);
        addButton.setPreferredSize(new Dimension(150, 40));
        addButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        c.gridwidth = 3;
        c.gridx= 2;
        c.gridy = 7;
        add(addButton, c);

        //adding add button
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(this);
        cancelButton.setPreferredSize(new Dimension(150, 40));
        cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        c.gridwidth = 3;
        c.gridx= 2;
        c.gridy = 8;
        add(cancelButton, c);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //checking if add to-do was pressed
        if (e.getActionCommand().equals("Add Todo")){
            //variables to get inputs
            String name;
            LocalDateTime date;
            Category category;
            Importance importance;
            Status status;

            text.setText("");

            //getting name
            if (!enterName.getText().isEmpty()){
                name = enterName.getText();
            }
            else {
                //if name empty print error message and return
                text.setText("Name cannot be left empty.");
                return;
            }

            //getting date
            if (!enterDate.getText().isEmpty()){
                try {
                    //trying to parse input to type LocalDateTime
                    date = LocalDateTime.parse(enterDate.getText());
                } catch (DateTimeParseException ex){
                    //if wrong format entered, print error message and return
                    text.setText("Invalid format entered. Enter a due date for the todo in the format YYYY-MM-DDTHH:MM.");
                    return;
                }
            }
            else {
                //if date empty print error message and return
                text.setText("Date cannot be left empty.");
                return;
            }

            //getting category
            if (red.isSelected()){
                category = Category.Red;
            }
            else if (orange.isSelected()){
                category = Category.Orange;
            }
            else if (blue.isSelected()){
                category = Category.Blue;
            }
            else if (purple.isSelected()){
                category = Category.Purple;
            }
            else if (yellow.isSelected()){
                category = Category.Yellow;
            }
            else if (green.isSelected()){
                category = Category.Green;
            }
            else {
                //if category is not selected print error message and return
                text.setText("Category must be selected.");
                return;
            }

            //getting importance
            if (low.isSelected()){
                importance = Importance.Low;
            }
            else if (normal.isSelected()){
                importance = Importance.Normal;
            }
            else if (high.isSelected()){
                importance = Importance.High;
            }
            else {
                //if importance is not selected print error message and return
                text.setText("Importance must be selected.");
                return;
            }

            //getting status
            if (pending.isSelected()){
                status = Status.Pending;
            }
            else if (partial.isSelected()){
                status = Status.Partial;
            }
            else if (started.isSelected()){
                status = Status.Started;
            }
            else if (completed.isSelected()){
                status = Status.Completed;
            }
            else {
                //if status is not selected print error message and return
                text.setText("Status must be selected.");
                return;
            }

            //adding to-to using method from CLIMenu
            CLIMenu.addTodo(name, date, category, importance, status);
        }

        //runningTodoGUI
        SwingUtilities.invokeLater(TodoGUI::new);
        //closing this GUI
        this.dispose();
    }
}
