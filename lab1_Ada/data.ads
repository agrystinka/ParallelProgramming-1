----------Data Package Specification----------
generic
   N : Integer;

package Data is

   --Vector and Matrix private types declaration
   type Vector is private;
   type Matrix is private;


   ----------F1: C = A -B * (MA * MC) * e
   function func1(MA, MC: in Matrix; A, B: in Vector; e: in Integer) return Vector;


   ----------F2: MF = MF * MG * k
   function func2(MF, MG: in Matrix; k: in Integer) return Matrix;


   ----------F3: O = SORT(P) * (MR * MT)
   function func3(MR, MT: in Matrix; P: in Vector) return Vector;


   --function sortVector( P: in Vector) return Vector;


   --Vector input from console
   procedure vectorInput(A: out Vector);

   --Vector output in console
   procedure vectorOutput(A: in Vector);

   --Matrix input from console
   procedure matrixInput(MA: out Matrix);

   --Matrix output in console
   procedure matrixOutput(MA: in Matrix);

   --Fill the vector with k's
   procedure fillVector(A: out Vector);

   --Fill the matrix with k's
   procedure fillMatrix(MA: out Matrix);

   --Vector and Matrix private types definition
private
   type Vector is array (1..N) of Integer;
   type Matrix is array (1..N, 1..N) of Integer;

end Data;
