public class Trabajador {
    
    String nombre ;
    int edad ;
    double sueldo;
    double horas_extra;
    
public String getNombre() {
        return nombre;
    }

public void setNombre(String nombre ) {
        this.nombre = nombre ;
    }
public int getEdad() {
        return edad;
    }

public void setEdad(int edad ) {
        this.edad = edad ;
    }
public double getSueldo() {
        return sueldo;
    }
public void setSueldo(double sueldo ) {
        this.sueldo = sueldo ;
    }
public double getHoras_extra() {
        return horas_extra;
    }   
public void setHoras_extra(double horas_extra ) {
        this.horas_extra = horas_extra ;
    }

public Trabajador(String nombre,int edad,double sueldo,double horas_extra){
this.nombre = nombre ;
this.edad = edad ;
this.sueldo = sueldo ;
this.horas_extra = horas_extra;
}

}    
    
    
