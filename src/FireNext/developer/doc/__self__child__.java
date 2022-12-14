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

public class __self__child__ {
    public static String __self__child__(String self) {
        String value = "";
        String databaseName = "";
        String parentDatabaseName = "";

        for (int x = 0; x <= self.length(); x++) {
            if ('>' != self.charAt(x)) {
                value = value + self.charAt(x);
            }
            if ('>' == self.charAt(x)) {
                if (databaseName.equals("")) {
                    File file = new File( value + ".ndb");
                    if (file.exists()) {
                        databaseName = value;
                        value = "";
                    } else {
                        return "'" + value + "' database not found";
                    }
                } else {
                    String childData = __file__read__.__file__read__(databaseName);
                    if (childData.equals("")) {
                        return "'" + value + "' child not found";
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
                                    File file = new File( value + ".ndb");
                                    if (file.exists()) {
                                        if (parentDatabaseName.equals("")) {
                                            parentDatabaseName = databaseName;
                                        } else {
                                            parentDatabaseName = parentDatabaseName + ">" + databaseName;
                                        }
                                        databaseName = value;
                                        value = "";
                                        break;
                                    } else {
                                        return "'" + value + "' database not found";
                                    }

                                }
                                readChild = "";
                            }
                            if (childData.charAt(x1) == end__tag && x1 == childData.length() - 1) {
                                if (readChild.equals(value)) {
                                    File file = new File( value + ".ndb");
                                    if (file.exists()) {
                                        if (parentDatabaseName.equals("")) {
                                            parentDatabaseName = databaseName;
                                        } else {
                                            parentDatabaseName = parentDatabaseName + ">" + databaseName;
                                        }
                                        databaseName = value;
                                        value = "";
                                    } else {
                                        return "'" + value + "' database not found";
                                    }

                                } else {
                                    return "'" + value + "' child not found";
                                }


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
                File file = new File(databaseName + ".ndb");

                if (file.exists()) {
                    String childData = __file__read__.__file__read__(databaseName);

                    if (childData.equals("")) {
                        return "'" + value + "' child not found";
                    } else {
                        String readChild = "";

                        for (int x2 = 0; x2 <= childData.length(); x2++) {
                            if (childData.charAt(x2) != start__tag && childData.charAt(x2) != child__end__tag && childData.charAt(x2) != end__tag) {
                                readChild = readChild + childData.charAt(x2);
                            }
                            if (childData.charAt(x2) == child__end__tag) {
                                if (readChild.equals("true")) {
                                    return readChild;
                                }
                                readChild = "";

                            }
                            if (childData.charAt(x2) == value__child__tag) {
                                if (readChild.equals(value)) {
                                    return "true";

                                }
                                readChild = "";

                            }
                            if (x2 == childData.length() - 1) {
                                if (readChild.equals(value)) {
                                    return "true";
                                } else {
                                    return "false";
                                }
                            }


                        }
                    }
                } else {
                    return "'" + databaseName + "' child not found";
                }
            }


        }
        return "false";
    }
}
