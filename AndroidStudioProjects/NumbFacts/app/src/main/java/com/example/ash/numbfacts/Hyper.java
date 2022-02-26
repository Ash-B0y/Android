package com.example.ash.numbfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class Hyper extends AppCompatActivity {
TextView t10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hyper);
        this.setTitle("HYPER COMPLEX NUMBER");
        t10 = (TextView) findViewById(R.id.textView10);
        t10.setMovementMethod(new ScrollingMovementMethod());
        String hyp="\n\n"+"There are at least two definitions of hypercomplex numbers. Clifford algebraists call their higher dimensional numbers hypercomplex, even though they do not share all the properties of complex numbers and no classical function theory can be constructed over them.\n" +
                "\n" +
                "According to van der Waerden (1985), a hypercomplex number is a number having properties departing from those of the real and complex numbers. The most common examples are biquaternions, exterior algebras, group algebras, matrices, octonions, and quaternions.\n" +
                "\n" +
                "One type of hypercomplex number due to Davenport (1996) and sometimes called \"the\" hypercomplex numbers are defined according to the multiplication table\n" +
                "\n" +
                "ij\t=\tji=k\t\n" +
                "(1)\n" +
                "jk\t=\tkj=-i\t\n" +
                "(2)\n" +
                "ki\t=\tik=-j,\t\n" +
                "(3)\n" +
                "and therefore satisfy\n" +
                "\n" +
                " i^2=j^2=-k^2=-1. \t\n" +
                "(4)\n" +
                "Note that these are not quaternions, and that the multiplication of these hypercomplex numbers is commutative. Unlike real and complex numbers, not all nonzero hypercomplex numbers have a multiplicative inverse. An application of this sort of hypercomplex number can be found in the julia_fractal command in POVRay.\n\n"+"The terms group theory and ring theory are refinements of algebraic understanding that developed in the era of electronics and aircraft, the 20th century. The term hypercomplex number harkens back to the age of steam. For the most part, the hypercomplex systems have been assimilated through the resolution of vision provided by groups, rings, and fields, and the term has been retired from use other than historic reference. Similarly, the field of complex numbers {\\displaystyle C=\\{z=x+iy,\\ x,y\\in R\\},\\ i^{2}=-1,} {\\displaystyle C=\\{z=x+iy,\\ x,y\\in R\\},\\ i^{2}=-1,} has an insufficiently descriptive name, and might be better described as division binarions C according to composition algebra theory.\n" +
                "\n" +
                "Hypercomplex numbers grew out of William Rowan Hamilton’s construction of quaternions in the 1840s. The legacy of his vision continues in spatial vector algebra: for vectors {\\displaystyle v=ai+bj+ck} {\\displaystyle v=ai+bj+ck} and {\\displaystyle w=di+ej+fk,} {\\displaystyle w=di+ej+fk,} the well-known products are\n" +
                "\n" +
                "Dot: {\\displaystyle v\\cdot w=ad+be+cf\\in R} {\\displaystyle v\\cdot w=ad+be+cf\\in R}\n" +
                "Cross: {\\displaystyle v\\times w=(bf-ec)i-(af-dc)j+(ae-db)k\\in R^{3}.} {\\displaystyle v\\times w=(bf-ec)i-(af-dc)j+(ae-db)k\\in R^{3}.}\n" +
                "These products are the severed remnants of Hamilton’s quaternion product: {\\displaystyle \\ \\ vw=-v\\cdot w+v\\times w\\in R^{4}.} {\\displaystyle \\ \\ vw=-v\\cdot w+v\\times w\\in R^{4}.}\n" +
                "\n" +
                "In 1845 John T. Graves and Arthur Cayley described an eight-dimensional hypercomplex system now referred to as octonions or Cayley numbers. They extend quaternions but associativity of multiplication is lost. James Cockle challenged the presumption of quaternions in four dimensions by presenting associative hypercomplex systems tessarines (1848) and coquaternions (1849). Hamilton had his own eight-dimensional system (biquaternions) that were explored in his Lectures on Quaternions (1853), but virtually ignored in Elements of Quaternions (completed by his son in 1865) and in the version edited by Charles Jasper Jolly in 1899.\n" +
                "\n" +
                "Quaternions feature the property of anti-commutativity of the basis vectors i, j, k:\n" +
                "\n" +
                "ij = -ji = k,   jk = -kj = i,   ki = -ik = j. (In coquaternions jk = -ki = -i).\n" +
                "Due to anti-commutativity, squaring a vector leaves many cancelled terms:\n" +
                "\n" +
                "{\\displaystyle (ai+bj+ck)^{2}=-a^{2}-b^{2}-c^{2},} {\\displaystyle (ai+bj+ck)^{2}=-a^{2}-b^{2}-c^{2},}   thus for {\\displaystyle r=ai+bj+ck,} {\\displaystyle r=ai+bj+ck,}\n" +
                "{\\displaystyle a^{2}+b^{2}+c^{2}=1\\ \\equiv \\ r^{2}=-1.} {\\displaystyle a^{2}+b^{2}+c^{2}=1\\ \\equiv \\ r^{2}=-1.}\n" +
                "For any such r, the plane {x + y r | x,y in R} is a complex number plane, and by Euler's formula the mapping {\\displaystyle ar\\mapsto \\cos a+r\\sin a} {\\displaystyle ar\\mapsto \\cos a+r\\sin a} takes the ray through r to a wrapping of the unit circle in that plane. The unit sphere in quaternions is composed of these circles, considering the variable r. According to Hamilton, a unit quaternions is a versor; evidently every versor can be known by its parameters a and r.\n" +
                "\n" +
                "When the anti-commutativity axiom is changed to commutativity, then two square roots of minus one, say h and i, have a product hi with square {\\displaystyle (hi)^{2}=hihi=h^{2}i^{2}=(-1)(-1)=+1.} {\\displaystyle (hi)^{2}=hihi=h^{2}i^{2}=(-1)(-1)=+1.} James Cockle’s tessarines are based on such an imaginary unit, now with plus one for its square. Cockle initiated the use of  j, j2 = +1, to represent this new imaginary unit that is not a square root of minus one. The tessarines are z = w + z j where z, w are in C. The real tessarines a + b j feature a unit hyperbola, contrasting with the unit circle {\\displaystyle \\{a+bi:a^{2}+b^{2}=1\\}\\subset C.} {\\displaystyle \\{a+bi:a^{2}+b^{2}=1\\}\\subset C.} Whereas the circle surrounds the origin, a hyperbola has radii in only half of the directions of the plane and requires a conjugate hyperbola to cover the other half, and even then the asymptotes, that they share, provide even more directions in the plane. In 1873 William Kingdon Clifford exploited the real tessarines to modify Hamilton's biquaternions: where Hamilton had used elements of C (division binarions) for coefficients of a biquaternion q = w + x i + y j + z k, Clifford used real tessarines (now called split binarions). Clifford’s construction illustrated a process of generating new algebras from given ones in a procedure called tensor products: Hamilton’s biquaternions are {\\displaystyle C\\otimes H} {\\displaystyle C\\otimes H}, and the split biquaternions of Clifford are {\\displaystyle D\\otimes H.} {\\displaystyle D\\otimes H.}\n" +
                "\n" +
                "Clifford was precocious, particularly in his anticipation of a geometric model of gravitation as hills and valleys in a temporal plenum. But he lived before set theory, modern logical and mathematical symbology, and before abstract algebra with its firmament of groups, rings and fields. One of the realities of light is its finite speed: a foot per nanosecond, an astronomic unit in 500 seconds, or a light year in a year. When a diagram uses an of these pairs of units as axes, the diagonals through the origin represent to locus of light, one for the left beam, one for the right. The diagonals are asymptotes to hyperbolas, such as {\\displaystyle aj\\mapsto \\cosh a+j\\sinh a,} {\\displaystyle aj\\mapsto \\cosh a+j\\sinh a,} a real tessarine. Eventually, over decades of deliberation, physicists realized that this hyperbola was the answer to a linear-velocity problem: how can v + w be the sum of two velocities when such accumulation may run over the speed of light. The hyperbola lies between the asymptotes and will not run over the speed of light. In the real tessarine system the points of the hyperbola are {\\displaystyle e^{aj}} {\\displaystyle e^{aj}} and {\\displaystyle e^{bj},} {\\displaystyle e^{bj},} representing two velocities in the group {\\displaystyle \\{e^{xj}:x\\in R\\},} {\\displaystyle \\{e^{xj}:x\\in R\\},} a hyperbola. The sum of two velocities is found by their product {\\displaystyle e^{aj}e^{bj}=e^{(a+b)j},} {\\displaystyle e^{aj}e^{bj}=e^{(a+b)j},} another element of the hyperbola. After 1911the parameter a was termed rapidity. Evidently this aspect of special relativity was born of real tessarines.\n" +
                "\n" +
                "The electromagnetic work of Clerk-Maxell and Heinrich Hertz demanded a fitting context for theorizing with the temporal variable included. Maxwell had used Hamilton’s del operator\n" +
                "\n" +
                "{\\displaystyle \\nabla =i{\\frac {\\partial }{\\partial x}}+j{\\frac {\\partial }{\\partial y}}+k{\\frac {\\partial }{\\partial z}}} {\\displaystyle \\nabla =i{\\frac {\\partial }{\\partial x}}+j{\\frac {\\partial }{\\partial y}}+k{\\frac {\\partial }{\\partial z}}} in A Treatise on Electricity and Magnetism, but the quaternion algebra is unsuitable: it is implicitly a Euclidean 4-space since {\\displaystyle qq^{*}=w^{2}+x^{2}+y^{2}+z^{2},} {\\displaystyle qq^{*}=w^{2}+x^{2}+y^{2}+z^{2},} the square of the Euclidean norm.\n" +
                "In the 1890s Alexander Macfarlane advocated Space Analysis with a hypercomplex system that exchanged Hamilton's sphere of imaginary units for a sphere of Cockle's imaginary units that square to +1. He retained the anti-commutative property of quaternions so that {\\displaystyle qq^{*}=w^{2}-x^{2}-y^{2}-z^{2}.} {\\displaystyle qq^{*}=w^{2}-x^{2}-y^{2}-z^{2}.} Then in this system of hyperbolic quaternions, for any r on the sphere, {\\displaystyle \\{x+yr:x,y\\in R\\}} {\\displaystyle \\{x+yr:x,y\\in R\\}} is a plane of real tessarines, including unit hyperbola suitable to represent motion at any rapidity in direction r. The hyperbolic quaternions looked like an elegant model for electromechanics until it was found wanting. The problem was that the simple property of associative multiplication broke down in hyperbolic quaternions, and though it was a hypercomplex system with a useful model, loss of this property put it outside the purview of group theory, for instance.\n" +
                "\n" +
                "Once the axioms of a vector space were established, hypercomplex systems were included. The axioms require a commutative group of vectors, a scalar field, and rules of operations. Putting the axioms of a vector space together with those for a ring establishes the meaning of an algebra in the study of abstract algebra.\n" +
                "\n" +
                "For associative hypercomplex systems, Joseph Wedderburn removed all the mystery in 1907 when he showed that any such system could be represented with matrix rings over a field. For instance, 2 x 2 real matrices form an algebra M(2,R) isomorphic to coquaternions and 2 x 2 complex matrices form an algebra M(2,C) isomorphic to biquaternions. These algebras, along with R, C and tessarines form the associative composition algebras which are noted for the property\n" +
                "\n" +
                "{\\displaystyle (pq)(pq)^{*}=(pp^{*})(qq^{*}).} {\\displaystyle (pq)(pq)^{*}=(pp^{*})(qq^{*}).}";
                t10.setText(hyp);
    }
}
