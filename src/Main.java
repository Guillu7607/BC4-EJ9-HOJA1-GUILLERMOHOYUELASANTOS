import java.sql.*;

public class Main {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "RIBERA";
    private static final String PASS = "ribera";

    public static void main(String[] args) {
        mostrarSalarioPromedio();
    }
    public static void mostrarSalarioPromedio() {
        String sql = "SELECT AVG(salaio) AS promedio FROM empleado";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                double promedio = rs.getDouble("promedio");
                System.out.printf("%nEl salario promedio de la empresa es: %.2f€%n", promedio);
            }
        } catch (SQLException e) {
            System.err.println("Error al calcular el promedio: " + e.getMessage());
        }
    }
}