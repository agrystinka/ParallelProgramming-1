with Text_IO, Ada.Integer_Text_IO;
use Text_IO, Ada.Integer_Text_IO;

----------Data Package Body----------
package body Data is


  --Returns matrix that is a product of matrices MA and MC
  function mulMatrix(MA, MC: in Matrix) return Matrix is
        result: Matrix;
     begin
        --Filling result with 0
        for i in 1..N loop
           for j in 1..N loop
              result(i, j) := 0;
           end loop;
        end loop;

        --Calculating the product
        for i in 1..N loop
           for j in 1..N loop
              for k in 1..N loop
                 result(i, j) := result(i, j) + MA(i,k) * MC(k, j);
              end loop;
           end loop;
        end loop;

      return result;
  end mulMatrix;

  --Returns vector that is the product of matrix MA and vector A
  function mulMatrixVec(MA: in Matrix; A: in Vector) return Vector is
        result: Vector;
  begin
        --Filling result with 0
        for i in 1..N loop
           result(i) := 0;
        end loop;

        --Calculating the product
        for i in 1..N loop
           for j in 1..N loop
              result(i) := result(i) + A(j) * MA(j,i);
           end loop;
        end loop;
        return result;
 end mulMatrixVec;

--Returns matrix that is the product of vector A and constant u
function mulVecConst(A: in Vector; u: in Integer) return Vector is
    result: Vector;
  begin
   --Filling result with 0
   for i in 1..N loop
      result(i) := 0;
   end loop;

  --Calculating the product
  for i in 1..N loop
      result(i) := result(i) + A(i) * u;
    end loop;
  return result;
end mulVecConst;


 --Returns a vector that is a result of subtraction of vector A with vector B
 function subVector(A, B: in Vector) return Vector is
    result: Vector;
 begin

   --Filling result with 0
   for i in 1..N loop
      result(i) := 0;
   end loop;
   --Calculating
    for i in 1..N loop
       result(i) := result(i) + A(i) - B(i);
    end loop;
    return result;
 end subVector;

 --Returns matrix that is the product of matrix MA and constant a
 function mulMatrixConst(MA: in Matrix; a: in Integer) return Matrix is
    result: Matrix;
 begin
   --Filling result with 0
   for i in 1..N loop
      for j in 1..N loop
         result(i, j) := 0;
      end loop;
   end loop;

    --Counting the product
    for i in 1..N loop
       for j in 1..N loop
          result(i, j) := result(i, j) + a * MA(j,i);
       end loop;
    end loop;
    return result;
 end mulMatrixConst;

 --Returns a vector that is a result of subtraction of vector A with vector B
 function sortVector(A: in Vector) return Vector is
   result: Vector;
   tmp: Integer;
   f: Integer := 1;
 begin

 --Filling result with 0
   for i in 1..N loop
     result(i) := A(i);
   end loop;

--Sort(bubble)

  --f : = 1;
  while f = 1 loop
    f := 0;
    for i in 1..N - 1 loop
      if result(i) > result (i + 1) then
        tmp :=  result(i);
        result(i) := result(i + 1);
        result(i + 1) := tmp;
        f := 1;
      end if;
    end loop;
  end loop;

  return result;
end sortVector;



----------F1: C = A -B * (MA * MC) * e
     function func1(MA, MC: in Matrix; A, B: in Vector; e: in Integer) return Vector is
        C: Vector;
     begin
        C := subVector(A, mulVecConst(mulMatrixVec(mulMatrix(MA, MC), B), e));
        return C;
     end func1;


----------F2: MF = MF * MG * k
     function func2(MF, MG: in Matrix; k: in Integer) return Matrix is
     ML: Matrix;
     begin
        ML := mulMatrixConst(mulMatrix(MF, MG), k);
        return ML;
     end func2;


----------F3: O = SORT(P) * (MR * MT)
     function func3(MR, MT: in Matrix; P: in Vector) return Vector is
        O: Vector;
     begin
        O := mulMatrixVec(mulMatrix(MR, MT), sortVector(P));
        return O;
     end func3;

----------Vector input
     procedure vectorInput(A: out Vector) is
     begin
        for i in 1..N loop
           get(A(i));
        end loop;
     end vectorInput;

  ----------Vector output
     procedure vectorOutput(A: in Vector) is
     begin
        for i in 1..N loop
           put(A(i));
           put(" ");
        end loop;
        Put_Line("");
     end vectorOutput;

----------Matrix input
     procedure matrixInput(MA: out Matrix) is
     begin
        for i in 1..N loop
           for j in 1..N loop
              get(MA(i, j));
           end loop;
        end loop;
     end matrixInput;

----------Matrix output
     procedure matrixOutput(MA: in Matrix) is
     begin
        for i in 1..N loop
           for j in 1..N loop
              put(MA(i, j));
              put(" ");
           end loop;
           Put_Line("");
        end loop;
     end matrixOutput;

----------Fill the vector A with 1, 2, 3
     procedure fillVector(A: out Vector) is
     m : Integer := 1;
     begin
        for i in 1..N loop
           A(i) := m;
           m := m + 1;
        end loop;
     end fillVector;

----------Fill the matrix MA with 1, 2, ..., 9
     procedure fillMatrix(MA: out Matrix) is
     l : Integer := 1;
     begin
        for i in 1..N loop
           for j in 1..N loop
              MA(i, j) := l;
              l := l + 1;
           end loop;
        end loop;
     end fillMatrix;

end Data;
