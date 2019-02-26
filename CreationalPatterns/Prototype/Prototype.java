package Prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prototype {

    static abstract class CloneTrooper{

        int blood_type;

        public CloneTrooper(int blood_type) {
            this.blood_type = blood_type;
        }

        public CloneTrooper(CloneTrooper trooper) {
            this.blood_type = trooper.blood_type;
        }

        public abstract CloneTrooper clone();

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CloneTrooper that = (CloneTrooper) o;
            return blood_type == that.blood_type;
        }

        @Override
        public int hashCode() {
            return Objects.hash(blood_type);
        }
    }

    static public class NormalTrooper extends CloneTrooper{

        String type;

        public NormalTrooper(int blood_type, String type) {
            super(blood_type);
            this.type = type;
        }

        public NormalTrooper(NormalTrooper trooper) {
            super(trooper);
            this.type = trooper.type;
        }

        @Override
        public CloneTrooper clone() {
            return new NormalTrooper(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            NormalTrooper that = (NormalTrooper) o;
            return Objects.equals(type, that.type);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), type);
        }

        @Override
        public String toString() {
            return "NormalTrooper{" +
                    "blood_type=" + blood_type +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    static public class ShadowTrooper extends CloneTrooper{

        String shadow_skill;

        public ShadowTrooper(int blood_type, String shadow_skill) {
            super(blood_type);
            this.shadow_skill = shadow_skill;
        }

        public ShadowTrooper(ShadowTrooper trooper) {
            super(trooper);
            this.shadow_skill = trooper.shadow_skill;
        }

        @Override
        public CloneTrooper clone() {
            return new ShadowTrooper(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            ShadowTrooper that = (ShadowTrooper) o;
            return Objects.equals(shadow_skill, that.shadow_skill);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), shadow_skill);
        }

        @Override
        public String toString() {
            return "ShadowTrooper{" +
                    "blood_type=" + blood_type +
                    ", shadow_skill='" + shadow_skill + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        CloneTrooper clone = new ShadowTrooper(1, "sneak");

        CloneTrooper clone2 = clone.clone();

        System.out.println(clone);
        System.out.println(clone2);

        if ( clone.equals(clone2)){
            System.out.println("They are the same");
        }

        List<CloneTrooper> clones = new ArrayList<>();

        for(int i=0; i<100; ++i){
            clones.add(clone.clone());
        }

        // HOHOHO army of clones
        System.out.println(clones);
    }
}
