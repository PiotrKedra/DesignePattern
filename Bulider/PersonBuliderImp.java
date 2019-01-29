class PersonBuliderImp implements PersonBulider{
    private String name;
    private int age = 0;
    private String addres = "Krakow";

    public PersonBuliderImp(String name){
        this.name = name;
    }

    public PersonBuliderImp setAge(int age){
        this.age = age;
        return this;
    }

    public PersonBuliderImp setAddres(String addres){
        this.addres = addres;
        return this;
    }

    public Person build(){
        return new Person(this);
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getAddres(){
        return this.addres;
    }
}