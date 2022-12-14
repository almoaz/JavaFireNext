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

public class __read__table__ {
    public static String __read__table__(String Table_Name) {
        String value = "";
        String value2 = "";
        String table_data = "";
        String table = __file__read__.__file__read__(Table_Name);
        if (table.equals("false")) {
            return "'error' " + '[' + Table_Name + ']' + " table not found";
        }
        if (table.length() > 0) {

            int Cell_Size = 0;
            for (int x = 0; x <= table.length(); x++) {
                if (table.charAt(x) != cel__end__tag && table.charAt(x) != col__start__tag && table.charAt(x) != col__end__tag && table.charAt(x) != row__start__tag && table.charAt(x) != row__end__tag) {
                    value = value + table.charAt(x);
                } else if (table.charAt(x) == cel__end__tag) {
                    if (value.length() > Cell_Size) {
                        Cell_Size = value.length();
                        value = "";
                    }

                } else if (table.charAt(x) == col__end__tag || table.charAt(x) == row__end__tag) {
                    if (value.length() > Cell_Size) {
                        Cell_Size = value.length();
                    }
                    value = "";
                }
                if (x == table.length() - 1) {
                    break;
                }
            }
            for (int x1 = 0; x1 <= table.length(); x1++) {
                if (table.charAt(x1) != cel__end__tag && table.charAt(x1) != col__start__tag && table.charAt(x1) != col__end__tag && table.charAt(x1) != row__start__tag && table.charAt(x1) != row__end__tag) {
                    value = value + table.charAt(x1);
                } else if (table.charAt(x1) == col__start__tag && !value2.equals("") || table.charAt(x1) == row__start__tag && !value2.equals("")) {
                    table_data = table_data + value2 + "\n";
                    table_data = table_data + repeat(value2.length(), "-") + "\n";
                    value2 = "";
                } else if (table.charAt(x1) == cel__end__tag) {

                    int value1 = Cell_Size - value.length();
                    value2 = value2 + value + repeat(value1 + 3, " ");
                    value = "";
                } else if (table.charAt(x1) == col__end__tag || table.charAt(x1) == row__end__tag) {

                    int value1 = Cell_Size - value.length();
                    value2 = value2 + value + repeat(value1 + 3, " ");
                    value = "";
                }
                if (x1 == table.length() - 1) {
                    table_data = table_data + value2 + "\n";
                    return table_data;
                }


            }
        }
        return table_data;
    }
}
