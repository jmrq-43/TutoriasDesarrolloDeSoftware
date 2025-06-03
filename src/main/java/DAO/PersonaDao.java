package DAO;

import Domain.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {

    private Connection connection;

    public PersonaDao(ConnectionDB connectionDB) throws SQLException {
        this.connection = ConnectionDB.getConnection();
    }

    //TODO: READ METHOD
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

    //TODO: CREATE PERSONA METHOD
    public void createPersona(Persona persona) throws SQLException {
        String sql = "INSERT INTO personas (Nombre, Edad) VALUES (?,?) ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, persona.getNombre());
            statement.setInt(2, persona.getEdad());
            statement.executeUpdate();
        }
    }

    //TODO: UPDATE PERSONA METHOD
    public void updatePersona(Persona persona) throws SQLException {
        String sql = "UPDATE personas SET Nombre = ?, Edad = ? WHERE ID = ? ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, persona.getNombre());
            statement.setInt(2, persona.getEdad());
            statement.setInt(3, persona.getId());
            statement.executeUpdate();
        }
    }

    //TODO: DELETE PERSONA METHOD
    public void deletePersona(Persona persona) throws SQLException {
        String sql = "DELETE FROM personas WHRE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, persona.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("la persona con el Id " + persona.getId() +
                        ">>" + persona.getNombre() + " fue eliminada");
            } else {
                System.out.println("no se encontro ninguna persona con el id " + persona.getId());
            }
        }
    }

}
