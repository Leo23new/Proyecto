package model;

public class Estudiante {
    private String name, gender, grade, math, science, english, total;

    public Estudiante(String name, String gender, String grade, String math, String science, String english, String total) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.math = math;
        this.science = science;
        this.english = english;
        this.total = total;                                                                         
    }

    
    public String getName() {
         return name; }
    public String getGender() {
         return gender; }
    public String getGrade() {
         return grade; }
    public String getMath() {
         return math; }
    public String getScience() { 
        return science; }
    public String getEnglish() { 
        return english; }
    public String getTotal() { 
        return total; }

    @Override
    public String toString() {
        return String.format("Estudiante [Nombre: %-10s | Genero: %-2s | Grado: %-4s | Matematicas: %-4s | Ciencias: %-4s | Inglés: %-4s | Total: %s]", 
                             name, gender, grade, math, science, english, total);
    }
}