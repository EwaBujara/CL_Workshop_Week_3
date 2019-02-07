package pl.coderslab.dao;


import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.services.DBService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SolutionDao {

    public void delete(Solution solution){
        String query = "Delete from `solutions` where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(solution.getId());

        try {
            DBService.executeQuery(query, params);
            solution = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        Solution solution = getById(id);
        delete(solution);
    }

    public void save(Solution solution){

        if(solution.getId() == 0){
            addToDb(solution);
        }else{
            updateInDb(solution);
        }

    }


    public static Solution getById(int id){
        String query = "Select `id`, `exercise_id` from `solution` Where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        Solution solution = null;

        Solution solution1 = getSingleData(query, params);

        if (solution1 != null) return solution1;

        return null;
    }




    public static void addToDb(Solution solution){

        String query = "Insert into `solutions` Values (?,?,?,?,?);";
        String[] params = new String[5];
        params[0] = String.valueOf(solution.getId());
        params[1] = String.valueOf(solution.getUser().getId());
        params[2] = String.valueOf(solution.getExercise().getId());
        params[3] = solution.getContent();
        params[4] = String.valueOf(solution.getCreated());

        try {
            int newId = DBService.executeInsert(query, params);
            solution.setId(newId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Solution> loadAll(){
        String query = "Select `id`, `user_id`, `exercise_id`, `created` from `solutions` " +
                "order by `created`;";

        //prepare list for data from DB
        List<Solution> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);

            for(String[] row : data){
                int id = Integer.parseInt(row[0]);
                int userId = Integer.parseInt(row[1]);
                int exerciseId = Integer.parseInt(row[2]);
                String createdString = row[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate created = LocalDate.parse(createdString, formatter);
                String content = "";

                User user = UserDao.getById(userId);
                Exercise exercise = ExerciseDao.getById(exerciseId);

                Solution solution = new Solution(id, user, exercise, content, created);

                result.add(solution);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static List<Solution> loadAll(int limit){
        String query = "Select `id`, `user_id`, `exercise_id`,`content`, `created` from `solutions` " +
                "order by `created` DESC limit "+limit+";";

        //prepare list for data from DB
        List<Solution> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);

            for(String[] row : data){
                int id = Integer.parseInt(row[0]);
                int userId = Integer.parseInt(row[1]);
                int exerciseId = Integer.parseInt(row[2]);
                String content = row[3];
                String createdString = row[4];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate created = LocalDate.parse(createdString, formatter);

                User user = UserDao.getById(userId);
                Exercise exercise = ExerciseDao.getById(exerciseId);

                Solution solution = new Solution(id, user, exercise, content, created);

                result.add(solution);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void updateInDb(Solution solution){

        String query = "Update `solutions` Set `content` = ? Where `id` = ?;";
        String[] params = new String[2];
        params[0] =solution.getContent();
        params[1] = String.valueOf(solution.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Solution getSingleData(String query, String[] params) {
        Solution solution;
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                String[] firstElement = data.get(0);
                int elementId = Integer.valueOf(firstElement[0]);
                int user_id = Integer.valueOf(firstElement[1]);
                int exercise_id = Integer.valueOf(firstElement[2]);

                User user = UserDao.getById(user_id);
                Exercise exercise = ExerciseDao.getById(exercise_id);

                solution = new Solution(elementId, user, exercise);
                return solution;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
