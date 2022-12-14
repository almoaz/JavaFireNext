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

public class __self__child__delete__ {
    public static String __self__child__delete__(String self) {
        String value = "";
        String parent = "";
        String databaseName = "";

        for (int x = 0; x <= self.length(); x++) {
            if (self.charAt(x) != '>') {
                value = value + self.charAt(x);
            }
            if (self.charAt(x) == '>') {
                value = value + self.charAt(x);
                parent = parent + value;
                value = "";
            }
            if (x == self.length() - 1) {
                File file;
                if (!parent.equals("")) {
                    file = new File(value + ".ndb");
                    if (file.exists()) {
                        String database = __file__read__.__file__read__(value);
                        if (database.equals(start__tag+""+end__tag) || database.equals("")) {
                            __self__update__.__self__update__(parent.substring(0, parent.length() - 1), value);
                            File file1 = new File( value + ".ndb");
                            file1.delete();
                            return "true";
                        } else {
                            databaseName = value;
                            value = "";
                            String childFound = "true";
                            for (int x1 = 0; x1 <= database.length(); x1++) {
                                if (database.charAt(x1) != child__end__tag && database.charAt(x1) != start__tag && database.charAt(x1) != end__tag) {
                                    value = value + database.charAt(x1);
                                }
                                if (database.charAt(x1) == value__child__tag) {
                                    childFound = "false";
                                } else if (database.charAt(x1) == child__end__tag) {
                                    if (childFound.equals("true")) {
                                        __self__child__delete__.__self__child__delete__1(value);
                                        value = "";
                                    } else {
                                        value = "";
                                        childFound = "true";
                                    }
                                }
                                if (x1 == database.length() - 1) {
                                    if (childFound.equals("true")) {
                                        __self__child__delete__.__self__child__delete__1(value);
                                    }
                                    File file1 = new File( databaseName + ".ndb");
                                    file1.delete();
                                    break;
                                }


                            }
                        }
                    } else {
                        return "'" + value + "' child not found";
                    }

                } else {
                    file = new File(value + ".ndb");

                    if (file.exists()) {
                        String database = __file__read__.__file__read__(value);
                        if (database.equals(start__tag+""+end__tag) || database.equals("")) {

                            File file1 = new File( value + ".ndb");
                            file1.delete();
                            return "true";
                        } else {
                            databaseName = value;
                            value = "";
                            String childFound = "true";

                            for (int x1 = 0; x1 <= database.length(); x1++) {
                                if (database.charAt(x1) != child__end__tag && database.charAt(x1) != start__tag && database.charAt(x1) != end__tag) {
                                    value = value + database.charAt(x1);
                                }
                                if (database.charAt(x1) == value__child__tag) {
                                    childFound = "false";
                                } else if (database.charAt(x1) == child__end__tag) {
                                    if (childFound.equals("true")) {
                                        __self__child__delete__.__self__child__delete__1(value);
                                        value = "";
                                    } else {
                                        value = "";
                                        childFound = "true";
                                    }
                                }
                                if (x1 == database.length() - 1) {
                                    if (childFound.equals("true")) {
                                        __self__child__delete__.__self__child__delete__1(value);
                                    }
                                    File file1 = new File(databaseName + ".ndb");
                                    file1.delete();
                                    break;
                                }


                            }
                        }
                    } else {
                        return "'" + value + "' child not found";
                    }

                }


                break;
            }

        }
        if (!parent.equals("")) {
            __self__update__.__self__update__(parent.substring(0, parent.length() - 1), databaseName);
        }
        return "true";
    }

    private static String __self__child__delete__1(String self) {
        String value = "";
        String databaseName = "";

        for (int x = 0; x <= self.length(); x++) {
            if (self.charAt(x) != '>') {
                value = value + self.charAt(x);
            }
            if (self.charAt(x) == '>') {

                value = "";
            }
            if (x == self.length() - 1) {
                File file = new File(value + ".ndb");
                if (file.exists()) {
                    String database = __file__read__.__file__read__(value);
                    if (database.equals(start__tag+""+end__tag) || database.equals("")) {
                        File file1 = new File( value + ".ndb");
                        file1.delete();
                        return "true";
                    } else {
                        databaseName = value;
                        value = "";
                        String childFound = "true";

                        for (int x1 = 0; x1 <= database.length(); x1++) {
                            if (database.charAt(x1) != child__end__tag && database.charAt(x1) != start__tag && database.charAt(x1) != end__tag) {
                                value = value + database.charAt(x1);
                            }
                            if (database.charAt(x1) == value__child__tag) {
                                childFound = "false";
                            } else if (database.charAt(x1) == child__end__tag) {
                                if (childFound.equals("true")) {
                                    __self__child__delete__.__self__child__delete__2(value);
                                    value = "";
                                } else {
                                    value = "";
                                    childFound = "true";
                                }
                            }
                            if (x1 == database.length() - 1) {
                                if (childFound.equals("true")) {
                                    __self__child__delete__.__self__child__delete__2(value);
                                }
                                File file1 = new File(databaseName + ".ndb");
                                file1.delete();
                                break;
                            }


                        }
                    }
                } else {
                    return "'" + value + "' child not found";
                }
                break;
            }

        }
        return "";
    }

    private static String __self__child__delete__2(String self) {
        String value = "";
        String databaseName = "";

        for (int x = 0; x <= self.length(); x++) {
            if (self.charAt(x) != '>') {
                value = value + self.charAt(x);
            }
            if (self.charAt(x) == '>') {

                value = "";
            }
            if (x == self.length() - 1) {
                File file = new File(value + ".ndb");
                if (file.exists()) {
                    String database = __file__read__.__file__read__(value);
                    if (database.equals(start__tag+""+end__tag) || database.equals("")) {
                        File file1 = new File(value + ".ndb");
                        file1.delete();
                        return "true";
                    } else {
                        databaseName = value;
                        value = "";
                        String childFound = "true";

                        for (int x1 = 0; x1 <= database.length(); x1++) {
                            if (database.charAt(x1) != child__end__tag && database.charAt(x1) != start__tag && database.charAt(x1) != end__tag) {
                                value = value + database.charAt(x1);
                            }
                            if (database.charAt(x1) == value__child__tag) {
                                childFound = "false";
                            } else if (database.charAt(x1) == child__end__tag) {
                                if (childFound.equals("true")) {
                                    __self__child__delete__.__self__child__delete__1(value);
                                    value = "";
                                } else {
                                    value = "";
                                    childFound = "true";
                                }
                            }
                            if (x1 == database.length() - 1) {
                                if (childFound.equals("true")) {
                                    __self__child__delete__.__self__child__delete__1(value);
                                }
                                File file1 = new File(databaseName + ".ndb");
                                file1.delete();
                                break;
                            }


                        }
                    }
                } else {
                    return "'" + value + "' child not found";
                }
                break;
            }

        }
        return "";
    }
}
