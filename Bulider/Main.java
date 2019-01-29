
public class Main{
    public static void main(String[] args){
        Person person = new PersonBuliderImp("Piotr").
                        setAge(21).
                        setAddres("Zabierzow").
                        build();

        System.out.println(person.name);
        System.out.println(person.age);
        System.out.println(person.addres);
    }
}