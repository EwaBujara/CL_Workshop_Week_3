package pl.coderslab.dao;

import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;
import pl.coderslab.services.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void delete(User user){
        String query = "Delete from `users` where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(user.getId());

        try {
            DBService.executeQuery(query, params);
            user = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        User user = getById(id);
        delete(user);
    }

    public void save(User user){

        if(user.getId() == 0){
            addToDb(user);
        }else{
            updateInDb(user);
        }

    }


    public static User getById(int id){
        String query = "Select `id`, `username`, `email`, `password`,`user_group_id` from `users` Where `id` = ?;";
        String[] params = new String[1];
        params[0] = String.valueOf(id);

        User user = getSingleData(query, params);

        if (user != null) return user;

        return null;
    }

    public static User getByName(String name){
        String query = "Select `id`,`username`, `email`, `password`, `user_group_id` from `users` Where `username` = ?;";
        String[] params = new String[1];
        params[0] = name;

        User user = getSingleData(query, params);

        if (user != null) return user;

        return null;
    }


    public static List<User> loadAll(String groupId){
        String query = "Select `id`, `username` from `users` where user_group_id="+groupId+";";
        //prepare list for data from DB
        List<User> result = new ArrayList<>();

        try {
            List<String[]> data = DBService.getData(query, null);

            for(String[] row : data){
                int id = Integer.parseInt(row[0]);
                String name = row[1];


                User user = new User(id, name);

                result.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    public static void addToDb(User user){

        String query = "Insert into `users` Values (?,?,?,?,?);";
        String[] params = new String[5];
        params[0] = String.valueOf(user.getId());
        params[1] =user.getUsername();
        params[2] = user.getEmail();
        params[3] = user.getPassword();
        params[4] = String.valueOf(user.getUserGroup().getId());

        try {
            int newId = DBService.executeInsert(query, params);
            user.setId(newId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateInDb(User user){

        String query = "Update `users` Set `username` = ? Where `id` = ?;";
        String[] params = new String[2];
        params[0] =user.getUsername();
        params[1] = String.valueOf(user.getId());

        try {
            DBService.executeQuery(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static User getSingleData(String query, String[] params) {
        User user;
        try {
            List<String[]> data = DBService.getData(query, params);
            if (data.size() > 0) {
                String[] firstElement = data.get(0);
                int userId = Integer.parseInt(firstElement[0]);
                String userName = firstElement[1];
                String email = firstElement[2];
                String password = firstElement[3];
                int userGroupId = Integer.parseInt(firstElement[4]);

                UserGroup userGroup = UserGroupDao.getById(userGroupId);
                user = new User(userId, userName, password, email, userGroup);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
