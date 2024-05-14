package accesoADatos;

import entidades.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Martin Piriz
 */
public class AlumnoData {

 
    private static Alumno alumnos;

    public static boolean guardarAlumno(Alumno alumno) {
        String query = "INSERT INTO alumno (dni, apellido,nombre,fechaNacimiento,estado) VALUES (?,?,?,?,?)";
        
        boolean res = false;
        if (Db.getConexion()) {
            try {
                PreparedStatement ps = Db.conec.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, alumno.getDni());
                ps.setString(2, alumno.getApellido());
                ps.setString(3, alumno.getNombre());
                ps.setDate(4, Date.valueOf(alumno.getFechaNacimiento()));
                ps.setBoolean(5, alumno.getEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    alumno.setIdAlumno(rs.getInt(1));
                    res = true;
                }
                ps.close();
            } catch (SQLException ex) {
                Db.msjError.add("Alumnos: guardarAlumno ->" + ex.getMessage());
            }
        }
        //ver donde cerrrar la coneccion puede ser en el main
        
        return res;
    }

    public static ArrayList<Alumno> listarAlumno() {
        ArrayList<Alumno> lista = new ArrayList<>();
        ResultSet res = null;
        alumnos = null;
        try {

            res = Db.consulta("Select * from alumno");
            if (res != null) {
                while (res.next()) {
                    //`idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado`
                    int idAlumno = res.getInt("idAlumno");
                    int dni = res.getInt("dni");
                    String apellido = res.getString("apellido");
                    String nombre = res.getString("nombre");
                    LocalDate fechaNacimiento = res.getDate("fechaNacimiento").toLocalDate();
                    boolean estado = res.getBoolean("estado");

                    lista.add(new Alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado));
                }
            }

        } catch (SQLException ex) {
            Db.msjError.add("fallo la consulta: " + ex.getMessage());
        }

        return lista;
    }

    //fin
}

/*

public void guardarMascota(Mascota m){    // obj mascota sin id valido
        String query = "INSERT INTO mascota(apodo, raza, sexo, obs, activo) VALUES (?,?,?,?,?)";  //1
        
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); //2
            ps.setString(1, m.getApodo());
            ps.setString(2, m.getRaza());
            ps.setString(3, String.valueOf(m.getSexo()));
            ps.setString(4, m.getObs());
            ps.setBoolean(5, m.getActivo());
            ps.executeUpdate();     // 3
           
            ResultSet rs = ps.getGeneratedKeys();  // recupero y asigno
            if(rs.next())
                m.setId(rs.getInt(1)); //claveGenerada 
            else
                System.out.println("No se pudo tener la claveGenerada");
            ps.close();
            System.out.println("Guardado!");
        } catch (SQLException ex) {
            Logger.getLogger(MascotaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   // INSERT INTO con preparedStatement
 */
