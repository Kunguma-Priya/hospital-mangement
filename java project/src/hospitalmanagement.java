import java.sql.*;
import java.util.Scanner;

public class hospitalmanagement {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Priya1604.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            while (true) {
                System.out.println("\nHospital Management System");
                System.out.println("1. Add Patient");
                System.out.println("2. View Patients");
                System.out.println("3. Delete Patient");
                System.out.println("4. Add Doctor");
                System.out.println("5. View Doctors");
                System.out.println("6. Delete Doctor");
                System.out.println("7. Add Medicine");
                System.out.println("8. View Medicines");
                System.out.println("9. Delete Medicine");
                System.out.println("10. Add Lab Test");
                System.out.println("11. View Lab Tests");
                System.out.println("12. Delete Lab Test");
                System.out.println("13. Add Lab Equipment");
                System.out.println("14. View Lab Equipment");
                System.out.println("15. Delete Lab Equipment");
                System.out.println("16. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addPatient(conn, scanner);
                        break;
                    case 2:
                        viewPatients(conn);
                        break;
                    case 3:
                        deletePatient(conn, scanner);
                        break;
                    case 4:
                        addDoctor(conn, scanner);
                        break;
                    case 5:
                        viewDoctors(conn);
                        break;
                    case 6:
                        deleteDoctor(conn, scanner);
                        break;
                    case 7:
                        addMedicine(conn, scanner);
                        break;
                    case 8:
                        viewMedicines(conn);
                        break;
                    case 9:
                        deleteMedicine(conn, scanner);
                        break;
                    case 10:
                        addLabTest(conn, scanner);
                        break;
                    case 11:
                        viewLabTests(conn);
                        break;
                    case 12:
                        deleteLabTest(conn, scanner);
                        break;
                    case 13:
                        addLabEquipment(conn, scanner);
                        break;
                    case 14:
                        viewLabEquipment(conn);
                        break;
                    case 15:
                        deleteLabEquipment(conn, scanner);
                        break;
                    case 16:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deletePatient(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Patient deleted successfully.");
        }
    }

    private static void deleteDoctor(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Doctor ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String sql = "DELETE FROM doctors WHERE doctor_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Doctor deleted successfully.");
        }
    }

    private static void deleteMedicine(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Medicine ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String sql = "DELETE FROM medicines WHERE medicine_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Medicine deleted successfully.");
        }
    }

    private static void deleteLabTest(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Lab Test ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String sql = "DELETE FROM lab_tests WHERE test_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Lab Test deleted successfully.");
        }
    }

    private static void deleteLabEquipment(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Equipment ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        String sql = "DELETE FROM lab_equipment WHERE equipment_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Lab Equipment deleted successfully.");
        }
    }
    private static void addPatient(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Sex (M/F): ");
        String sex = scanner.nextLine();
        System.out.print("Enter Disease: ");
        String disease = scanner.nextLine();
        System.out.print("Enter Type (Inpatient/Outpatient): ");
        String type = scanner.nextLine();

        String sql = "INSERT INTO patients (name, age, sex, disease, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, sex);
            stmt.setString(4, disease);
            stmt.setString(5, type);
            stmt.executeUpdate();
            System.out.println("Patient added successfully.");
        }
    }

    private static void addDoctor(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Working Time: ");
        String workingTime = scanner.nextLine();

        String sql = "INSERT INTO doctors (name, age, department, qualification, salary, working_time) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, department);
            stmt.setString(4, qualification);
            stmt.setDouble(5, salary);
            stmt.setString(6, workingTime);
            stmt.executeUpdate();
            System.out.println("Doctor added successfully.");
        }
    }

    private static void addMedicine(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Medicine Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Cost: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        String sql = "INSERT INTO medicines (medicine_name, cost, expiry_date, stock) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, cost);
            stmt.setString(3, expiryDate);
            stmt.setInt(4, stock);
            stmt.executeUpdate();
            System.out.println("Medicine added successfully.");
        }
    }

    private static void addLabTest(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Lab Test Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Test Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        String sql = "INSERT INTO lab_tests (test_name, test_price) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.executeUpdate();
            System.out.println("Lab Test added successfully.");
        }
    }

    private static void addLabEquipment(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Equipment Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Cost: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Working Condition (Good/Bad): ");
        String condition = scanner.nextLine();

        String sql = "INSERT INTO lab_equipment (equipment_name, cost, working_condition) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setDouble(2, cost);
            stmt.setString(3, condition);
            stmt.executeUpdate();
            System.out.println("Lab Equipment added successfully.");
        }
    }
    private static void viewPatients(Connection conn) throws SQLException {
        String sql = "SELECT * FROM patients";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nPatients List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patient_id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Sex: " + rs.getString("sex") + ", Disease: " + rs.getString("disease") + ", Type: " + rs.getString("type"));
            }
        }
    }

    private static void viewDoctors(Connection conn) throws SQLException {
        String sql = "SELECT * FROM doctors";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nDoctors List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("doctor_id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age") + ", Department: " + rs.getString("department") + ", Qualification: " + rs.getString("qualification") + ", Salary: " + rs.getDouble("salary") + ", Working Time: " + rs.getString("working_time"));
            }
        }
    }

    private static void viewMedicines(Connection conn) throws SQLException {
        String sql = "SELECT * FROM medicines";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nMedicines List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("medicine_id") + ", Name: " + rs.getString("medicine_name") + ", Cost: " + rs.getDouble("cost") + ", Expiry Date: " + rs.getDate("expiry_date") + ", Stock: " + rs.getInt("stock"));
            }
        }
    }

    private static void viewLabTests(Connection conn) throws SQLException {
        String sql = "SELECT * FROM lab_tests";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nLab Tests List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("test_id") + ", Name: " + rs.getString("test_name") + ", Price: " + rs.getDouble("test_price"));
            }
        }
    }

    private static void viewLabEquipment(Connection conn) throws SQLException {
        String sql = "SELECT * FROM lab_equipment";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nLab Equipment List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("equipment_id") + ", Name: " + rs.getString("equipment_name") + ", Cost: " + rs.getDouble("cost") + ", Condition: " + rs.getString("working_condition"));
            }
        }
    }
}
