package dao;

import Domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao {

    private static Connection connection = new ConnectionDB().getConnection();

    //TODO: READ METHOD
    public List<Person> getPersons() {
        List<Person> personList = new ArrayList<>();
        String sql = "SELECT Id, Nombre, Edad  FROM personas ";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("Id"));
                person.setNombre(resultSet.getString("Nombre"));
                person.setEdad(resultSet.getInt("Edad"));
                personList.add(person);
            }

        } catch (SQLException e) {
            System.out.println("error from getPersonas method = " + e.getMessage());
        }
        return personList;
    }

    //TODO: CREATE PERSONA METHOD
    public void createPersons(Person person) throws SQLException {
        String sql = "INSERT INTO personas (Nombre, Edad) VALUES (?,?) ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, person.getNombre());
            statement.setInt(2, person.getEdad());
            statement.executeUpdate();
        }
    }

    //TODO: UPDATE PERSONA METHOD
    public void updatePersons(Person person) throws SQLException {
        String sql = "UPDATE personas SET Nombre = ?, Edad = ? WHERE ID = ? ";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, person.getNombre());
            statement.setInt(2, person.getEdad());
            statement.setInt(3, person.getId());
            statement.executeUpdate();
        }
    }

    //TODO: DELETE PERSONA METHOD
    public void deletePersons(Person person) throws SQLException {
        String sql = "DELETE FROM personas WHERE  id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, person.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("la persona con el Id " + person.getId() +
                        ">>" + person.getNombre() + " fue eliminada");
            } else {
                System.out.println("no se encontro ninguna persona con el id " + person.getId());
            }
        }
    }

}
