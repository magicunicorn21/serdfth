package view;

import Module.Expression.ArithExp;
import Module.Expression.ValueExp;
import Module.Expression.VarExp;
import Module.Stmt.*;
import Module.Type.BoolType;
import Module.Type.IntType;
import Module.Value.BoolValue;
import Module.Value.IntValue;
import controller.Controller;
import org.w3c.dom.ls.LSInput;
import repository.MyRepository;
import repository.Repository;
import Module.MyException;
import Module.PrgState;

import java.util.Scanner;

public class View {
    public static void main(String[] args) throws MyException
    {
        Scanner p = new Scanner(System.in);
        System.out.println("Choose program:\n2 - int v; v=2;Print(v)\n1 : int a;int b; a=2+3*5;b=a+1;Print(b)\n3 - bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v)");
        int choice = p.nextInt();
        if (choice == 1)
        {
            Repository repo1 = new Repository("/Users/mara.dobse/Desktop/da.txt");
            Controller ctrl1 = new Controller(repo1);
            IStmt e1 = new CompStmt(new VarDeclStmt("v", new IntType()), new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))), new PrintStmt(new VarExp("v"))));
            PrgState p1 = new PrgState();
            p1.getStk().push(e1);
            repo1.addPrgState(p1);
            while (choice != 0)
            {
                System.out.println("Choose steps method:\n1 - all steps\n2 - one step\n0 - stop the program\n");
                choice = p.nextInt();
                if (choice == 1)
                {
                    ctrl1.allStep();
                    return;
                }
                if (choice == 2)
                {
                    ctrl1.oneStep(repo1.getState());
                    if (repo1.getState().getStk().isEmpty())
                        return;
                }
            }

        }
        else if (choice == 2)
        {
            Repository repo2 = new Repository("Desktop/da.txt");
            Controller ctrl2 = new Controller(repo2);
            IStmt e2 =  new CompStmt( new VarDeclStmt("a",new IntType()), new CompStmt(new VarDeclStmt("b",new IntType()), new CompStmt(new AssignStmt("a", new ArithExp(new ValueExp(new IntValue(2)),new ArithExp(new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)), 3), 1)), new CompStmt(new AssignStmt("b",new ArithExp(new VarExp("a"), new ValueExp(new IntValue(1)), 1)), new PrintStmt(new VarExp("b"))))));
            PrgState p2 = new PrgState();
            p2.getStk().push(e2);
            repo2.addPrgState(p2);
            while (choice != 0)
            {
                System.out.println("Choose steps method:\n1 - all steps\n2 - one step\n0 - stop the program\n");
                choice = p.nextInt();
                if (choice == 1)
                    ctrl2.allStep();
                if (choice == 2)
                    ctrl2.oneStep(repo2.getState());
            }        }
        else
        {
            Repository repo3 = new Repository("Desktop/da.txt");
            Controller ctrl3 = new Controller(repo3);
            IStmt e3 = new CompStmt(new VarDeclStmt("a",new BoolType()), new CompStmt(new VarDeclStmt("v", new IntType()), new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
            PrgState p3 = new PrgState();
            p3.getStk().push(e3);
            repo3.addPrgState(p3);
            while (choice != 0)
            {
                System.out.println("Choose steps method:\n1 - all steps\n2 - one step\n0 - stop the program\n");
                choice = p.nextInt();
                if (choice == 1)
                    ctrl3.allStep();
                if (choice == 2)
                    ctrl3.oneStep(repo3.getState());
            }        }
    }
}
