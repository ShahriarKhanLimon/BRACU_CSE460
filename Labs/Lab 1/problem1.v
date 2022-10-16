module problem1(A, Y, Z); 

input[2:0] A;
output reg[1:0] Y; 
output reg Z;

always @ (*) 

begin
if(A[1]==A[2] & A[2]!=A[0])
begin
Y=2'b00;
Z= A[0];
end

if(A[0]==A[2] & A[2]!=A[1])
begin 
Y=2'b01;
Z=A[1];
end

if(A[0]==A[1] & A[1]!=A[2])
begin 
Y=2'b10;
Z=A[2];
end

if(A[0]==A[1] & A[1]==A[2])
begin 
Y=2'b11;
end

end

endmodule
