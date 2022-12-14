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

import java.util.ArrayList;
import java.util.List;

public class __read__col__name__ {
    public static List<Object> __read__col__name__(String Table_Name) {
        List<Object> returnValue = new ArrayList<>();
        String table = __file__read__.__file__read__(Table_Name);
        if (table.equals("false")) {
            returnValue.add("'error' " + '[' + Table_Name + ']' + " table not found");
            return returnValue;
        } else {
            String value = "";
            String value2 = "";

            for (int x = 0; x <= table.length(); x++) {
                if (table.charAt(x) != cel__end__tag && table.charAt(x) != col__start__tag && table.charAt(x) != col__end__tag) {
                    value = value + table.charAt(x);
                } else if (table.charAt(x) == cel__end__tag) {
                    returnValue.add(value);
                    value = "";
                } else if (table.charAt(x) == col__end__tag) {
                    returnValue.add(value);
                    return returnValue;
                }

            }
        }
        return returnValue;
    }
}
