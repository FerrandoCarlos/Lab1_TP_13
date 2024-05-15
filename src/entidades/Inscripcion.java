
package entidades;
/**
 *@author Ferrando Carlos
 * @author Martin
 */
public class Inscripcion {
    private int inscripcion;
    private Alumno alumno;
    private Materia materia;
    private double nota;

    public Inscripcion(int inscripcion, Alumno alumno, Materia materia, double nota) {
        this.inscripcion = inscripcion;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion() {
    }

    public Inscripcion(double nota) {
        this.nota = nota;
    }

    public int getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(int inscripcion) {
        this.inscripcion = inscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
