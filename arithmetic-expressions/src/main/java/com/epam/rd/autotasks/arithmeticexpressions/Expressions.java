package com.epam.rd.autotasks.arithmeticexpressions;

import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
        Variable variable = new Variable(name, value);
        return variable;
    }

    public static Expression val(int value) {
        Expression expr = new Expression() {

            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if (value >= 0)
                    return "" + value + "";
                else
                    return "(" + value + ")";
            }
        };
        return expr;
    }

    public static Expression sum(Expression... members) {

        Expression expr = new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;

                for (int i = 0; i < members.length; i++) {
                    sum += members[i].evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {

                StringBuilder sb = new StringBuilder();
                String str = null;
                for (int i = 0; i < members.length; i++) {
                    if (i != members.length - 1) {
                        sb.append(members[i].toExpressionString()).append(" + ");
                    }else {
                        sb.append(members[i].toExpressionString());
                    }
                }
                str = sb.toString();

                return "(" + str + ")";
            }
        };
        return expr;
    }

    public static Expression product(Expression... members) {

        Expression expr = new Expression() {
            @Override
            public int evaluate() {
                int prod = 1;

                for (int i = 0; i < members.length; i++) {
                    prod *= members[i].evaluate();
                }
                return prod;
            }

            @Override
            public String toExpressionString() {

                StringBuilder sb = new StringBuilder();
                String str = null;
                for (int i = 0; i < members.length; i++) {
                    if (i != members.length - 1) {
                        sb.append("(").append(members[i].toExpressionString()).append(" * ");
                    }else {
                        sb.append(members[i].toExpressionString()).append(")");
                    }
                }
                str = sb.toString();


                return str;
            }
        };
        return expr;
    }

    public static Expression difference(Expression minuend, Expression subtrahend) {
        Expression expr = new Expression() {
            @Override
            public int evaluate() {

                int a = minuend.evaluate();
                int b = subtrahend.evaluate();

                int res = a - b;
                return res;
            }

            @Override
            public String toExpressionString() {
                String subtrahendString;
                if (subtrahend.toExpressionString() == null) {
                    subtrahendString = val(subtrahend.evaluate()).toExpressionString();
                } else {
                    subtrahendString = subtrahend.toExpressionString();
                }

                String res = "(" + minuend.toExpressionString() + " - " + subtrahendString + ")";
                return res;
            }
        };
        return expr;
    }

    public static Expression fraction(Expression dividend, Expression divisor) {


        Expression expr = new Expression() {
            @Override
            public int evaluate() {

                int a = dividend.evaluate();
                int b = divisor.evaluate();

                int res = a / b;
                return res;
            }

            @Override
            public String toExpressionString() {

                String resStr = "(" + dividend.toExpressionString() + " / " + divisor.toExpressionString() + ")";

                return resStr;
            }
        };
        return expr;
    }
}
