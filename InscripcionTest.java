import junit.framework.Assert;
import junit.framework.TestCase;

public class InscripcionTest extends TestCase {

    public void testInscripcionSinMaterias() {
        Alumno alumno = new Alumno();
        Materia[] materiasSolicitadas = new Materia[0];
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(materiasSolicitadas);
        
        Assert.assertTrue(inscripcion.aprobada());
    }

    public void testInscripcionConMateriaSinCorrelativas() {
        Alumno alumno = new Alumno();
        Materia materia = new Materia();
        Materia[] materiasSolicitadas = {materia};
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(materiasSolicitadas);
        
        Assert.assertTrue(inscripcion.aprobada());
    }

    public void testInscripcionConCorrelativasAprobadas() {
        // Crear materias
        Materia correlativa = new Materia();
        Materia materia = new Materia();
        materia.setCorrelativas(new Materia[]{correlativa});
        
        // Crear alumno con la correlativa aprobada
        Alumno alumno = new Alumno();
        alumno.setMateriasAprobadas(new Materia[]{correlativa});
        
        // Crear inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(new Materia[]{materia});
        
        Assert.assertTrue(inscripcion.aprobada());
    }

    public void testInscripcionConCorrelativasNoAprobadas() {
        // Crear materias
        Materia correlativa = new Materia();
        Materia materia = new Materia();
        materia.setCorrelativas(new Materia[]{correlativa});
        
        // Crear alumno sin materias aprobadas
        Alumno alumno = new Alumno();
        alumno.setMateriasAprobadas(new Materia[0]);
        
        // Crear inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(new Materia[]{materia});
        
        Assert.assertFalse(inscripcion.aprobada());
    }

    public void testInscripcionConMultiplesMaterias() {
        // Crear materias
        Materia correlativa1 = new Materia();
        Materia correlativa2 = new Materia();
        Materia materia1 = new Materia();
        Materia materia2 = new Materia();
        materia1.setCorrelativas(new Materia[]{correlativa1});
        materia2.setCorrelativas(new Materia[]{correlativa2});
        
        // Crear alumno con una correlativa aprobada y otra no
        Alumno alumno = new Alumno();
        alumno.setMateriasAprobadas(new Materia[]{correlativa1});
        
        // Crear inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasSolicitadas(new Materia[]{materia1, materia2});
        
        Assert.assertFalse(inscripcion.aprobada());
    }
} 