package az.task.etaskifyms.util;
public class Util {
    public static String formatNameSurname(String name,String surname){
        return name != null && surname != null ? name.toLowerCase() + " " + surname.toLowerCase() : " ";
    }
}

