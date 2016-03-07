import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<Person> data = Arrays.asList(
            new Person.Builder().name("Juraj").birthday(LocalDate.of(1500, 3, 5)).gender(Person.Sex.MALE).emailAddress("gooseka@foobar.com").build(),
            new Person.Builder().name("Peter").birthday(LocalDate.of(1998, 3, 18)).gender(Person.Sex.MALE).emailAddress("peter@seznam.cz").build(),
            new Person.Builder().name("Suzzana").birthday(LocalDate.of(1970, 12, 2)).gender(Person.Sex.FEMALE).emailAddress("suzana@foobar.com").build(),
            new Person.Builder().name("Dagmar").birthday(LocalDate.of(1885, 5, 1)).gender(Person.Sex.FEMALE).emailAddress("dagmar@foobar.com").build(),
            new Person.Builder().name("John").birthday(LocalDate.of(2000, 4, 17)).gender(Person.Sex.MALE).emailAddress("johny@outlook.com").build(),
            new Person.Builder().name("Kristine").birthday(LocalDate.of(1999, 4, 17)).gender(Person.Sex.FEMALE).emailAddress("kristine@outlook.com").build(),
            new Person.Builder().name("Sandy").birthday(LocalDate.of(2015, 1, 17)).gender(Person.Sex.FEMALE).build(),
            new Person.Builder().name("Tandy").birthday(LocalDate.of(2012, 8, 10)).gender(Person.Sex.FEMALE).build());

    public static class Person {

        public enum Sex {
            MALE, FEMALE
        }

        private String name;
        private LocalDate birthday;
        private Sex gender;
        private String emailAddress;

        public Person(Builder builder) {
            this.name = builder.name;
            this.birthday = builder.birthday;
            this.gender = builder.gender;
            this.emailAddress = builder.emailAddress;
        }

        public String getName() {
            return name;
        }

        public LocalDate getBirthday() {
            return birthday;
        }

        public Sex getGender() {
            return gender;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void printPerson() {
            System.out.println(this);
        }

        public int getAge() {
            return birthday.until(LocalDate.now()).getYears();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (name != null ? !name.equals(person.name) : person.name != null) return false;
            if (birthday != null ? !birthday.equals(person.birthday) : person.birthday != null) return false;
            if (gender != person.gender) return false;
            return emailAddress != null ? emailAddress.equals(person.emailAddress) : person.emailAddress == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
            result = 31 * result + (gender != null ? gender.hashCode() : 0);
            result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", birthday=" + birthday +
                    ", gender=" + gender +
                    ", emailAddress='" + emailAddress + '\'' +
                    '}';
        }

        public static class Builder {

            private String name;
            private LocalDate birthday;
            private Sex gender;
            private String emailAddress;

            public Builder name(String name) {
                this.name = name;
                return this;
            }

            public Builder birthday(LocalDate birthday) {
                this.birthday = birthday;
                return this;
            }

            public Builder gender(Sex gender) {
                this.gender = gender;
                return this;
            }

            public Builder emailAddress(String emailAddress) {
                this.emailAddress = emailAddress;
                return this;
            }

            public Person build() {
                return new Person(this);
            }

        }
    }

    public static void main(String[] args) {
    }
}
