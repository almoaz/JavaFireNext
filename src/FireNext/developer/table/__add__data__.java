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


public class __add__data__ {
    public static String __add__data__(String Table_Name, String Data) {
        String table = __file__read__.__file__read__(Table_Name);
        if (table.equals("false")) {
            return "'error' " + '[' + Table_Name + ']' + " table not found";
        }
        if (table.length() < 4) {
            return "'error' column name not found\nbefore add data we need to add column name";
        } else {
            String value = "";
            for (int x = 0; x <= Data.length(); x++) {
                if (Data.charAt(x) == '|') {
                    value = value + cel__end__tag;
                } else {
                    value = value + Data.charAt(x);
                }
                if (x == Data.length() - 1) {
                    break;
                }

            }
            __table__append__.__table__append__(Table_Name, row__start__tag + value + row__end__tag);
            return "true";
        }

    }
}
