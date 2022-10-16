module problem3(x, y, B, C, D);

input B, C, D;
output x, y;
wire a, b, c, d, e, f;

and(a, C, D);
or(b, C ,D);
not(c, b);
and(d, B, c);
not(e, B);
and(f, b, e);

or(y, a, c);
or(x, d, f);

endmodule
