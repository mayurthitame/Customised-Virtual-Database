import java.lang.*;
import java.util.*;

// create table student(RID int, Name varchar(255), Salary int);
// Database table / schema
class Student
{
    public int RID;
    public String Name;
    public int Salary;

    private static int Generator;

    static
    {
        Generator = 0;
    }

    public Student(String str, int value)
    {
        this.RID = ++Generator;
        this.Name = str;
        this.Salary = value;
    }

    public void DisplayData()
    {

        // System.out.println("-------------------------------------------------------");
        System.out.println(this.RID + "\t\t" + this.Name + "\t\t" + this.Salary);
        //  System.out.println("-------------------------------------------------------");
    }
}

class DBMS
{
   public LinkedList <Student> lobj;

    public DBMS()
    {
        lobj = new LinkedList<>();
    }

    public void StartDBMS()
    {
        Scanner scanobj = new Scanner(System.in);

        System.out.println("Marvellous customised DBMS started succesfully....");
        String Query = "";

        while(true)
        {
            System.out.print("Marvellous DBMS console >");
            Query = scanobj.nextLine();
            Query=Query.toLowerCase();
            String tokens[] = Query.split(" ");
            int QuerySize = tokens.length;
                try
                {
                        
                    if(QuerySize == 1)
                    {
                        if("help".equals(tokens[0]))
                        {
                            System.out.println("------------------------------------------------------------------");
                            System.out.println("------------------------------------------------------------------");
                            System.out.println("This application is used to demonstrates the customised DBMS");
                            System.out.println("Terminate DBMS:         Exit");
                            System.out.println("Display all data :      select * from student");
                            System.out.println("Insert data :           insert into student s_Name s_Salary");
                            System.out.println("Display data by Name    select * from student where name _____");
                            System.out.println("Display data by RID:    select * from student where rollno ____");
                            System.out.println("Update data by RID:     update student set Name _____ salary ____ where rid __");
                            System.out.println("delete data by RID:     delete rid ___");
                            System.out.println("delete data by Name:    delete name ___");
                            System.out.println("Display minimum salary: select min salary from student");
                            System.out.println("Display maximum salary: select max salary from student");
                            System.out.println("Display total salary: select sum salary from student");
                            System.out.println("Display average salary: select avg salary from student");
    
                            System.out.println("------------------------------------------------------------------");
                            System.out.println("------------------------------------------------------------------");
                        }
                        else if("exit".equals(tokens[0]))
                        {
                            System.out.println("Thank you for using Marvellous DBMS");
                            break;
                        }
                        else
                        {
                            System.out.println("Invalid Query.....Try Again !!!");
                        }
                    }
                    else if(QuerySize == 2)
                    {

                    }
                        //insert into student piyush 54444
                        //select min salary from student
                        //select max salary from student
                        //select sum salary from student
                        //select avg salary from student
    

                    else if(QuerySize==5)
                    {
                        if("insert".equals(tokens[0]))
                        {
                            InsertData(tokens[3],Integer.parseInt(tokens[4]));
                        }
                        else if("select".equals(tokens[0]) && "max".equals(tokens[1]))
                        {
                            AggregateMax();
                        }
                        else if("select".equals(tokens[0]) && "min".equals(tokens[1]))
                        {
                            AggregateMin();
                        }
                        else if("select".equals(tokens[0]) && "sum".equals(tokens[1]))
                        {
                            AggregateSum();
                        }
                        else if("select".equals(tokens[0]) && "avg".equals(tokens[1]))
                        {
                            AggregateAvg();
                        }
                    }
                        //select * from student
                    else if(QuerySize==4)
                    {
                        if("select".equals(tokens[0]))
                        {
                            if("*".equals(tokens[1]))
                            {
                                DisplayAll();
                            }
                            
                        }
                    }
                    
                    //update student set Name Ram salary 66000 where rid 2
                    else if(QuerySize==10)
                    {
                        if("update".equals(tokens[0])&& "set".equals(tokens[2]))
                        {
                            UpdateSpecific(Integer.parseInt(tokens[9]),tokens[4],Integer.parseInt(tokens[6]));
                        }
                    }
                    //select * from student where Rollno 3
                    else if(QuerySize==7)
                    {
                        if("select".equals(tokens[0]))
                        {
                            if("rollno".equals(tokens[5]))
                            {
                                DisplaySpecific(Integer.parseInt(tokens[6]));   
                            }
                            else if("name".equals(tokens[5]))
                            {
                                DisplaySpecific(tokens[6]);
                            }
                        }
                    }
                    //delete rid ___
                    else if(QuerySize==3)
                    {
                        if("delete".equals(tokens[0]))
                        {
                            if("rid".equals(tokens[1]))
                            {
                                DeleteSpecific(Integer.parseInt(tokens[2]));   
                            }
                            else if("name".equals(tokens[1]))
                            {
                                DeleteSpecific(tokens[2]);
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Invalid Query.....Try Again !!!");
                    }
                
                }
                catch(Exception e)
                {
                    System.out.println("!!!!......Please provide valid rollno /name....!!!!!");
                }
        }
    }

    // Insert into query
    public void InsertData(String str, int value)
    {
        Student sobj = new Student(str,value);
        lobj.add(sobj);
    }

    // Display all without condition
    public void DisplayAll()
    {
        System.out.println("-------------------------------------------------------");
        System.out.println("Roll No"+"\t\t"+"Name"+"\t\t"+"Salary");
        System.out.println("-------------------------------------------------------");
        for(Student sref : lobj)
        {
            sref.DisplayData();
        }
        System.out.println("-------------------------------------------------------");
    }

    // Display by RID
    public void DisplaySpecific(int rid)
    {
        System.out.println("-------------------------------------------------------");
        System.out.println("Roll No"+"\t\t"+"Name"+"\t\t"+"Salary");
        System.out.println("-------------------------------------------------------");
         for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.DisplayData();
                break;
            }
            
        }
        System.out.println("-------------------------------------------------------");
    }
    public void UpdateSpecific(int rid,String str,int value)
    {
        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                sref.Name=str;
                sref.Salary=value;
                break;
            }
        }
    }

    // Display by name
    public void DisplaySpecific(String str)
    {
        System.out.println("-------------------------------------------------------");
        System.out.println("Roll No"+"\t\t"+"Name"+"\t\t"+"Salary");
        System.out.println("-------------------------------------------------------");
         for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                sref.DisplayData();
            }
        }
        System.out.println("-------------------------------------------------------");
    }

    // Delete by RID
    public void DeleteSpecific(int rid)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(sref.RID == rid)
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    // Delete by Name
    public void DeleteSpecific(String str)
    {
        int index = 0;

        for(Student sref : lobj)
        {
            if(str.equals(sref.Name))
            {
                lobj.remove(index);
                break;
            }
            index++;
        }
    }

    public void AggregateMax()
    {
        int iMax = 0;
        Student temp = null;

        for(Student sref : lobj)
        {
            if(sref.Salary > iMax)
            {
                iMax = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having maximum salary : ");
        temp.DisplayData();
    }

    public void AggregateMin()
    {
        int iMin = (lobj.getFirst()).Salary;
        Student temp = lobj.getFirst();

        for(Student sref : lobj)
        {
            if(sref.Salary < iMin)
            {
                iMin = sref.Salary;
                temp = sref;
            }
        }

        System.out.println("Information of student having minimum salary : ");
        temp.DisplayData();
    }

    public void AggregateSum()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Summation of salaries is : "+ iSum);
    }

    public void AggregateAvg()
    {
        long iSum = 0;

        for(Student sref : lobj)
        {
            iSum = iSum + sref.Salary;
        }

        System.out.println("Average salary is : "+ iSum / (lobj.size()));
    }

    public void AggregateCount()
    {
         System.out.println("Count is : "+lobj.size());
    }
}

class program371
{
    public static void main(String arg[])
    {
        DBMS dobj = new DBMS();

        dobj.StartDBMS();
    }
}