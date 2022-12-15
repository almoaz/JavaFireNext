package FireNext;

import FireNext.developer.doc.*;

import java.util.ArrayList;
import java.util.List;

public class NextDatabase {

    public static String add(String path)
    {
        /**
           print(NextDatabase.add_data("USER>001>name:Mahfuz Salehin Moaz|age:26|nationality:Bangladesh"))
           output :
           USER
               |---001
               |     |---name:Mahfuz Salehin Moaz
               |     |---age:26
               |     |---nationality:Bangladesh

           ---------------------------------------------
           USER
               |---001
               |     |---name:Mahfuz Salehin Moaz
               |     |---age:26
               |     |---nationality:Bangladesh
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------



           print(NextDatabase.add_data("USER>001>name:"))
           output :
           USER
               |---001
               |     |---name:

           ---------------------------------------------
           USER
               |---001
               |     |---name:
               |     |---age:26
               |     |---nationality:Bangladesh
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------
        */

        String check = __self__check__.__self__check__(path, "add");
        if (check.equals("child"))
        {
            return "value child not found";
        }
        if (check.equals("parent"))
        {
            return "parent not found";
        }
        if (check.equals("syntax"))
        {
            return "'error' "+path;
        }

        return __self__add__.__self__add__(check);
    }
    public static String read(String path)
    {
        /**
           print(NextDatabase.read("USER>001>name:"))
           output : Mahfuz Salehin Moaz


           print(NextDatabase.read("USER"))
           output:
           --------------------------------------------
           USER
               |---001
               |     |---name:Mahfuz Salehin Moaz
               |     |---age:26
               |     |---nationality:Bangladesh
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------

           print(NextDatabase.read("USER>001"))
           output:
           ---------------------------------
           001
             |---name:Mahfuz Salehin Moaz
             |---age:26
             |---nationality:Bangladesh
           ---------------------------------
        */
        String check = __self__check__.__self__check__(path, "child");
        if (check.equals("child"))
        {
            return "value child not found";
        }
        if (check.equals("syntax"))
        {
            return "'error' "+path;
        }
        return __self__read__.__self__read__(check);
    }

    public static String hasChild(String path)
    {
        /**
           print(NextDatabase.hasChild("USER>001>name:"))
           output : true

           ---------------------------------------------
           USER
               |---001
               |     |---name:Mahfuz Salehin Moaz
               |     |---age:26
               |     |---nationality:Bangladesh
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------
        */
        String check = __self__check__.__self__check__(path, "child");
        if (check.equals("child"))
        {
            return "value child not found";
        }
        if (check.equals("syntax"))
        {
            return "'error' "+path;
        }
        return __self__child__.__self__child__(check);
    }

    public static ArrayList query(String path) {
        /**
           child = NextDatabase.query("USER>name:")
           output : [001,002,003]

           for x in child:

             if NextDatabase.hasChild("USER>"+x">name:") == "true":
                print(NextDatabase.read_data("USER>"+x">name:"))

           output : Mahfuz Salehin Moaz
                    Mithila Nisa
                    Sharmin
           ---------------------------------------------
           USER
               |---001
               |     |---name:Mahfuz Salehin Moaz
               |     |---age:26
               |     |---nationality:Bangladesh
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------
        */
        ArrayList<String> returnValue = new ArrayList<>();
        String check = __self__check__.__self__check__(path, "query");
        if (check.equals("child"))
        {
            returnValue.add("value child not found");
            return returnValue;
        }
        if (check.equals("parent"))
        {
            returnValue.add("parent not found");
            return returnValue;
        }
        if (check.equals("syntax"))
        {
            returnValue.add("'error' "+path);
            return returnValue;
        }
        return __self__query__.__self__query__(check);
    }

    public static String delete(String path)
    {
        /**
           print(NextDatabase.read_data("USER>001>name:"))
           output:
           ---------------------------------------------
           USER
               |---001
               |     |---age:26
               |     |---nationality:Bangladesh
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------


           print(NextDatabase.read_data("USER>001))
           output:
           ---------------------------------------------
           USER
               |---002
               |     |---name:Mithila Nisa
               |     |---age:23
               |     |---nationality:Bangladesh
               |---003
               |     |---name:Sharmin
               |     |---age:22
               |     |---nationality:Bangladesh
           ----------------------------------------------
        */

        String check = __self__check__.__self__check__(path, "delete");
        if (check.equals("child"))
        {
            return "value child not found";
        }
        if (check.equals("syntax"))
        {
            return "'error' "+path;
        }

        return __self__delete__.__self__delete__(check);
    }

}
