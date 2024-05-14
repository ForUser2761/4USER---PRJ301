
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class Manage {
    public static List<Train> list = new ArrayList<>();

    public Manage() {
    }

    public static List<Train> getList() {
        return list;
    }

    public static void setList(List<Train> list) {
        Manage.list = list;
    }
    
    
    
}
