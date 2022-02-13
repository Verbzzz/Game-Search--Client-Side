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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JFrame frame = this.view;

        if (e.getSource() == view.saveGameButton) {

            List<String> input = new ArrayList<>();

            String name = view.nameGameAdmin.getText();
            String genre = view.genreGameAdmin.getText();
            String companyDevelop = view.gameCompanyDevelopAdmin.getText();
            String storeName = view.gameStoreNameAdmin.getText();
            String address = view.addressStoreAdmin.getText();
            input.add(name);
            input.add(genre);
            input.add(companyDevelop);
            input.add(storeName);
            input.add(address);

            String response = model.saveGame(input);

            if (response.equals("Game saved")) {
                JOptionPane.showMessageDialog(frame, name + " Game was saved successfully");

            } else {
                JOptionPane.showMessageDialog(frame, "ERROR");

            }
            clearAdminGameDetails();
        } else {
            clearAdminGameDetails();
            JOptionPane.showMessageDialog(frame, "Fields cannot be empty or contain whitespaces.");
        }

        if (e.getSource() == view.deleteGameButton) {

            String gameNameDelete = view.gameNameDeleteAdmin.getText();

            if (legalString(gameNameDelete)) {

                String response = model.deleteGame(gameNameDelete);

                if (response.equals("Game deleted")) {
                    JOptionPane.showMessageDialog(frame, gameNameDelete + " Game was deleted successfully");

                } else {
                    JOptionPane.showMessageDialog(frame, "No such game: " + gameNameDelete);

                }
                clearAdminGameDetails();
            } else {
                clearAdminGameDetails();
                JOptionPane.showMessageDialog(frame, "Fields cannot be empty or contain whitespaces.");
            }

        }

        if (e.getSource() == view.updateGameButton) {

            String gameName = view.nameUpdateAdmin.getText();
            String category = view.categoryToUpdateAdmin.getText();
            String val = view.valToUpdateAdmin.getText();

            if (legalString(gameName)) {

                List<String> input = new ArrayList<>();
                input.add(gameName);
                input.add(category);
                input.add(val);

                String response = model.updateGame(input);

                if (response.equals("Game updated")) {
                    JOptionPane.showMessageDialog(frame, "The" + category + " of the game has updated successfully");

                } else {
                    JOptionPane.showMessageDialog(frame, "No such game: " + gameName);

                }
                clearAdminGameDetails();
            } else {
                clearAdminGameDetails();
                JOptionPane.showMessageDialog(frame, "Fields cannot be empty or contain whitespaces.");
            }

        }

        if (e.getSource() == view.getGameButton) {

            String searchRestName = view.getGameUser.getText();

            List <Game> games = null;
            games = model.getGame(searchRestName);

            if (games == null)
            {
                clearTable();
                clearUserGameDetails();
                JOptionPane.showMessageDialog(frame, "We have some error with server, please try again");
            }
            else
            {
                setNewTable(games);
                clearUserGameDetails();
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

    public boolean legalStrings (List < String > details)
    {
        for (String s : details) {
            if (s.equals("") || s.contains(" ")) {
                return false;
            }
        }

        return true;
    }

    public boolean legalString(String details)
    {
        return !details.equals("") && !details.contains(" ");
    }


}
