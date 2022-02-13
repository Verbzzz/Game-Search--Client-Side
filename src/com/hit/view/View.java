package com.hit.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Arrays;


public class View extends JFrame{



    // Windows.
    public JPanel homeScreenPanel = new JPanel();
    public JPanel adminPanel = new JPanel();
    public JPanel adminAuthorization = new JPanel();
    public JPanel adminGameUpdatePanel = new JPanel();
    public JPanel adminGameSavePanel = new JPanel();
    public JPanel adminGameDeletePanel = new JPanel();

    public JPanel userPanel = new JPanel();
   //public JPanel gameClientPanel = new JPanel();




    // Main Buttons
    public JButton adminButton = new JButton("Enter as Admin");
    public JButton userButton = new JButton("Enter as User");

    public JButton saveButton = new JButton("Save a new game");
    public JButton updateButton = new JButton("Update a game");
    public JButton deleteButton = new JButton("Delete a game");

    public JButton exitFromAdminAuthorizationButton = new JButton("Back");
    public JButton exitFromSaveAdminButton = new JButton("Back");
    public JButton exitFromUpdateAdminButton = new JButton("Back");
    public JButton exitFromDeleteAdminButton = new JButton("Back");
    public JButton exitFromAdminButton = new JButton("Back");
    public JButton exitFromUserButton = new JButton("Back");



    ///////  Admin Panels //////
    public JTextArea loginText = new JTextArea("Admin password");
    public JTextArea addGameText = new JTextArea("Add a new game");
    public JTextArea updateGameText = new JTextArea("Update a game");
    public JTextArea saveGameText = new JTextArea("Save a game");
    public JTextArea deleteGameText = new JTextArea("Delete Game");

    //delete game
    public JTextArea gameToDeleteText = new JTextArea("Game name to delete");
    public JTextField gameNameDeleteAdmin = new JTextField();

    //save game
    public JTextArea nameText = new JTextArea("Game Name:");
    public JTextArea genreText = new JTextArea("Genre:");
    public JTextArea gameCompanyDevelopText = new JTextArea("Company Develop:");
    public JTextArea gameStoreNameText = new JTextArea("Store Name:");
    public JTextArea addressStoreText = new JTextArea("Store Address:");

    public JTextField nameGameAdmin = new JTextField();
    public JTextField genreGameAdmin = new JTextField();
    public JTextField gameCompanyDevelopAdmin = new JTextField();
    public JTextField gameStoreNameAdmin = new JTextField();
    public JTextField addressStoreAdmin = new JTextField();


    //update
    public JTextArea nameUpdateText = new JTextArea("Game to update:");
    public JTextArea categoryToUpdateText = new JTextArea("Category to update:");
    public JTextArea valToUpdateText = new JTextArea("Enter the update:");

    public JTextField nameUpdateAdmin = new JTextField();
    public JTextField categoryToUpdateAdmin = new JTextField();
    public JTextField valToUpdateAdmin = new JTextField();




    public JButton saveGameButton = new JButton("Save");
    public JButton updateGameButton = new JButton("Update");
    public JButton deleteGameButton = new JButton("Delete Game");


    //admin login
    public JButton submitPasswordButton = new JButton("Login");
    public JPasswordField adminPassword = new JPasswordField();






///////  User Panels //////

    //get

    public JButton getGameButton = new JButton("Search Game");

    public JTextArea getGameText = new JTextArea("Search your game");
    public JTextField getGameUser = new JTextField();

    public String[] columns = {"Name", "Genre", "Develop Company", "Store Name", "Store Address"};
    public final DefaultTableModel[] dtm = {new DefaultTableModel(null, columns)};
    public JTable gameTable = new JTable(dtm[0]);
    public final JScrollPane[] gamePanel;


