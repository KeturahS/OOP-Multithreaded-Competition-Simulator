package utilities;
/**
 * by Keturah Shlomo- 313922783 and Shilat Haya Yosefi- 324964410
 * It allows users to build an arena, create a competition, add competitors, start the competition, and display information about competitors.
 */


import game.arena.ArenaFactory;
import game.arena.ArenaType;
import game.arena.WinterArena;
import game.competition.*;
import game.entities.sportsman.*;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.sleep;

/**
 * utilities.GUIcompetition class represents the graphical user interface for a skiing competition simulation.
 * It allows users to build an arena, create a competition, add competitors, start the competition, and display information about competitors.
 */
public class GUIcompetition extends Component implements Observer
{
    private JFrame frame;
    private JTextField arenaLengthField;
    private JComboBox<SnowSurface> snowSurfaceCombo;
    private JComboBox<WeatherCondition> weatherConditionCombo;
    private JComboBox<String> CompetitorsListCombo;
    private JTextField maxCompetitorsField;
    private JComboBox<String> competitionTypeCombo;
    private JComboBox<String> arenaType;
    private JComboBox<Discipline> disciplineCombo;
    private JComboBox<League> leagueCombo;
    private JComboBox<Gender> genderCombo;
    private JComboBox<String> colourCombo;
    private JComboBox<String> colour1Combo;
    private JTextField addAccelerationField;

    private JTextField nameField;
    private JTextField ageField;
    private JTextField maxSpeedField;
    private JTextField accelerationField;
    private static JPanel canvasPanel;
    private JPanel PlayerPanel;
    private Image backgroundImage;
    private Image PlayerImage;
    private boolean RaceBegan;
    private ArenaType arena;
    private WinterCompetition competition1;
    private Competitor competitor;
    private JFrame InfoFrame;
    private JPanel InfoPanel;
    private JTable table;
    private DefaultTableModel tableModel;
    private BufferedImage playerImage;
    private List<BufferedImage> playerImages;
    private int gap;
    private String competitorType;
    private JTextField amount;
    private long startTime;


    /**
     * Constructor for utilities.GUIcompetition.
     * Initializes the graphical user interface.
     */
    public GUIcompetition()
    {
        createGUI();
    }

