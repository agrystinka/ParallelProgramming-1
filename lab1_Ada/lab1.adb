with Ada.Text_IO, Ada.Integer_Text_IO, Data;
use  Ada.Text_IO, Ada.Integer_Text_IO;

--with System.Multiprocessors;
--use System.Multiprocessors;

--package Ada.Synchronuos_Task_Control;
-----------Lab1-----------
--Humeniuk Inna
--IP-74
--Task(3)
--C = A -B * (MA * MC) * e
--MF = MF * MG * k
--O = SORT(P) * (MR * MT)

procedure lab1 is
  
  --CPU0: CPU-Range:= 0;

   --Size of Vector and Matrix
   N: Integer := 3;

   --Data package initialization
   package DataN is new Data(N);
   use DataN;

  procedure tasks is
    task T1 is
       --//  pragma CPU(CPU1);
    			pragma Priority(3);
    			pragma Storage_Size(100000);
    end T1;

    task T2    is
       --  pragma CPU(CPU2);
    			pragma Priority(2);
    			pragma Storage_Size(300_000_000);
    end T2;

    task T3 is
       --  pragma CPU(CPU3);
    			pragma Priority(5);
    			pragma Storage_Size(300_000_000);
    end T3;

    --Task T1 body
    task body T1 is
       MA, MC: Matrix;
       A, B, C: Vector;
       e: Integer;
    begin
       Put_Line("T1 started");
       --Filling
       Put_Line("Filling Vectors A, B with 1, 2, 3");
       fillVector(A);
       fillVector(B);
       Put_Line("Filling Matrices MA, MC with 1, 2, ..., 9");
       fillMatrix(MA);
       fillMatrix(MC);
       delay 2.0;
       Put_Line("Input Integer e");
       get(e);
       --Computing the result
       C := func1(MA, MC, A, B, e);
       --Output
       --vectorOutput(C);
       Put_Line("T1 finished");
    end T1;

    --Task T2 body
    task body T2 is
       MF, MG: Matrix;
       k: Integer;
    begin
       Put_Line("T2 started");
       --Input
       Put_Line("Filling Matrices MF, MG with 1, 2, ..., 9");
       fillMatrix(MF);
       fillMatrix(MG);
       Put_Line("Input Integer k");
     --  k := 8;
       get(k);
       --Computing the result
       MF := func2(MF, MG, k);
       --Output
       --matrixOutput(MF);
       Put_Line("T2 finished");
    end T2;

    --Task T3 body
    task body T3 is
       MR, MT: Matrix;
       O, P: Vector;
    begin
       Put_Line("T3 started");
       --Input
       Put_Line("Input Vector P");
       vectorInput(P);
       Put_Line("Filling Matrices MR, MT with 1, 2, ..., 9");
       fillMatrix(MR);
       fillMatrix(MT);
       --Computing the result
       O := func3(MR, MT, P);
       --Output
     --  vectorOutput(O);
       Put_Line("T3 finished");
    end T3;

  begin
    null;
  end tasks;


begin
  --Creating of semaphores
   Put_Line("Main started");
-- call tasks in procedure after creating semaphores
   tasks;

   Put_Line("Main finished");
end lab1;
