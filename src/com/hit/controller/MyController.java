package com.hit.controller;

import com.hit.client.Game;
import com.hit.model.MyModel;
import com.hit.view.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyController implements ActionListener {

    View view;
    MyModel model;


    public MyController(View view, MyModel model) {
        this.view = view;
        this.model = model;

        this.view.saveGameButton.addActionListener(this);
        this.view.updateGameButton.addActionListener(this);
        this.view.deleteGameButton.addActionListener(this);
        this.view.getGameButton.addActionListener(this);
        this.view.comboBox.addActionListener(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame frame = this.view;

        //save game
        if (e.getSource() == view.saveGameButton) {

            List<String> input = new ArrayList<>();

            String name = view.nameGameAdmin.getText().replaceAll(" ","");
            String genre = view.genreGameAdmin.getText().replaceAll(" ","");
            String companyDevelop = view.gameCompanyDevelopAdmin.getText().replaceAll(" ","");
            String storeName = view.gameStoreNameAdmin.getText().replaceAll(" ","");
            String address = view.addressStoreAdmin.getText().replaceAll(" ","");
            input.add(name);
            input.add(genre);
            input.add(companyDevelop);
            input.add(storeName);
            input.add(address);

            if(!(specialCharList(input))){
                String response = model.saveGame(input);
                if (response.equals("1")) {
                    JOptionPane.showMessageDialog(frame, name + " Game was saved successfully");

                } else {
                    JOptionPane.showMessageDialog(frame, "Please try again");
                }
                clearAdminGameDetails();
            }
            else{
                JOptionPane.showMessageDialog(frame, "You can't save a game with special character, try again");
            }
        }

        //delete game
        if (e.getSource() == view.deleteGameButton) {

            String gameNameDelete = view.gameNameDeleteAdmin.getText().replaceAll(" ","");

            String response = model.deleteGame(gameNameDelete);

            if (response.equals("1")) {
                JOptionPane.showMessageDialog(frame, gameNameDelete + " Game was deleted successfully");

            } else {
                JOptionPane.showMessageDialog(frame, "No such game: " + gameNameDelete);
            }
            clearAdminGameDetails();
        }


        if(e.getSource() == view.comboBox){
            view.categoryToUpdateAdmin.setText((String) view.comboBox.getSelectedItem());

            List<String> enumKeys = new ArrayList<>();
            enumKeys.add("GameName");
            enumKeys.add("Genre");
            enumKeys.add("GameCompanyDevelop");
            enumKeys.add("GameStoreName");
            enumKeys.add("AddressStore");

            if(!(enumKeys.contains((String) view.comboBox.getSelectedItem()))){
                JOptionPane.showMessageDialog(frame, "Illegal category, please try again");
            }
        }

        if (e.getSource() == view.updateGameButton) {

            String gameName = view.nameUpdateAdmin.getText().replaceAll(" ","");
            String category = view.categoryToUpdateAdmin.getText().replaceAll(" ","");
            String val = view.valToUpdateAdmin.getText().replaceAll(" ","");

            List<String> input = new ArrayList<>();
            input.add(gameName);
            input.add(category);
            input.add(val);

            if(!(specialCharList(input))){
                String response = model.updateGame(input);

                if (response.equals("1")) {
                    JOptionPane.showMessageDialog(frame, "The " + category + " of the game has updated successfully");

                } else {
                    JOptionPane.showMessageDialog(frame, "Please try again");
                }
            }
            else{
                JOptionPane.showMessageDialog(frame, "You can't update a game with special character, try again");
            }
            clearAdminGameDetails();
        }


        //get game
        if (e.getSource() == view.getGameButton) {

            String search = view.getGameUser.getText().replaceAll(" ","");

            if(!specialChar(search)){
                List <Game> games = null;
                games = model.getGame(search);

                if (games.isEmpty())
                {
                    clearTable();
                    clearUserGameDetails();
                    JOptionPane.showMessageDialog(frame, "No games matches the search");
                }
                else
                {
                    setNewTable(games);
                    clearUserGameDetails();
                }
            }
        }
    }


    public void setNewTable(List<Game> games)
    {
        view.userPanel.remove(view.gamePanel[0]);
        view.dtm[0] = new DefaultTableModel(null, view.columns);
        for (Game g : games) {
            view.dtm[0].addRow(new Object[]{g.getGameName(), g.getGenre(),
                    g.getGameCompanyDevelop(), g.getGameStoreName(), g.getAddressStore()});
        }
        view.gameTable = new JTable(view.dtm[0]);
        view.gameTable.getTableHeader().setReorderingAllowed(false);
        view.gameTable.setAutoCreateColumnsFromModel(false);
        view.gameTable.getTableHeader().setResizingAllowed(false);
        view.gameTable.setEnabled(false);
        view.gamePanel[0] = new JScrollPane(view.gameTable);
        view.gamePanel[0].setBounds(100, 400, 700, 130);
        view.userPanel.add(view.gamePanel[0]);
    }

    public  void clearTable()
    {
        view.userPanel.remove(view.gamePanel[0]);
        view.dtm[0] = new DefaultTableModel(null, view.columns);
        view.gameTable = new JTable(view.dtm[0]);
        view.gameTable.getTableHeader().setReorderingAllowed(false);
        view.gameTable.setAutoCreateColumnsFromModel(false);
        view.gameTable.getTableHeader().setResizingAllowed(false);
        view.gameTable.setEnabled(false);
        view.gamePanel[0] = new JScrollPane(view.gameTable);
        view.gamePanel[0].setBounds(100, 400, 700, 130);
        view.userPanel.add(view.gamePanel[0]);
    }


    public void clearAdminGameDetails()
    {
        view.nameGameAdmin.setText("");
        view.genreGameAdmin.setText("");
        view.gameCompanyDevelopAdmin.setText("");
        view.gameStoreNameAdmin.setText("");
        view.addressStoreAdmin.setText("");
        view.gameNameDeleteAdmin.setText("");
        view.getGameUser.setText("");
    }

    public  void clearUserGameDetails()
    {
        view.getGameUser.setText("");
    }

    public boolean specialCharList(List<String> input){
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        for (String temp:input) {
            Matcher matcher = pattern.matcher(temp);
            boolean isStringContainsSpecialCharacter = matcher.find();
            if (isStringContainsSpecialCharacter)
                return true;
        }
        return false;
    }

    public boolean specialChar(String temp) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(temp);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if (isStringContainsSpecialCharacter)
            return true;
        else
            return false;
    }
}
