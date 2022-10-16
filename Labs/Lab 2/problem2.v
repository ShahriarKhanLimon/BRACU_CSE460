module problem2 (Clock, Resetn, w, Q, c);

input Clock, Resetn;
input [2:1] w;
output reg Q;
output reg [2:1] c;
reg [2:1] y, Y;
parameter [2:1] A = 2'b00, B = 2'b01, C = 2'b10, D=2'b11;

// Define the next state combinational circuit
always @(w, y)
	case (y)
		A: 	if (w[1]==0 & w[2]==0) 
		begin
		Q=0; 
		Y=A; 
		c=2'b10;
		end
		else if (w[1]==1 & w[2]==0)
		begin
		Y=B; 
		Q=0; 
		c=2'b10;
		end
		else if (w[1]==0 & w[2]==1)
		begin
		Y=D; 
		Q=0; 
		c=2'b10;
		end
		
		B: 	if (w[1]==0 & w[2]==0) 
		begin
		Q=0; 
		Y=B; 
		c=2'b10;
		end
		else if (w[1]==1 & w[2]==0)
		begin
		Y=C; 
		Q=0; 
		c=2'b10;
		end
		else if (w[1]==0 & w[2]==1)
		begin
		Y=A; 
		Q=1; 
		c=2'b10;
		end
		
		C: 	if (w[1]==0 & w[2]==0) 
		begin
		Q=0; 
		Y=C; 
		c=2'b10;
		end
		else if (w[1]==1 & w[2]==0)
		begin
		Y=D; 
		Q=0; 
		c=2'b10;
		end
		else if (w[1]==0 & w[2]==1)
		begin
		Y=A; 
		Q=1; 
		c=2'b00;
		end
		
		D: 	if (w[1]==0 & w[2]==0) 
		begin
		Q=0; 
		Y=D; 
		c=2'b10;
		end
		else if (w[1]==1 & w[2]==0)
		begin
		Y=A; 
		Q=1; 
		c=2'b10;
		end
		else if (w[1]==0 & w[2]==1)
		begin
		Y=A; 
		Q=1; 
		c=2'b01;
		end
		
	endcase

// Define the sequential block
always @(negedge Resetn, posedge Clock)
	if (Resetn == 0) y <= A;
	else y <= Y;

endmodule
