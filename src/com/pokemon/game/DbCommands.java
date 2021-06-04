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
import java.util.ArrayList;

public class DbCommands {
    Connection con;


    public DbCommands() {
        con = DbConnection.connect();
    }

    public static void main(String[] args) {
        DbCommands db = new DbCommands();
       /* db.getInventory();
        ArrayList <Pokemon> Inventory = db.getInventory();

        for (Pokemon pokemon:Inventory){
            System.out.println(pokemon.name + pokemon.HP + pokemon.);
        }*/
        db.getAttack(1);
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
            String sql = "SELECT * FROM POKEMON WHERE Pokemon_ID = ?";
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
                    this.getAttack(rs.getInt("Attack_1")),
                    this.getAttack(rs.getInt("Attack_2")),
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

    public void updatePokemonCatch(int Pokemon_ID) {
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO INVENTORY(Pokemon_ID) VALUES (?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(Pokemon_ID));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void deletePokemon(String id) throws SQLException {
        String sql = "DELETE * FROM POKEMON WHERE Pokemon_ID = ?";
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
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT COUNT(Pokemon_ID) FROM POKEMON";
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

    public Attack getAttack(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT Attack_Name, Attack_DMG, Sprite FROM ATTACKS WHERE Attack_ID = ?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Spritesheet spritesheet = null;

            String attackName = rs.getString("Attack_Name");
            int attackDMG = rs.getInt("Attack_DMG");
            try {
                byte[] spriteBinary = rs.getBytes("Sprite");
                spritesheet = new Spritesheet(ImageIO.read(new ByteArrayInputStream(spriteBinary)), attackName, 32, 32);
                Resources.spritesheets().add(attackName, spritesheet);
                System.out.println(spritesheet);
            } catch (Exception e) {
            }

            ps.close();
            rs.close();

            System.out.println(attackName);
            System.out.println(attackDMG);
            return new Attack(id, attackName, attackDMG, spritesheet);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void updateHP(int pokemonID, int HP) {
        try {
            String sql = "UPDATE POKEMON SET HP = ? WHERE Pokemon_ID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(HP));
            ps.setString(2, String.valueOf(pokemonID));
            ps.execute();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void insertIntoInventory(int pokemonID) {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE INVENTORY set Unlocked = ? where Pokemon_ID = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "1");
            ps.setString(2, String.valueOf(pokemonID));
            System.out.println("Your new Pokemon is saved in your Inventory");

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    public ArrayList<Pokemon> getInventory() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Pokemon> ownedPokemon = new ArrayList<Pokemon>();
        try {
            String sql = "SELECT Pokemon_ID FROM INVENTORY WHERE Unlocked = 1";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String pokemonID = rs.getString("Pokemon_ID");
                ownedPokemon.add(this.getPokemon(pokemonID));
            }
            ps.close();
            return ownedPokemon;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
