package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Int extends AppCompatActivity {
TextView t5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_int);
        this.setTitle("INTEGER");
        t5 = (TextView) findViewById(R.id.textView5);
        t5.setMovementMethod(new ScrollingMovementMethod());
        String Int="\n\n"+"There are a lot of different types of numbers in the world. Each number is different than another, yet they may share some common characteristics. To help themselves keep track of and understand the similarities and differences between numbers, mathematicians have developed a grouping system that categorizes and describes numbers based on their characteristics.\n"+"An integer (pronounced IN-tuh-jer) is a whole number (not a fractional number) that can be positive, negative, or zero.\nIntegers are a special group or category of numbers that:\n" +
                "\n" +
                "Consist of the set of numbers: {. . .-4, -3, -2, -1, 0, 1, 2, 3, 4. . .}\n" +
                "Are all positive and negative whole numbers that do not include any fractional or decimal parts\n" +
                "A few things to note here:\n" +
                "\n" +
                "There are no fractions or decimals in any part of the numbers.\n" +
                "Negative numbers often represent the idea of being below a standard value.\n" +
                "Zero is an integer.\n" +
                "Remember that categories of numbers overlap, just like categories of geography (such as country, state, county, city, street) overlap each other. For instance, a street is in a certain city, which is in a certain county, which is in a certain state. Categories of math overlap each other too.\n" +
                "Don't let the notation throw you off. The brackets - { } - are used to write sets. This is the standard mathematical notation used when you want to list a group (or a 'set') of numbers. The ellipse (. . .) just means they go on and on forever in the same pattern. This is especially helpful when the group you are trying to represent is too big to write out in its entirety." +
                "\n" +
                "Examples of integers are: -5, 1, 5, 8, 97, and 3,043.\n" +
                "\n" +
                "Examples of numbers that are not integers are: -1.43, 1 3/4, 3.14, .09, and 5,643.1.\n" +
                "\n" +
                "The set of integers, denoted Z, is formally defined as follows:\n" +
                "\n" +
                "Z = {..., -3, -2, -1, 0, 1, 2, 3, ...}\n" +
                "\n" +
                "In mathematical equations, unknown or unspecified integers are represented by lowercase, italicized letters from the \"late middle\" of the alphabet. The most common are p, q, r, and s.";
                t5.setText(Int);
    }
}
