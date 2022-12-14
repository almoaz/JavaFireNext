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

public class __search__row__data__ {
    public static List<Object> __search__row__data__(String Table_Name, String Search_Id) {
        String table = __file__read__.__file__read__(Table_Name);
        List<Object> returnValue = new ArrayList<>();
        if (table.equals("false")) {
            returnValue.add("'error' " + '[' + Table_Name + ']' + " table not found");
            return returnValue;
        } else {
            String queryPermit = "false";
            String value = "";
            String col_name = "";
            for (int x = 0; x <= table.length(); x++) {
                if (queryPermit.equals("false")) {
                    col_name = col_name + table.charAt(x);
                }
                if (table.charAt(x) == col__end__tag && queryPermit.equals("false")) {
                    queryPermit = "true";
                } else if (queryPermit.equals("true")) {
                    value = value + table.charAt(x);
                    if (table.charAt(x) == row__end__tag) {
                        String data = "";
                        for (int x1 = 0; x1 <= value.length(); x1++) {
                            if (value.charAt(x1) != row__start__tag && value.charAt(x1) != cel__end__tag && value.charAt(x1) != row__end__tag) {
                                data = data + value.charAt(x1);

                            } else if (value.charAt(x1) == cel__end__tag) {
                                if (data.equals(Search_Id)) {

                                    col_name =  value;
                                    value = "";
                                    List<Object> value2 = new ArrayList<>();
                                    for (int x2 = 0; x2 <= col_name.length(); x2++) {
                                        if (col_name.charAt(x2) != cel__end__tag && col_name.charAt(x2) != col__start__tag && col_name.charAt(x2) != col__end__tag && col_name.charAt(x2) != row__start__tag && col_name.charAt(x2) != row__end__tag) {
                                            value = value + col_name.charAt(x2);
                                        } else if (col_name.charAt(x2) == cel__end__tag) {
                                            value2.add(value);
                                            value = "";
                                        } else if (col_name.charAt(x2) == col__end__tag || col_name.charAt(x2) == row__end__tag) {

                                            value2.add(value);
                                            value = "";
                                        }
                                        if (x2 == col_name.length() - 1) {
                                            returnValue = value2;
                                            return returnValue;
                                        }

                                    }
                                    break;
                                } else {
                                    data = "";
                                }


                            } else if (value.charAt(x1) == row__end__tag) {
                                if (data.equals(Search_Id)) {

                                    col_name =  value;
                                    value = "";
                                    List<Object> value2 = new ArrayList<>();
                                    for (int x2 = 0; x2 <= col_name.length(); x2++) {
                                        if (col_name.charAt(x2) != cel__end__tag && col_name.charAt(x2) != col__start__tag && col_name.charAt(x2) != col__end__tag && col_name.charAt(x2) != row__start__tag && col_name.charAt(x2) != row__end__tag) {
                                            value = value + col_name.charAt(x2);
                                        } else if (col_name.charAt(x2) == cel__end__tag) {
                                            value2.add(value);
                                            value = "";
                                        } else if (col_name.charAt(x2) == col__end__tag || col_name.charAt(x2) == row__end__tag) {
                                            value2.add(value);
                                            value = "";
                                        }
                                        if (x2 == col_name.length() - 1) {
                                            returnValue = value2;
                                            return returnValue;
                                        }
                                    }
                                    break;
                                }
                            }
                            if (x1 == value.length() - 1) {
                                break;
                            }
                        }
                        if (x == table.length() - 1) {
                            returnValue.add("'error' [Search id : " + Search_Id + "] not found");
                            return returnValue;
                        }
                        value = "";
                    }
                }
            }
        }
        return returnValue;
    }
}
