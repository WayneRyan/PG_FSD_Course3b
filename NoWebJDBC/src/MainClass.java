import java.sql.*;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded...");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/university_batch", "root", "1234567");
            System.out.println("Connected to database...");
//            Statement stmt = con.createStatement();
//            int res = stmt.executeUpdate("insert into employee values(5, 'Balaji', 32000)"); // DML Insert, Delete and Update
//            if(res>0){
//                System.out.println("Record inserted successfully");
//            }

//            int res = stmt.executeUpdate("delete from employee where id = 1");
//            if(res>0){
//                System.out.println("record deleted successfully");
//            }else {
//                System.out.println("record not present");
//            }

//            int res = stmt.executeUpdate("update employee set salary = 45000 where id = 2");
//            if(res>0){
//                System.out.println("record updated successfully");
//            }else {
//                System.out.println("record not present");
//            }

//            ResultSet rs = stmt.executeQuery("select * from employee");
//            while(rs.next()) {
//                System.out.println(" id is "+rs.getInt(1)+" Name is "+rs.getString(2)+" Salary is "+rs.getFloat(3));
//            }


//            PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter the id: ");
//            int id = sc.nextInt();
//            pstmt.setInt(1,id);
//            System.out.println("Enter the name: ");
//            String name = sc.next();
//            pstmt.setString(2,name);
//            System.out.println("Enter the salary: ");
//            float salary = sc.nextFloat();
//            pstmt.setFloat(3,salary);
//            int res = pstmt.executeUpdate();
//            if(res>0){
//                System.out.println("Record inserted successfully...");
//            }

//            PreparedStatement pstmt = con.prepareStatement("delete from employee where id = ?");
//            System.out.println("Enter the id to delete the record: ");
//            int id = sc.nextInt();
//            pstmt.setInt(1,id);
//            int res = pstmt.executeUpdate();
//            if(res>0){
//                System.out.println("Record deleted");
//            }else{
//                System.out.println("Record not present");
//            }

            PreparedStatement pstmt = con.prepareStatement("update employee set salary = ? where id = ?");
            System.out.println("Enter the id to update the record: ");
            int id = sc.nextInt();
            pstmt.setInt(2,id);
            System.out.println("Enter the salary");
            float salary = sc.nextFloat();
            pstmt.setFloat(1, salary);
            int res = pstmt.executeUpdate();
            if(res>0){
                System.out.println("Record updated successfully");
            }else{
                System.out.println("Record not present");
            }

            pstmt.close();
            con.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
