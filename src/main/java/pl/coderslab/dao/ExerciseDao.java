package pl.coderslab.dao;

import pl.coderslab.model.Exercise;
import pl.coderslab.model.User;
import pl.coderslab.services.DBService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {
    public void delete(Exercise exercise){
        String query = "Delete from `exercises` where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(exercise.getId());

        try {
            DBService.executeQuery(query, params);
            exercise = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        Exercise exercise = getById(id);
        delete(exercise);
    }

    public void save(Exercise exercise){

        if(exercise.getId() == 0){
            addToDb(exercise);
        }else{
            updateInDb(exercise);
        }

    }


    public static Exercise getById(int id){
        String query = "Select `id`, `exercise_name` from `exercises` Where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        Exercise exercise = null;

        Exercise exercise1 = getSingleData(query, params);

        if (exercise1 != null) return exercise1;

        return null;
    }

    public static Exercise getByName(String name){
        String query = "Select `id`, `exercise_name` from `exercises` Where `exercise_name` = ?;";
        String[] params = new String[1];
        params[0] = name;

        Exercise exercise = getSingleData(query, params);

        if (exercise != null) return exercise;

        return null;
    }


    public static List<Exercise> loadAll(){
        String query = "Select `id`, `exercise_name`,`content`,`created`,`user_id` from `exercises`;";
        //prepare list for data from DB
        List<Exercise> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);

            for(String[] row : data){
                int id = Integer.parseInt(row[0]);
                String name = row[1];
                String content = row[2];
                String createdString = row[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate created = LocalDate.parse(createdString, formatter);
                int userId = Integer.parseInt(row[4]);
                User user = UserDao.getById(userId);

                Exercise exercise = new Exercise(id, name,content,created, user);

                result.add(exercise);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static void addToDb(Exercise exercise){

        String query = "Insert into `exercises` Values (?,?,?,?,?);";
        String[] params = new String[5];
        params[0] = String.valueOf(exercise.getId());
        params[1] = exercise.getName();
        params[2] = exercise.getContent();
        params[3] = String.valueOf(exercise.getCreated());
        params[4] = String.valueOf(exercise.getUser().getId());

        try {
            int newId = DBService.executeInsert(query, params);
            exercise.setId(newId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateInDb(Exercise exercise){

        String query = "Update `exercises` Set `exercise_name` = ? Where `id` = ?;";
        String[] params = new String[2];
        params[0] =exercise.getName();
        params[1] = String.valueOf(exercise.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Exercise getSingleData(String query, String[] params) {
        Exercise exercise;
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                String[] firstElement = data.get(0);
                int elementId = Integer.valueOf(firstElement[0]);
                String name = firstElement[1];
                //int userId = Integer.parseInt(firstElement[2]);

                exercise = new Exercise(elementId, name);
                return exercise;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
