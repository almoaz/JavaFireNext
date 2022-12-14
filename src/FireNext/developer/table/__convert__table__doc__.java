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

import FireNext.NextDatabase;

import static FireNext.developer.table.__init__.*;


import java.util.List;

public class __convert__table__doc__ {
    public static String __convert__table__doc__(String self, String Column_Name) {
        List<Object> value_child = __read__col__name__.__read__col__name__(self);
        List<Object> child_id = __search__col__data__.__search__col__data__(self, Column_Name);
        String child = "";

        for (int x = 0; x <= child_id.size(); x++) {
            for (int x1 = 0; x1 <= value_child.size(); x1++) {
                String value = __search__data__.__search__data__(self, (String) child_id.get(x), (String) value_child.get(x1));
                value = (String) value_child.get(x1) + value__child__tag + value;
                if (child.equals("")) {
                    child = value;
                } else {
                    child = child + devided__tag + value;
                }
                if (x1 == value_child.size() - 1) {
                    break;
                }

            }
            if (!child.equals("")) {
                NextDatabase.add(child_id.get(x) + ">" + child);
                __parent__update__.__parent__update__(self, (String) child_id.get(x));
            }
            if (x == child_id.size() - 1) {
                break;
            }
            child = "";
        }
        return "true";
    }
}
