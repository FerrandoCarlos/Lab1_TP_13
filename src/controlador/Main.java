
package controlador;

import accesoADatos.AlumnoData;
import accesoADatos.Db;
import accesoADatos.InscripcionData;
import accesoADatos.MateriaData;
import entidades.Alumno;
import entidades.Inscripcion;
import entidades.Materia;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Ferrando Carlos | Martin Piriz | Ariel Zurita | Agustin Jofre
 */
public class Main {

   
    public static void main(String[] args) {
        
        /*Agustin Jofre*/
        //Crear alumnos
        Alumno agustin=new Alumno(33444555,"Jofre","Agustin",LocalDate.of(1996, 3, 11),true);
        Alumno martin=new Alumno(35666777,"Piriz","Martin",LocalDate.of(1990, 9, 20),true);
        Alumno carlos=new Alumno(32555666,"Ferrando","Carlos",LocalDate.of(1993, 4, 20),true);
        Alumno ariel=new Alumno(35888999,"Zurita","Ariel",LocalDate.of(1990, 7, 5),true);
        
      
//        //Insertar alumnos en tabla alumno
//        AlumnoData.guardarAlumno(agustin);
//        AlumnoData.guardarAlumno(martin);
//        AlumnoData.guardarAlumno(carlos);
//        AlumnoData.guardarAlumno(ariel);
        
        //Crear Materias
         Materia materia1 = new Materia("EDA",1,true);
         Materia materia2 = new Materia("LAB",1,true);
         Materia materia3 = new Materia("Matematica",2,true);
         Materia materia4 = new Materia("Ingles",2,true);
        
//        //Insertar materias en tabla materia
////        MateriaData.guardarMateria(materia1);
////        MateriaData.guardarMateria(materia2);
////        MateriaData.guardarMateria(materia3);
////        MateriaData.guardarMateria(materia4);
        
        
//        //Inscribir alumnos
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData Idata = new InscripcionData();
        
//        //alumno agustin
        
//        Alumno a = ad.buscarAlumno(5);
//        Materia mat = md.buscarMateria(3);
//        Materia mat2 = md.buscarMateria(4);
//        Inscripcion insc = new Inscripcion(a,mat,7);
//        Inscripcion insc2 = new Inscripcion(a,mat2,8);
//        Idata.guardarInscripcion(insc);
//        Idata.guardarInscripcion(insc2);
        
        
//        alumno martin

//        Alumno m = ad.buscarAlumno(6);
//        Materia mat3 = md.buscarMateria(5);
//        Materia mat4 = md.buscarMateria(4);
//        Inscripcion insc3 = new Inscripcion(m,mat3,9);
//        Inscripcion insc4 = new Inscripcion(m,mat4,8);
//        Idata.guardarInscripcion(insc3);
//        Idata.guardarInscripcion(insc4);
        
        
//        alumno carlos

//        Alumno c = ad.buscarAlumno(7);
//        Materia mat5 = md.buscarMateria(2);
//        Materia mat6 = md.buscarMateria(3);
//        Inscripcion insc5 = new Inscripcion(c,mat5,10);
//        Inscripcion insc6 = new Inscripcion(c,mat6,9);
//        Idata.guardarInscripcion(insc5);
//        Idata.guardarInscripcion(insc6);


//        Listar alumnos con nota superior a 8

//    ArrayList<Alumno> alumnosConNotaSuperior = ad.listarAlumnosYNota();
//
//    if (!alumnosConNotaSuperior.isEmpty()) {
//        System.out.println("Alumnos con nota superior a 8: ");
//        for (Alumno alumno : alumnosConNotaSuperior) {
//            System.out.println(alumno);
//        }
//    } else {
//        System.out.println("No se encontraron alumnos con nota superior a 8.");
//    }

        
//      Desinscribir a un alumno de una materia

        InscripcionData.eliminarInscripcion(5, 4);



////
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
       
       /*Ferrando Carlos*/
        
        
        //errores capturas
          if(Db.msjError.size()>0){
             System.out.println("\n\nErrores");
             Db.mostrarErrores();
       }
        
    }

}
