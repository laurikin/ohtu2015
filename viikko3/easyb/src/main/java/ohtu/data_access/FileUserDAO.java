/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.data_access;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

/**
 *
 * @author laurikin
 */
public class FileUserDAO implements UserDao {

    private final String filename;

    public FileUserDAO(String filename) {
        this.filename = filename;
    }

    @Override
    public List<User> listAll() {
        List<User> users = new ArrayList<User>();
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String[] user = sc.nextLine().split(",");
                users.add(new User(user[0], user[1]));
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }

        return users;
    }

    @Override
    public User findByName(String name) {
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String[] user = sc.nextLine().split(",");
                if (user[0].equals(name));
                return new User(user[0], user[1]);
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }

    @Override
    public void add(User user) {
        try {
            FileWriter fw = new FileWriter(filename,true);
            fw.write("" + user.getUsername() + "," + user.getPassword());
            fw.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            System.exit(1);
        }
    }
    
}
