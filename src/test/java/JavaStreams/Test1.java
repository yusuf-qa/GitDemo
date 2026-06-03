package JavaStreams;

import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
   /* @Test
    public void regular() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        int count = 0;
        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }*/

    @Test
    public void streamTest() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Abhijeet");
        names.add("Don");
        names.add("Alekhya");
        names.add("Adam");
        names.add("Ram");
        //there is no life for intermediate op if there is no terminal op
        //terminal op will execute only if inter op (filter) returns true
        //we can create stream
        //how to use filter in stream API

        Long c = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(c);

        //we can mention array directly by stream also as below
        long d = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s ->
        {
            return s.startsWith("A");

        }).count();

        System.out.println(d);
        //print all the names of array
        //names.stream().filter(s -> s.length()>4).forEach(s-> System.out.println(s));
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));


    }

    @Test
    public void StreamMap() {

        ArrayList<String> names = new ArrayList<>();
        names.add("Women");
        names.add("Man");


        //print names which have last letter is "a" with uper case
        //Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
        //print names which has first letter as a then covert with uppercase and sort
        //converting Arrays to List as below and performing streams op
        List<String> names1 = Arrays.asList("Abhijeet", "Don", "Alekhya", "Adam", "Rama");
        names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
        //merging two streams names & names1
        Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
        //newStream.sorted().forEach(s -> System.out.println(s));
        //Check "Adam" present or not
        boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
        System.out.println(flag);
        Assert.assertTrue(flag);
    }

    @Test
    public void streamCollect(){
        List<String> ls = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s->s.endsWith("a"))
                .map(s->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3,4,5,6,7,3,9,8,9);
        //print unique numbers
        //sort the array 3rd index
        values.stream().distinct().forEach(s-> System.out.println(s));
        List<Integer>  li =  values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));

    }
}