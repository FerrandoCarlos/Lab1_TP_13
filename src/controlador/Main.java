
package controlador;

import accesoADatos.AlumnoData;
import accesoADatos.Db;
import entidades.Alumno;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Ferrando Carlos | Martin Piriz | Ariel Zurita | Agustin Jofre
 */
public class Main {

   
    public static void main(String[] args) {
        
       /* Martin Piriz*/
        /*Alumno alumnos1=new Alumno(34877112,"piriz","martin",LocalDate.of(1989, 10, 26),true);
        Alumno alumnos2=new Alumno(32564,"piriz","martin",LocalDate.of(1999, 9, 12),true);
        Alumno alumnos3=new Alumno(152659,"piriz","martin",LocalDate.of(1990, 12, 20),false);
        
        AlumnoData.guardarAlumno(alumnos1);
        AlumnoData.guardarAlumno(alumnos2);
        AlumnoData.guardarAlumno(alumnos3);
        
       ArrayList<Alumno> lista=  AlumnoData.listarAlumno();
       if(lista.size()>0){
           System.out.println("Listado de alumnos:\n");
           for (Alumno alumno : lista) {
               System.out.println(alumno);
           }
       }else{
           System.out.println("No hay alumnos");
       } 
         if(Db.msjError.size()>0){
             System.out.println("\n\nErrores");
             Db.mostrarErrores();
       }
       
      */
       
       
        
        
        //errores capturas
          if(Db.msjError.size()>0){
             System.out.println("\n\nErrores");
             Db.mostrarErrores();
       }
        
    }

}
