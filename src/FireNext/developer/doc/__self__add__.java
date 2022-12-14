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
package FireNext.developer.doc;
import static FireNext.developer.doc.__init__.*;


import java.io.File;

public class __self__add__ {
    public static String __self__add__(String self) {
        String value = "";
        String databaseName = "";

        for (int x = 0; x <= self.length(); x++) {
            if ('>' != self.charAt(x)) {
                value = value + self.charAt(x);
            }
            if ('>' == self.charAt(x)) {
                if (databaseName.equals("")) {
                    File file = new File(value + ".ndb");
                    if (file.exists()) {
                        databaseName = value;
                        value = "";
                    } else {
                        __create__database__.__create__database__(value);
                        databaseName = value;
                        value = "";
                    }


                } else {
                    String childData = __file__read__.__file__read__(databaseName);
                    if (childData.equals("")) {
                        __database__writer__.__database__writer__(databaseName, start__tag + value + end__tag);
                        __create__database__.__create__database__(value);

                        databaseName = value;
                    } else {
                        String readChild = "";
                        String updateNDB = "";

                        for (int x1 = 0; x1 <= childData.length(); x1++) {
                            if (childData.charAt(x1) != end__tag) {
                                updateNDB = updateNDB + childData.charAt(x1);
                            }
                            if (childData.charAt(x1) != start__tag && childData.charAt(x1) != child__end__tag && childData.charAt(x1) != end__tag) {
                                readChild = readChild + childData.charAt(x1);
                            }
                            if (childData.charAt(x1) == child__end__tag) {
                                if (readChild.equals(value)) {
                                    databaseName = value;
                                    break;
                                }
                                readChild = "";
                            }
                            if (childData.charAt(x1) == end__tag && x1 == childData.length() - 1) {
                                if (readChild.equals(value)) {
                                    databaseName = value;
                                } else {
                                    updateNDB = updateNDB + child__end__tag + value + childData.charAt(x1);
                                    __database__writer__.__database__writer__(databaseName, updateNDB);
                                    __database__writer__.__database__writer__(value, "");
                                    databaseName = value;
                                }
                                break;


                            }
                            if (x1 == childData.length() - 1) {
                                break;
                            }

                        }
                    }
                    value = "";
                }
            }
            if (x == self.length() - 1) {
                String childData = __file__read__.__file__read__(databaseName);

                String value1 = "";
                if (childData.equals("")) {

                    for (int x1 = 0; x1 <= value.length(); x1++) {
                        if (value.charAt(x1) != devided__tag) {
                            value1 = value1 + value.charAt(x1);
                        }
                        if (value.charAt(x1) == devided__tag) {

                            value1 = value1 + child__end__tag;

                        }
                        if (x1 == value.length() - 1) {
                            break;
                        }
                    }
                    __database__writer__.__database__writer__(databaseName, start__tag + value1 + end__tag);
                    break;
                } else {
                    String name = "";
                    for (int x1 = 0; x1 <= value.length(); x1++) {
                        if (value.charAt(x1) != devided__tag) {
                            value1 = value1 + value.charAt(x1);
                        }
                        if (value.charAt(x1) == value__child__tag) {
                            name = value1;
                            value1 = "";
                        }
                        if (value.charAt(x1) == devided__tag) {
                            String readChild = "";
                            String updateNDB = "";
                            String childMatch = "false";


                            for (int x2 = 0; x2 <= childData.length(); x2++) {
                                if (childData.charAt(x2) == start__tag) {
                                    updateNDB = updateNDB + childData.charAt(x2);
                                }
                                if (childData.charAt(x2) != start__tag && childData.charAt(x2) != child__end__tag && childData.charAt(x2) != end__tag) {
                                    readChild = readChild + childData.charAt(x2);
                                }
                                if (childData.charAt(x2) == child__end__tag) {
                                    if (childMatch.equals("null")) {
                                        updateNDB = updateNDB + name + value1;
                                        childMatch = "true";
                                    }
                                    if (childMatch.equals("false")) {
                                        updateNDB = updateNDB + readChild + child__end__tag;
                                    }
                                    readChild = "";

                                }
                                if (childData.charAt(x2) == value__child__tag) {
                                    if (readChild.equals(name)) {
                                        childMatch = "null";
                                    }

                                }
                                if (childMatch.equals("true")) {
                                    updateNDB = updateNDB + childData.charAt(x2);
                                }
                                if (childData.charAt(x2) == end__tag && x2 == childData.length() - 1) {
                                    if (childMatch.equals("true")) {
                                        __database__writer__.__database__writer__(databaseName, updateNDB);
                                    }
                                    if (childMatch.equals("null")) {
                                        updateNDB = updateNDB + name + value1 + end__tag;
                                        __database__writer__.__database__writer__(databaseName, updateNDB);
                                    }
                                    if (childMatch.equals("false")) {
                                        childData = childData.substring(0, childData.length() - 1);
                                        updateNDB = childData + child__end__tag + name + value1 + end__tag;
                                        __database__writer__.__database__writer__(databaseName, updateNDB);
                                    }
                                    break;
                                }
                                if (x2 == childData.length() - 1) {
                                    break;
                                }


                            }
                            value1 = "";
                            name = "";
                        }
                        if (x1 == value.length() - 1) {
                            String readChild = "";
                            String updateNDB = "";
                            String childMatch = "false";

                            childData = __file__read__.__file__read__(databaseName);

                            for (int x2 = 0; x2 <= childData.length(); x2++) {
                                if (childData.charAt(x2) == start__tag) {
                                    updateNDB = updateNDB + childData.charAt(x2);
                                }
                                if (childData.charAt(x2) != start__tag && childData.charAt(x2) != child__end__tag && childData.charAt(x2) != end__tag) {
                                    readChild = readChild + childData.charAt(x2);
                                }
                                if (childData.charAt(x2) == child__end__tag) {
                                    if (childMatch.equals("null")) {
                                        updateNDB = updateNDB + name + value1;
                                        childMatch = "true";
                                    }
                                    if (childMatch.equals("false")) {
                                        updateNDB = updateNDB + readChild + child__end__tag;
                                    }
                                    readChild = "";

                                }
                                if (childData.charAt(x2) == value__child__tag) {
                                    if (readChild.equals(name)) {
                                        childMatch = "null";
                                    }

                                }
                                if (childMatch.equals("true")) {
                                    updateNDB = updateNDB + childData.charAt(x2);
                                }
                                if (childData.charAt(x2) == end__tag && x2 == childData.length() - 1) {
                                    if (childMatch.equals("true")) {
                                        __database__writer__.__database__writer__(databaseName, updateNDB);
                                    }
                                    if (childMatch.equals("null")) {
                                        updateNDB = updateNDB + name + value1 + end__tag;
                                        __database__writer__.__database__writer__(databaseName, updateNDB);
                                    }
                                    if (childMatch.equals("false")) {
                                        childData = childData.substring(0, childData.length() - 1);
                                        updateNDB = childData + child__end__tag + name + value1 + end__tag;
                                        __database__writer__.__database__writer__(databaseName, updateNDB);
                                    }
                                    break;
                                }
                                if (x2 == childData.length() - 1) {
                                    break;
                                }


                            }
                            break;
                        }
                    }

                    return "true";

                }

            }
        }
        return "true";
    }
}
