package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Natural extends AppCompatActivity {
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_natural);
        this.setTitle("NATURAL NUMBER");
        t2 = (TextView) findViewById(R.id.textView2);
        t2.setMovementMethod(new ScrollingMovementMethod());
        String nat="\n\n"+"NATURAL NUMBER: DEFINITION AND EXAMPLES\n\n"+"A natural number is a counting number, a member of the set {1,2,3,4,….}.  The set of natural numbers is designated by ℕ.\n\n"+"FORMAL DESCRIPTION OF NATURAL NUMBERS\n\n"+"More formally, we can define the natural numbers as the set ℕ= {x| x=1, or there is some y in ℕ where y = {x + 1}. In plain English, that means that ℕ is the set where x either is one, or x is 1 more than some other number y in ℕ. The easiest way to come up with examples of natural numbers is simply to start at one and begin counting; each of the numbers that result when you add 1 to a natural number is another natural number.\n" +
                "\n" +
                "All natural numbers are integers. In set theory, we would say that ℕ is a subset of ℤ.\n" +
                "\n" +
                "EXAMPLES OF NATURAL NUMBERS\n\n" +
                "Examples of natural numbers include 4, 79, and 56,793. \n" +
                "-5, -7, and 9.8 are not natural numbers.\n" +
                "\n" +
                "ALTERNATIVE DEFINITION OF A NATURAL NUMBER\n\n"+" The set of natural numbers is sometimes defined as the set {0,1,2,3,4,….}. In this case it is equivalent to the set of non negative integers. The essential properties of natural numbers remain the same whether or not we include 0.\n" +
                "\n" +
                "PROPERTIES OF A NATURAL NUMBER\n" +
                "The set of natural numbers is closed under addition and multiplication. If you add or multiply natural numbers, you’ll get a natural number as a result. That is, for any a and b in ℕ, a + b = c and a * b = g will also be in ℕ.\n" +
                "\n" +
                "The set of natural numbers isn’t closed under subtraction or division. For every natural number a, there exist natural numbers b and c such that a – b = e and a / c = f, where e and f are not natural numbers.\n" +
                "\n" +
                "Natural numbers make an infinite set. For any natural number, there is another natural number that is one greater.\n" +
                "\n" +
                "Another important property of natural numbers is that they can be ordered. Formally, we’d say that for any a, b in ℕ a > b if and only if a = b + k for some k in ℕ. This means that natural numbers include the set of ordinal numbers and the set of cardinal numbers.";
               t2.setText(nat);
    }
}
