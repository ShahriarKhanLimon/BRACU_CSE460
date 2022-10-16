module problem2(Y, A, B, C); 

input C, B, A; 
output Y; 

assign e = ~(A & A);
//assign e2 = ~(e);
assign f = ~(B & B);
//assign f2 = ~(f);
assign g = ~(C & C); 
//assign g2 = ~(g);

assign h = ~(e & f & C);
assign i = ~(e & B & g);
assign j = ~(A & f & g);
assign k = ~(A & B & C);

assign Y = ~(h & i & j & k); 

endmodule
