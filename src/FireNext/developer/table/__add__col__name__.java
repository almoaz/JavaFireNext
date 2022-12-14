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

public class __add__col__name__ {
    public static String __add__col__name__(String Table_Name, String Column_Name) {
        String table = __file__read__.__file__read__(Table_Name);
        if (table.equals("false")) {
            return "'" + Table_Name + "' table not found";
        } else {
            if (table.length() == 0) {
                String value = "";
                for (int x = 0; x <= Column_Name.length(); x++) {
                    if (Column_Name.charAt(x) == '|') {
                        value = value + cel__end__tag;
                    } else {
                        value = value + Column_Name.charAt(x);

                    }
                    if (x == Column_Name.length() - 1) {
                        break;
                    }
                }
                System.out.println(value);
                value = col__start__tag + value + col__end__tag;
                __table__writer__.__table__writer__(Table_Name, value);
                return "true";


            } else {
                String queryPermit = "false";
                String duplicateCondition = "false";
                String duplicateColumnName = "";
                String value = "";
                String updateDB = "";

                for (int x = 0; x <= table.length(); x++) {
                    if (table.charAt(x) != col__end__tag && queryPermit.equals("false")) {
                        updateDB = updateDB + table.charAt(x);
                    }
                    if (table.charAt(x) != col__start__tag && table.charAt(x) != cel__end__tag && table.charAt(x) != col__end__tag && queryPermit.equals("false")) {
                        value = value + table.charAt(x);
                    } else if (table.charAt(x) == cel__end__tag && queryPermit.equals("false")) {
                        String value1 = "";
                        for (int x1 = 0; x1 <= Column_Name.length(); x1++) {
                            if (Column_Name.charAt(x1) != devided__tag) {
                                value1 = value1 + Column_Name.charAt(x1);
                            } else if (Column_Name.charAt(x1) == devided__tag) {
                                if (value.equals(value1)) {
                                    duplicateCondition = "true";
                                    if (duplicateColumnName.equals("")) {
                                        duplicateColumnName = value1;
                                    } else {
                                        duplicateColumnName = duplicateColumnName + cel__end__tag + value1;
                                    }
                                    break;
                                } else {
                                    value1 = "";
                                }
                            }
                            if (x1 == Column_Name.length() - 1) {
                                if (value.equals(value1)) {
                                    duplicateCondition = "true";
                                    if (duplicateColumnName.equals("")) {
                                        duplicateColumnName = value1;
                                    } else {
                                        duplicateColumnName = duplicateColumnName + cel__end__tag + value1;
                                    }
                                    break;
                                }
                                break;

                            }
                        }
                        value = "";
                    } else if (table.charAt(x) == col__end__tag && queryPermit.equals("false")) {
                        String value1 = "";
                        for (int x1 = 0; x1 <= Column_Name.length(); x1++) {
                            if (Column_Name.charAt(x1) != devided__tag) {
                                value1 = value1 + Column_Name.charAt(x1);
                            } else if (Column_Name.charAt(x1) == devided__tag) {
                                if (value.equals(value1)) {
                                    duplicateCondition = "true";
                                    if (duplicateColumnName.equals("")) {
                                        duplicateColumnName = value1;
                                    } else {
                                        duplicateColumnName = duplicateColumnName + cel__end__tag + value1;
                                    }
                                    break;
                                } else {
                                    value1 = "";
                                }
                            }
                            if (x1 == Column_Name.length() - 1) {
                                if (value.equals(value1)) {
                                    duplicateCondition = "true";
                                    if (duplicateColumnName.equals("")) {
                                        duplicateColumnName = value1;
                                    } else {
                                        duplicateColumnName = duplicateColumnName + cel__end__tag + value1;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                    }
                    if (table.charAt(x) == col__end__tag && queryPermit.equals("false")) {
                        updateDB = updateDB + cel__end__tag + Column_Name + col__end__tag;
                        queryPermit = "true";
                    } else if (queryPermit.equals("true")) {
                        updateDB = updateDB + table.charAt(x);
                    }
                    if (x == table.length() - 1) {

                        if (duplicateCondition.equals("true")) {
                            return "'error' " + "[" + duplicateColumnName + "]" + " duplicate column name";
                        } else {
                            __table__writer__.__table__writer__(Table_Name, updateDB);
                            return "true";
                        }
                    }
                }
            }
        }
        return "true";
    }
}