    /**
     * Creates the graphical user interface.
     */
    private void createGUI() {
        frame = new JFrame("Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 1000);
        RaceBegan = false;

        gap = 0;


        // Main panel with BoxLayout for east side
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setSize(700, 1000);

        // BUILD ARENA panel
        JPanel buildArenaPanel = new JPanel();
        buildArenaPanel.setLayout(new GridLayout(5, 5));

        buildArenaPanel.add(new JLabel("Arena type:"));

        arenaType = new JComboBox<>(new String[]{"winter", "summer"});

        buildArenaPanel.add(arenaType);

        buildArenaPanel.add(new JLabel("Arena Length:"));

        arenaLengthField = new JTextField(10);

        arenaLengthField.setText("700");
        buildArenaPanel.add(arenaLengthField);
        buildArenaPanel.add(new JLabel("Snow Surface:"));
        snowSurfaceCombo = new JComboBox<>(SnowSurface.values());
        buildArenaPanel.add(snowSurfaceCombo);
        buildArenaPanel.add(new JLabel("Weather Condition:"));
        weatherConditionCombo = new JComboBox<>(WeatherCondition.values());
        buildArenaPanel.add(weatherConditionCombo);

        JButton buildArenaButton = new JButton("Build Arena");
        buildArenaButton.addActionListener(new BuildArenaListener());
        buildArenaPanel.add(buildArenaButton);
        buildArenaPanel.setBorder(BorderFactory.createTitledBorder("Build Arena"));

        // CREATE COMPETITION panel
        JPanel createCompetitionPanel = new JPanel();
        createCompetitionPanel.setLayout(new GridLayout(6, 2));
        createCompetitionPanel.add(new JLabel("Competition Type:"));
        competitionTypeCombo = new JComboBox<>(new String[]{"Ski", "Snowboard"});
        createCompetitionPanel.add(competitionTypeCombo);
        createCompetitionPanel.add(new JLabel("Max Competitors:"));
        maxCompetitorsField = new JTextField(10);
        createCompetitionPanel.add(maxCompetitorsField);
        createCompetitionPanel.add(new JLabel("Discipline:"));
        disciplineCombo = new JComboBox<>(Discipline.values());
        createCompetitionPanel.add(disciplineCombo);
        createCompetitionPanel.add(new JLabel("League:"));
        leagueCombo = new JComboBox<>(League.values());
        createCompetitionPanel.add(leagueCombo);
        createCompetitionPanel.add(new JLabel("Gender:"));
        genderCombo = new JComboBox<>(Gender.values());
        createCompetitionPanel.add(genderCombo);
        JButton createCompetitionButton = new JButton("Create Competition");


        createCompetitionButton.addActionListener(new CreateCompetitionListener());
        createCompetitionPanel.add(createCompetitionButton);
        createCompetitionPanel.setBorder(BorderFactory.createTitledBorder("Create Competition"));


        JPanel competitionShortcut = new JPanel();
        competitionShortcut.setLayout(new GridLayout(4, 3));
        competitionShortcut.setBorder(BorderFactory.createTitledBorder("Create competition shortcut"));

        competitionShortcut.add(new JLabel("Enter amount of competitors:"));
        amount = new JTextField(5);

        JButton createDefaultCompetitionButton = new JButton("Create default Competition");
        createDefaultCompetitionButton.addActionListener(new createDefaultCompetitionListener());

        competitionShortcut.add(amount);
        competitionShortcut.add(createDefaultCompetitionButton);


        // ADD COMPETITOR panel
        JPanel Player = new JPanel();
        Player.setSize(50, 50);


        JPanel addCompetitorPanel = new JPanel();
        addCompetitorPanel.setLayout(new GridLayout(5, 2));
        addCompetitorPanel.add(new JLabel("Name:"));
        nameField = new JTextField(10);
        addCompetitorPanel.add(nameField);
        addCompetitorPanel.add(new JLabel("Age:"));
        ageField = new JTextField(10);
        addCompetitorPanel.add(ageField);
        addCompetitorPanel.add(new JLabel("Max Speed:"));
        maxSpeedField = new JTextField(10);
        addCompetitorPanel.add(maxSpeedField);
        addCompetitorPanel.add(new JLabel("Acceleration:"));
        accelerationField = new JTextField(10);
        addCompetitorPanel.add(accelerationField);
        JButton addCompetitorButton = new JButton("Add Competitor");
        addCompetitorButton.addActionListener(new AddCompetitorListener());
        addCompetitorPanel.add(addCompetitorButton);


        addCompetitorPanel.setBorder(BorderFactory.createTitledBorder("Add Competitor"));


        JPanel addModifiedCompetitorPanel = new JPanel();
        addModifiedCompetitorPanel.setLayout(new GridLayout(12, 2));

        addModifiedCompetitorPanel.setBorder(BorderFactory.createTitledBorder("Choose competitor from the list:"));


        JButton add_copy_modify_existing_competitor_button = new JButton("Show list of competitors");
        add_copy_modify_existing_competitor_button.addActionListener(new AddChangedExistingCompetitor());
        addModifiedCompetitorPanel.add(add_copy_modify_existing_competitor_button);

        CompetitorsListCombo = new JComboBox<>();
        addModifiedCompetitorPanel.add(CompetitorsListCombo);

        add_copy_modify_existing_competitor_button.addActionListener(new AddChangedExistingCompetitor());

        addModifiedCompetitorPanel.add(new JLabel("Change copied chosen competitor:"));
        addModifiedCompetitorPanel.add(new JLabel("Choose colour:"));

        colourCombo = new JComboBox<>(new String[]{"Blue", "Pink"});

        addModifiedCompetitorPanel.add(colourCombo);


        JButton addNewCopiedCompetitor = new JButton("Add new changed competitor");
        addModifiedCompetitorPanel.add(addNewCopiedCompetitor);
        addNewCopiedCompetitor.addActionListener(new addNewCopiedCompetitorListener());

        addModifiedCompetitorPanel.add(new JLabel("Modify chosen competitor:"));

        addModifiedCompetitorPanel.add(new JLabel("Choose colour:"));

        colour1Combo = new JComboBox<>(new String[]{"No change","Blue", "Pink"});
        addModifiedCompetitorPanel.add(colour1Combo);
        addModifiedCompetitorPanel.add(new JLabel("Add acceleration:"));
        addAccelerationField = new JTextField(5);

        addModifiedCompetitorPanel.add(addAccelerationField);

        JButton modifyCompetitor = new JButton("Modify competitor");
        addModifiedCompetitorPanel.add(modifyCompetitor);
        modifyCompetitor.addActionListener(new modifyCompetitorListener());


        // Create buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        JButton startCompetitionButton = new JButton("Start Competition");
        startCompetitionButton.addActionListener(new StartCompetitionListener());
        JButton showInfoButton = new JButton("Show Info");
        showInfoButton.addActionListener(new ShowInfoListener());
        buttonPanel.add(startCompetitionButton);
        buttonPanel.add(showInfoButton);
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        // Add panels to the main panel
        mainPanel.add(buildArenaPanel);
        mainPanel.add(createCompetitionPanel);
        mainPanel.add(competitionShortcut);
        mainPanel.add(addCompetitorPanel);
        mainPanel.add(addModifiedCompetitorPanel);
        // mainPanel.add(Box.createVerticalGlue()); // Adds space between components and buttons
        mainPanel.add(buttonPanel);


        // יצירת גלגלת עבור אזור הטקסט


        // The following is the  canvas panel for the background image and painting the players as well
        canvasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                if (backgroundImage != null && arena == null) {
                    g.drawImage(backgroundImage, 0, 0, 1200, 700, this);

                }

                if (backgroundImage != null && arena != null) {
                    g.drawImage(backgroundImage, 0, 0, 1200, (int) ((WinterArena) arena).getLength(), this);

                }

                if (competition1 != null && competition1.hasActiveCompetitors()) {
                    for (int i = 0; i < competition1.getActiveCompetitors().size(); i++) {
                        if (Objects.equals(((WinterSportsman) (competition1.getActiveCompetitors().get(i))).getColour(), "Blue")) {
                            try {
                                if (Objects.equals(competitorType, "Skier"))
                                    playerImage = ImageIO.read(new File("src/icons/SkiMale.png"));
                                else
                                    playerImage = ImageIO.read(new File("src/icons/SnowboardMale.png"));


                            } catch (IOException ex) {
                                return;
                            }

                        } else {
                            try {

                                if (Objects.equals(competitorType, "Skier"))
                                    playerImage = ImageIO.read(new File("src/icons/SkiFemale.png"));
                                else
                                    playerImage = ImageIO.read(new File("src/icons/SnowboardFemale.png"));
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }

                        try {
                            g.drawImage(playerImage, (int) (competition1.getActiveCompetitors().get(i).getLocation().getX()), (int) (competition1.getActiveCompetitors().get(i).getLocation().getY()), 50, 50, null);

                        } catch (Exception e) {

                            return;

                        }
                    }
                }

                if (competition1 != null && !competition1.getFinishedCompetitors().isEmpty()) {
                    for (int i = 0; i < competition1.getFinishedCompetitors().size(); i++) {
                        if ( Objects.equals(((WinterSportsman) (competition1.getFinishedCompetitors().get(i))).getColour(), "Blue")) {
                            try {
                                if (Objects.equals(competitorType, "Skier"))
                                    playerImage = ImageIO.read(new File("src/icons/SkiMale.png"));
                                else
                                    playerImage = ImageIO.read(new File("src/icons/SnowboardMale.png"));


                            } catch (IOException ex) {
                                return;
                            }

                        } else {
                            try {

                                if (Objects.equals(competitorType, "Skier"))
                                    playerImage = ImageIO.read(new File("src/icons/SkiFemale.png"));
                                else
                                    playerImage = ImageIO.read(new File("src/icons/SnowboardFemale.png"));


                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        try {

                            if(!Objects.equals(((WinterSportsman) (competition1.getFinishedCompetitors().get(i))).getState().alert(), "disabled"))
                                    g.drawImage(playerImage, (int) (competition1.getFinishedCompetitors().get(i).getLocation().getX()), 650, 50, 50, null);
                            else g.drawImage(playerImage, (int) (competition1.getFinishedCompetitors().get(i).getLocation().getX()), (int) (competition1.getFinishedCompetitors().get(i).getLocation().getY()), 50, 50, null);


                        } catch (Exception e) {
                            return;
                        }

                    }
                }
            }

        };


        canvasPanel.setPreferredSize(new Dimension(1200, 700)); // Adjust size as needed
        canvasPanel.setBorder(BorderFactory.createTitledBorder(""));


        // Adding canvas panel to frame

        Font smallerFont = new Font("Arial", Font.PLAIN, 10);
        int componentWidth = 140;  // Adjust width as needed
        int componentHeight = 12; // Adjust height as needed

        // Set font and size for all components in the panel
        setFontAndSizeRecursively(mainPanel, smallerFont, componentWidth, componentHeight);


        frame.add(mainPanel, BorderLayout.EAST);

        frame.add(canvasPanel, BorderLayout.WEST);


        frame.setVisible(true);


    }

    /**
     * Returns the {@link JPanel} representing the canvas panel.
     * This panel can be used for drawing or other graphical operations.
     *
     * @return The canvas {@link JPanel}.
     */

    public JPanel getCanvas()
    {
        return canvasPanel;

    }


    /**
     * Recursively sets the font and size of all components within a given container.
     * This method traverses through the container hierarchy, applying the specified font
     * and resizing components like {@link JButton}, {@link JTextField}, and {@link JLabel}
     * that have a {@code setPreferredSize} method.
     *
     * <p>This can be useful for ensuring a consistent look and feel across a GUI application,
     * especially when you need to adjust component sizes and fonts dynamically.</p>
     *
     * @param container The top-level {@link Container} whose components will be adjusted.
     * @param font      The {@link Font} to be applied to all components.
     * @param width     The preferred width for resizable components.
     * @param height    The preferred height for resizable components.
     */

    public static void setFontAndSizeRecursively(Container container, Font font, int width, int height) {
        for (Component component : container.getComponents()) {
            if (component instanceof Container) {
                setFontAndSizeRecursively((Container) component, font, width, height);
            }
            component.setFont(font);

            // Adjust size for components with setPreferredSize method
            if (component instanceof JButton || component instanceof JTextField || component instanceof JLabel) {
                component.setPreferredSize(new Dimension(width, height));
            }
        }
    }

    /**
     * Sets a new background image for the canvas panel.
     *
     * @param imagePath the path to the image file.
     */
    public void setBackgroundImage(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));

            canvasPanel.revalidate();
            canvasPanel.repaint();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Updates the state and position of a competitor (RACER) in the competition.
     * This method handles the movement of the competitor, changes their state based on their location,
     * and manages the transitions between different states such as "active," "injured," "disabled," and "completed."
     *
     * <p>This method is synchronized to ensure that updates to the competitor's state and location are thread-safe.</p>
     *
     * @param RACER The competitor whose state and location are to be updated.
     * @param point The new location of the competitor.
     */

    @Override
    public synchronized void UpdateCompetition(WinterSportsman RACER, Point point)
    {

        RACER.setLocation(point);

        RACER.move(((WinterArena)arena).getFriction());


        if(RACER.getLocation().getY()> RACER.getStateChangeLocation() && RACER.getLocation().getY()<RACER.getStateChangeLocation()*1.5 && Objects.equals(RACER.getNewState(), "injured") )
        {

                RACER.getState().setState(new injured());

                RACER.setChangeStateTime(System.currentTimeMillis()-startTime);


            int time = 1000;
            try {
                sleep(time);
            } catch (InterruptedException e) {
                System.out.println("Got an exception");
            }


            Random rnd = new Random();

                String[] options = {"active", "disabled"};

                int index = rnd.nextInt(options.length);

                String newState = options[index];

                if(newState.equals("active"))
                {
                    RACER.getState().setState(new active());
                    RACER.setNewState("active");

                }
                else
                {
                    RACER.setNewState("disabled");
                    RACER.setChangeStateTime(0);
                }

        }

        if (Objects.equals(RACER.getNewState(), "disabled"))
            {

                RACER.getState().setState(new disabled());
                competition1.AddFinishedCompetitor(RACER);
                competition1.getActiveCompetitors().remove(RACER);

            }



        if(RACER.getLocation().getY()>=get_arena_length())
        {
            RACER.getState().setState(new completed());
            competition1.AddFinishedCompetitor(RACER);

            competition1.RemoveCompetitor(RACER);
        }

        if(competition1.getActiveCompetitors().isEmpty() && !competition1.getFinishedCompetitors().isEmpty())
        {

            competition1.setRACEFINISHED();

        }

    }

    /**
     * Returns the length of the arena.
     *
     * @return The length of the arena as a {@code double}.
     */
    @Override
    public double get_arena_length()
    {
        return ((WinterArena)arena).getLength();
    }

    /**
     * Returns the GUI component associated with the competition.
     *
     * @return The {@link GUIcompetition} instance.
     */
    @Override
    public GUIcompetition getGUI() {
        return this;
    }



    /**
     * ActionListener for the "Build Arena" button.
     * Builds the arena based on user input.
     */
    private class BuildArenaListener implements ActionListener {

        /**
         *  actionPerformed function for building the arena based on user input.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!RaceBegan)   //עברנו על זה וזה בסדר
            {
                competition1 = null;
                gap = 0;
                repaint();
            }

            if (competition1 != null) //עברנו על זה וזה בסדר
            {
                if (competition1.get_if_race_finished()) {
                    RaceBegan = false;
                    gap = 0;
                    competition1.getFinishedCompetitors().clear();
                    competition1.getActiveCompetitors().clear();
                    competition1 = null;
                    repaint();

                }
            }


            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun. Not possible to start a new race before the previous one has finished.");
                return;
            }


            if (arenaLengthField.getText() == null || arenaLengthField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter arena length.");
                return;
            }

            double Length = Double.parseDouble(arenaLengthField.getText());
            SnowSurface snowSurface = (SnowSurface) snowSurfaceCombo.getSelectedItem();
            WeatherCondition weatherCondition = (WeatherCondition) weatherConditionCombo.getSelectedItem();

            if (Length > 900 || Length < 700) {
                JOptionPane.showMessageDialog(frame, "Invalid Length input value! Please try again.");
                return;
            }

            String arena_type = arenaType.getSelectedItem().toString();

            ArenaFactory factory = new ArenaFactory();
            arena = factory.getArena(arena_type, Length, snowSurface, weatherCondition);

            //JOptionPane.showMessageDialog(frame, arena);

            if (Objects.equals(arena_type, "summer")) {

                return;

            }


            String imagePath = switch (weatherCondition) {
                case SUNNY -> "src/icons/Sunny.jpg";
                case CLOUDY -> "src/icons/Cloudy.jpg";
                case STORMY -> "src/icons/Stormy.jpg";
            };

            canvasPanel.setSize(1000, (int) Length);
            setBackgroundImage(imagePath);
            repaint();


            SwingUtilities.invokeLater(() -> {
                canvasPanel.revalidate();
                canvasPanel.repaint();
                frame.pack();
            });

        }
    }


    private class createDefaultCompetitionListener implements ActionListener {

        /**
         * Handles the action event triggered by the Create default Competition button.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }


            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to start a new race before the previous one has finished.");
                return;

            }

            if (amount.getText().isEmpty() || Integer.parseInt(amount.getText()) > 20 || Integer.parseInt(amount.getText()) <= 0) {
                JOptionPane.showMessageDialog(frame, "Please enter amount of competitors for the competition, amount must be positive and less than 20!");
                return;

            }

            gap = 0;



            int amount_of_competitors = Integer.parseInt(amount.getText());

            SkiCompetitionBuilder cBuilder = new MyBuilder(GUIcompetition.this);

            Engineer engineer = new Engineer(cBuilder);

            engineer.constructCompetition(amount_of_competitors, canvasPanel);

            competition1 = engineer.getSkiCompetition();

            competitorType = "Skier";

            for (int i = 0; i < amount_of_competitors; i++) {
                competition1.getActiveCompetitors().get(i).setLocation(new Point(gap, 0));

                gap += 60;
            }


            arena = competition1.getArena();


            String imagePath = "src/icons/Stormy.jpg";


            canvasPanel.setSize(1000, (int) competition1.get_arena_length());
            setBackgroundImage(imagePath);
            repaint();


            SwingUtilities.invokeLater(() -> {
                canvasPanel.revalidate();
                canvasPanel.repaint();
                frame.pack();
            });


        }

    }


    /**
     * ActionListener for the Create Competition button.
     * This class handles the creation of a competition based on the selected
     * arena, discipline, gender, and league. It also ensures that the necessary
     * conditions for creating a competition are met.
     */
    private class CreateCompetitionListener implements ActionListener {

        /**
         * Handles the action event triggered by the Create Competition button.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }

            if (arena == null) {
                JOptionPane.showMessageDialog(frame, "Please build arena, then create the competition and then add competitors!");
                return;
            }


            if (competition1 != null) {
                if (competition1.get_if_race_finished()) {
                    JOptionPane.showMessageDialog(frame, "Please build arena, then create the competition and then add competitors!");
                    return;
                }
            }


            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to start a new race before the previous one has finished.");
                return;

            }

            if (maxCompetitorsField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter MAX amount of competitors.");
                return;
            }

            if (Integer.parseInt(maxCompetitorsField.getText()) < 1 || Integer.parseInt(maxCompetitorsField.getText()) > 20) {
                JOptionPane.showMessageDialog(frame, "MAX amount of competitors must be between 1-20..");
                return;
            }

            String ComType = (String) competitionTypeCombo.getSelectedItem();
            int MaxCompetitors = Integer.parseInt(maxCompetitorsField.getText());
            Discipline discipline = (Discipline) disciplineCombo.getSelectedItem();
            Gender gender = (Gender) genderCombo.getSelectedItem();
            League league = (League) leagueCombo.getSelectedItem();


            if (Objects.equals(ComType, "Ski")) {
                competition1 = new SkiCompetition(GUIcompetition.this, (WinterArena) arena, MaxCompetitors, discipline, league, gender);
                competitorType = "Skier";
            } else {
                competition1 = new SnowboardCompetition(GUIcompetition.this , (WinterArena) arena, MaxCompetitors, discipline, league, gender);
                competitorType = "Snowboarder";
            }


            SwingUtilities.invokeLater(() -> {
                canvasPanel.revalidate();
                canvasPanel.repaint();
                frame.pack();
            });
        }


    }

    /**
     * The {@code AddChangedExistingCompetitor} class is an inner class that implements {@link ActionListener}.
     * It handles the event where the user attempts to change or add an existing competitor to the competition.
     *
     * <p>This class checks various conditions, such as ensuring the correct arena type is selected,
     * verifying that the competition and arena are initialized, and ensuring that competitors are present and the race has not started.</p>
     *
     * <p>If any of these conditions are not met, it displays appropriate error messages using {@link JOptionPane} dialogs.</p>
     */

    private class AddChangedExistingCompetitor implements ActionListener {


        /**
         * Invoked when an action occurs. This method checks the selected arena type,
         * ensures the competition and arena are initialized, verifies that competitors exist,
         * and that the race has not begun. If all conditions are met, it updates the list
         * of competitors in the {@code CompetitorsListCombo} combo box.
         *
         * @param e The action event that triggers this method.
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }

            if (competition1 == null || arena == null) {
                JOptionPane.showMessageDialog(frame, "Please build arena, create competition and add competitors!");
                return;
            }

            if (!competition1.hasActiveCompetitors()) {
                JOptionPane.showMessageDialog(frame, "Please add competitors!");
                return;
            }


            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to add competitors before the race has finished.");
                return;

            }

            ArrayList<String> competitors_and_Id_list = new ArrayList<>();

            CompetitorsListCombo.removeAllItems();

            for (int i = 0; i < competition1.getActiveCompetitors().size(); i++) {
                int num1 = ((WinterSportsman) (competition1.getActiveCompetitors().get(i))).getUnique_num();
                String num = "" + num1;
                String name = ((WinterSportsman) (competition1.getActiveCompetitors().get(i))).getName();
                String ID = name + ", " + num;
                competitors_and_Id_list.add(ID);
            }


            for (String item : competitors_and_Id_list) {
                CompetitorsListCombo.addItem(item);
            }


        }
    }


    /**
     * The {@code addNewCopiedCompetitorListener} class is an inner class that implements {@link ActionListener}.
     * It handles the event where the user attempts to add a new competitor by copying and modifying an existing one.
     *
     * <p>This class performs various checks, such as ensuring the correct arena type is selected,
     * verifying that the competition and arena are initialized, ensuring that competitors are present,
     * and that the race has not started. It also checks if the competition is full or if a competitor has been selected.</p>
     *
     * <p>If all conditions are met, it creates a new competitor by cloning an existing one, applies modifications,
     * and adds the new competitor to the competition.</p>
     */
    private class addNewCopiedCompetitorListener implements ActionListener {

        /**
         * Invoked when an action occurs. This method checks the selected arena type,
         * ensures the competition and arena are initialized, verifies that competitors exist,
         * and that the race has not begun. If all conditions are met, it clones the selected
         * competitor, modifies the clone, and adds it to the competition. The graphical interface
         * is then updated to reflect the changes.
         *
         * @param e The action event that triggers this method.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }

            if (competition1 == null || arena == null) {
                JOptionPane.showMessageDialog(frame, "Please build arena, create competition and add competitors!");
                return;
            }

            if (!competition1.hasActiveCompetitors()) {
                JOptionPane.showMessageDialog(frame, "Please add competitors!");
                return;
            }


            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to add competitors before the race has finished.");
                return;

            }


            if (competition1.getActiveCompetitors().size() >= competition1.getMaxCompetitors()) {
                JOptionPane.showMessageDialog(frame, "Competition is full, no more competitors can be added.");
                return;
            }


            if (CompetitorsListCombo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(frame, "Please select competitor from the list in order to create a modified copied competitor ");
                return;
            }


            int ChosenCompetitorIndex = (int) CompetitorsListCombo.getSelectedIndex();
            String ChosenColour = (String) colourCombo.getSelectedItem();

            CompetitorsListCombo.removeAllItems();

            WinterSportsman SelectedSportsman = (WinterSportsman) competition1.getActiveCompetitors().get(ChosenCompetitorIndex);

            WinterSportsman newSportsman = SelectedSportsman.clone();

            PrototypeCompetitor workShop = new PrototypeCompetitor();

            workShop.makeNewCompetitor(newSportsman, ChosenColour);


            if (Objects.equals(competitorType, "Skier")) {

                Skier competitor1 = new Skier(canvasPanel, newSportsman.getName(), newSportsman.getAge(), competition1.getGender(), newSportsman.getAcceleration(), newSportsman.getMaxSpeed(), competition1.getDiscipline());
                competitor1.upgrade(ChosenColour);
                competitor1.setLocation(new Point(gap, 0));

                competition1.addCompetitor(competitor1);

                gap += 60;


            } else {
                Snowboarder competitor2 = new Snowboarder(canvasPanel, newSportsman.getName(), newSportsman.getAge(), competition1.getGender(), newSportsman.getAcceleration(), newSportsman.getMaxSpeed(), competition1.getDiscipline());
                competitor2.upgrade(ChosenColour);
                competitor2.setLocation(new Point(gap, 0));

                competition1.addCompetitor(competitor2);
                gap += 60;

            }


            SwingUtilities.invokeLater(() -> {
                canvasPanel.revalidate();
                canvasPanel.repaint();
                frame.pack();
            });

        }

    }


    /**
     * The {@code modifyCompetitorListener} class is an inner class that implements {@link ActionListener}.
     * It handles the event where the user modifies an existing competitor's attributes, such as their color
     * and acceleration, in the competition.
     *
     * <p>This class ensures that the necessary conditions are met before allowing modifications, such as
     * checking for active competitors, ensuring a competitor is selected, and confirming that the race
     * has not started. If all conditions are satisfied, it updates the selected competitor's attributes.</p>
     */
    private class modifyCompetitorListener implements ActionListener {
        /**
         * Handles the action event triggered by the "Modify Competitor" button.
         *
         * <p>This method checks if there are active competitors in the competition, verifies that a competitor
         * is selected, and ensures that the race has not begun. It then retrieves the selected competitor and
         * modifies their attributes based on user input, such as changing the color and adjusting the acceleration.</p>
         *
         * @param e the action event that triggers this method.
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (!competition1.hasActiveCompetitors()) {
                JOptionPane.showMessageDialog(frame, "Please add competitors!");
                return;
            }


            if (CompetitorsListCombo.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(frame, "Please select competitor from the list in order to modify its attributes ");
                return;
            }

            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to add competitors before the race has finished.");
                return;
            }


            String Colour = colour1Combo.getSelectedItem().toString();
            double acceleration = 0;


            if (!addAccelerationField.getText().isEmpty()) {
                try {
                    acceleration = Double.parseDouble(addAccelerationField.getText());

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(frame, "Acceleration must be positive decimal number!");
                    return;

                }
            }


            WinterSportsman w = (WinterSportsman) (competition1.getActiveCompetitors().get(CompetitorsListCombo.getSelectedIndex()));

            IWinterSportsman winterSportsman = null;

            if(colour1Combo.getSelectedIndex()!=0)
            {
                if (!addAccelerationField.getText().isEmpty()) {
                    winterSportsman = new SpeedySportsman(acceleration, new ColoredSportsman(Colour, w));
                }
                else
                    winterSportsman = new SpeedySportsman(0, new ColoredSportsman(Colour, w));
            }

            else
            {
                if (!addAccelerationField.getText().isEmpty()) {
                    winterSportsman = new SpeedySportsman(acceleration, w);
                }

            }

            winterSportsman.updateWinterSportsman();




            SwingUtilities.invokeLater(() -> {
                canvasPanel.revalidate();
                canvasPanel.repaint();
                frame.pack();
            });


        }


    }


    /**
     * ActionListener for the Add Competitor button.
     * This class handles adding a new competitor to the competition. It validates
     * the input fields, creates a new competitor, and adds it to the competition.
     */
    private class AddCompetitorListener implements ActionListener {
        /**
         * Handles the action event triggered by the Add Competitor button.
         *
         * @param e the action event
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }
            if (competition1 == null || arena == null) {
                JOptionPane.showMessageDialog(frame, "Please build arena, create competition and add competitors!");
                return;
            }


            if (competition1.get_if_race_finished()) {
                JOptionPane.showMessageDialog(frame, "Please build arena, then create the competition and then add competitors!");
                return;
            }


            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to add competitors to the current competition.");
                return;

            }


            if (competition1.getActiveCompetitors().size() >= competition1.getMaxCompetitors()) {
                JOptionPane.showMessageDialog(frame, "Competition is full, no more competitors can be added.");
                return;
            }


            if (nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter name.");
                return;
            }

            // Extract and validate competitor details

            String name = nameField.getText();
            double age = 0;
            double MaxSpeed = 0;
            double acceleration = 0;

            try {
                age = Double.parseDouble(ageField.getText());
                MaxSpeed = Double.parseDouble(maxSpeedField.getText());
                acceleration = Double.parseDouble(accelerationField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Incorrect value types: age, max speed and acceleration must be of type double.");
                return;
            }


            if (!competition1.getLeague().isInLeague(age)) {
                JOptionPane.showMessageDialog(frame, "Competitor does not fit to the age of the league in the competition! Choose another competitor.");
                return;

            }


            // Create competitor based on competition type

            if (competitionTypeCombo.getSelectedItem().toString() == "Ski") {
                Skier competitor1 = new Skier(canvasPanel, name, age, competition1.getGender(), acceleration, MaxSpeed, competition1.getDiscipline());

                competitor1.setLocation(new Point(gap, 0));

                competition1.addCompetitor(competitor1);

                gap += 60;

                if (Objects.equals(competitor1.getColour(), "Blue")) {
                    try {
                        playerImage = ImageIO.read(new File("src/icons/SkiMale.png"));


                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                } else {
                    try {
                        playerImage = ImageIO.read(new File("src/icons/SkiFemale.png"));

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }


            } else {
                Snowboarder competitor2 = new Snowboarder(canvasPanel, name, age, competition1.getGender(), acceleration, MaxSpeed, competition1.getDiscipline());
                competitor2.setLocation(new Point(gap, 0));
                competition1.addCompetitor(competitor2);
                gap += 60;

                if (Objects.equals(competitor2.getColour(), "Blue")) {
                    try {
                        playerImage = ImageIO.read(new File("src/icons/SnowboardMale.png"));

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                } else {
                    try {
                        playerImage = ImageIO.read(new File("src/icons/SnowboardFemale.png"));

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                }


            }


            SwingUtilities.invokeLater(() -> {
                canvasPanel.revalidate();
                canvasPanel.repaint();
                frame.pack();
            });


            CompetitorsListCombo.removeAllItems();
        }

    }

    /**
     * ActionListener for the Start Competition button.
     * This class handles the action of starting the competition. It validates that a competition
     * has been created and has competitors. It also updates the GUI and starts the race.
     */
    private class StartCompetitionListener implements ActionListener {
        /**
         * Handles the action event triggered by the Start Competition button.
         * It checks if the competition has been created and has competitors.
         * If these conditions are met, it updates the GUI to reflect the start of the race
         * and initiates the competition logic.
         *
         * @param e the action event
         */

        @Override
        public void actionPerformed(ActionEvent e) {

            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }

            if (competition1 == null || arena == null) {
                JOptionPane.showMessageDialog(frame, "Please build arena, create competition and add competitors!");
                return;

            }
            if (RaceBegan) {
                JOptionPane.showMessageDialog(frame, "The race has begun." +
                        " Not possible to start a new race before the previous one has finished.");
                return;
            }

            if (competition1.get_if_race_finished()) {
                JOptionPane.showMessageDialog(frame, "Please build arena, create competition and add competitors!");
                return;
            }


            RaceBegan = true;


            (new Thread() {
                public void run() {
                    while (competition1.hasActiveCompetitors()) {
                        try {
                            int timeToSleep = 30;
                            Thread.sleep(timeToSleep);
                            revalidate();
                            repaint();


                        } catch (InterruptedException ex) {
                            ex.printStackTrace();

                        }
                    }
                    RaceBegan = false;

                    revalidate();
                    repaint();
                }
            }).start();

            startTime = System.currentTimeMillis();

            for (int i = 0; i < competition1.getActiveCompetitors().size(); i++) {
                new Thread((WinterSportsman) competition1.getActiveCompetitors().get(i)).start();

            }


        }
    }

    /**
     * ActionListener for the Show Info button.
     */
    private class ShowInfoListener implements ActionListener {


        /**
         * Displays a dialog showing information about the competition.
         * This method gathers information about the competition such as competitors' details, and the status of the race, and then displays it in a message dialog.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Objects.equals(arenaType.getSelectedItem().toString(), "summer")) {
                JOptionPane.showMessageDialog(frame, "You must choose the winter arena instead of the summer one in order to continue with creating the competition.");
                return;

            }

            if (competition1 == null || !competition1.hasActiveCompetitors() && competition1.getFinishedCompetitors().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please build arena, create competition and add competitors!");
                return;
            }

            InfoFrame = new JFrame();
            InfoPanel = new JPanel();
            InfoFrame.setTitle("Competitors information");
            InfoFrame.setSize(800, 300);

            InfoPanel.setLayout(new BorderLayout());


            String[] columnNames = {"Name", "Speed", "Max speed", "Acceleration", "Location", "Finished", "Unique ID", "State", "Time (mills)"};


            tableModel = new DefaultTableModel();
            table = new JTable(tableModel);

            tableModel.setColumnIdentifiers(columnNames);


            for (int j = 0; j < competition1.getFinishedCompetitors().size() && !competition1.getFinishedCompetitors().isEmpty(); j++) {

                WinterSportsman s = (WinterSportsman) (competition1.getFinishedCompetitors().get(j));
                String finished="yes";
                String state="completed";
                if(Objects.equals(s.getState().alert(), "disabled") )
                {
                    finished = "no";
                    state="Failed";
                }

                tableModel.addRow(new Object[]{
                        s.getName(),
                        s.getSpeed(),
                        s.getMaxSpeed(),
                        s.getAcceleration(),
                        s.getLocation().getY(),
                        finished,
                        s.getUnique_num(),
                        state,
                        });


            }


            for (int i = 0; i < competition1.getActiveCompetitors().size() && !competition1.getActiveCompetitors().isEmpty(); i++) {

                WinterSportsman s = (WinterSportsman) (competition1.getActiveCompetitors()).get(i);

                if(Objects.equals(s.getState().alert(), "injured"))
                {
                    tableModel.addRow(new Object[]{
                            s.getName(),
                            s.getSpeed(),
                            s.getMaxSpeed(),
                            s.getAcceleration(),
                            s.getLocation().getY(),
                            "no",
                            s.getUnique_num(),
                            s.getState().alert(),
                            s.getChangeStateTime()
                    });


                }
                else {

                    tableModel.addRow(new Object[]{
                            s.getName(),
                            s.getSpeed(),
                            s.getMaxSpeed(),
                            s.getAcceleration(),
                            s.getLocation().getY(),
                            "no",
                            s.getUnique_num(),
                            s.getState().alert(),

                    });
                }


            }


            // Add the table to a scroll pane (optional)
            JScrollPane scrollPane = new JScrollPane(table);

            // Add the scroll pane to the panel
            InfoPanel.add(scrollPane, BorderLayout.CENTER);

            InfoFrame.add(InfoPanel);

            InfoFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    tableModel.setRowCount(0); // Clear all rows
                }
            });


            InfoFrame.setVisible(true);

        }
    }


    /**
     * Launches the GUICompetition application on the Event Dispatch Thread.
     * Ensures thread-safety for GUI operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIcompetition GUICompetition = new GUIcompetition();
        });
    }
}