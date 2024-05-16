
package accesoADatos;

import entidades.Materia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Clase para acceder a los datos de la entidad Materia en la base de datos.
 */
public class MateriaData {

    /**
     * Guarda una materia en la base de datos.
     * @param materia La materia a guardar.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    public static boolean guardarMateria(Materia materia) {
        String query = "INSERT INTO materia (idMateria, nombre, año, estado) VALUES (?, ?, ?, ?)";
        
        boolean exito = false;
        if (Db.getConexion()) {
            try {
                PreparedStatement ps = Db.conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, materia.getIdMateria());
                ps.setString(2, materia.getNombre());
                ps.setInt(3, materia.getAño());
                ps.setString(4, materia.getEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    materia.setIdMateria(rs.getInt(1));
                    exito = true;
                }
                ps.close();
            } catch (SQLException ex) {
                Db.msjError.add("MateriaData: guardarMateria -> " + ex.getMessage());
            }
        }
        
        return exito;
    }

    /**
     * Obtiene una lista de todas las materias en la base de datos.
     * @return Una lista de materias.
     */
    public static ArrayList<Materia> listarMaterias() {
        ArrayList<Materia> lista = new ArrayList<>();
        ResultSet rs = null;
        
        try {
            rs = Db.consulta("SELECT * FROM materia");
            if (rs != null) {
                while (rs.next()) {
                    int idMateria = rs.getInt("idMateria");
                    String nombre = rs.getString("nombre");
                    int año = rs.getInt("año");
                    boolean estado = rs.getBoolean("estado");

                    lista.add(new Materia(idMateria, nombre, año, estado));
                }
            }
        } catch (SQLException ex) {
            Db.msjError.add("fallo la consulta: " + ex.getMessage());
        }

        return lista;
    }
}

