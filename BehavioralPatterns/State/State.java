package State;

public class State {

    static class Person{
        private StateOfLife state;

        public Person() {
            this.state = new Infancy(this);
        }

        void changeState(StateOfLife state){
            this.state = state;
        }

        void live(){
            state.live();
        }

        void grow(){
            state.grow();
        }
    }

    static abstract class StateOfLife{
        protected Person person;

        public StateOfLife(Person person) {
            this.person = person;
        }

        abstract void live();
        abstract void grow();
    }

    static class Infancy extends StateOfLife {

        public Infancy(Person person) {
            super(person);
        }

        @Override
        public void live() {
            System.out.println("Stands on 4 limbs");
        }

        @Override
        public void grow() {
            person.changeState(new MiddleAge(person));
        }
    }

    static class MiddleAge extends StateOfLife{

        public MiddleAge(Person person) {
            super(person);
        }

        @Override
        void live() {
            System.out.println("Stands on 2 limbs");
        }

        @Override
        void grow() {
            person.changeState(new OldAge(person));
        }
    }

    static class OldAge extends StateOfLife{

        public OldAge(Person person) {
            super(person);
        }

        @Override
        void live() {
            System.out.println("Stands on 3 limbs");
        }

        @Override
        void grow() {
            person.changeState(new Dead(person));
        }
    }

    static class Dead extends StateOfLife{

        public Dead(Person person) {
            super(person);
        }

        @Override
        void live() {
            System.out.println("Dead in the coffin");
        }

        @Override
        void grow() {
            //Do nothing
        }
    }

    public static void main(String[] args) {
        Person person = new Person();

        person.live();
        person.grow();

        person.live();
        person.grow();

        person.live();
        person.grow();

        person.live();
        person.grow();
    }
}
