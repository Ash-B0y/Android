package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Transcendental extends AppCompatActivity {
TextView t12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transcendental);
        this.setTitle("TRANSCENDENTAL NUMBER");
        t12 = (TextView) findViewById(R.id.textView12);
        t12.setMovementMethod(new ScrollingMovementMethod());
        String trans="\n\n"+"TRANSCENDENTAL NUMBER\n\n"+"A transcendental number is a real number that is not the solution of any single-variable polynomial equation whose coefficients are all integers . All transcendental numbers are irrational numbers . But the converse is not true; there are some irrational numbers that are not transcendental.Examples of transcendental numbers include pi , the ratio of a circle's circumference to its diameter in a plane, and e , the base of the natural logarithm . The case of pi has historical significance. The fact that pi is transcendental means that it is impossible to draw to perfection, using a compass and straightedge and following the ancient Greek rules for geometric constructions, a square with the same area as a given circle. This ancient puzzle, known as squaring the circle , was, for centuries, one of the most baffling challenges in geometry. Schemes have been devised that provide amazingly close approximations to squaring the circle. But in theoretical mathematics (unlike physics and engineering), approximations are never good enough; a solution, scheme, or method is either valid, or else it is not.\n" +
                "\n" +
                "It can be difficult, and perhaps impossible, to determine whether or not a certain irrational number is transcendental. Some numbers defy classification (algebraic, irrational, or transcendental) to this day. Two examples are the product of pi and e (call this quantity P pie ) and the sum of pi and e (call this S pie ). It has been proved that pi and e are both transcendental. It has also been shown that at least one of the two quantities P pie and S pie are transcendental. But as of this writing, no one has rigorously proven that P pie is transcendental, and no one has rigorously proved that S pie is transcendental.";
        t12.setText(trans);
    }
}