    public View(){

        /// main windows

        setResizable(false); // else all the styling goes away..
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600); // app size.
        this.getContentPane().setLayout(new CardLayout(0,0));
        this.setTitle("Game Search App");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dimension.width/2 - 500, dimension.height/2 - 250); //Location on screen


        this.getContentPane().add(homeScreenPanel);
        homeScreenPanel.setLayout(null);

        this.getContentPane().add(adminPanel);
        adminPanel.setLayout(null);

        this.getContentPane().add(adminAuthorization);
        adminAuthorization.setLayout(null);

        this.getContentPane().add(adminGameUpdatePanel);
        adminGameUpdatePanel.setLayout(null);

        this.getContentPane().add(adminGameDeletePanel);
        adminGameDeletePanel.setLayout(null);

        this.getContentPane().add(adminGameSavePanel);
        adminGameSavePanel.setLayout(null);

        this.getContentPane().add(userPanel);
        userPanel.setLayout(null);


        Color Salmon = new Color(225, 102, 102);
        Border border = BorderFactory.createLineBorder(Color.black);

        userButton.addActionListener(e -> {
            homeScreenPanel.setVisible(false);
            userPanel.setVisible(true);
        });
        userButton.setFont(new Font("Default", Font.ITALIC, 20 ));
        userButton.setBounds(600, 290, 165, 60);
        userButton.setBackground(Salmon);
        userButton.setBorder(border);
        userButton.setFocusPainted(false);


        adminButton.addActionListener(e -> {
            homeScreenPanel.setVisible(false);
            adminAuthorization.setVisible(true);
        });
        adminButton.setFont(new Font("Default", Font.ITALIC, 20 ));
        adminButton.setBackground(Salmon);
        adminButton.setBounds(300, 290, 165, 60);
        adminButton.setBorder(border);
        adminButton.setFocusPainted(false);

        homeScreenPanel.add(userButton);
        homeScreenPanel.add(adminButton);
        //homeScreenPanel.add(HomeScreenBack);

        //------------------------------------Admin  Authorization side---------------------------------------------//
        // ------------------------------------------------------------------------------------------//

        Color pink = new Color(225, 153, 153);
        adminPassword.setBounds(80,90,250,25);
        adminPassword.setBorder(border);

        loginText.setFont(new Font("Default", Font.ITALIC, 20 ));
        loginText.setForeground(pink);
        loginText.setBounds(50, 40, 350, 50);
        loginText.setOpaque(false);
        loginText.setEditable(false);


        JFrame frame = this;
        submitPasswordButton.addActionListener(e -> {
            if(isPasswordCorrect(adminPassword.getPassword()))
            {
                adminAuthorization.setVisible(false);
                adminPanel.setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog( frame, "Wrong Password");
            }
            adminPassword.setText("");

        });
        submitPasswordButton.setBounds(135,140,150,30);
        submitPasswordButton.setBackground(pink);
        submitPasswordButton.setBorder(border);
        submitPasswordButton.setFocusPainted(false);


        exitFromAdminAuthorizationButton.addActionListener(e->{

            adminPassword.setText("");
            adminAuthorization.setVisible(false);
            homeScreenPanel.setVisible(true);
        });

        exitFromAdminAuthorizationButton.setBounds(834,0,50,20);
        exitFromAdminAuthorizationButton.setBackground(pink);
        exitFromAdminAuthorizationButton.setBorder(border);

        adminAuthorization.add(loginText);
        adminAuthorization.add(adminPassword);
        adminAuthorization.add(submitPasswordButton);
        adminAuthorization.add(exitFromAdminAuthorizationButton);



        //------------------------------------Admin side---------------------------------------------//
        // ------------------------------------------------------------------------------------------//

        Color blackColor = new Color(0, 0, 0);

        exitFromAdminButton.setBounds(834,0,50,20);
        exitFromAdminButton.setBackground(pink);
        exitFromAdminButton.setBorder(border);

        exitFromAdminButton.addActionListener(e->{
            adminPanel.setVisible(false);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(true);
        });


        exitFromSaveAdminButton.setBounds(834,0,50,20);
        exitFromSaveAdminButton.setBackground(pink);
        exitFromSaveAdminButton.setBorder(border);

        exitFromSaveAdminButton.addActionListener(e->{

            nameGameAdmin.setText("");
            genreGameAdmin.setText("");
            gameCompanyDevelopAdmin.setText("");
            gameStoreNameAdmin.setText("");
            addressStoreAdmin.setText("");
            adminPanel.setVisible(true);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(false);
        });

        exitFromUpdateAdminButton.setBounds(834,0,50,20);
        exitFromUpdateAdminButton.setBackground(pink);
        exitFromUpdateAdminButton.setBorder(border);

        exitFromUpdateAdminButton.addActionListener(e->{

            nameUpdateAdmin.setText("");
            categoryToUpdateAdmin.setText("");
            valToUpdateAdmin.setText("");
            adminPanel.setVisible(true);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(false);
        });

        exitFromDeleteAdminButton.setBounds(834,0,50,20);
        exitFromDeleteAdminButton.setBackground(pink);
        exitFromDeleteAdminButton.setBorder(border);

        exitFromDeleteAdminButton.addActionListener(e->{

            gameNameDeleteAdmin.setText("");
            adminPanel.setVisible(true);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(false);
        });


        addGameText.setFont(new Font("Default", Font.ITALIC, 25 ));
        addGameText.setForeground(pink);
        addGameText.setBounds(50, 20, 400, 50);
        addGameText.setOpaque(false);
        addGameText.setEditable(false);

        updateGameText.setFont(new Font("Default", Font.ITALIC, 25 ));
        updateGameText.setForeground(pink);
        updateGameText.setBounds(50, 20, 400, 50);
        updateGameText.setOpaque(false);
        updateGameText.setEditable(false);

        saveGameText.setFont(new Font("Default", Font.ITALIC, 25 ));
        saveGameText.setForeground(pink);
        saveGameText.setBounds(50, 20, 400, 50);
        saveGameText.setOpaque(false);
        saveGameText.setEditable(false);

        deleteGameText.setFont(new Font("Default", Font.ITALIC, 25 ));
        deleteGameText.setForeground(pink);
        deleteGameText.setBounds(50, 20, 400, 50);
        deleteGameText.setOpaque(false);
        deleteGameText.setEditable(false);





        //save panel
        nameText.setFont(new Font("Default", Font.ITALIC, 15 ));
        nameText.setForeground(blackColor);
        nameText.setBounds(0, 90, 150, 30);
        nameText.setOpaque(false);
        nameText.setEditable(false);

        nameGameAdmin.setBounds(160,90,150,25);
        nameGameAdmin.setBorder(border);


        genreText.setFont(new Font("Default", Font.ITALIC, 15 ));
        genreText.setForeground(blackColor);
        genreText.setBounds(0, 120, 150, 30);
        genreText.setOpaque(false);
        genreText.setEditable(false);

        genreGameAdmin.setBounds(160,120,150,25);
        genreGameAdmin.setBorder(border);

        gameCompanyDevelopText.setFont(new Font("Default", Font.ITALIC, 15 ));
        gameCompanyDevelopText.setForeground(blackColor);
        gameCompanyDevelopText.setBounds(0, 150, 150, 30);
        gameCompanyDevelopText.setOpaque(false);
        gameCompanyDevelopText.setEditable(false);

        gameCompanyDevelopAdmin.setBounds(160,150,150,25);
        gameCompanyDevelopAdmin.setBorder(border);

        gameStoreNameText.setFont(new Font("Default", Font.ITALIC, 15 ));
        gameStoreNameText.setForeground(blackColor);
        gameStoreNameText.setBounds(0, 180, 150, 30);
        gameStoreNameText.setOpaque(false);
        gameStoreNameText.setEditable(false);

        gameStoreNameAdmin.setBounds(160,180,150,25);
        gameStoreNameAdmin.setBorder(border);

        addressStoreText.setFont(new Font("Default", Font.ITALIC, 15 ));
        addressStoreText.setForeground(blackColor);
        addressStoreText.setBounds(0, 210, 150, 30);
        addressStoreText.setOpaque(false);
        addressStoreText.setEditable(false);

        addressStoreAdmin.setBounds(160,210,150,25);
        addressStoreAdmin.setBorder(border);

        saveGameButton.setBounds(160,260,200,50);
        saveGameButton.setBackground(pink);
        saveGameButton.setBorder(border);
        saveGameButton.setFocusPainted(false);

        //save admin
        adminGameSavePanel.add(nameText);
        adminGameSavePanel.add(nameGameAdmin);
        adminGameSavePanel.add(genreText);
        adminGameSavePanel.add(genreGameAdmin);
        adminGameSavePanel.add(gameCompanyDevelopText);
        adminGameSavePanel.add(gameCompanyDevelopAdmin);
        adminGameSavePanel.add(gameStoreNameText);
        adminGameSavePanel.add(gameStoreNameAdmin);
        adminGameSavePanel.add(addressStoreText);
        adminGameSavePanel.add(addressStoreAdmin);
        adminGameSavePanel.add(saveGameButton);
        adminGameSavePanel.add(exitFromSaveAdminButton);



        //delete panel

        gameToDeleteText.setFont(new Font("Default", Font.ITALIC, 15 ));
        gameToDeleteText.setForeground(blackColor);
        gameToDeleteText.setBounds(380, 100, 150, 30);
        gameToDeleteText.setOpaque(false);
        gameToDeleteText.setEditable(false);

        gameNameDeleteAdmin.setBounds(380,150,180,25);
        gameNameDeleteAdmin.setBorder(border);

        deleteGameButton.setBounds(380,200,200,50);
        deleteGameButton.setBackground(pink);
        deleteGameButton.setBorder(border);
        deleteGameButton.setFocusPainted(false);


        //delete admin
        adminGameDeletePanel.add(gameToDeleteText);
        adminGameDeletePanel.add(gameNameDeleteAdmin);
        adminGameDeletePanel.add(deleteGameButton);
        adminGameDeletePanel.add(exitFromDeleteAdminButton);



        //update panel

        nameUpdateText.setFont(new Font("Default", Font.ITALIC, 15 ));
        nameUpdateText.setForeground(blackColor);
        nameUpdateText.setBounds(0, 90, 150, 30);
        nameUpdateText.setOpaque(false);
        nameUpdateText.setEditable(false);

        nameUpdateAdmin.setBounds(140,90,180,25);
        nameUpdateAdmin.setBorder(border);

        categoryToUpdateText.setFont(new Font("Default", Font.ITALIC, 15 ));
        categoryToUpdateText.setForeground(blackColor);
        categoryToUpdateText.setBounds(0, 120, 150, 30);
        categoryToUpdateText.setOpaque(false);
        categoryToUpdateText.setEditable(false);

        categoryToUpdateAdmin.setBounds(140,120,180,25);
        categoryToUpdateAdmin.setBorder(border);

        valToUpdateText.setFont(new Font("Default", Font.ITALIC, 15 ));
        valToUpdateText.setForeground(blackColor);
        valToUpdateText.setBounds(0, 150, 150, 30);
        valToUpdateText.setOpaque(false);
        valToUpdateText.setEditable(false);

        valToUpdateAdmin.setBounds(140,150,180,25);
        valToUpdateAdmin.setBorder(border);

        updateGameButton.setBounds(140,200,200,50);
        updateGameButton.setBackground(pink);
        updateGameButton.setBorder(border);
        updateGameButton.setFocusPainted(false);


        //update admin
        adminGameUpdatePanel.add(nameUpdateText);
        adminGameUpdatePanel.add(nameUpdateAdmin);
        adminGameUpdatePanel.add(categoryToUpdateText);
        adminGameUpdatePanel.add(categoryToUpdateAdmin);
        adminGameUpdatePanel.add(valToUpdateText);
        adminGameUpdatePanel.add(valToUpdateAdmin);
        adminGameUpdatePanel.add(updateGameButton);
        adminGameUpdatePanel.add(exitFromUpdateAdminButton);




        //main admin

        saveButton.setBounds(600,155,200,50);
        saveButton.setBackground(pink);
        saveButton.setBorder(border);
        saveButton.setFocusPainted(false);

        saveButton.addActionListener(e->{
            adminPanel.setVisible(false);
            adminGameSavePanel.setVisible(true);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(false);
        });

        updateButton.setBounds(350,155,200,50);
        updateButton.setBackground(pink);
        updateButton.setBorder(border);
        updateButton.setFocusPainted(false);

        updateButton.addActionListener(e->{
            adminPanel.setVisible(false);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(true);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(false);
        });

        deleteButton.setBounds(100,155,200,50);
        deleteButton.setBackground(pink);
        deleteButton.setBorder(border);
        deleteButton.setFocusPainted(false);

        deleteButton.addActionListener(e->{
            adminPanel.setVisible(false);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(true);
            homeScreenPanel.setVisible(false);
        });

        adminPanel.add(saveButton);
        adminPanel.add(updateButton);
        adminPanel.add(deleteButton);
        adminPanel.add(exitFromAdminButton);








        //------------------------------------User Side-----------------------------------------//
        //---------------------------------------------------------------------------------------//

        getGameText.setFont(new Font("Default", Font.ITALIC, 25 ));
        getGameText.setForeground(pink);
        getGameText.setBounds(65, 20, 400, 50);
        getGameText.setOpaque(false);
        getGameText.setEditable(false);

        getGameUser.setBounds(110,70,200,25);
        getGameUser.setBorder(border);


        getGameButton.setBounds(110,125,200,50);
        getGameButton.setBackground(pink);
        getGameButton.setBorder(border);
        getGameButton.setFocusPainted(false);

        gameTable.getTableHeader().setReorderingAllowed(false);
        gameTable.setAutoCreateColumnsFromModel(false);
        gameTable.getTableHeader().setResizingAllowed(false);
        gamePanel = new JScrollPane[]{new JScrollPane(gameTable)};


        exitFromUserButton.setBounds(834,0,50,20);
        exitFromUserButton.setBackground(pink);
        exitFromUserButton.setBorder(border);

        exitFromUserButton.addActionListener(e->{
            getGameText.setText("");
            adminPanel.setVisible(false);
            adminGameSavePanel.setVisible(false);
            adminGameUpdatePanel.setVisible(false);
            adminGameDeletePanel.setVisible(false);
            homeScreenPanel.setVisible(true);
        });

        userPanel.add(getGameText);
        userPanel.add(getGameUser);
        userPanel.add(getGameButton);
        userPanel.add(gameTable);
        userPanel.add(exitFromUserButton);


        //userPanel.add(UserBack);
        this.setVisible(true);

    }

    private static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect;
        char[] correctPassword = { '1', '2', '3', '4', '5' };

        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }

        //Zero out the password.
        Arrays.fill(correctPassword,'0');

        return isCorrect;
    }


}
