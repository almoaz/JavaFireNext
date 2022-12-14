/*
 MIT License
 Copyright (c) 2022 Mahfuz Salehin Moaz

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package FireNext.developer.table;

import static FireNext.developer.table.__init__.*;


import java.io.*;
import java.util.Scanner;

class __parent__update__
{
    public static void __parent__update__(String self, String child)
    {
        File file = new File(self+".ndb");
        if (file.exists())
        {
            String database = "";
            try {
                Scanner myReader = new Scanner(file);

                while (myReader.hasNextLine()) {

                    String data = myReader.nextLine();
                    database = database + data;
                }

                myReader.close();

            } catch (FileNotFoundException e) {

                e.printStackTrace();

            }
            String value = "";
            String updateDB = "";
            String child_update = "false";

            for (int x = 0; x <= database.length(); x++)
            {
                if (database.charAt(x) != start__tag && database.charAt(x) != child__end__tag && database.charAt(x) != end__tag)
                {
                    value = value + database.charAt(x);
                }
                if (database.charAt(x) == child__end__tag)
                {
                    if (child.equals(value))
                    {
                        child_update = "true";
                        if (updateDB.equals(""))
                        {
                            updateDB = value + child__end__tag;
                        }
                        else
                        {
                            updateDB = updateDB + value + child__end__tag;
                        }
                    }
                    else
                    {
                        if (updateDB.equals(""))
                        {
                            updateDB = value + child__end__tag;
                        }
                        else
                        {
                            updateDB = updateDB + value + child__end__tag;
                        }
                    }
                    value = "";
                }
                if (x == database.length() -1)
                {
                    if (!child.equals(value))
                    {
                        if (child_update.equals("false"))
                        {
                            updateDB = updateDB + value + child__end__tag + child;
                        }
                        else
                        {
                            updateDB = updateDB + value;
                        }
                    }
                    if (child.equals(value))
                    {
                        if (updateDB.equals(""))
                        {
                            updateDB = value;
                        }
                        else
                        {
                            updateDB = updateDB + value;
                        }
                    }
                    break;
                }
            }
            FileWriter file1 = null;
            try {
                file1 = new FileWriter(self+".ndb");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                file1.write(start__tag + updateDB + end__tag);
                file1.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            FileWriter file1 = null;
            try {
                file1 = new FileWriter(self+".ndb");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                file1.write(start__tag + child + end__tag);
                file1.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
