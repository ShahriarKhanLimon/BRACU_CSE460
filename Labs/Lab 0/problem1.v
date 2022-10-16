module problem1(Y, A, B, C); 

input C, B, A; 
output Y; 

assign e = ~A;
assign f = ~B;
assign g = ~C; 
assign h = e & f & C;
assign i = e & B & g;
assign j = A & f & g;
assign k = A & B & C;
assign Y = h | i | j | k; 

endmodule 
