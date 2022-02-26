package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Real extends AppCompatActivity {
TextView t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        this.setTitle("REAL NUMBER");
        t4 = (TextView) findViewById(R.id.textView4);
        t4.setMovementMethod(new ScrollingMovementMethod());
        String re="\n\n"+"REAL NUMBERS\n\n"+"WHAT ARE REAL NUMBERS?\n\n" +
                "When both the rational and irrational numbers combined, the combination is defined as the real numbers. Real numbers can be both positive or negative, and they are denoted by the symbol “R”. Numbers like a natural number, decimals, and fraction comes under the real number.\n\n"+"CLASSIFICATION OF REAL NUMBERS\n\n" +
                "Natural Numbers– It includes all the counting numbers such as 1, 2, 3, 4,…\n" +
                "Whole Numbers– Numbers starting with zero are called whole numbers, like 0, 1, 2, 3, 4,…\n" +
                "Integers– Whole numbers and negative of all natural numbers are collectively known as integers, for example -3, -2, -1, 0, 1, 2,\n" +
                "Rational Numbers– All the numbers that can be written in the form of p/q, where q≠0 are known as Rational numbers.\n" +
                "Irrational Numbers– The numbers which cannot be written in the form of p/q (simple fraction) are known as irrational numbers. Irrational numbers are non-terminating and non-repeating in nature.\n\n"+"PROPERTIES OF REAL NUMBERS\n\n" +
                "Commutative property- If we have real numbers m,n. The general form will be m + n = n + m  for adaddition andmn = nm for multiplication\n" +
                "Associative property- If we have real numbers m,n,r. The general form will be  m + (n + r) = (m + n) + r for addition(mn) r = m (nr) for multiplication\n" +
                "Distributive property- If we have real numbers m,n,r. The general form will be – m (n + r) = mn + mr and (m + n) r = mr + nr\n" +
                "Identity property- For addition: m + (- m) = 0";
        t4.setText(re);
    }
}
