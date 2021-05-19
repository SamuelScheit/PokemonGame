package com.pokemon.game;

import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.resources.Resource;
import de.gurkenlabs.litiengine.resources.Resources;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCommands {
    Connection con;

    public DbCommands() {
        con = DbConnection.connect();
    }

    public void insertPokemon(int Pokemon_ID, String Pokemon_Name, int HP, int Attack_1, int Attack_2, int Sprite_ID) {
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

    public ResultSet readTable(PreparedStatement ps) {
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

    public Pokemon getPokemon(String id) {
        try {
            String sql = "Select * from POKEMON where Pokemon_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = this.readRow(ps);
            if (rs == null) return null;

            String pokemonName = rs.getString("Pokemon_Name");
            byte[] spriteBinary = rs.getBytes("Sprite");
            Spritesheet spritesheet = new Spritesheet(ImageIO.read(new ByteArrayInputStream(spriteBinary)), pokemonName, 32, 32);

            Resources.spritesheets().add(pokemonName, spritesheet);

            Pokemon pokemon = new Pokemon(
                    rs.getInt("Pokemon_ID"),
                    pokemonName,
                    rs.getInt("HP"),
                    rs.getInt("Attack_1"),
                    rs.getInt("Attack_2"),
                    spritesheet
            );

            rs.close();

            return pokemon;
        } catch (SQLException | IOException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public ResultSet readRow(PreparedStatement ps) {
        try {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs;
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void updateSavegame() {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE SAVEGAME set Player_Pos_X = ? AND Player_Pos_Y = ? AND Map_Name = ? WHERE Game_ID = ?";
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

    public void updatePokemonCatch(int Pokemon_ID) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT into INVENTORY(Pokemon_ID) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(Pokemon_ID));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deletePokemon(String id) throws SQLException {
        String sql = "DELETE from POKEMON WHERE Pokemon_ID = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        this.deleteRow(ps);
    }

    public void deleteRow(PreparedStatement ps) {
        try {
            ps.execute();
            System.out.println("Data has been deleted");
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void getNumberOfPokemon() {
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

    public void insertAttack(int Attack_ID, String Attack_Name, int Attack_DMG) {
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO ATTACKS(Attack_ID, Attack_Name, Attack_DMG) VALUES(?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(Attack_ID));
            ps.setString(2, Attack_Name);
            ps.setString(3, String.valueOf(Attack_DMG));
            ps.execute();
            System.out.println("Data has been inserted");
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
