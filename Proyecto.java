import java.util.ArrayList;
import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        // variables que activan los dos menus
        //mantener 1 activa el primer menu
        boolean mantener1 = true;
        //mantener activa el segundo menu
        boolean mantener = true;
        //declaracion de variables
        String nombre; int edad ; double sueldo, horas_extra;
        //Arraylist que guarda los objetos clase Trabajador 
       ArrayList<Trabajador> trabajadores = new ArrayList();
       //teclado permite ingresar datos de las variables
       Scanner teclado = new Scanner(System.in);
       //opcion permite seleccionar la accion en el switch case
        int opcion ;
        //contador señala el numero de trabajador que se esta creando
        int contador = 1;
        
       System.out.println("Paso 1 crear trabajadores : ");
       System.out.println("______________________________________________");  
        while(mantener1){
                //mientras se ejectura el menu 1 mantener esta en falso para evitar que se active antes de tiempo 
                mantener= false;
                
                System.out.println("ingrese el nombre del trabajador : "+ contador);
                nombre = teclado.next();
                
                contador++;  
                
                System.out.println("ingrese la  edad del trabajador:");
                edad = teclado.nextInt();
                
                System.out.println("ingrese el sueldo del trabajador:");
                sueldo = teclado.nextDouble();
                
                System.out.println("ingrese el numero horas de extra del trabajador hasta ahora:");
                horas_extra = teclado.nextDouble();              
                //se crea un nuevo trabajador cada vez que se ejectute el while y se le dan las caracteristicas que ingrese el usuario
                //a su vez se agrega al arraylist de trabajadores
                trabajadores.add(new Trabajador(nombre,edad,sueldo,horas_extra));
                
                System.out.println("______________________________________________");
                //se le pregunta al usuario si desea continuar 
                System.out.println("¿desea seguir agregando trabajadores? si / no");
                //se guarda la respuesta en un String
                String desea = teclado.next();
                //para la comparacion creamos un String con no
                String no = "no";
                //como desea es un String hereda sus metodos entre ellos el metodo equals
                //equals toma el Objeto dentro del parentesis y lo compara con desea si es verdadero retorna true
                //lo cual hace que la condicion dentro del if se cumpla
                if(desea.equals(no)){
                    //pasamos mantener 1 a false para que el primer menu deje de repetirse
                mantener1 = false;
                
                    //pasamos mantener a true para que el segundo menu empiece
                mantener = true;
                }
               
       }
        //cuando la persona decide no agregar mas trabajadores el segundo menu comienza a ejecutarse
        while(mantener){
        //se le muestran al usuario las opciones o menu    
        System.out.println("1.modificar trabajador");
        System.out.println("2.agregar horas extra a un trabajado");
        System.out.println("3.mostrar valor a pagar a todos");
        System.out.println("4.salir del progama");
        //se guarda la respuesta en opcion
        opcion = teclado.nextInt(); 
        //cuando opcion sea igual al numero del caso este se ejecutara        
        switch(opcion){
            case 1:
            //como la persona desea modificiar un trabajador se le pide el nombre para encontrarlo
                System.out.println("ingrese el nombre del trabajador");
                nombre = teclado.next();
                //creamos un for each que almacena temporalmente en a cada uno de los trabajadores que fueron creados
               for(Trabajador a : trabajadores){
                //como a es un trabajador hereda el metodo get de la clase trabajdor el cual retorna un string nombre
                //como nombre es un string hereda equals y perite compararlo con el nombre ingresado por el usuario
                //cuando el getnombre de cada uno de los trabajadores es igual al nombre dado por usuario se cumple la 
                //condicion del if
               if(a.getNombre().equals(nombre)){
                // se muestran los datos viejos para verificar que vamos a cambiar y saber que esta funcionando bien   
                System.out.println("Los datos viejos son : " +
                        "\n Nombre : "+a.getNombre() 
                        +"\n Edad : " + a.getEdad()
                        +"\n Sueldo :  " + a.getSueldo()
                        +"\n Horas extra"+a.getHoras_extra() );
                //pedimos los nuevos valores
                System.out.println("ingrese la  edad nueva del trabajador");
                edad = teclado.nextInt();
                
                System.out.println("ingrese el sueldo nuevo del trabajador");
                 sueldo = teclado.nextDouble();
                 
                System.out.println("ingrese el numero horas de extra nuevas del trabajador ");
                horas_extra = teclado.nextDouble();              
                // como a hereda los metodos de trabajador utilizamos los metodos set
                //cada metodo set recibe lo que hay dentro del parentesis y modifica el atributo del objeto a 
                a.setEdad(edad);
                a.setSueldo(sueldo);
                a.setHoras_extra(horas_extra);
                 // se muestran los nuevos resultados
                 // para que no se amontonen se les da un salto de linea (\n)
                System.out.println("Los datos nuevos son : " +
                        "\n Nombre : "+a.getNombre() 
                        +"\n Edad : " + a.getEdad()
                        +"\n Sueldo :  " + a.getSueldo()
                        +"\n Horas extra"+a.getHoras_extra() );
                
                }
               }
               //rompemos el caso para que no salte al siguiente y vuelva al menu 2 ya que mantener sigue en true
               break;
            case 2:
                 //volvemos a pedir el nombre de trabajador a quien se le va a agregar horas extra
                System.out.println("ingrese el nombre del trabajador a agregar horas extra");
                String nombre_a_buscar = teclado.next();
                // en i se va a guardar temproalmente cada uno de los trabajadores 
                for(Trabajador i : trabajadores ){
                    
                    if( i.getNombre().equals(nombre_a_buscar)){
                //se piden las horas extra nuevas        
             System.out.println("ingrese el numero horas de extra nuevas");
                double horas_extra_nuevas = teclado.nextDouble();
                //el metodo setHoras extra recibe el valor dentro del parentesis
                // y como las horas extra son la suma de las horas anteriores mas las nuevas 
                //recibimos con getHoras_extra() las horas extra que ingresamos al crear el trabajador
                //y sumamos las nuevas que realizo
                i.setHoras_extra(i.getHoras_extra() + horas_extra_nuevas);
                }
                }
                //rompemos para que no salte al siguiente caso y acontinuacion continua con el menu 2 porque mantener sigue en true
                break;
                
            case 3:
                //creamos una variable llamada sueldo total donde se guardara lo que se va a pagar segun horas extra trabajadas
                double sueldo_total;
                //recorremos todo el arraylist trabajadores
                
                for(Trabajador i : trabajadores ){
                    
                    sueldo_total =(i.getHoras_extra() * 2000)+ i.getSueldo();
                //imprimimos TODOS LOS TRABAJADORES     
                    System.out.println("Nombre : "+i.getNombre()+"Edad : "+ i.getEdad()+"sueldo base de " +i.getSueldo()+"Horas extra trabajadas : "+i.getHoras_extra() +"sueldo total de : "+ sueldo_total);
                }
                //rompemos para que no salte al siguiente caso y continue en el menu 2
                
                break;
              case 4:
              //como e usuario quiere salir cerramos el menu 2 
               mantener = false;   
              break ;
            default:
            //default en caso de que opcion sea  distinta a las opciones ofrecidas es decir al numero de casos dados
                 System.out.println("ingreso mal la opcion");
                 break;
        
        }
        }
    }
    
}
