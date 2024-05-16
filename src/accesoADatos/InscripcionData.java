package accesoADatos;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

<<<<<<< Updated upstream
import entidades.Inscripcion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Martin
 */
public class InscripcionData {
    /**
     * Guarda una inscripción en la base de datos.
     * @param inscripcion La inscripción a guardar.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    
    public static boolean guardarInscripcion(Inscripcion inscripcion){
        String query = "INSERT INTO inscripcion (idAlumno,idMateria,nota) VALUES (?,?,?)";  
        boolean res = false;
        if (Db.getConexion()) {
            try {
                PreparedStatement ps = Db.conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
              
                ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
                ps.setInt(2, inscripcion.getMateria().getIdMateria());
                ps.setDouble(3, inscripcion.getNota());
           
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                  inscripcion.setIdInscripcion(rs.getInt(1));
                    res = true;
                }
                ps.close();
            } catch (SQLException ex) {
                Db.msjError.add("Inscripción: guardarInscripcion ->" + ex.getMessage());
            }
        }
        return res; 
    }
    
    public static boolean actulizarNota(int idAlumno,int idMateria, double nota){
        String query = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? and idMateria = ?";
        
         boolean res = false;
        if (Db.getConexion()) {
            try {
                PreparedStatement ps = Db.conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
              
                ps.setDouble(1, nota);
                ps.setInt(2, idAlumno);
                ps.setInt(3, idMateria);
           
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Nota Actualizada");
                    res = true;
                }
                ps.close();
            } catch (SQLException ex) {
                Db.msjError.add("Inscripción: actualizarNota ->" + ex.getMessage());
            }
        }
        return res;
    }
=======
public class InscripcionData {
    private Connection cc = null;
    
    
    public InscripcionData(){

    }
    
    
    public void guardarInscripcion(Inscripcion insc){
    
        String sql = "INSERT INTO inscripcion(idAlumno, idMateria, nota) VALUES (?, ?, ?)";
        
         boolean resultado = false;
        if (Db.getConexion()) {
            try {
                PreparedStatement ps = Db.conec.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, insc.getAlumno().getIdAlumno());
                ps.setInt(2, insc.getMateria().getIdMateria());
                ps.setDouble(3, insc.getNota());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    insc.setIdInscripcion(rs.getInt(1));
                    resultado = true;
                }
                ps.close();
            } catch (SQLException ex) {
                Db.msjError.add("MateriaData: guardarMateria -> " + ex.getMessage());
            }
        }
    }
    
    public static boolean eliminarInscripcion(int idAlumno, int idMateria) {
    String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
    
    boolean exito = false;
    if (Db.getConexion()) {
        try {
            PreparedStatement ps = Db.conec.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                exito = true;
            }
            ps.close();
        } catch (SQLException ex) {
            Db.msjError.add("InscripcionData: eliminarInscripcion -> " + ex.getMessage());
        }
    }
    
    return exito;
}
>>>>>>> Stashed changes
}
