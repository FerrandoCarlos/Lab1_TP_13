
package controlador;

import accesoADatos.AlumnoData;
import accesoADatos.Db;
import entidades.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Ferrando Carlos
 */
public class Main {

   
    public static void main(String[] args) {
        
       
        Alumno alumnos1=new Alumno(34877112,"piriz","martin",LocalDate.of(1989, 10, 26),true);
        Alumno alumnos2=new Alumno(35878112,"piriz","martin",LocalDate.of(1999, 9, 12),true);
        Alumno alumnos3=new Alumno(24877112,"piriz","martin",LocalDate.of(1990, 12, 20),false);
        
        AlumnoData.guardarAlumno(alumnos1);
        AlumnoData.guardarAlumno(alumnos2);
        AlumnoData.guardarAlumno(alumnos3);
        
       ArrayList<Alumno> lista=  AlumnoData.listarAlumno();
       if(lista.size()>0){
           
       }else{
           System.out.println("No hay alumnos");
       } 
       
        
    }

}
