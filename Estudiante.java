public class Estudiante {
    // Atributos basados en las columnas de tu archivo CSV
    private String name;
    private String gender;
    private String grade;
    private String math;
    private String science;
    private String english;
    private String total;

    // Constructor con todos los parámetros
    public Estudiante(String name, String gender, String grade, String math, String science, String english, String total) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.math = math;
        this.science = science;
        this.english = english;
        this.total = total;
    }

    // --- GETTERS ---
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getGrade() {
        return grade;
    }

    public String getMath() {
        return math;
    }

    public String getScience() {
        return science;
    }

    public String getEnglish() {
        return english;
    }

    public String getTotal() {
        return total;
    }

    // --- SETTERS ---
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMath(String math) {
        this.math = math;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    // Método toString para imprimir fácilmente el registro en consola
    @Override
    public String toString() {
        return String.format("Estudiante [Nombre: %-10s | Género: %-6s | Grado: %-8s | Matemáticas: %-8s | Ciencias: %-8s | Inglés: %-8s | Total: %s]", 
                             name, gender, grade, math, science, english, total);
    }
}