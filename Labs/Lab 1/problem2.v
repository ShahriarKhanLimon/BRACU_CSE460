module problem2 (d, load, clk, q);

input [4:01] d;
input load, clk; 
output reg [4:0] q;

always @ (negedge clk)
begin 
if (load)
q<=d;
else
begin
q[0]<=q[4];
q[4]<=q[3];
q[3]<=q[2];
q[2]<=q[1];
q[1]<=q[0];
end
end
endmodule
