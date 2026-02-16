public class GestorAlumnos {

    Alumnos[] alumnos = new Alumnos[25];

    // ---------- ALTA ----------
    public boolean alta(int id, String nombre, double promedio) {

        if (id <= 0 || nombre.isEmpty() || promedio < 0 || promedio > 10 || idExiste(id)) {
            return false;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumnos(id, nombre, promedio);
                return true;
            }
        }
        return false;
    }

    // ---------- BUSCAR ----------
    public Alumnos buscarActivo(int id) {
        for (Alumnos a : alumnos) {
            if (a != null && a.id == id && a.activo) {
                return a;
            }
        }
        return null;
    }

    // ---------- ACTUALIZAR ----------
    public boolean actualizarPromedio(int id, double nuevoPromedio) {
        if (nuevoPromedio < 0 || nuevoPromedio > 10) {
            return false;
        }

        Alumnos a = buscarActivo(id);
        if (a != null) {
            a.promedio = nuevoPromedio;
            return true;
        }
        return false;
    }

    // ---------- BAJA LOGICA ----------
    public boolean bajaLogica(int id) {
        Alumnos a = buscarActivo(id);
        if (a != null) {
            a.activo = false;
            return true;
        }
        return false;
    }

    // ---------- LISTAR ----------
    public void listarActivos() {
        System.out.println("\n--- ALUMNOS ACTIVOS ---");
        for (Alumnos a : alumnos) {
            if (a != null && a.activo) {
                System.out.println(a.id + " | " + a.nombre + " | " + a.promedio);
            }
        }
    }

    // ---------- REPORTES ----------
    public void reportes() {
        double suma = 0;
        int contador = 0;
        Alumnos mayor = null;
        Alumnos menor = null;
        int mayoresA8 = 0;

        for (Alumnos a : alumnos) {
            if (a != null && a.activo) {
                suma += a.promedio;
                contador++;

                if (a.promedio >= 8.0) {
                    mayoresA8++;
                }

                if (mayor == null || a.promedio > mayor.promedio) {
                    mayor = a;
                }

                if (menor == null || a.promedio < menor.promedio) {
                    menor = a;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos activos");
            return;
        }

        System.out.println("\n--- REPORTES ---");
        System.out.println("Promedio general: " + (suma / contador));
        System.out.println("Mayor promedio: " + mayor.id + " | " + mayor.nombre + " | " + mayor.promedio);
        System.out.println("Menor promedio: " + menor.id + " | " + menor.nombre + " | " + menor.promedio);
        System.out.println("Alumnos con promedio >= 8.0: " + mayoresA8);
    }

    // ---------- VALIDACION ----------
    private boolean idExiste(int id) {
        for (Alumnos a : alumnos) {
            if (a != null && a.id == id) {
                return true;
            }
        }
        return false;
    }
}
