package FireNext.developer.doc;

import static FireNext.developer.doc.__init__.value__child__tag;

public class __self__check__ {
    public static String __self__check__(String self, String condition)
    {
        String parent = "";
        String valueChild = "";
        String value = "";

        if (condition.equals("add"))
        {
            for (int x = 0; x <= self.length(); x++)
            {
                if (x >= 0)
                {
                    if (value.equals("") && self.charAt(x) == ' ')
                    {
                        value = "";
                    }
                    else
                    {
                        value = value + self.charAt(x);
                    }
                }
                if (self.charAt(x) == '>')
                {
                    if (valueChild.equals(""))
                    {
                        parent = parent + value;
                        value = "";
                    }
                    else
                    {
                        return "syntax";
                    }
                }
                if (self.charAt(x) == value__child__tag)
                {
                    if (value.length() != 1)
                    {
                        valueChild += value;
                        value = "";
                    }
                    else
                    {
                        return "child";
                    }

                }
                if (x == self.length()-1)
                {
                    if (!valueChild.equals("") && parent.equals(""))
                    {
                        return "parent";
                    }
                    else if (parent.equals(""))
                    {
                        return "parent";
                    } else if (valueChild.equals(""))
                    {
                        return "child";
                    }
                    else
                    {
                        return parent+valueChild+value;
                    }

                }

            }
        }
        if (condition.equals("child"))
        {
            for (int x = 0; x <= self.length(); x++)
            {
                if (x >= 0)
                {
                    if (value.equals("") && self.charAt(x) == ' ')
                    {
                        value = "";
                    }
                    else
                    {
                        value = value + self.charAt(x);
                    }
                }
                if (self.charAt(x) == '>')
                {
                    if (valueChild.equals(""))
                    {
                        parent = parent + value;
                        value = "";
                    }
                    else
                    {
                        return "syntax";
                    }
                }
                if (self.charAt(x) == value__child__tag)
                {
                    if (value.length() != 1)
                    {
                        valueChild += value;
                        value = "";
                    }
                    else
                    {
                        return "child";
                    }

                }
                if (x == self.length()-1)
                {
                    return parent+valueChild+value;


                }

            }
        }

        return parent+valueChild+value;
    }
}
