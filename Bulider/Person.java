class Person{
    String name;
    int age;
    String addres;

    public Person(PersonBulider bulider){
        this.name = bulider.getName();
        this.age = bulider.getAge();
        this.addres = bulider.getAddres();
    }
}