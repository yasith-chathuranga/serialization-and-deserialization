package lk.ijse.gdse68.serializationanddeserialization;

import java.io.*;

public class EmployeeSerializationDemo {

    public static void main(String[] args) {
        Employee employee = new Employee(101, "Yasith Chathuranga", 200000.00);

        //serialization
        try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(employee);
            System.out.println("Serialized data is saved in employee.ser");
        } catch (IOException i){
            i.printStackTrace();
        }

        //deserialization
        try (FileInputStream fileIn = new FileInputStream("employee.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            employee = (Employee) in.readObject();
            System.out.println("Deserialized Employee: ");
            System.out.println(employee);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
    }
}
