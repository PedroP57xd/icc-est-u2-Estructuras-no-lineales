package models;

public class Person implements Comparable<Person> {
    private String nombre;
    private int edad;

    public Person() {
    }

    public Person(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
public int compareTo(Person other) {
    int cmp = Integer.compare(this.getEdad(), other.getEdad());
    if (cmp == 0) {
        return this.getNombre().compareTo(other.getNombre());
    }
    return cmp;
}


    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }

}
