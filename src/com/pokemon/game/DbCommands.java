package com.pokemon.game;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCommands {
    Connection con;

    public DbCommands() {
        con = DbConnection.connect();
    }

    private void insert(int Pokemon_ID, String Pokemon_Name, int HP, int Attack_1, int Attack_2, int Sprite_ID) {
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO POKEMON(Pokemon_ID, Pokemon_Name, HP, Attack_1, Attack_2, Sprite_ID) VALUES(?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(Pokemon_ID));
            ps.setString(2, Pokemon_Name);
            ps.setString(3, String.valueOf(HP));
            ps.setString(4, String.valueOf(Attack_1));
            ps.setString(5, String.valueOf(Attack_2));
            ps.setString(6, String.valueOf(Sprite_ID));
            ps.execute();
            System.out.println("Data has been inserted");
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private void readTable() {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM POKEMON";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String Pokemon_ID = rs.getString("Pokemon_ID");
                String Pokemon_Name = rs.getString("Pokemon_Name");
                String HP = rs.getString("HP");
                String Attack_1 = rs.getString("Attack_1");
                String Attack_2 = rs.getString("Attack_2");
                String Sprite_ID = rs.getString("Sprite_ID");

                System.out.println("All Pokemon have been exported");
                System.out.println("Pokemon_ID: " + Pokemon_ID);
                System.out.println("Pokemon_Name: " + Pokemon_Name);
                System.out.println("HP: " + HP);
                System.out.println("Attack_1: " + Attack_1);
                System.out.println("Attack_2: " + Attack_2);
                System.out.println("Sprite_ID: " + Sprite_ID);
            }

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public Pokemon getPokemon(String id) {
        try {
            String sql = "Select Pokemon_Name from POKEMON where Pokemon_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = this.readRow(ps);
            if (rs == null) return null;

            Pokemon pokemon = new Pokemon(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("HP"),
                    rs.getInt("attack1"),
                    rs.getInt("attack2")
            );

            return pokemon;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public ResultSet readRow(PreparedStatement ps) {
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rs.close();
                return rs;
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private void updateSavegame() {
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE SPIELSTAENDE set Player_Pos_X = ? AND Player_Pos_Y = ? AND Map_Name = ? WHERE Game_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.execute();
            System.out.println("Data has been updated");
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public void deletePokemon(String id) throws SQLException {
        String sql = "DELETE from POKEMON WHERE Pokemon_ID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        this.deleteRow(ps);
    }

    private void deleteRow(PreparedStatement ps) {
        try {
            ps.execute();
            System.out.println("Data has been deleted");
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void getNumberOfPokemon() {
        Connection con = DbConnection.connect();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "Select count(Pokemon_ID) from POKEMON";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int size = rs.getInt(1);
            System.out.println("You have " + size + " Pokemon");

            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
