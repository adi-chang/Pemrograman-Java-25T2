public class Demo01 {
    
    public static String toGreeting(String name) {
        return "Greeting to : %s".formatted(name);
    }

    public static void main(String[] args) {
    
        Greeting greet1 = new Greeting("Budi");
        Greeting greet2 = new Greeting();
        greet2.setName("Iwan"); 
        
        // akses ke instance method : sayHi()
        // instance method hanya bisa diakses melalui object dari class tsb
        greet1.sayHi();
        greet2.sayHi();

        // akses ke class method : sayHello(name), sayHello(name, city)
        // akses ke class method, dilakukan dengan cara memanggil method bersangkutan
        // dari class-nya 
        Greeting.sayHello("Susan");
        Greeting.sayHello("Tuti", "Binjai");

        System.out.println(Demo01.toGreeting("Juliana"));
        System.out.println(toGreeting("Roberto Carlos"));

    }

}

class Greeting {

    private String name;

    public Greeting() {
        this.name = "";
    }

    public Greeting(String aName) {
        this.name = aName;
    }

    public void setName(String aName) { this.name = aName; }
    public String getName() {
        return name;
    }

    // methods - instance methods

    public void sayHi() {
        System.out.println("Hi, %s".formatted(this.name));
    }

    // methods - class methods [ static methods ]

    public static void sayHello(String aName) {
        System.out.println("Hello, %s".formatted(aName));
    }

    // method sayHello : menerapkan konsep overloading

    public static void sayHello(String aName, String city) {
        System.out.println("Hello, %s. I\'m from %s".formatted(aName, city));
    }


}