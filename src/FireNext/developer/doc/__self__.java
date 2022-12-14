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

public class __self__ {
    private static String __self__read__(String self) {
        return __file__read__.__file__read__(self);
    }

    public static String __self__(String self) {


        String database = __self__read__(self);
        String childValue = "";
        int spaceLength = self.length();
        String childName = "";
        String returnValue = "";

        for (int x = 0; x <= database.length(); x++) {
            if (database.charAt(x) != start__tag && database.charAt(x) != child__end__tag && database.charAt(x) != end__tag) {
                childValue = childValue + database.charAt(x);
            }

            if (database.charAt(x) == value__child__tag) {
                childName = childValue;
                childValue = "";
            }
            if (database.charAt(x) == child__end__tag) {
                if (!childName.equals("")) {
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + repeat(spaceLength) + devided__tag + line__tag + childName + childValue;
                    } else {
                        returnValue = returnValue + "\n" + repeat(spaceLength) + devided__tag + line__tag + childName + childValue;

                    }
                    childName = "";
                    childValue = "";

                } else {
                    String space = repeat(spaceLength - 1) + devided__tag + repeat(childValue.length() + 2) + devided__tag;
                    String value = __self__1(childValue, space);

                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + repeat(spaceLength - 1) + devided__tag + line__tag + value;
                    } else {
                        returnValue = returnValue + "\n" + repeat(spaceLength - 1) + devided__tag + line__tag + value;
                    }
                    childValue = "";
                }

            }
            if (x == database.length() - 1) {
                if (!childName.equals("")) {
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + repeat(spaceLength) + devided__tag + line__tag + childName + childValue;
                    } else {
                        returnValue = returnValue + "\n" + repeat(spaceLength) + devided__tag + line__tag + childName + childValue;
                    }
                } else {
                    String space = repeat(spaceLength - 1) + devided__tag + repeat(childValue.length() + 2) + devided__tag;
                    String value = __self__1(childValue, space);
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + repeat(spaceLength - 1) + devided__tag + line__tag + value;
                    } else {
                        returnValue = returnValue + "\n" + repeat(spaceLength - 1) + devided__tag + line__tag + value;
                    }
                }
                break;
            }


        }
        return returnValue;
    }

    private static String __self__1(String self, String parentSpace) {

        String database = __self__read__(self);
        String childValue = "";
        String childName = "";
        String returnValue = "";
        for (int x = 0; x <= database.length(); x++) {
            if (database.charAt(x) != start__tag && database.charAt(x) != child__end__tag && database.charAt(x) != end__tag) {
                childValue = childValue + database.charAt(x);
            }

            if (database.charAt(x) == value__child__tag) {
                childName = childValue;
                childValue = "";
            }
            if (database.charAt(x) == child__end__tag) {
                if (!childName.equals("")) {
                    if (returnValue.equals("")) {

                        returnValue = self + "\n" + parentSpace + line__tag + childName + childValue;

                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + childName + childValue;

                    }
                    childName = "";
                    childValue = "";

                } else {
                    String space = parentSpace + repeat(childValue.length() + 2) + devided__tag;
                    String value = __self__2(childValue, space);

                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + value;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + value;
                    }
                }
                childValue = "";

            }
            if (x == database.length() - 1) {
                if (!childName.equals("")) {
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + childName + childValue;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + childName + childValue;

                    }
                } else {
                    String space = parentSpace + repeat(childValue.length() + 2) + devided__tag;
                    String value = __self__2(childValue, space);
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + value;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + value;
                    }
                }
                break;
            }


        }
        return returnValue;
    }

    private static String __self__2(String self, String parentSpace) {
        String database = __self__read__(self);
        String childValue = "";
        String childName = "";
        String returnValue = "";
        for (int x = 0; x <= database.length(); x++) {
            if (database.charAt(x) != start__tag && database.charAt(x) != child__end__tag && database.charAt(x) != end__tag) {
                childValue = childValue + database.charAt(x);
            }

            if (database.charAt(x) == value__child__tag) {
                childName = childValue;
                childValue = "";
            }
            if (database.charAt(x) == child__end__tag) {
                if (!childName.equals("")) {
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + childName + childValue;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + childName + childValue;

                    }
                    childName = "";
                    childValue = "";

                } else {
                    String space = parentSpace + repeat(childValue.length() + 2) + devided__tag;
                    String value = __self__1(childValue, space);

                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + value;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + value;
                    }
                    childValue = "";
                }

            }
            if (x == database.length() - 1) {
                if (!childName.equals("")) {
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + childName + childValue;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + childName + childValue;
                    }
                } else {
                    String space = parentSpace + repeat(childValue.length() + 2) + devided__tag;
                    String value = __self__1(childValue, space);
                    if (returnValue.equals("")) {
                        returnValue = self + "\n" + parentSpace + line__tag + value;
                    } else {
                        returnValue = returnValue + "\n" + parentSpace + line__tag + value;
                    }
                }
                break;
            }


        }
        return returnValue;
    }

}
