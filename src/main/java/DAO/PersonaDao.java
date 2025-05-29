package DAO;

import Controller.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {

    private Connection connection;

    public PersonaDao(ConnectionDB connectionDB) throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    public List<Persona> getPersonas() {
        List<Persona> personaList = new ArrayList<>();
        String sql = "SELECT Id, Nombre, Edad  FROM personas ";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Persona persona = new Persona();
                persona.setId(resultSet.getInt("Id"));
                persona.setNombre(resultSet.getString("Nombre"));
                persona.setEdad(resultSet.getInt("Edad"));
                personaList.add(persona);
            }

        } catch (SQLException e) {
            System.out.println("error from getPersonas method = " + e.getMessage());
        }
        return personaList;
    }

}
