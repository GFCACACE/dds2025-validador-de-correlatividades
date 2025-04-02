public class Inscripcion {

    private Alumno alumno;
    private Materia[] materias_solicitadas;

    public boolean aprobada(){
        // Si no hay materias solicitadas, la inscripción está aprobada
        if (materias_solicitadas == null || materias_solicitadas.length == 0) {
            return true;
        }

        // Para cada materia solicitada
        for (Materia materiaSolicitada : materias_solicitadas) {
            // Obtener las correlativas de la materia
            Materia[] correlativas = materiaSolicitada.getCorrelativas();
            
            // Si la materia tiene correlativas
            if (correlativas != null && correlativas.length > 0) {
                // Verificar que cada correlativa esté aprobada
                for (Materia correlativa : correlativas) {
                    boolean correlativaAprobada = false;
                    
                    // Buscar si la correlativa está en las materias aprobadas del alumno
                    for (Materia materiaAprobada : alumno.getMateriasAprobadas()) {
                        if (materiaAprobada.equals(correlativa)) {
                            correlativaAprobada = true;
                            break;
                        }
                    }
                    
                    // Si alguna correlativa no está aprobada, la inscripción no está aprobada
                    if (!correlativaAprobada) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public void setMateriasSolicitadas(Materia[] materias_solicitadas) {
        this.materias_solicitadas = materias_solicitadas;
    }
} 