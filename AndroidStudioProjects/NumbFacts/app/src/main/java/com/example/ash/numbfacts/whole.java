package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class whole extends AppCompatActivity {
    TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole);
        this.setTitle("WHOLE NUMBER");
        t3 = (TextView) findViewById(R.id.textView3);
        t3.setMovementMethod(new ScrollingMovementMethod());
        String wh="\n\n"+"WHOLE NUMBER \n\n"+"A whole number is a member of the set {0,1, 2, 3, …}. It is either one of the positive integers (natural numbers) or zero.\n" +
                "The set of whole numbers is exactly equivalent to the set of non negative integers.\n" +
                "\n\n" +
                "EXAMPLES OF WHOLE NUMBERS\n\n" +
                "Some examples of whole numbers are 4, 5, and 89,453,711.\n" +
                "\n" +
                "Any fraction, decimal, negative number or imaginary number is not a whole number. For example, -5, 6.788, and 4/5 are not whole numbers.\n" +
                "\n" +
                "THE SET OF WHOLE NUMBERS\n\n"+"The set of whole numbers is closed under addition and multiplication. What that means is that for all whole numbers a and b, a + b = c and a b = d will also be whole numbers.Just as 6 + 7 = 13 and 6 · 7 = 42 are whole numbers, the sum or product of any two whole numbers will also be whole.\n" +
                "\n" +
                "The set of whole numbers isn’t closed under division and subtraction. For any whole number a, there is another whole number b such that a – b = c and a / b = d are not whole numbers.\n" +
                "\n" +
                "Example: 7 and 9 are whole numbers, but 7 – 9 = -2, which is not a whole number. 4 and 5 are whole numbers, but 4/5 is not a whole number.\n\n"+"PROPERTIES OF WHOLE NUMBERS\n\n" +
                "Whole numbers are commutative under addition and multiplication . For every a, b in the set of whole numbers, a + b = b + a and a · b = b a.\n" +
                "\n" +
                "Whole numbers are associative under addition and multiplication. For every a, b, and c in the set of whole numbers, a(b·c) = (a·b) · c and (a + b) + c = a + (b + c).\n" +
                "\n" +
                "The set of whole numbers includes an additive identity 0 so that a + 0 = a for every whole number a. It also includes a multiplicative identity 1 so that 1 · a = a.\n" +
                "\n\n" +
                "ANOTHER DEFINITION OF WHOLE NUMBER\n\n" +
                "Sometimes the set of whole numbers is defined to exclude zero. Then it is equivalent to the set of natural numbers, and can be written as {1,2,3,4,5….}";
                t3.setText(wh);
    }
}
