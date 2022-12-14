package FireNext;

import FireNext.developer.doc.*;

import java.util.ArrayList;

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
        return __self__add__.__self__add__(path);
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
        return __self__read__.__self__read__(path);
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
        return __self__child__.__self__child__(path);
    }

    public static ArrayList query(String path)
    {
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
        return __self__query__.__self__query__(path);
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


        return __self__delete__.__self__delete__(path);
    }

}
