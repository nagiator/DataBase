package ru.sapteh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class Main {


    public static void main(String[] args) throws IOException , ClassNotFoundException {
            DataBaseConnection dataBase = new DataBaseConnection();
            Connection connection = dataBase.getConnection();
            String sqlSelect = "SELECT * FROM " + Students.TABLE_NAME;
            List<Students> list = new ArrayList<>();
            try {
                PreparedStatement statement = connection.prepareStatement(sqlSelect);
                ResultSet resultSet = statement.executeQuery();
                Students students = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(Students.ID_COLUMN);
                    String firstname = resultSet.getString(Students.FIRSTNAME_COLUMN);
                    String middelName = resultSet.getString(Students.MIDDLENAME_COLUMN);
                    String lastName = resultSet.getString(Students.LASTNAME_COLUMN);
                    String birtDay = resultSet.getString(Students.BIRTDAY_COLUMN);
                    String specialnost = resultSet.getString(Students.SPECIALNOST_COLUMN);
                    String course = resultSet.getString(Students.COURSE_COLUMN);
                    String grups = resultSet.getString(Students.GRUPS_COLUMN);

                    students = new Students(id, firstname, middelName, lastName, birtDay, specialnost, course, grups);
                    list.add(students);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите -с, -d или -u");
            String crud = scanner.nextLine();


            if(crud.equals("-c")) {
                System.out.println("Введите имя студента");
                String firstName= scanner.nextLine();
                System.out.println("Введите отчество");
                String middlName = scanner.nextLine();
                System.out.println("Введите фамилию");
                String lastName = scanner.nextLine();
                System.out.println("Введите дата рождения");
                String birtDay = scanner.nextLine();
                System.out.println("Введите специальность");
                String specialnost = scanner.nextLine();
                System.out.println("Введите курс");
                String course = scanner.nextLine();
                System.out.println("Введите группу");
                String grups = scanner.nextLine();
//                Students students = new Students(list.size()+1,firstName, lastName, middlName, specialnost, course,  );
                String sqlInsert = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES(?,?,?,?,?,?,?)",
                        Students.TABLE_NAME,
                        Students.FIRSTNAME_COLUMN,
                        Students.MIDDLENAME_COLUMN,
                        Students.LASTNAME_COLUMN,
                        Students.BIRTDAY_COLUMN,
                        Students.SPECIALNOST_COLUMN,
                        Students.COURSE_COLUMN,
                        Students.GRUPS_COLUMN);
                try {
                    PreparedStatement statement = connection.prepareStatement(sqlInsert);
                    statement.setString(1, firstName);
                    statement.setString(3, middlName);
                    statement.setString(2, lastName);
                    statement.setString(7, birtDay);
                    statement.setString(4, specialnost);
                    statement.setString(5, course);
                    statement.setString(6, grups);


                    statement.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (crud.equals("-d")) {

                System.out.println("Введите id записи");
                int id = Integer.parseInt(scanner.nextLine());
                try {
                    String sqlDelete = String.format("DELETE FROM %s WHERE %s=?", Students.TABLE_NAME, Students.ID_COLUMN);
                    PreparedStatement statement = connection.prepareStatement(sqlDelete);
                    statement.setInt(1,id);
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (crud.equals("-u")) {

                System.out.println("Введите id студента");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите имя студента");
                String firstname = scanner.nextLine();
                System.out.println("Введите фамилию");
                String middleName = scanner.nextLine();
                System.out.println("Введите отчество");
                String lastname = scanner.nextLine();
                System.out.println("Введите специальность");
                String specialnost= scanner.nextLine();
                System.out.println("Введите дату рождения");
                String birtDay = scanner.nextLine();
                System.out.println("Введите группу");
                String grups = scanner.nextLine();

                String profession = scanner.nextLine();
                System.out.println("Введите курс");
                String course = scanner.nextLine();
                try {
                    String sqlUpdate = String.format("UPDATE %s SET %s=?, %s=?, %s=?, %s=?, %s=? WHERE %s=?",
                            Students.TABLE_NAME,Students.LASTNAME_COLUMN,
                            Students.FIRSTNAME_COLUMN,Students.LASTNAME_COLUMN,
                            Students.SPECIALNOST_COLUMN,Students.COURSE_COLUMN,
                            Students.ID_COLUMN);
                    PreparedStatement statement = connection.prepareStatement(sqlUpdate);
                    statement.setInt(1,id);
                    statement.setString(2,firstname);
                    statement.setString(3, middleName);
                    statement.setString(4,lastname);
                    statement.setString(5, birtDay);
                    statement.setString(6,specialnost);
                    statement.setString(7,course);
                    statement.setString(8, grups);
                    statement.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


